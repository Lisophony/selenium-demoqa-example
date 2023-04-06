package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.json.simple.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import utils.JsonUtil;

import java.util.List;

public class BrowserFactory {
    private static final JSONObject settings = JsonUtil.getJson("src/main/resources/browserSettings.json");
    private static final List<String> options = JsonUtil.getArray(settings, "options");
    private static final String browserSettingsName = settings.get("browserName").toString();

    public static Browser getBrowser(BrowserType type) {
        switch (type) {
            case CHROME -> {
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                return new Browser(new ChromeDriver(getChromeOptions()));
            }
            case FIREFOX -> {
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                return new Browser(new FirefoxDriver(getFirefoxOptions()));
            }
            case EDGE -> {
                WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
                return new Browser(new EdgeDriver(getEdgeOptions()));
            }
            case SAFARI -> {
                WebDriverManager.getInstance(DriverManagerType.SAFARI).setup();
                return new Browser(new SafariDriver(getSafariOptions()));
            }
            default -> throw new IllegalStateException("Unexpected value in switch: " + type);
        }
    }

    public static Browser getBrowser() {
        for (BrowserType type : BrowserType.values()) {
            if (type.getBrowserJsonName().equals(browserSettingsName)) {
                return getBrowser(type);
            }
        }
        throw new IllegalStateException("Invalid browser name in json settings file");
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(options);
        return chromeOptions;
    }

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(options);
        return firefoxOptions;
    }

    private static SafariOptions getSafariOptions() {
        return new SafariOptions();
    }

    private static EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(options);
        return edgeOptions;
    }
}
