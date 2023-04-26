package page_objects;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    String cardsLoc = "//div[contains(@class,'top')]//h5[contains(text(),'%s')]";
    public enum Cards {
        ELEMENTS("Elements"), ALERTS("Alerts");

        final String cardName;

        Cards(String cardName) {
           this.cardName = cardName;
        }

        public String getCardName() {
            return cardName;
        }
    }

    public MainPage() {
        super(new Label(By.xpath("//img[contains(@class,'banner') and contains(@alt,'raining')]"), "Banner"), "Main Page");
    }

    public void clickOnCard(Cards cardType) {
        By cardLocator = By.xpath(String.format(cardsLoc, cardType.getCardName()));
        new Button(cardLocator, cardType.getCardName()).click();
    }
}
