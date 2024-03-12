import {
    request
} from '@/utils/request'
// 注册接口
export function getHomeBanner() {
    return request({
        url: '/xiaomi/v2/carousel',
        method: 'GET',
    })
}

// 查询商品分类列表
export function getHomeClassification() {
    return request({
        url: '/xiaomi/v2/category',
        method: 'GET',
    })
}

// 查询首页
export function getHomeHot() {
    return request({
        url: '/xiaomi/v2/product/hot',
        method: 'GET',
    })
}

// 查询商品列表
export function getShoppingList(params) {
    return request({
        url: '/xiaomi/v2/product',
        method: 'GET',
        params
    })
}

// 查询商品详情数据
export function getShoppingInfo(productId) {
    return request({
        url: '/xiaomi/v2/product/' + productId,
        method: 'GET',
    })
}

// 查询当前用户收藏商品信息
export function getCollect() {
    return request({
        url: '/xiaomi/v2/collect',
        method: 'GEt',
    })
}


// 收藏、取消收藏
export function setCollect(productId) {
    return request({
        url: '/xiaomi/v2/collect/' + productId,
        method: 'POST',
    })
}

// 查询当前用户购物车
export function getShoppingCart() {
    return request({
        url: '/xiaomi/v2/shoppingCart',
        method: 'GET',
    })
}

// 添加购物车商品
export function setShoppingCart(data) {
    return request({
        url: '/xiaomi/v2/shoppingCart',
        method: 'POST',
        data
    })
}


// 修改购物车商品数量
export function setShoppingCartNum(data) {
    return request({
        url: '/xiaomi/v2/shoppingCart/product/num',
        method: 'PUT',
        data
    })
}

// 删除购物车商品
export function deleteShoppingCartNum(shoppingCartId) {
    return request({
        url: '/xiaomi/v2/shoppingCart/'+Number(shoppingCartId),
        method: 'DELETE',
    })
}

// 查询我的购物车数量
export function getMyShoppingCarNum() {
    return request({
        url: '/xiaomi/v2/shoppingCart/product/count',
        method: 'GET',
    })
}

// 生成订单 (弃用)
// export function generateOrder(options) {
//     return request({
//         url: '/xiaomi/v2/orders/'+options,
//         method: 'POST',
//     })
// }
// 生成订单
export function generateOrder(data) {
    return request({
        url: '/xiaomi/v2/orders/create?addressId='+data.addressId+"&shoppingCartIds="+data.shoppingCartIds,
        method: 'POST',
    })
}


// 我的订单
export function getOrder() {
    return request({
        url: '/xiaomi/v2/orders',
        method: 'GET',
    })
}

// 查询地区联级数据
export function getArea(pid) {
    return request({
        url: '/xiaomi/v2/area/' + pid,
        method: 'GET',
    })
}

// 新增地址
export function createAddress(data) {
    return request({
        url: '/xiaomi/v2/address',
        method: 'POST',
        data
    })
}

// 删除地址
export function deleteAddress(addressId) {
    return request({
        url: '/xiaomi/v2/address/'+addressId,
        method: 'DELETE',
    })
}

// 获取用户地址
export function getAddressByUser() {
    return request({
        url: '/xiaomi/v2/address/list',
        method: 'GET',
    })
}