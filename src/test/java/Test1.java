import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jshell.execution.Util;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class Test1 {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @BeforeMethod
    public void eachSetup() {

    }

    @Test
    public void verifyThatPageTitleIsCorrect() throws InterruptedException { //pageTitleShouldBeTesterSii <-alternatywne nazewnictwo
        driver.get("http://146.59.32.4/index.php");
        assertEquals("TesterSii", driver.getTitle());

        driver.findElement(By.cssSelector(
                "div[itemprop=\"itemListElement\"]:nth-of-type(1) h3 a")).click();
        assertEquals("HUMMINGBIRD T-SHIRT", driver.getTitle());

        double cena1 = Double.parseDouble(
                driver.findElement(By.cssSelector(".current-price>span[content]")).getAttribute("content"));
        driver.findElement(By.cssSelector(
                "#add-to-cart-or-refresh > div.product-add-to-cart > div > div.add > button")).click();
//        Thread.sleep(2000);
        driver.get("http://146.59.32.4/index.php");
        driver.findElement(By.cssSelector("div[itemprop=\"itemListElement\"]:nth-of-type(2) h3 a")).click();
        assertEquals("HUMMINGBIRD SWEATER", driver.getTitle());

        double cena2 = Double.parseDouble(
                driver.findElement(By.cssSelector(".current-price>span[content]")).getAttribute("content"));
        driver.findElement(By.cssSelector(
                "#add-to-cart-or-refresh > div.product-add-to-cart > div > div.add > button")).click();
//        Thread.sleep(2000);

        String expectedPrice = ("zł" + String.format("%.2f", cena1 + cena2)).replace(',', '.');
//        Thread.sleep(400);
        String cenaKoszyka = driver.findElement(
                By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]")).getText();
//        assertEquals(expectedPrice,cenaKoszyka);
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1"));

    }

    @Test
    public void Test2() {
        driver.get("http://146.59.32.4/index.php");
        String prodTitle = "MUG THE ADVENTURE BEGINS";
        String featuredProductsCSS = ".featured-products div[itemprop=\"itemListElement\"]";
        List<WebElement> featuredProducts = driver.findElements(By.cssSelector(featuredProductsCSS));


        boolean found = false;
        for (WebElement item : featuredProducts) {

            WebElement title = item.findElement(By.cssSelector("h3.product-title a"));
            String priceOnMain = item.findElement(By.cssSelector(".product-price-and-shipping .price")).getText();
            if (title.getText().equals(prodTitle)) {
                found = true;
                title.click();
                assertEquals(prodTitle, driver.getTitle());
                assertEquals(priceOnMain, driver.findElement(
                        By.cssSelector(".product-price span[itemprop=\"price\"]")).getText());
                break;
            }
        }
        assertTrue(found);
    }

//    @Test
//    public void loopTestForms(){
//        for(int i=0;i<5;i++) {
//            try {
//                TestCaseForms();
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }


//jezyk na pl, wpisujemy adventure wbijamy enter potem dodac oba produky poprzez klik szybki podglad, zmienic ilosc na dwa
// obraz zmieniamy 80-120 i ilosc 2x, i na koniec se wejdz do koszyka i strzel screena ale tez sprawdzic czy sie zgadzaja dane

    @Test
    public void TestZadanie() throws IOException, InterruptedException {
        driver.get("http://146.59.32.4/index.php");
//        Select language = new Select(driver.findElement(
//                By.xpath("//*[@id=\"_desktop_language_selector\"]/div/div/select")));
//        language.selectByVisibleText("Polski");
        driver.findElement(By.xpath("//*[@id=\"_desktop_language_selector\"]/div/div/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"_desktop_language_selector\"]/div/div/ul/li[1]/a")).click();

        WebElement search = driver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/input[2]"));
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.elementToBeClickable(search));
        search.sendKeys("adventure");
        search.sendKeys(Keys.ENTER);

        WebElement producsRow = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]"));
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.elementToBeClickable(producsRow));

        String imageSize = "80x120cm";
        String amountOfItem = "";
        String price = "";

        WebElement product = driver.findElement(By.cssSelector(
                "#js-product-list > div.products.row > div:nth-child(2) > article > div > div.highlighted-informations.no-variants.hidden-sm-down > a"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(product));

        Actions action = new Actions(driver);
        action.moveToElement(product).build().perform();
        product.click();

        WebElement actualPrice = driver.findElement(By.cssSelector(
                "#quickview-modal-3-13  span[itemprop=\"price\"]"));

        WebElement selector = driver.findElement(By.xpath("//*[@id=\"group_3\"]"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(selector));
        Select imgSize = new Select(selector);
        imgSize.selectByValue("21");

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.stalenessOf(actualPrice));

        WebElement value = driver.findElement(By.xpath(
                "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]"));
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.elementToBeClickable(value));
//        Thread.sleep(100);
        value.click();
