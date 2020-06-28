package com.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;

/**
 * @version V1.0
 * @description: 服务端
 * @author: fenggaopan
 * @date: 2020-06-28 09:23:52
 */
public class MyServer {

    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(9999);
        Socket ss = s.accept();

    }

}
