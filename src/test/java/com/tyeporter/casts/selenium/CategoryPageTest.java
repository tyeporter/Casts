package com.tyeporter.casts.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.tyeporter.casts.selenium.pom.CategoryPageModel;
import com.tyeporter.casts.selenium.util.Browser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CategoryPageTest {

    private WebDriver driver;
    private Browser browser;

    private CategoryPageModel categoryPage;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        this.browser = Browser.FIREFOX;
        if (browser.equals(Browser.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "/Users/tyeporter/selenium/geckodriver");
            driver = new FirefoxDriver();
            driver.get("http://localhost:" + this.port + "/science");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } else if (browser.equals(Browser.CHROME)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

        this.categoryPage = new CategoryPageModel(this.driver);
    }

    @Test
    public void testPageHasCorrectTitle() {
        String expected = "Casts";
        String actual = this.categoryPage.getPageTitleText();

        assertEquals(expected, actual);
    }

    @Test
    public void testPageHasCorrectNavigationItemSize() {
        List<String> actual = this.categoryPage.getPageNavigationAnchorTitles();
        assertEquals(7, actual.size());
    }

    @Test
    public void testPageHasCorrectNavigationItemTitles() {
        List<String> actual = this.categoryPage.getPageNavigationAnchorTitles();
        assertThat(actual, containsInAnyOrder("Science", "Health", "Politics", "Spirituality", "Sports", "Relationships", ""));
    }

}