//        Thread.sleep(300);
        value.click();
//        Thread.sleep(300);
        driver.findElement(
                By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[2]")).click();

//        Thread.sleep(500);
        amountOfItem = driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).getAttribute("value");
        price = driver.findElement(By.xpath(
                "//*[@id=\"quickview-modal-3-13\"]/div/div/div[2]/div/div[2]/div[1]/div[1]/div/span")).getText();

        if(Integer.parseInt(amountOfItem)>1) {
            driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
        }else{
            value.click();
            driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
        }

        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1"));
        assertEquals(imageSize, driver.findElement(
                By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[3]/span[2]")).getText());
        assertEquals(amountOfItem, driver.findElement(By.xpath(
                "//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[1]/div/input"
                        )).getAttribute("value"));
        assertEquals(price, driver.findElement(By.xpath(
                "//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div/span"
                        )).getText());
        Utils.takeScreenShot(driver, "Zadanie1", "");
    }

    @Test
    public void TestCaseForms() throws InterruptedException, IOException {
        driver.get("http://146.59.32.4/index.php");
        driver.findElement(By.cssSelector(
                "div[itemprop=\"itemListElement\"]:nth-of-type(1) h3 a")).click();
        driver.findElement(By.cssSelector(
                "#add-to-cart-or-refresh > div.product-add-to-cart > div > div.add > button")).click();
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();

        driver.findElement(By.cssSelector("div.checkout.cart-detailed-actions.card-block a")).click();
        driver.findElement(By.id("checkout-personal-information-step"));

        driver.findElement(By.name("firstname")).sendKeys("Krzysztof");
        driver.findElement(By.name("lastname")).sendKeys("Jamro");
        driver.findElement(By.name("email")).sendKeys("Krzysztof.jamro@gmail.com");
        driver.findElement(By.cssSelector("input[name=\"id_gender\"][value=\"1\"]")).click();
        driver.findElement(By.name("psgdpr")).click();
        driver.findElement(By.name("customer_privacy")).click();
        Utils.takeScreenShot(driver, "TestForms", "");
        driver.findElement(By.cssSelector("#customer-form > footer > button")).click();

        driver.findElement(By.cssSelector("#checkout-addresses-step > h1"));

        Select country = new Select(driver.findElement(By.name("id_country")));
        country.selectByVisibleText("Poland");
        WebElement adres = driver.findElement(By.name("address1"));
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.elementToBeClickable(adres));
        adres.sendKeys("Dzialkowcow 10");

        WebElement city = driver.findElement(By.name("city"));
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.elementToBeClickable(city));
        city.sendKeys("Czerwionka-Leszczyny");

        WebElement psotcode = driver.findElement(By.name("postcode"));
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.elementToBeClickable(psotcode));
        psotcode.sendKeys("44-230");

        driver.findElement(By.cssSelector(".js-address-form button")).click();

        driver.findElement(By.cssSelector("#checkout-delivery-step > h1"));

        Utils.takeScreenShot(driver, "TestForms", "");

        Thread.sleep(2000);
    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
