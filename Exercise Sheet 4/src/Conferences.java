import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Conferences {
    private String name;
    private HashSet<Participants> participants = new HashSet<Participants>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Participants search(String target) {
        Iterator<Participants> iter = this.participants.iterator();
        while (iter.hasNext()) {
            Participants t = (Participants) iter.next();
            if (t.getName().equals(target)) {
                return t;
            }
        }
        return null;
    }

    public int searchCountry(String targetCountry) {
        HashSet<Participants> temp = new HashSet<Participants>();
        Iterator<Participants> iter = this.participants.iterator();
        while (iter.hasNext()) {
            Participants t = (Participants) iter.next();
            if (t.getCountry().equals(targetCountry)) {
                temp.add(t);
            }
        }
        return temp.size();
    }

    public void print() {
        Iterator<Participants> iter = this.participants.iterator();
        while (iter.hasNext()) {
            Participants temp = iter.next();
            //System.out.println("Name: "+ temp.getName() + " Company: " + temp.getCompany() + "Country: "+ temp.getCountry());
            temp.print();
        }
    }

    public void addParticipants(String name, String country, String company) {
        Participants neu = new Participants(name, country, company);
        this.participants.add(neu);
        System.out.println("Successful added new participants");
    }

    public String getConfrenceName() {
        return this.name;
    }

    public HashSet<Participants> getParticipants() {
        return participants;
    }


    public List<String> getAllNameOfParticipant(){
        List<String> participantName=new ArrayList<>();
            Iterator it= this.getParticipants().iterator();
            while(it.hasNext()){
                Participants temp= (Participants) it.next();
                participantName.add(temp.getName());
            }
        return participantName;
    }
}

