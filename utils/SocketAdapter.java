package io.advlab.mailrb.mailrbuploader.model.util;

import io.advlab.mailrb.mailrbuploader.controller.response.Responsable;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;

import static io.advlab.mailrb.mailrbuploader.controller.response.CommonResponse.*;

@Data
@Service
public class SocketAdapter {
    private static final int PORT = 8008;
    private  ServerSocket socket = null;


    public ResponseEntity<Responsable> socketSniffer() {
        ResponseEntity<Responsable> response = null;
        try {
            //Bind to localhost adapter with a zero connection queue
             socket = new ServerSocket(PORT, 0, InetAddress.getByAddress(new byte[]{127, 0, 0, 1}));
            SocketAddress res = socket.getLocalSocketAddress();
            System.out.println("Cокет Адрес" + res.toString());

        } catch (BindException e) {
            response = ResponseEntity.status(PROCESSING_LOCK.getCode()).body(PROCESSING_LOCK);
        } catch (IOException e) {
            response =  ResponseEntity.status(ACCESS_DENIED.getCode()).body(ACCESS_DENIED);
        }
        if (response == null)
        return ResponseEntity.status(UPDATE_STARTED.getCode()).body(UPDATE_STARTED);
        else {
            return response;
        }
    }
}
