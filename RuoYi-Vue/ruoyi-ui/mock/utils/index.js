/**
 * 分页器
 * @param {Array} list 列表数据
 * @param {Number} pageNum 分页页码
 * @param {Number} pageSize 分页大小
 * @returns
 */
exports.pager = (list = [], pageNum = 1, pageSize = 10) => {
  return {
    total: list.length,
    items: list.slice((pageNum - 1) * pageSize, pageNum * pageSize),
  }
}
