package com.ruppyrup.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.TimeUnit;

public class EchoServer extends Thread {

    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[10240];

    public EchoServer() throws SocketException {
        socket = new DatagramSocket(4445);

    }

    public void run() {
        running = true;

        while (running) {
            DatagramPacket packet
                    = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            String received
                    = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received :: " + received);
            sleeper(1);

//            if (received.equals("end")) {
//                running = false;
//                continue;
//            }
//            byte[] out = "Sever says".getBytes();
//            packet = new DatagramPacket(out, out.length, address, port);
//            try {
//                socket.send(packet);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
//        socket.close();
    }

    private void sleeper(long timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SocketException {
        new EchoServer().start();
    }
}
