import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class TestsForBMI {

    Random wg = new Random();
    int rw = wg.nextInt();


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
    public void minWeight(){

        System.setProperty("webdriver.chrome.driver", "/Users/eugeneuielski/BMIcalc/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("10");
        driver.findElement(By.name("cc")).click();
        String actualErrorTextMinWG = driver.switchTo().alert().getText();
        String expectedErrorTextMinWG = "Weight should be greater than 10kgs";
        driver.switchTo().alert().accept();
        driver.findElement(By.name("wg")).clear();
        driver.findElement(By.name("wg")).sendKeys("11");
    }

    @Test
    public void minHeight(){
            System.setProperty("webdriver.chrome.driver", "/Users/eugeneuielski/BMIcalc/src/test/resources/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://healthunify.com/bmicalculator/");
            driver.findElement(By.name("wg")).sendKeys("11");
            Select hgOpt2 = new Select(driver.findElement(By.name("opt2")));
            hgOpt2.selectByValue("1");
            Select hgOpt3 = new Select(driver.findElement(By.name("opt3")));
            hgOpt3.selectByValue("1");
            String actualSiValue = driver.findElement(By.name("si")).getAttribute("value");
            String expectedSIvalue = "101.01";
            hgOpt3.selectByValue("0");
            driver.findElement(By.name("cc")).click();
            String actualErrorTextMinHG = driver.switchTo().alert().getText();
            String expectedErrorTextMinHG = "Height should be taller than 33cms";

    }


}
