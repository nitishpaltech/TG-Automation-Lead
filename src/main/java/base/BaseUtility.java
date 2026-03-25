package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUtility {

    public static WebDriver driver;
    public static Properties prop;

    // Load config.properties
    public void loadConfig() {

        prop = new Properties();

        try {

            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir")
                            + "/src/test/resources/config.properties");

            prop.load(fis);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    // Browser setup
    @BeforeMethod
    public void setup() {

        loadConfig();

        String browser = prop.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        }

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        String env = prop.getProperty("env");

        if(env.equalsIgnoreCase("testing")) {

            driver.get(prop.getProperty("testingUrl"));

        }

        else if(env.equalsIgnoreCase("production")) {

            driver.get(prop.getProperty("productionUrl"));

        }

    }

    // Browser close
    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

}