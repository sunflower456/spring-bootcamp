package com.posco.mes3.quality.tracking.stream.websocket;

import com.posco.mes3.quality.tracking.stream.TotalTrackingCount;
import com.posco.mes3.quality.tracking.stream.TrackingStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

@EnableBinding(TrackingStream.class)
public class TotalTrackingCountConsumer {
    //
    private final SimpMessageSendingOperations simpMessageSendingOperations;

    public TotalTrackingCountConsumer(SimpMessageSendingOperations simpMessageSendingOperations) {
        //
        this.simpMessageSendingOperations = simpMessageSendingOperations;
    }

    @StreamListener(TrackingStream.TRACKING_COUNT_INPUT)
    public void receiveMessage(@Payload TotalTrackingCount message) {
        //
        System.out.println("received from kafka: " + message.toJson());

        Message chatMessage = new Message();
        chatMessage.setContent(String.valueOf(message.getTotalCount()));

        simpMessageSendingOperations.convertAndSend("/topic/public", chatMessage);
    }
}
