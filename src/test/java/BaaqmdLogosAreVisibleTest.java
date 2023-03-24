import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BaaqmdLogosAreVisibleTest {
    // go to sitemap, collect links, execute every link
    private static BaamqdPage baaqmdPage = new BaamqdPage();

    private static Stream<String> getLinksFromSitemap() {
        return Stream.of(baaqmdPage.GetLinksFromSitemap());
    }

    @ParameterizedTest
    @MethodSource("getLinksFromSitemap")
    public void logoExistsOnPage(String link) {
        BaamqdPage newPage = new BaamqdPage(link);
        Assertions.assertTrue(newPage.IsLogoExists());
    }
}
