import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {
    WebDriver webDriver;
    WebDriverWait wait;
    @Given("I open browser")
    public void iOpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\spier\\Desktop\\testowanie\\CodersLab\\automation testing\\WebDrivers\\chromedriver.exe");
        webDriver = new ChromeDriver(); // each call this line of code -> new browser will be opened.
        wait = new WebDriverWait(webDriver, 3);
    }

    @And("I go to login page")
    public void iGoToLoginPage() {
        webDriver.get("https://studyhub-rmr6.onrender.com/loginRegister");
    }

    @When("I type {string} as login")
    public void iTypeAsLogin(String login) {
        webDriver.findElement(By.cssSelector("input[name='email']")).sendKeys(login);
    }

    @And("I type {string} as password")
    public void iTypeAsPassword(String password) {
        webDriver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        webDriver.findElement(By.cssSelector("button[id='loginBtn']")).click();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        wait.until(ExpectedConditions.urlContains("/tutorIn"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='logoutBtn']")));
        String expectedText = "My tutor profile";
        String currentText = webDriver.findElement(By.cssSelector("h2[id='tutorHeader']")).getText();
        Assert.assertTrue(currentText.contains(expectedText));
    }

    @Then("I am NOT logged in")
    public void iAmNOTLoggedIn() {

    }
}
