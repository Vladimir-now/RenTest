package ru.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.managers.PageManager;


import static ru.appline.framework.managers.DriverManager.getDriver;

public class BasePage {

    protected PageManager app = PageManager.getPageManager();
    protected WebDriverWait wait = new WebDriverWait(getDriver(), 15, 500);
    protected JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    protected void scrollTo(WebElement element) {
        if (!element.isDisplayed()) javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void clickElement(WebElement element) {
        scrollTo(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void fillInputField(WebElement element, String value) {
        scrollTo(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(value);
    }

    protected void selector(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    protected void sleeper(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}