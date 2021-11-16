package guru.qa.pages.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Products {

    private final ElementsCollection productBlocks;
    private final ElementsCollection names;

    private Products(SelenideElement container) {
        productBlocks = container.$$(".product");
        names = container.$$(".product-name");
    }

    public static Products of(String cssSelector) {
        return new Products($(cssSelector));
    }

    public Products shouldBeFilteredByName(String value) {
        names.forEach(name -> name.shouldHave(text(value)));
        return this;
    }

    public Products productsBlocksShouldBeVisible() {
        productBlocks.forEach(name -> name.shouldBe(visible));
        return this;
    }
}
