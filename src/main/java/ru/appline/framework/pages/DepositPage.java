package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.framework.utils.Parameters;

import java.util.List;

public class DepositPage extends BasePage {

    @FindBy(xpath = "//h1")
    WebElement conversionPage;

    @FindBy(xpath = "//div[@class=\"calculator__currency-content\"]")
    List<WebElement> currency;

    @FindBy(xpath = "//input[@name=\"amount\"]")
    WebElement depositAmount;

    @FindBy(xpath = "//select[@id=\"period\"]")
    WebElement timeDeposit;

    @FindBy(xpath = "//input[@name=\"replenish\"]")
    WebElement monthlyReplenishment;

    @FindBy(xpath = "//input[@name=\"capitalization\"]/..")
    WebElement tickMonthlyCapitalization;

    @FindBy(xpath = "//span[@class=\"js-calc-earned\"]")
    WebElement accrued;

    @FindBy(xpath = "//span[@class=\"js-calc-replenish\"]")
    WebElement replenishment;

    @FindBy(xpath = "//span[@class=\"js-calc-result\"]")
    WebElement toWithdraw;


    @Step("Выбираем валюту '{nameCurrency}'")
    public DepositPage selectCurrency(Parameters.Currency nameCurrency) {
        Assertions.assertEquals(conversionPage.getText(), StartPage.getConversionPage(), "Страница \"" + StartPage.getConversionPage() + "\" не прогрузилась.");
        WebElement title;
        WebElement linkCurrency;
        for (WebElement e: currency) {
            title = e.findElement(By.xpath(".//span[contains(@class, \"text\")]"));
            if (title.getText().equals(nameCurrency.getTitleCurrency())){
                linkCurrency = e.findElement(By.xpath("./../.."));
                clickElement(linkCurrency);
                return this;
            }
        }
        Assertions.fail("Валюты \"" + nameCurrency.getTitleCurrency() + "\" нет на странице.");
        return this;
    }

    @Step("Заполняем форму")
    public DepositPage fillForm(String amount, Parameters.TimeDeposit time, String replenishment, Parameters.Tick capitalization) {
        fillInputField(depositAmount, amount);
        selector(timeDeposit, time.getTitleTimeDeposit());
        fillInputField(monthlyReplenishment, replenishment);
        if(!tickMonthlyCapitalization.getAttribute("class").endsWith("checked") && capitalization.isStateTick()) {
            clickElement(tickMonthlyCapitalization);
        }
        return this;
    }

    @Step("Проверка результатов после заполнения")
    public DepositPage expectedResults(String accrued, String replenishment, String toWithdraw) {
        if (!accrued.equals(this.accrued.getText()) || !replenishment.equals(this.replenishment.getText()) || !toWithdraw.equals(this.toWithdraw.getText())) sleeper(500);
        Assertions.assertAll(
                () -> Assertions.assertEquals(this.accrued.getText(), accrued, "Значение в поле 'Начислено' неверное"),
                () -> Assertions.assertEquals(this.replenishment.getText(), replenishment,"Значение в поле 'Пополнение за' неверное"),
                () -> Assertions.assertEquals(this.toWithdraw.getText(), toWithdraw,"Значение в поле 'К снятию через' неверное")
        );
        return this;
    }
}
