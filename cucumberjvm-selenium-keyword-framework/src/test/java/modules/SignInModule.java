package modules;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Properties;
public class SignInModule {
    public static void Execute(WebDriver driver,Properties OR,String username,String password) throws Exception{
        driver.findElement(By.linkText(OR.getProperty("signin_text"))).click();
        driver.findElement(By.id(OR.getProperty("username_id"))).sendKeys(username);
        driver.findElement(By.id(OR.getProperty("password_id"))).sendKeys(password);
        driver.findElement(By.id(OR.getProperty("submit_login_id"))).click();
    }
}