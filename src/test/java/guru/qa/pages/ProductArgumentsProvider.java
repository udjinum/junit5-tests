package guru.qa.pages;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ProductArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of("Finlandia", "Самогонный аппарат Finlandia"),
                Arguments.of("Eurostahl", "Самогонный аппарат Eurostahl")
        );
    }
}
