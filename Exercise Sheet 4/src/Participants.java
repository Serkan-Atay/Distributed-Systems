public class Participants {
    private String name;
    private String country;
    private String company;

    public Participants(String name, String country, String company) {
        this.name = name;
        this.country = country;
        this.company = company;
    }
    public Participants(){
        this.name="";
        this.company="";
        this.country="";
    }
    public void print(){
        System.out.println("Name: "+ this.getName() + " Company: " + this.getCompany() + " Country: "+ this.getCountry());
    }
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCompany() {
        return company;
    }

    public void getCompany(String company) {
        this.company = company;
    }


}
