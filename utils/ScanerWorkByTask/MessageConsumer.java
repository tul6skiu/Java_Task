package io.advlab.mailrb.mailrbuploader.model.util;

import lombok.Data;

import java.util.concurrent.BlockingQueue;

@Data
public class MessageConsumer implements Runnable {

    private BlockingQueue<String> messageQueue;
    private String sseEmitter;

    public MessageConsumer(BlockingQueue<String> messageQueue, String sseEmitter) {
        this.messageQueue = messageQueue;
        this.sseEmitter = sseEmitter;
    }

    @Override
    public void run() {
        try {
            while (true){
                String message = messageQueue.take();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
