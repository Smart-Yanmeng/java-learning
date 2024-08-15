package com.york.websocket.utils;

import com.alibaba.fastjson2.JSON;

public class MessageUtils {

    public static String getMessage(boolean isSystemMessage, String fromName, Object message) {

        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setSystem(isSystemMessage);
        resultMessage.setMessage(message);
        if (fromName != null) {
            resultMessage.setFromName(fromName);
        }

        return JSON.toJSONString(resultMessage);
    }
}
