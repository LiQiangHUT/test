package NIO;

import java.nio.channels.SocketChannel;

public class Server {

    public static void main(String[] args) {
        try {
            SocketChannel open = SocketChannel.open();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
