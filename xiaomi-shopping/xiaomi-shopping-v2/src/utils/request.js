import axios from 'axios'
import {
    getCookie
} from '../common/cookie'
import store from '../store'
export function request(config) {
    const ins = axios.create({
        baseURL: process.env.VUE_APP_BASE_API
    })
    ins.interceptors.request.use(function (config) {
        if (config.headers.isToken !== false) {
            let token = getCookie('token')
            if (token) {
                config.headers.Authorization = token
            }
        }
        return config
    }, function (error) {
        return Promise.reject(error)
    })

    ins.interceptors.response.use(function (response) {
        let code = response.data.code
        switch (code) {
            // 登录失效
            case 401:
                store.commit('setLoginPop', 1)
                return response.data
            default:
                return response.data
        }
    }, function (error) {
        return Promise.reject(error)
    })
    return ins(config)
}