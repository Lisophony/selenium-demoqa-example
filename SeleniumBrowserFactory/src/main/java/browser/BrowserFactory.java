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
    public enum BrowserType {
        CHROME("chrome"), FIREFOX("firefox"), EDGE("egde"), SAFARI("safari");
        private String browserJsonName;
        BrowserType(String browserName) {
            browserJsonName = browserName;
        }
        String getBrowserJsonName() {return browserJsonName;}
    }

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



    private static SafariOptions getSafariOptions() {
        return null;
    }

    private static EdgeOptions getEdgeOptions() {
        return null;
    }

    private static FirefoxOptions getFirefoxOptions() {
        return null;
    }

    private static ChromeOptions getChromeOptions() {
        return null;
    }

}
