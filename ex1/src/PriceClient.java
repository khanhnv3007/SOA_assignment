import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PriceClient {
    private PriceClient() {};
    public static void main(String[] args) {
    	try {
            Registry registry = LocateRegistry.getRegistry();
            Price stub = (Price) registry.lookup("Price");
            String response = stub.getPrice(args[0]);
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("PriceClient exception:");
            e.printStackTrace();
        }
   }
}

