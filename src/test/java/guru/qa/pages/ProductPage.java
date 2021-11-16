package guru.qa.pages;

import com.codeborne.selenide.*;
import guru.qa.pages.elements.Products;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ProductPage {

    private final ElementsCollection filters = $$(".filter-option-name");
    private final SelenideElement showAllLink = $(".show-all");
    private final ElementsCollection makers = $$(".filter-option-content li");
    private final SelenideElement showButton = $("#filter-show");
    protected final Products products = Products.of("#filter-results");

    public ProductPage openPage() {
        open("https://penza.gradushaus.ru/samogonovarenie/samogonnye-apparaty");
        return this;
    }

    public ProductPage selectMaker(String value) {
        makers
                .findBy(text(value))
                .click();
        return this;
    }

    public ProductPage productsShouldBeFiltered(String value) {
        products.shouldBeFilteredByName(value);
        return this;
    }

    public ProductPage productsShouldBeVisible() {
        products.productsBlocksShouldBeVisible();
        return this;
    }

    public ProductPage openBrandsFilter() {
        filters
                .get(1)
                .click();
        return this;
    }

    public ProductPage showAllFilters() {
        showAllLink.click();
        return this;
    }

    public ProductPage showSearchResults() {
        showButton.click();
        return this;
    }
}
