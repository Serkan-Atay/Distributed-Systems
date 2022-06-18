import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteArticleInterface extends Remote {

     String getName()throws RemoteException;
     Integer getPage()throws RemoteException;
     String getCathegory()throws RemoteException;
     void setPage(Integer newPage) throws RemoteException;

}
