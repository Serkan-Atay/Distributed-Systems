import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashSet;

public interface RemoteNewspaperInterface extends Remote {

     void addArticle(String name, String cathegory, int page)throws RemoteException;
     HashSet<RemoteArticleInterface> getAllArticles()throws RemoteException;
     RemoteArticleInterface searchArticle(String name)throws RemoteException;
     String getName() throws RemoteException;


}
