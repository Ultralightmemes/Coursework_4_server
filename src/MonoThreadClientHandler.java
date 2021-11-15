import java.io.*;
import java.net.Socket;
import org.json.*;

public class MonoThreadClientHandler implements Runnable {

    private static Socket clientDialog;

    public MonoThreadClientHandler(Socket client) {
        MonoThreadClientHandler.clientDialog = client;
    }

    @Override
    public void run() {

        try {

            BufferedReader recv = new BufferedReader(new InputStreamReader(clientDialog.getInputStream()));

            PrintWriter out = new PrintWriter(clientDialog.getOutputStream(), true);
            System.out.println("DataInputStream created");

            System.out.println("DataOutputStream  created");

            String inputLine;
            String line = null;
            JSONObject json = new JSONObject();
            Admin admin = new Admin();
            while (true) {
                if ((inputLine = recv.readLine()) != null) {

                    if (inputLine.equals("first")) {
                        System.out.println("what&");
                        admin.logAdmin("login", "password");
                        json.put("type", "CONNECT");
                        json.put("1", "one");
                        out.println(json.toString());
                    } else if (inputLine.equals("quit")) {
                        break;
                    } else {
                        System.out.println(inputLine);
                        out.println("error");
                    }
                }
            }


            System.out.println("Client disconnected");
            System.out.println("Closing connections & channels.");

            recv.close();
            out.close();

            clientDialog.close();

            System.out.println("Closing connections & channels - DONE.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}