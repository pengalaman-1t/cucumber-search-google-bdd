package StepBy;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {
    WebDriver driver;
    @Given("saya Buka browser")
    public void sayaBukaBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @And("Buka situs web Google")
    public void bukaSitusWebGoogle() throws InterruptedException {
        driver.get("https://www.google.com/");
//        Sleep 7 detik setelah membuka google.com
        Thread.sleep(7000);
    }

    @And("Terletak di situs web google")
    public void terletakDiSitusWebGoogle() {
        driver.findElement(By.name("btnK")).isDisplayed();
    }

    @When("saya mencari {string}")
    public void sayaMencari(String searchValue) {
        driver.findElement(By.name("q")).sendKeys(searchValue);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("Menampilkan hasil yang terkait dengan {string}")
    public void menampilkanHasilYangTerkaitDengan(String arg0) {
//        mencari url rsyndu
        driver.findElement(By.xpath("//a[@href='https://id.linkedin.com/in/rsyndu/in']")).isDisplayed();
//        menangkap title
        String urlLinkedinSyndu = driver.findElement(By.xpath("//a[@href='https://id.linkedin.com/in/rsyndu/in']")).getText();
//       cetak variabel titel tersebut
        System.out.println(urlLinkedinSyndu);
        driver.close();
        driver.quit();
    }
}
