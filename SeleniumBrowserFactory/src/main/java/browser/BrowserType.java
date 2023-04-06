package browser;

public enum BrowserType {
    CHROME("chrome"), FIREFOX("firefox"), EDGE("egde"), SAFARI("safari");
    private final String browserJsonName;
    BrowserType(String browserName) {
        browserJsonName = browserName;
    }
    String getBrowserJsonName() {return browserJsonName;}
}
