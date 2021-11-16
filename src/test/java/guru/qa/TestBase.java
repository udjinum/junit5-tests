package guru.qa;

import com.codeborne.selenide.Configuration;

import guru.qa.pages.ProductPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void setUpBeforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    ProductPage productPage = new ProductPage();
}
