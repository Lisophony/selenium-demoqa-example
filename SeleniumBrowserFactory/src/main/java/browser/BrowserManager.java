package browser;

public class BrowserManager {
    private static Browser browserInstance = null;

    public static Browser getBrowser() {
        if(browserInstance != null)
            return browserInstance;
        return browserInstance = BrowserFactory.getBrowser();
    }

    public static void clearBrowserInstance() {
        browserInstance = null;
    }
}
