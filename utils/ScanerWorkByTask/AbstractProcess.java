package io.advlab.mailrb.mailrbuploader.model.util;

import lombok.Data;

import java.util.concurrent.BlockingQueue;

@Data
public class AbstractProcess implements Process {

    BlockingQueue<String> messageQueue;

    AbstractProcess(BlockingQueue<String> messageQueue) {
        this.messageQueue = messageQueue;
    }


    @Override
    public void process() {
        System.out.println(messageQueue);
    }
}
