package advice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AdviceServer {

    String[] adviceList = {
            "A debugged program is one for which you have not yet found the conditions that make it fail.",
            "A bug in the hand is better than two as yet undetected.",
            "A complex system that works is invariably found to have evolved from a simple one that works.",
            "A computer lets you make more mistakes faster than any other invention",
            "A language that doesn't affect the way you think about programming is not worth knowing.",
            "Adding manpower to a late software project makes it later.",
            "All programmers are optimists."
    };

    public void go() {

        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            while (true) {
                Socket socket = serverSocket.accept();

                PrintWriter writer = new PrintWriter(socket.getOutputStream());

                String advice = getAdvice();
                writer.println(advice);
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];

    }

    public static void main(String[] args) {
        AdviceServer server = new AdviceServer();
        server.go();
    }
}
