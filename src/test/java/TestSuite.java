import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSuite {
    WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://tiki.vn");
        driver.manage().window().maximize();
    }

    @Test
    public void SearchForm() {
        String inputSearch = "//input[@data-view-id='main_search_form_input']";
        String btnSearch = "//button[@data-view-id='main_search_form_button']";
        String productAsus ="//div[@data-view-id='product_list_container']//img[contains(@alt,'Laptop Asus VivoBook Flip 14 TP470EA-EC027T (Core i3-1115G4/ 4GB DDR4/ 512GB Pcle/ 14.1 FHD IPS  Touch/ Win10) - Hàng Chính Hãng')]";
        String expectTitle ="Laptop Asus VivoBook Flip 14 TP470EA-EC027T (Core i3-1115G4/ 4GB DDR4/ 512GB Pcle/ 14.1 FHD IPS  Touch/ Win10) - Hàng Chính Hãng";
        String xpathTitle ="//div[@class='header']//h1";
        String expectPrice ="15.139.000 ₫";
        String xpathPrice ="//span[@class='product-price__current-price']";
        String addToCart = "//button[@class='btn btn-add-to-cart']";
        String viewCart ="//img[@class='cart-icon']";
        String xpathTel ="//input[@type='tel']";
        driver.findElement(By.xpath(inputSearch)).sendKeys("ASUS");
        driver.findElement(By.xpath(btnSearch)).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(productAsus)).click();
        String actualTitle = driver.findElement(By.xpath(xpathTitle)).getAttribute("innerHTML");
        System.out.println("Tieu de: " + actualTitle);
        Assert.assertEquals(expectTitle, actualTitle);
        String actualPrice= driver.findElement(By.xpath(xpathPrice)).getText();
        System.out.println("Gia sp: " + actualPrice);
        Assert.assertEquals(expectPrice, actualPrice);
        driver.findElement(By.xpath(addToCart)).click();
        driver.findElement(By.xpath(viewCart)).click();
//        Alert alert = driver.switchTo().alert();
//               alert.sendKeys("0946215516");
    }
}
