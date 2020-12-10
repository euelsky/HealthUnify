import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsForBMI {

    @Test
    public void normalweight() {
        System.setProperty("webdriver.chrome.driver", "/Users/eugeneuielski/BMIcalc/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("80");
        driver.findElement(By.name("ht")).sendKeys("180");
        driver.findElement(By.name("cc")).click();
        String actualCategoryText = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedCategoryText = "Your category is Normal";
        Assert.assertEquals(actualCategoryText, expectedCategoryText, "incorrect");
    }

    @Test
    public void obeseweight() {
        System.setProperty("webdriver.chrome.driver", "/Users/eugeneuielski/BMIcalc/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("170");
        driver.findElement(By.name("ht")).sendKeys("180");
        driver.findElement(By.name("cc")).click();
        String actualCategoryText = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedCategoryText = "Your category is Obese";
        Assert.assertEquals(actualCategoryText, expectedCategoryText, "incorrect");
    }

    @Test
    public void starvationweight() {
        System.setProperty("webdriver.chrome.driver", "/Users/eugeneuielski/BMIcalc/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("45");
        driver.findElement(By.name("ht")).sendKeys("190");
        driver.findElement(By.name("cc")).click();
        String actualCategoryText = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedCategoryText = "Your category is Starvation";
        Assert.assertEquals(actualCategoryText, expectedCategoryText, "incorrect");
    }



}
