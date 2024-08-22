import request from '@/utils/request'
import { tansParams } from '@/utils/ruoyi'
import { MockBaseURL } from './mock.config'

/**
 * 获取商品列表
 * @param {Object} query 查询参数
 * @param {String} query.commodity_name 商品名称
 * @param {Number} query.pageNum 页码
 * @param {Number} query.pageSize 每页显示数量
 * @returns
 */
export const getProductList = (query) => {
  return request({
    baseURL: MockBaseURL,
    url: '/product/list' + `?${tansParams(query)}`,
    method: 'get',
  })
}
