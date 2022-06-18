import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;

public class Newspaper extends UnicastRemoteObject implements RemoteNewspaperInterface {

    private String name;
    private HashSet<RemoteArticleInterface> articles;

    public Newspaper(String name) throws RemoteException {
        this.name = name;
        this.articles = new HashSet<>();
    }


    @Override
    public void addArticle(String name, String cathegory, int page) throws RemoteException {
       Article article = new Article(name,cathegory,page);
        articles.add(article);
    }


    @Override
    public HashSet<RemoteArticleInterface> getAllArticles() throws RemoteException {
        return this.articles;
    }



    @Override
    public RemoteArticleInterface searchArticle(String name) throws RemoteException {

        for (RemoteArticleInterface article : articles){
            if (article.getName().equals(name)){
                return article;
            }
        }
        return null;
    }



    @Override
    public String getName() {
        return name;
    }
}
