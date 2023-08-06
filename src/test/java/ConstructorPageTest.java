import io.qameta.allure.junit4.DisplayName;
import org.example.pageobject.ConstructorPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class ConstructorPageTest {
    private WebDriver driver;
    private ConstructorPage constructorPage;

    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "yandexdriver.exe");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Переход на вкладку Булки")
    public void canChoseRollsMenu() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        constructorPage = new ConstructorPage(driver);

        constructorPage.waitCreateBurgerBunner();
        if (!constructorPage.getRollsButtonDiv().getAttribute("class").contains("current")) {
            constructorPage.clickRollsButton();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(constructorPage.getRollsButtonDiv().getAttribute("class").contains("current"));
    }

    @Test
    @DisplayName("Переход на вкладку Соусы")
    public void canChoseSausesMenu() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        constructorPage = new ConstructorPage(driver);

        constructorPage.waitCreateBurgerBunner();
        if (!constructorPage.getSausesButtonDiv().getAttribute("class").contains("current")) {
            constructorPage.clickSausesButton();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(constructorPage.getSausesButtonDiv().getAttribute("class").contains("current"));
    }

    @Test
    @DisplayName("Переход на вкладку Начинки")
    public void canChoseFillingsMenu() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        constructorPage = new ConstructorPage(driver);

        constructorPage.waitCreateBurgerBunner();
        if (!constructorPage.getFillingsButtonDiv().getAttribute("class").contains("current")) {
            constructorPage.clickFillingsButton();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(constructorPage.getFillingsButtonDiv().getAttribute("class").contains("current"));
    }
}