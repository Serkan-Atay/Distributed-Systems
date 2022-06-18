import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Message implements Serializable {
    private String method;
    private String confrenceName;
    private String name;
    private String company;
    private String country;

    public Message() {
    }

    public String getConfrenceName() {
        return confrenceName;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getCountry() {
        return country;
    }

    public String getMethod() {
        return method;
    }

    public Message(String confrenceName, String name, String company, String country, String method) {
        this.method = method;
        this.confrenceName = confrenceName;
        this.name = name;
        this.company = company;
        this.country = country;
    }


}
