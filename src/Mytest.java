import java.security.PublicKey;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Mytest extends Parameters {

	@BeforeTest
	public void MyBeforeTest()

	{
		driver.get(TheWebsite);
		driver.manage().window().maximize();

	}

	@Test(description = "test 1", priority = 1)
	public void CheckForLanguage()

	{
		String ActualWebLanguage = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]"))
				.getText();
		myAssert.assertEquals(ActualWebLanguage, ExpectedWebLanguageArabic);

	}

	@Test(description = "test 2", priority = 2)
	public void CheckForCurrencey() {
		String ActualCurrency = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/div[1]/div/button")).getText();
		myAssert.assertEquals(ActualCurrency, ExpectedCurrency);

	}

	@Test(description = "test 3", priority = 3)
	public void CheckContactNumber() {
		String ActualContactNumber = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[2]/strong")).getText();
		myAssert.assertEquals(ActualContactNumber, ExpectedContactNumber);

	}

	@Test(description = "test 4", priority = 4)
	public void CheckQitafLogo() {

		WebElement LogosInFooter = driver.findElement(By.tagName("footer"));

		List<WebElement> SearchLogoInsideDiv = LogosInFooter.findElements(By.tagName("svg"));

		for (int i = 0; i < SearchLogoInsideDiv.size(); i++) {
			String ResultForSearchDiv = SearchLogoInsideDiv.get(i).getAttribute("data-testid");
			System.out.println(ResultForSearchDiv);

			if (ResultForSearchDiv == null) {
				continue;
			} else if (ResultForSearchDiv.equals("Footer__QitafLogo")) {
				ActualQittafInFooter = true;
			}
			myAssert.assertEquals(ActualQittafInFooter, true);
		}

	}

	@Test(description = "test 5", priority = 5)
	public void Hotel_Tap_NotSelected() {
		WebElement HotelTap = driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]"));
		String ActualHotelTapNotPressed = HotelTap.getAttribute("aria-selected");
		System.out.println(ActualHotelTapNotPressed);
		myAssert.assertEquals(ActualHotelTapNotPressed, ExpectedHotelTapNotPressed);

	}

	@SuppressWarnings("deprecation")
	@Test(description = "test 6", priority = 6)
	public void DateOfDepature() {
		String ActualDayInWebsite = driver.findElement(By.xpath(
				"//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[3]/div/div/div/div[1]/span[2]"))
				.getText();
		System.out.println(ActualDayInWebsite);
		Date MyDate = new Date();
		int Expected_Actual_DateInComp = MyDate.getDate();
		System.out.println(Expected_Actual_DateInComp);
		int Converted_ActualDayInWebsite = Integer.parseInt(ActualDayInWebsite);
		myAssert.assertEquals(Converted_ActualDayInWebsite, Expected_Actual_DateInComp + 1);

	}

	@SuppressWarnings("deprecation")
	@Test(description = "test 7", priority = 7)
	public void DateOfReturn() {
		String ActualRetDayInWebsite = driver.findElement(By.xpath(
				"//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[3]/div/div/div/div[2]/span[2]"))
				.getText();
		int Converted_ActualRetDayInWebsite = Integer.parseInt(ActualRetDayInWebsite);
		Date MyDate = new Date();
		int Expected_Actual_DateInComp = MyDate.getDate();
		myAssert.assertEquals(Converted_ActualRetDayInWebsite, Expected_Actual_DateInComp + 2);

	}

