package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Verify_Locator_Browser {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Verify_URL() {
        driver.get("http://live.techpanda.org/");
        String Login_URL = "http://live.techpanda.org/index.php/customer/account/login/";
        String Create_URL = "http://live.techpanda.org/customer/account/create/";
        WebElement MyAccount_btn =  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        MyAccount_btn.click();
        if (driver.getCurrentUrl().equals(Login_URL)){
            WebElement CreateAccount_btn =  driver.findElement(By.xpath("//a[@title='Create an Account']"));
            if (CreateAccount_btn.isDisplayed()) {
                CreateAccount_btn.click();
                driver.getCurrentUrl().equals(Create_URL);
                System.out.println("ok");
            }
        };
        driver.quit();
    }

    @Test
    public void TC_02_Verify_Title() {
        driver.get("http://live.techpanda.org/");
        String Login_Title = "Customer Login";
        String Create_Title = "Create New Customer Account";
        WebElement MyAccount_btn =  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        MyAccount_btn.click();
        if (driver.getTitle().equals(Login_Title)){
            WebElement CreateAccount_btn =  driver.findElement(By.xpath("//a[@title='Create an Account']"));
            if (CreateAccount_btn.isDisplayed()) {
                CreateAccount_btn.click();
                driver.getTitle().equals(Create_Title);
                driver.navigate().back();
                System.out.println("ok");
            }
        };
        driver.quit();
    }

    @Test
    public void TC_03_Navigate_Function() {
        driver.get("http://live.techpanda.org/");
        String Login_Title = "Customer Login";
        String Create_Title = "Create New Customer Account";
        String Login_URL = "http://live.techpanda.org/index.php/customer/account/login/";
        String Create_URL = "http://live.techpanda.org/customer/account/create/";
        WebElement MyAccount_btn =  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        MyAccount_btn.click();
        if (driver.getTitle().equals(Login_Title)){
            WebElement CreateAccount_btn =  driver.findElement(By.xpath("//a[@title='Create an Account']"));
            if (CreateAccount_btn.isDisplayed()) {
                CreateAccount_btn.click();
                if (driver.getCurrentUrl().equals(Create_URL)) driver.navigate().back();
                if (driver.getCurrentUrl().equals(Login_URL)) driver.navigate().forward();
                if (driver.getTitle().equals(Create_Title)) System.out.println("OK");
            }

        };
        driver.quit();
    }

    @Test
    public void TC_04_Get_Page_Source() {
        driver.get("http://live.techpanda.org/");
        String Login_Title = "Customer Login";
        String Create_Title = "Create New Customer Account";
        String Login_URL = "http://live.techpanda.org/index.php/customer/account/login/";
        String Create_URL = "http://live.techpanda.org/customer/account/create/";
        WebElement MyAccount_btn =  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        MyAccount_btn.click();
        if (driver.getPageSource().contains("Login or Create an Account")){
            WebElement CreateAccount_btn =  driver.findElement(By.xpath("//a[@title='Create an Account']"));
            if (CreateAccount_btn.isDisplayed()) {
                CreateAccount_btn.click();
                driver.getPageSource().contains("Create an Account");
                System.out.println("OK");
            }
        };
        driver.quit();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}