
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPClient {


    public static void main(String args[]) {
        // args[0] ===> identifizieren von processes

        int i = Integer.parseInt(args[0]);


        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        switch (i) {
            //call addParticipant
            case 1:
                System.out.println("Give the information of Participant");
                // Enter data using BufferReader

                // Reading data using readLine
                try {
                    System.out.println("Confrence Name: ");
                    String confrence = reader.readLine();
                    System.out.println("Name: ");
                    String name = reader.readLine();
                    System.out.println("Company: ");
                    String company = reader.readLine();
                    System.out.println("country");
                    String country = reader.readLine();
                    Message neu = new Message(confrence, name, company, country, "addMethod");
                    sentMessage(neu);
                    break;

                } catch (IOException e) {
                    e.printStackTrace();
                }

                // call allParticipant
            case 2 :
                try {
                    System.out.println("Confrence Name: ");
                    String confName = reader.readLine();
                    System.out.println("waiting: Participants for "+ confName + " is called");
                    Message neu= new Message(confName,"","","","callParticipants");
                    sentMessage(neu);
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case 3 :
                try{
                    System.out.println("Confrence Name: ");
                    String confName = reader.readLine();
                    Message neu= new Message(confName,"","","","confName");
                    sentMessage(neu);
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }


    }

    public static void sentMessage(Serializable m) {

        int serverPort = 6789;
        try {
            ByteArrayOutputStream bStream = new ByteArrayOutputStream();
            ObjectOutput oo = new ObjectOutputStream(bStream);
            oo.writeObject(m);
            oo.close();
            byte[] message = bStream.toByteArray();

            DatagramSocket aSocket = new DatagramSocket();
            InetAddress aHost = InetAddress.getLocalHost();
            DatagramPacket request = new DatagramPacket(message, message.length,
                    aHost, serverPort);
            aSocket.send(request);

            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println(" Message:\n" + new String(reply.getData(), 0, reply.getLength()));
            aSocket.close();
        } catch (Exception e) {

        }

    }


}


