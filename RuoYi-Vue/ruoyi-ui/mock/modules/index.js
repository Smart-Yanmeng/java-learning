const user = require('./user')
const product = require('./product')

const mocks = [...user, ...product]

module.exports = Array.from(mocks, (item) => {
  return {
    ...item,
  }
})
