package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TodoPage {
    private static final String PAGE_URL = "https://forhemer.github.io/React-Todo-List/";
    public static final By FIELD_ADD_TODO = By.xpath(".//input");
    public static final By SUBMIT = By.xpath(".//button");
    public static final By CHECKBOX2 = By.xpath("(.//input[@type='checkbox'])[2]");
    public static final By ELEMENT2 = By.xpath(".//span[text()='2']");
    public static final By ELEMENT2_LINE_THROUGH = By.xpath(".//span[contains(@style, 'line-through')]");
    public static final By DELETE_ELEMENT2 = By.xpath("(.//button[text()='Delete'])[2]");
    private WebDriver driver;
    public TodoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void inputElement(String ELEMENT) {
        WebElement field = driver.findElement(FIELD_ADD_TODO);
        field.sendKeys(ELEMENT);
    }

    public void clickButton() {
        WebElement button = driver.findElement(SUBMIT);
        button.click();
    }

    public void addElement(String ELEMENT) {
        inputElement(ELEMENT);
        clickButton();
    }
    public void clickCheckbox2() {
        WebElement checkbox = driver.findElement(CHECKBOX2);
        checkbox.click();
    }

    public boolean isElement2LineThrough(By ELEMENT2_LINE_THROUGH) {
        try {
            return driver.findElement(ELEMENT2_LINE_THROUGH).isDisplayed();
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean isElement2isDisplayed(By ELEMENT2) {
        try {
            return driver.findElement(ELEMENT2).isDisplayed();
        } catch (Exception ignored) {
            return false;
        }
    }

    public void deleteElement2() {
        WebElement driverElement2 = driver.findElement(DELETE_ELEMENT2);
        driverElement2.click();
    }

}
