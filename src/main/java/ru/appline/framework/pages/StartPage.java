package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.framework.utils.Parameters;

import java.util.List;

public class StartPage extends BasePage {

    private static String conversionPage;

    public static String getConversionPage() {
        return conversionPage;
    }

    @FindBy(xpath = "//div[@class=\"services services_main\"]/div")
    List<WebElement> services;

    @Step ("Выбираем  поле '{nameService}'")
    public DepositPage selectServicesList(Parameters.Services nameService) {
        WebElement title;
        WebElement linkService;
        conversionPage = nameService.getTitleService();
        for (WebElement e: services) {
            title = e.findElement(By.xpath(".//div[@class=\"service__title-text\"]"));
            if(title.getText().equalsIgnoreCase(nameService.getTitleService())) {
                linkService = title.findElement(By.xpath("./../a[not(@class)]"));
                clickElement(linkService);
                return app.getDepositPage();
            }
        }
        Assertions.fail("Сервис \"" + nameService.getTitleService() + "\" отсутствует на странице");
        return app.getDepositPage();
    }

}
