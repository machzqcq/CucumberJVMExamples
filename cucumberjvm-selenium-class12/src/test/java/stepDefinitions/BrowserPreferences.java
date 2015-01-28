package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

/**
 * Created by pmacharl on 1/28/2015.
 */
public class BrowserPreferences {
    public WebDriver driver;
    public FirefoxProfile ffprofile;

    public BrowserPreferences()
    {
    }

    @Given("^I create a new firefox profile$")
    public void iCreateANewFirefoxProfile() throws Throwable {
        ffprofile = new FirefoxProfile();

    }

    @Then("^I pass that profile to create firefox browser$")
    public void iPassThatProfileToCreateFirefoxBrowser() throws Throwable {
        ffprofile.setPreference("browser.startup.homepage","http://seleniumframework.com");
        ffprofile.setAcceptUntrustedCertificates(true);
        ffprofile.setAssumeUntrustedCertificateIssuer(true);

        //Override useragent, or read a random line from useragents.txt
       // ffprofile.setPreference("general.useragent.override","Mozilla/5.0 (compatible; U; ABrowse 0.6; Syllable) AppleWebKit/420+ (KHTML, like Gecko)");
        driver = new FirefoxDriver(ffprofile);
        Thread.sleep(5000);
        driver.quit();

    }

    @Given("^I create a new firefox profile to automatically download a file$")
    public void iCreateANewFirefoxProfileWithProxy() throws Throwable {
        ffprofile = new FirefoxProfile();
        //2 means save to custom folder
        ffprofile.setPreference("browser.download.folderList",2);
        ffprofile.setPreference("browser.download.dir","c:\\seleniumdrivers");
        ffprofile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/x-zip-compressed");

    }

    @Then("^I use that profile to download$")
    public void iUseThatProfileToLaunchTheBrowser() throws Throwable {
        driver = new FirefoxDriver(ffprofile);
        driver.navigate().to("http://chromedriver.storage.googleapis.com/2.13/chromedriver_win32.zip");
        Thread.sleep(5000);
        driver.quit();
    }
}
