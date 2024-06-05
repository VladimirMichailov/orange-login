package lt.techin.vm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrangeLogin {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

        @Test
        void loginToPage(){

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector(".orangehrm-login-button")).click();

        }

    @Test
    void loginToPageUsingPageData(){
        String fullUserName = driver.findElement(By.cssSelector(".orangehrm-demo-credentials.oxd-sheet.oxd-sheet--gray-lighten-2.oxd-sheet--gutters.oxd-sheet--rounded > p:nth-of-type(1)")).getText();
        String fullPassword = driver.findElement(By.cssSelector(".orangehrm-demo-credentials.oxd-sheet.oxd-sheet--gray-lighten-2.oxd-sheet--gutters.oxd-sheet--rounded > p:nth-of-type(2)")).getText();

        String[] usernameSplited = fullUserName.split(" ");
        String username = usernameSplited[usernameSplited.length - 1];

        String[] passwordSplited = fullPassword.split(" ");
        String password = passwordSplited[passwordSplited.length - 1];


        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector(".orangehrm-login-button")).click();

        assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",driver.getCurrentUrl()," Puslapio adresai nesutampa");

    }


}

