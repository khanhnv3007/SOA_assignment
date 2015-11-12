import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class PriceServer implements Price {
    public PriceServer(){};
    public String getPrice(String book_id){
    	String price = new String();
    	if(book_id.contains("978-0071605526")) price = "$25.00";
    	if(book_id.contains("978-0321815736")) price = "$46.29";
    	if(book_id.contains("978-0321718334")) price = "$39.99";
        return price;
    }

    public static void main(String[] args) {
        try {
            PriceServer obj = new PriceServer();
            Price stub = (Price)UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Price", stub);
        } catch (Exception e) {
            System.err.println("PriceServer exception:");
            e.printStackTrace();
        }
            
    }
}