

import javax.swing.text.html.HTMLDocument;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UDPServer {
    public static void main(String args[]) {
        System.out.println("The Server is running");

        Conferences confrencesOne = new Conferences();
        confrencesOne.setName("Kriesen Sitzung");
        confrencesOne.addParticipants("Max, Mustermann", "Germany", "Siemens");
        confrencesOne.addParticipants("David, Hard", "USA", "Apple");

        Conferences confrencesTwo = new Conferences();
        confrencesTwo.setName("Vorstand Sitzung");
        confrencesTwo.addParticipants("Maxxxx, Mustermann", "Germany", "Siemens");


        try {
            DatagramSocket aSocket = new DatagramSocket(6789);
            byte[] buffer = new byte[1000];
            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(buffer,0, buffer.length));
                Message message = (Message) iStream.readObject();

                if (message.getMethod().equals("addMethod")) {
                    System.out.println("-------------------------------");
                    System.out.println("Server create a new Participant");
                    if (message.getConfrenceName().equals("confrencesOne")){
                        confrencesOne.addParticipants(message.getName(),message.getCountry(),message.getCompany());
                    }
                    if(message.getConfrenceName().equals("confrencesTwo")){
                        confrencesTwo.addParticipants(message.getName(),message.getCountry(),message.getCompany());
                    }
                    System.out.println("Server finished, and Added in confrences");
                    System.out.println("-------------------------------");

                    byte [] nachricht= "geadded".getBytes();
                    DatagramPacket reply = new DatagramPacket(nachricht,
                            nachricht.length, request.getAddress(), request.getPort());
                    aSocket.send(reply);
                }

                if(message.getMethod().equals("callParticipants")){
                    List<String> participantName=new ArrayList<String>();
                    if(message.getConfrenceName().equals("confrencesOne")){
                        participantName=confrencesOne.getAllNameOfParticipant();
                    }
                    if(message.getConfrenceName().equals("confrencesTwo")){
                        participantName=confrencesTwo.getAllNameOfParticipant();
                    }

                    String replayy="";
                    Iterator it= participantName.iterator();
                    while(it.hasNext()){
                        replayy=replayy+it.next().toString()+"\n";
                    }
                    byte [] nachricht= replayy.getBytes();
                    DatagramPacket reply = new DatagramPacket(nachricht,
                            nachricht.length, request.getAddress(), request.getPort());
                    aSocket.send(reply);
                    
                }

                if(message.getMethod().equals("confName")){
                    if(message.getConfrenceName().equals("confrencesOne")){

                        byte [] nachricht= (confrencesOne.getConfrenceName() +" is the name of confrence").getBytes();
                        DatagramPacket reply = new DatagramPacket(nachricht,
                                nachricht.length, request.getAddress(), request.getPort());
                        aSocket.send(reply);

                    }
                    if(message.getConfrenceName().equals("confrencesTwo")){

                        byte [] nachricht= (confrencesTwo.getConfrenceName() +" is the name of confrence").getBytes();
                        DatagramPacket reply = new DatagramPacket(nachricht,
                                nachricht.length, request.getAddress(), request.getPort());
                        aSocket.send(reply);

                    }
                }
            }
        } catch (SocketException e) {
            System.out.println(" Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(" IO: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    } // main
} //class UDPServer