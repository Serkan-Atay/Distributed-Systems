import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashSet;

public class Client{


    public static void main(String args[]) throws RemoteException, NotBoundException, MalformedURLException {


            //Newspaper1 erstellen
            RemoteNewspaperInterface newspapaer1 = (RemoteNewspaperInterface) Naming.lookup("rmi://localhost/Newspapaer1");
            newspapaer1.addArticle("Slavic", "LOW", 312);
            newspapaer1.addArticle("Nicu", "LOW", 12);
            newspapaer1.addArticle("Markk", "High", 499);

            //Articles von Newspapaer1
            System.out.println("Name Newspaper: "+ newspapaer1.getName());
             System.out.println("\n");
           for (RemoteArticleInterface articleInterface: newspapaer1.getAllArticles()){
                    System.out.println("Name: " + articleInterface.getName());
                    System.out.println("Cathegory: " + articleInterface.getCathegory());
                    System.out.println("Pagenumber: " + articleInterface.getPage());
                    System.out.println("\n");
            }




System.out.println("################################################################################################################################################");
            //Newspaper2 erstellen
            RemoteNewspaperInterface newspapaer2;
            newspapaer2 = (RemoteNewspaperInterface) Naming.lookup("rmi://localhost/Newspapaer2");
            newspapaer2.addArticle("Mank", "LOW", 130);
            newspapaer2.addArticle("Far", "LOW", 12);
            newspapaer2.addArticle("Bac", "MEDIUM", 900);

           //Articles von Newspapaer1
            System.out.println("Name Newspaper: "+ newspapaer2.getName());
            System.out.println("\n");
            for (RemoteArticleInterface articleInterface : newspapaer2.getAllArticles()) {
                    System.out.println("Name: " + articleInterface.getName());
                    System.out.println("Cathegory: " + articleInterface.getCathegory());
                    System.out.println("Pagenumber: " + articleInterface.getPage());
                    System.out.println("\n");
            }


        //Search article
System.out.println("################################################################################################################################################");
        try {
            RemoteArticleInterface rem = newspapaer2.searchArticle("Bac");
            System.out.println("Article found: "+rem.getName());
        }catch (Exception e){
            System.out.println("Article not found");
        }



        // The bigest Page of Newspaper1
System.out.println("################################################################################################################################################");
        HashSet<RemoteArticleInterface> articles = newspapaer1.getAllArticles();
        int max = 0;
        for(RemoteArticleInterface articleIter : articles)
            {
                if (articleIter.getPage() > max){
                max = articleIter.getPage();
            }
        }
        System.out.println("The Bigest page from "+newspapaer1.getName()+ " is: "+ max);



        // The bigest Page of Newspaper2
        HashSet<RemoteArticleInterface> articles1 = newspapaer2.getAllArticles();
        int max1 = 0;
        RemoteArticleInterface artForPageChagne = null;
        for(RemoteArticleInterface articleIter : articles1)
        {
            if (articleIter.getPage() > max1){
                max1 = articleIter.getPage();
                artForPageChagne = articleIter;
            }
        }
        System.out.println("The Bigest page from "+newspapaer2.getName()+ " is: "+ max1);



        //Chage page number
System.out.println("################################################################################################################################################");
        artForPageChagne.setPage(901);
        System.out.println("The page is now: "+ artForPageChagne.getPage() + "\nFrom: "+ artForPageChagne.getName() + "\nCategory: "+artForPageChagne.getCathegory());
    }
}
