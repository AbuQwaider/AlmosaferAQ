import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class Parameters {
	static WebDriver driver = new ChromeDriver();
	String TheWebsite = "https://www.almosafer.com/en";
	Assertion myAssert = new Assertion();
	String ExpectedWebLanguageArabic = "العربية";
	String expectedWebLanguageEnglish = "English";
	String ExpectedCurrency = "SAR";
	String ExpectedContactNumber = "+966554400000";
	String ExpectedHotelTapNotPressed = "false";
	boolean ActualQittafInFooter = true;
	Random rand = new Random();
}
