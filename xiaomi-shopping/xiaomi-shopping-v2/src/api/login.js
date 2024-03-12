import { request } from '@/utils/request'
// 注册接口
export function setRegister(data) {
    return request({
        url: '/xiaomi/v2/ms/user/register',
        method: 'POST',
        headers:{isToken:false},
        data: data
    })
}

// 登录接口
export function login(data) {
    return request({
        url: '/xiaomi/v2/ms/user/login',
        method: 'POST',
        headers:{isToken:false},
        data: data
    })
}