package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkoutFullAddDetailsPage extends BasePage {

//    public static final By DETAILS_TAB = By.xpath("//div[contains(@class,'w-box-header')]//h4[contains(text(), 'Workout Details')]");
    public static final By title = By.id("dpMonth");
    public WorkoutFullAddDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(title);
    }
}
