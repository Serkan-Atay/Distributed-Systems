import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Article extends UnicastRemoteObject implements RemoteArticleInterface{

    private String name;
    private String cathegory;
    private int page;

    public Article(String name, String cathegory, int page) throws RemoteException {
        this.page = page;
        this.name = name;
        this.cathegory = cathegory;
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public Integer getPage() throws RemoteException {
        return page;
    }

    @Override
    public String getCathegory()throws RemoteException{
        return cathegory;
    }

    @Override
    public void setPage(Integer newPage) throws RemoteException {
        this.page = newPage;
    }
}
