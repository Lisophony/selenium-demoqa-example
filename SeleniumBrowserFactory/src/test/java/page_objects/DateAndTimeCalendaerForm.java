package page_objects;

import elements.BaseElement;
import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import utils.DateTimeUtil;

public class DateAndTimeCalendaerForm extends BasePage{
    public DateAndTimeCalendaerForm() {
        super(new BaseElement(By.xpath("//div[contains(@class,'time') and contains(@class,'container')]"), "Time container"), "Time Container");

    }
    String dayButtonLocator = "//div[(contains(@role,'option') and contains(text(),%s)) and contains(@aria-label,'%s')]";
    private Button leftArrow = new Button(By.xpath("//button[contains(@aria-label,'revious')]"), "LeftArrow Button");
    private Button rightArrow = new Button(By.xpath("//button[contains(@aria-label,'ext')]"), "NextArrow Bbutton");
    private Label currentYearAndMonth = new Label(By.xpath("//div[contains(@class,'current') and contains(@class,'month')]"), "Current year and month Label");

    public void setDateViaArrows(String year, String month, String day, String dateFormat) {
        if(DateTimeUtil.isBefore(year, month, day, dateFormat)) {
            while (!currentYearAndMonth.getText().equals(month + " " + year)) {
                rightArrow.click();
            }
        }
        else {
            while (!currentYearAndMonth.getText().equals(month + " " + year)) {
                leftArrow.click();
            }
        }
        pickDay(month, day);
    }

    private void pickDay(String month, String day) {
        String dayLocator = String.format(dayButtonLocator, day, month);
        new Button(By.xpath(dayLocator), day + " " + month + " day Button").click();
    }
}
