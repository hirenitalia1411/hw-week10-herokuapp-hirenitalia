package herokuapp;
/**
 * Project-3 - ProjectName : com-herokuapp
 * BaseUrl = http://the-internet.herokuapp.com/login
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Refresh the page.
 * 11. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class HerokuApp {

    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static String browser = "Chrome";
    static WebDriver driver;

    public static void main(String[] args) {

        // Step 1: Setup browser
        if (browser.trim().equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name");
        }

        // Step 2: Open URL
        driver.get(baseUrl); // open the URL in the browser
        driver.manage().window().maximize(); // maximize the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000)); // wait for 5 seconds to load the page

        // Step 3: Print title of the page
        String titleOfPage = driver.getTitle();
        System.out.println("Title of the page: " + titleOfPage);

        // Step 4: Print the current URL
        System.out.println("The Current Page URL: " + driver.getCurrentUrl());

        // Step 5: Print the page resource
        System.out.println(driver.getPageSource());

        // Step 6: Enter email to the email field
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        // Step 7: Enter password to the password field
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        // Step 8: Click on login button
        driver.findElement(By.cssSelector("i[class^='fa fa-2x fa-sign-in']")).click();

        // Step 9: Print the current URL
        System.out.println("The Current Page URL: " + driver.getCurrentUrl());

        // Step 10: Refresh the page (using refresh button on the browser)
        driver.navigate().refresh();

        // Step 11: Close the browser
        driver.quit();
    }
}
