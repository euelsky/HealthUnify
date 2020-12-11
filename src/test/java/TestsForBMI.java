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

    @Test
    public void errorPopupText() {
        System.setProperty("webdriver.chrome.driver", "/Users/eugeneuielski/BMIcalc/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("cc")).click();
        driver.switchTo().alert().getText();
        String actualErrorText = driver.switchTo().alert().getText();
        String expectedErrorText = "Enter the value for weight";
        Assert.assertEquals(actualErrorText, expectedErrorText, "incorrect");
    }

    @Test
    public void emptyFieldsResult() {
        System.setProperty("webdriver.chrome.driver", "/Users/eugeneuielski/BMIcalc/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("cc")).click();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        String actualSiValue = driver.findElement(By.name("si")).getAttribute("value");
        String expectedSIvalue = "NaN";
        Assert.assertEquals(actualSiValue, expectedSIvalue, "incorrect");
        String actualUSValue = driver.findElement(By.name("us")).getAttribute("value");
        String expectedUSvalue = "NaN";
        Assert.assertEquals(actualUSValue, expectedUSvalue, "incorrect");
        String actualUKValue = driver.findElement(By.name("uk")).getAttribute("value");
        String expectedUKvalue = "NaN";
        Assert.assertEquals(actualUKValue, expectedUKvalue, "incorrect");
    }
    @Test


}
