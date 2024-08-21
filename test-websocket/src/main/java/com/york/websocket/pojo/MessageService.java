package com.york.websocket.pojo;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Resource
    private IMessageMapper messageMapper;

    public void saveMessage(Message message) {
        messageMapper.saveMessage(message);
    }
}
