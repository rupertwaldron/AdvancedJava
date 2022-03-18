package com.ruppyrup.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class EchoClient {
    private DatagramSocket socket;
    private InetAddress address;

    private byte[] buf = new byte[10240];

    public EchoClient() throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
    }

    public void sendEcho(String msg) throws IOException {
        buf = msg.getBytes();
        DatagramPacket packet
                = new DatagramPacket(buf, buf.length, address, 4445);
        socket.send(packet);
//        packet = new DatagramPacket(buf, buf.length);
//        socket.receive(packet);
//        String received = new String(
//                packet.getData(), 0, packet.getLength());
//        return received;
    }

    public void close() {
        socket.close();
    }

    private static void sleeper(long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        EchoClient echoClient = new EchoClient();
        for (int i = 0; i < 100; i++) {
            sleeper(100);
            echoClient.sendEcho("Hello from client " + i);
            System.out.println("Sending :: " + "Hello from client " + i);
        }
    }
}
