package Automation;

public class auto1 {

}
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSanity {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up Selenium WebDriver
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait
    }

    @Test
    public void testPageLoads() {
        // Test whether the page loads successfully
        driver.get("http://localhost:8080/interview");
        assertTrue(driver.getTitle().contains("Professional Experiences"));
    }

    @Test
    public void testExperiencesDisplayed() {
        // Test whether professional experiences are displayed
        driver.get("http://localhost:8080/interview");
        WebElement experiencesList = driver.findElement(By.tagName("ul"));
        assertTrue(experiencesList.findElements(By.tagName("li")).size() > 0);
    }

    @After
    public void tearDown() {
        // Clean up after the test
        driver.quit();
    }
}
