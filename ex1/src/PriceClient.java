import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class PriceClient {
    private PriceClient() {};
    public static void main(String[] args) {
    	try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            Price stub = (Price) registry.lookup("Price");
            
            Scanner scanner = new Scanner(System.in);
            String isbn = scanner.next();
            String response = stub.getPrice(isbn);
            scanner.close();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("PriceClient exception:");
            e.printStackTrace();
        }
   }
}

