package com.posco.mes3.quality.tracking.stream.websocket;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {
    //
    private SimpMessageSendingOperations simpMessageSendingOperations;

    public WebSocketEventListener(SimpMessageSendingOperations simpMessageSendingOperations) {
        //
        this.simpMessageSendingOperations = simpMessageSendingOperations;
    }

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        //
        System.out.println("Received a new web socket connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        //
        System.out.println("disconnected client");
    }
}
