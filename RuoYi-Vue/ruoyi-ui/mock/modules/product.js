const Mock = require('mockjs')
const { pager } = require('../utils')

const product_list = Mock.mock({
  'data|50': [
    {
      'commodity_id|+1': 1,
      commodity_name: '@ctitle(3, 24)',
      commodity_price: '@float(1, 1000, 2, 3)',
      price_units: '@pick(["盒", "瓶", "袋", "箱", "个", "支", "包", "罐", "桶", "套"])',
      commodity_image: '@image("200x200")',
      commodity_charger: '@cname',
      status: '正常',
      create_time: '@datetime',
      update_time: '@datetime',
      create_by: '@integer(1, 100)',
      update_by: '@integer(1, 100)',
      remark: '@cparagraph(1, 2)',
    },
  ],
})

module.exports = [
  {
    url: '/product/list',
    type: 'get',
    response: (config) => {
      const { commodity_name, pageNum = 1, pageSize = 10 } = config.query
      if (commodity_name) {
        const items = product_list.data.filter((item) => item.commodity_name.indexOf(commodity_name) > -1)
        return {
          code: 200,
          data: pager(items, pageNum, pageSize),
        }
      } else {
        return {
          code: 200,
          data: pager(product_list.data, pageNum, pageSize),
        }
      }
    },
  },
]
