/**
 * @typedef { "get" | "post" | "put" | "delete" | "patch" } HTTP_METHOD
 */

const chalk = require('chalk')
const Mock = require('mockjs')
const bodyParser = require('body-parser')
const chokidar = require('chokidar')
const path = require('path')

const mockDir = path.join(process.cwd(), 'mock')

function registerMocks(app) {
  let appRoutesStackLastIndex

  const mocks = require('./modules')
  const parseMocksRes = mocks.map((item) => {
    return parseMock(item.url, item.type, item.response)
  })

  for (const mock of parseMocksRes) {
    app[mock.type](
      mock.url,
      bodyParser.json(),
      bodyParser.urlencoded({
        extended: true,
      }),
      mock.response
    )
    appRoutesStackLastIndex = app._router.stack.length
  }

  const mockRoutesLength = Object.keys(parseMocksRes).length

  return {
    mockRoutesLength,
    appRoutesStackStartIndex: appRoutesStackLastIndex - mockRoutesLength,
  }
}

/**
 *
 * @param {string} url - 请求路径
 * @param {HTTP_METHOD} type - 请求方式
 * @param {Function | Object} responed - 响应数据
 * @returns
 */
function parseMock(url, type, responed) {
  return {
    url: new RegExp(`${url}`),
    type: type || 'get',
    response(req, res) {
      console.log(chalk.black.bgCyanBright(' MOCK '), chalk.cyanBright(`${req.method} ${req.url}`))
      res.json(Mock.mock(typeof responed === 'function' ? responed(req) : responed))
    },
  }
}

function unregisterMocks() {
  Object.keys(require.cache).forEach((item) => {
    if (item.includes(mockDir)) {
      delete require.cache[require.resolve(item)]
    }
  })
}

module.exports = (app) => {
  const mockRes = registerMocks(app)
  let mockRoutesLength = mockRes.mockRoutesLength
  let appRoutesStackStartIndex = mockRes.appRoutesStackStartIndex
  console.log(chalk.black.bgGreen(` MOCK SUCCESS `), chalk.greenBright('Start mock server success!'))

  // 热更新 mock 数据
  chokidar.watch(mockDir, { ignored: /mock-server/, ignoreInitial: true }).on('all', (event, path) => {
    if (event === 'change' || event === 'add') {
      try {
        // 消除旧的路由栈
        app._router.stack.splice(appRoutesStackStartIndex, mockRoutesLength)

        unregisterMocks()

        // 重新注册新mock接口
        const mockRes = registerMocks(app)
        mockRoutesLength = mockRes.mockRoutesLength

        console.log(chalk.black.bgGreen(` MOCK UPDATED `), chalk.greenBright(`${path}`))
      } catch (error) {
        console.log(chalk.bgRed(`\n MOCK ERROR`), chalk.redBright(error))
      }
    }
  })
}
