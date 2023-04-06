package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class BrowserFactory {
    public static WebDriver createDriver(BrowserType type) {
        switch (type) {
            case CHROME -> {
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                return new ChromeDriver(getChromeOptions());
            }
            case FIREFOX -> {
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                return new FirefoxDriver(getFirefoxOptions());
            }
            case EDGE -> {
                WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
                return new EdgeDriver(getEdgeOptions());
            }
            case SAFARI -> {
                WebDriverManager.getInstance(DriverManagerType.SAFARI).setup();
                return new SafariDriver(getSafariOptions());
            }
            default -> throw new IllegalStateException("Unexpected value in switch: " + type);
        }
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        return chromeOptions;
    }

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--incognito");
        return firefoxOptions;
    }

    private static SafariOptions getSafariOptions() {
        return new SafariOptions();
    }

    private static EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--incognito");
        return edgeOptions;
    }
    private static final String keyMaxWin = "start-max";
    private static final String keyIncognito = "search-mode";
}
