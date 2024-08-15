package com.york.websocket.ws;

import com.alibaba.fastjson2.JSON;
import com.york.websocket.config.GetHttpSessionConfig;
import com.york.websocket.pojo.Message;
import com.york.websocket.utils.MessageUtils;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/chat", configurator = GetHttpSessionConfig.class)
@Component
public class ChatEndpoint {

    private static final Map<String, Session> onlineUsers = new ConcurrentHashMap<>();

    private HttpSession httpSession;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws IOException {

        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        String username = (String) this.httpSession.getAttribute("user");
        onlineUsers.put(username, session);

        broadcastAllUsers(MessageUtils.getMessage(true, null, getFriends()));
    }

    @OnMessage
    public void onMessage(String jsonMessage) throws IOException {

        Message msg = JSON.parseObject(jsonMessage, Message.class);
        String toName = msg.getToName();
        String message = msg.getMessage();

        Session session = onlineUsers.get(toName);
        session.getBasicRemote().sendText(MessageUtils.getMessage(false, toName, message));
    }

    @OnClose
    public void onClose(Session session) throws IOException {

        String username = (String) this.httpSession.getAttribute("user");
        onlineUsers.remove(username);

        broadcastAllUsers(MessageUtils.getMessage(true, null, getFriends()));
    }

    private void broadcastAllUsers(String message) throws IOException {

        Set<Map.Entry<String, Session>> entries = onlineUsers.entrySet();
        for (Map.Entry<String, Session> entry : entries) {
            entry.getValue().getBasicRemote().sendText(message);
        }
    }

    private Set getFriends() {
        return onlineUsers.keySet();
    }
}
