package io.advlab.mailrb.mailrbuploader.model.util;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

@EqualsAndHashCode(callSuper = true)
@Data
public class SimulateProcess extends AbstractProcess {

    private List<String> messages = new ArrayList<>(){{
        add("Start");
        add("Get connection to service");
        add("Check operation");
        add("File downloading");
        add("Analysis data");
        add("Save file to the disk");
        add("Finish");
    }};

    public SimulateProcess(BlockingQueue<String> messageQueue) {
        super(messageQueue);
    }

    public void process() {
        try {
            for (String message : messages) {
                messageQueue.put(message);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
