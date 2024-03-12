/**
 * setCookie 设置cookie
 * key value t 键 值 时间(秒)
 */
export function setCookie(key, value, t) {
    const oDate = new Date()
        // 设置时间无效，存储于会话期间
        // oDate.setDate(oDate.getTime() + t * 1000)
        // document.cookie = key + '=' + value + '; expires=' + oDate.toDateString()
    // 设置时间有效
    oDate.setTime(oDate.getTime() + t * 1000);
    document.cookie = key + "=" + value + "; expires=" + oDate.toGMTString();
}

/**
 * getCookie 获取cookie
 */
export function getCookie(key) {
    const arr1 = document.cookie.split('; ')
    for (let i = 0; i < arr1.length; i++) {
        const arr2 = arr1[i].split('=')
        if (arr2[0] === key) {
            return decodeURI(arr2[1])
        }
    }
}

/**
 * removeCookie 移除cookie
 */
export function removeCookie(key) {
    setCookie(key, '', -1) // 把cookie设置为过期
}