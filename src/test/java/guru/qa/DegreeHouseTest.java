package guru.qa;

import guru.qa.enums.Brands;
import guru.qa.pages.ProductArgumentsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class DegreeHouseTest extends TestBase {

    @ParameterizedTest(name = "Search for products by brand {0}")
    @Tag("Blocker")
    @DisplayName("Search for products on the website")
    @ValueSource(strings = {"Kanzler", "Finlandia"})
    public void checkVisibilityProductsOnSiteWithValueSourceTest(String brand) {
        productPage
                .openPage()
                .openBrandsFilter()
                .showAllFilters()
                .selectMaker(brand)
                .showSearchResults()
                .productsShouldBeVisible();
    }

    @ParameterizedTest(name = "Search for products by brand {0}")
    @Tag("Blocker")
    @DisplayName("Search for products on the website")
    @EnumSource(value = Brands.class, names = {"BULAT","SLAVYANKA"}, mode =  EnumSource.Mode.EXCLUDE)
    public void checkVisibilityProductsOnSiteWithEnumSourceTest(Brands brand) {
        productPage
                .openPage()
                .openBrandsFilter()
                .showAllFilters()
                .selectMaker(brand.getName())
                .showSearchResults()
                .productsShouldBeVisible();
    }

    @ParameterizedTest(name = "Search for products by brand {0} and checking product names {1}")
    @Tag("Blocker")
    @DisplayName("Checking headings on product cards on the website")
    @CsvSource(value = {
            "Oregon : Самогонный аппарат Oregon",
            "Wagner : Самогонный аппарат Wagner"
    }, delimiter = ':')
    public void findProductsOnSiteWithCsvSourceTest(String brand, String expectedResult) {
        productPage
                .openPage()
                .openBrandsFilter()
                .showAllFilters()
                .selectMaker(brand)
                .showSearchResults()
                .productsShouldBeFiltered(expectedResult);
    }

    @ParameterizedTest(name = "Search for products by brand {0} and checking product names {1}")
    @Tag("Blocker")
    @DisplayName("Checking headings on product cards on the website")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void findProductsOnSiteWithCsvFileSourceTest(String brand, String expectedResult) {
        productPage
                .openPage()
                .openBrandsFilter()
                .showAllFilters()
                .selectMaker(brand)
                .showSearchResults()
                .productsShouldBeFiltered(expectedResult);
    }

    @ParameterizedTest(name = "Search for products by brand {0} and checking product names {1}")
    @Tag("Blocker")
    @DisplayName("Checking headings on product cards on the website")
    @MethodSource("setProductSearch")
    public void findProductsOnSiteWithMethodSourceTest(String brand, String expectedResult) {
        productPage
                .openPage()
                .openBrandsFilter()
                .showAllFilters()
                .selectMaker(brand)
                .showSearchResults()
                .productsShouldBeFiltered(expectedResult);
    }

    @ParameterizedTest(name = "Search for products by brand {0} and checking product names {1}")
    @Tag("Blocker")
    @DisplayName("Checking headings on product cards on the website")
    @ArgumentsSource(ProductArgumentsProvider.class)
    public void findProductsOnSiteWithArgumentSourceTest(String brand, String expectedResult) {
        productPage
                .openPage()
                .openBrandsFilter()
                .showAllFilters()
                .selectMaker(brand)
                .showSearchResults()
                .productsShouldBeFiltered(expectedResult);
    }

    private static Stream<Arguments> setProductSearch() {
        return Stream.of(
                Arguments.of("Finlandia", "Самогонный аппарат Finlandia"),
                Arguments.of("Eurostahl", "Самогонный аппарат Eurostahl")
        );
    }
}
