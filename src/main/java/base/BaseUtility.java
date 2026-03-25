package base;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseUtility {
	public static WebDriver driver = null;;

	public void getURL(String Url) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);
		driver.manage().window().maximize();

	}
	
	public static void main(String[] args) {
		BaseUtility ut = new BaseUtility();
		ut.getURL("https://t1tg.tractorfirst.com/");
	}

}
