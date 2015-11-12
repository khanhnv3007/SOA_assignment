import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Price extends Remote {
    public String getPrice(String book_id) throws RemoteException;
}
