import net.webservicex.*;
import java.math.*;
public class MainClient {
	public static void main(String...arg) { System.out.println("Invoking...");
	CurrencyConvertor service = new CurrencyConvertor();
	CurrencyConvertorSoap port = service.getCurrencyConvertorSoap();
	
	Currency fromCurrency = Currency.fromValue("USD");
	Currency toCurrency = Currency.fromValue("EUR");
	//Invoke Service and Get Result
	double rate = port.conversionRate(fromCurrency, toCurrency);
	       
	    //Use the generated objects in the result String placeName = forecasts.getPlaceName();
	System.out.println(rate);
	}
}
