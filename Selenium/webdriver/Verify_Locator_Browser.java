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
       // driver.quit();
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
        //driver.quit();
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
        //driver.quit();
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
       // driver.quit();
    }

    @Test
    public void TC_01_Check_Element_isDisplayed(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement email_lbl_Section_1 = driver.findElement(By.xpath("//label[@for='mail']"));
        WebElement email_textfield_Section_1 = driver.findElement(By.xpath("//input[@id='mail']"));
        WebElement email_lbl_Section_11 = driver.findElement(By.xpath("//label[@for='email']"));
        WebElement under18_lbl_Section_1 = driver.findElement(By.xpath("//label[@for='under_18']"));
        WebElement education_lbl_Section_2 = driver.findElement(By.xpath("//label[@for='edu']"));
        WebElement education_textarea_Section_2 = driver.findElement(By.xpath("//textarea[@id='edu']"));
        WebElement under18_radio_btn = driver.findElement(By.xpath("//input[@id='under_18']"));
        WebElement name_h5 = driver.findElement(By.xpath("//h5[text()='Name: User1']"));
        if (email_lbl_Section_11.isDisplayed() && email_lbl_Section_1.isDisplayed()){
            email_textfield_Section_1.sendKeys("Automation Testing");
            System.out.println("Element is displayed");
        }
        if(under18_lbl_Section_1.isDisplayed() && under18_radio_btn.isDisplayed() && !under18_radio_btn.isSelected()){
            under18_radio_btn.click();
            System.out.println("Element is displayed");
        }
        if(education_lbl_Section_2.isDisplayed() && education_textarea_Section_2.isDisplayed()) {
            education_textarea_Section_2.sendKeys("Automation Testing");
            System.out.println("Element is displayed");
        }
        if(!name_h5.isDisplayed()){
            System.out.println("Element is not displayed");
        }


    //    System.out.println(Email_lbl_Section_11.getText() + " + " + Email_lbl_Section_1.getText() );

    }

    @Test
    public void TC_02_Check_Element_isEnabled(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement email_lbl_Section_1 = driver.findElement(By.xpath("//label[@for='mail']"));
        WebElement email_lbl_Section_11 = driver.findElement(By.xpath("//label[@for='email']"));
        WebElement under18_lbl_Section_1 = driver.findElement(By.xpath("//label[@for='under_18']"));
        WebElement education_lbl_Section_2 = driver.findElement(By.xpath("//label[@for='edu']"));
        WebElement job_role_01_dropdown = driver.findElement(By.xpath("//select[@id='job1']"));
        WebElement job_role_02_dropdown = driver.findElement(By.xpath("//select[@id='job2']"));
        WebElement development_checkbox = driver.findElement(By.xpath("//input[@id='development']"));
        WebElement slider_lbl = driver.findElement(By.xpath("//label[@for='slider-1']"));
        WebElement slider_value = driver.findElement(By.xpath("//input[@id='slider-1']"));
        if (email_lbl_Section_11.isEnabled() && email_lbl_Section_1.isEnabled()){
            System.out.println("Element is enabled");
        }
        if(under18_lbl_Section_1.isEnabled()){
            System.out.println("Element is enabled");
        }
        if(education_lbl_Section_2.isEnabled()) {
            System.out.println("Element is enabled");
        }
        if(job_role_01_dropdown.isEnabled() && job_role_02_dropdown.isEnabled()) {
            System.out.println("Element (dropdown) is enabled");
        }
        if(development_checkbox.isEnabled()){
            System.out.println("Element is enabled");
        }
        if(slider_lbl.isDisplayed() && slider_lbl.isEnabled() && slider_value.isEnabled()){
            System.out.println("Element is enabled");
        }
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}