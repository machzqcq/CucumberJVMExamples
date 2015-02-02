package modules;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Properties;
public class ContactusModule {
    public static void Execute(WebDriver driver,Properties OR,String orderref,String message) throws Exception{
        driver.findElement(By.linkText(OR.getProperty("contact_us_text"))).click();
        new Select(driver.findElement(By.id(OR.getProperty("subject_heading_id")))).selectByVisibleText("Customer service");
        driver.findElement(By.id(OR.getProperty("email_id"))).sendKeys("pradeep@seleniumframework.com");
        driver.findElement(By.id(OR.getProperty("order_reference_id"))).sendKeys(orderref);
        driver.findElement(By.id(OR.getProperty("message_id"))).sendKeys(message);
        driver.findElement(By.id(OR.getProperty("submit_message_id"))).click();
    }
}