//	@Test(description = "test 8", invocationCount = 3, priority = 8)
//	public void RandomLanguageTest() {
//		String[] WebsiteUrlListForLanguage = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
//		int TheRandomGet = rand.nextInt(0, 2);
//		driver.get(WebsiteUrlListForLanguage[TheRandomGet]);
////driver.get(WebsiteUrlListForLanguage[rand.nextInt(0, 2)]);
//		if (driver.getCurrentUrl().contains("en")) {
//			String ActualTestLang = driver
//					.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]")).getText();
//			myAssert.assertEquals(ActualTestLang, ExpectedWebLanguageArabic);
//		} else {
//			String ActualTestLang = driver
//					.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]")).getText();
//			myAssert.assertEquals(ActualTestLang, expectedWebLanguageEnglish);
//		String[] WebsiteUrlLanguages = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
//		int RandomLangSelect = rand.nextInt(0, 2);
//		driver.get(WebsiteUrlLanguages[RandomLangSelect]);
//		if (driver.getCurrentUrl().contains("en")) {
//			String ButtonWhenEnglish = driver
//					.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]")).getText();
//			myAssert.assertEquals(ButtonWhenEnglish, ExpectedWebLanguageArabic);
//		} else {
//			String ButtonWhenArabic = driver
//					.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]")).getText();
//			myAssert.assertEquals(ButtonWhenArabic, expectedWebLanguageEnglish);
//		}
//
//	}

	@Test(description = "test 9", priority = 8)
	public void TestForHotelSearch_DueLan() {
		String[] EnglishCountries = { "Dubai", "Jeddah", "Riyadh" };
		int RandEnglishCountries = rand.nextInt(0, 3);
		String[] ArabicCountries = { "جدة", "دبي" };
		int RandArabicCountries = rand.nextInt(0, 2);
		String[] WebsiteUrlLanguages = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
		int RandomLangSelect = rand.nextInt(0, 2);
		driver.get(WebsiteUrlLanguages[RandomLangSelect]);

		if (driver.getCurrentUrl().contains("en")) {
			WebElement HotelButtonEnglish = driver
					.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]/div"));
			HotelButtonEnglish.click();
			WebElement SearchField = driver.findElement(By.xpath(
					"//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[1]/div/div/div/div/input"));
			SearchField.sendKeys(EnglishCountries[RandEnglishCountries] + Keys.ARROW_DOWN);
//			SearchField.sendKeys(Keys.chord(Keys.ARROW_DOWN)+Keys.ENTER);
			driver.findElement(
					By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[4]/button")).click();
		} else {
			WebElement HotelButtonArabic = driver
					.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]/div"));
			HotelButtonArabic.click();
			WebElement SearchField = driver.findElement(By.xpath(
					"//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[1]/div/div/div/div/input"));
			SearchField.sendKeys(ArabicCountries[RandArabicCountries] + Keys.ARROW_DOWN);
//SearchField.sendKeys(Keys.chord(Keys.ARROW_DOWN)+Keys.ENTER);
			driver.findElement(
					By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[4]/button")).click();
		}

	}

	@Test(description = "test 10", priority = 9)
	public void RandomVisitorNumber() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement NumberOfVisitors = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/section[2]/div/section/div/div/div/div/div[3]/div/select"));

		Select MySelector = new Select(NumberOfVisitors);
		int NumberOfVisitorsINDEX = rand.nextInt(0, 2);
		MySelector.selectByIndex(NumberOfVisitorsINDEX);

	}

	@Test(description = "test 11", priority = 10)
	public void HotelSearchButton() {
		WebElement SearchButton = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/section[2]/div/section/div/div/div/div/div[4]/button"));
		SearchButton.click();
	}

	@Test(description = "Test 12", priority = 11)
	public void DoneSearching() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement SearchingResult = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section/span"));
		String TextSearchingResult = SearchingResult.getText();
		System.out.println(TextSearchingResult);
		boolean ActualDoneSearchingInWebsite = TextSearchingResult.contains("founds")
				|| TextSearchingResult.contains("وجدنا");
		myAssert.assertEquals(ActualDoneSearchingInWebsite, true);
	}

	@Test(description = "Test 13", priority = 12)
	public void Sorting_From_Low_High() {
		WebElement LowestPriceButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[2]/section[1]/div/button[2]"));
		LowestPriceButton.click();
		
	WebElement RightSide = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[2]"));
	List <WebElement> SortedPrices = RightSide.findElements(By.className("Price__Value"));
	for(int i=0; i<SortedPrices.size();i++)
	{
		String First = SortedPrices.get(0).getText();
		String Last = SortedPrices.get(SortedPrices.size()-1).getText();
		int FirstConverted = Integer.parseInt(First);
		int LastConverted = Integer.parseInt(Last);
		myAssert.assertEquals(FirstConverted<LastConverted, true);

	}

	}

	@AfterTest
	public void AfterrTest() {

	}

}
