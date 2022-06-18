import java.rmi.Naming;

public class Server{

    public static void main(String args[]){
        try {

            RemoteNewspaperInterface  newspapaerServer1 = new Newspaper("Newspaper1");
            Naming.rebind("Newspapaer1", newspapaerServer1);

            RemoteNewspaperInterface   newspapaerServer2 = new Newspaper("Newspaper2");
            Naming.rebind("Newspapaer2", newspapaerServer2);

            System.out.println("The server is up");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
