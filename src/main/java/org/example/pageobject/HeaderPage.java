package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class HeaderPage {
    private WebDriver driver;
    private By mainLogo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    private By enterPersonalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private By constructorButton = By.xpath("//p[text()='Конструктор']");

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMainLogo() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(mainLogo));
        driver.findElement(mainLogo).click();
    }

    public void clickEnterPersonalAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(enterPersonalAccountButton));
        driver.findElement(enterPersonalAccountButton).click();
    }

    public void clickConstructorButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(constructorButton));
        driver.findElement(constructorButton).click();
    }
}
