import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Conferences confrences = new Conferences();

        confrences.addParticipants("Max, Mustermann", "Germany", "Siemens");
        confrences.addParticipants("David, Hard", "USA", "Apple");
        confrences.addParticipants("Maria, Garciac", "Spain", "Aoloa");

        Participants targe = confrences.search("Maria, Garciac");
        if (targe == null) {
            System.out.println("no Participants with this name ");
        } else {
            System.out.println("successfully search");
            targe.print();
        }
        Participants targeTwo = confrences.search("Max mueller");
        if (targeTwo == null) {
            System.out.println("no Participants with this name ");
        } else {
            System.out.println("successfully search");
            targeTwo.print();
        }

        System.out.println("total number of all participants from Germany: "+confrences.searchCountry("Germany"));

    }
}
