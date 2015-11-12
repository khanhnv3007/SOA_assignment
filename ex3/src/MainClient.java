import net.webservicex.*;
import java.util.Scanner;

public class MainClient {
	public static void main(String...arg) {
    	CurrencyConvertor service = new CurrencyConvertor();
    	CurrencyConvertorSoap port = service.getCurrencyConvertorSoap();
    	
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Please enter the source currency");
    	String fromCur = scanner.next();
    	fromCur = fromCur.toUpperCase();
    	Currency fromCurrency = Currency.fromValue(fromCur);
    	
    	System.out.println("Please enter the source currency");
    	String toCur = scanner.next();
    	toCur = toCur.toUpperCase();
    	Currency toCurrency = Currency.fromValue(toCur);
    	
    	scanner.close();
    	
    	//Invoke Service and Get Result
    	System.out.println("Invoking...");
    	double rate = port.conversionRate(fromCurrency, toCurrency);
    	       
    	//Use the generated objects in the result String placeName = forecasts.getPlaceName();
    	System.out.println(rate);
	}
}
