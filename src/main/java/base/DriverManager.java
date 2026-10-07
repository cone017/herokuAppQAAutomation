package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigReader;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

        public static WebDriver getDriver() {
            return driverThreadLocal.get();
        }

        public static void initDriver() {
            String browser = ConfigReader.getBrowser();

            WebDriver driver;
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();

                    String downloadPath = System.getProperty("user.dir") + "/downloads";
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("download.default_directory", downloadPath);
                    prefs.put("download.prompt_for_download", false);
                    options.setExperimentalOption("prefs", prefs);

                    options.addArguments("--disable-features=DnsOverHttps");

                    if (ConfigReader.isHeadless()) {
                        options.addArguments("--headless=new");
                    }
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");

                    driver = new ChromeDriver(options);
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getImplicitWait()));
            driver.manage().window().maximize();

            driverThreadLocal.set(driver);
        }

        public static void quitDriver() {
            if (getDriver() != null) {
                getDriver().quit();
                driverThreadLocal.remove();
            }
        }
}
