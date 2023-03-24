import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BaamqdPage {

    private final String LogoSrc = "https://www.baaqmd.gov/~/media/dotgov/images/logos/logo-with-tagline.png?h=54&la=en&w=343&hash=7D45CEF8C8222A67E15B7D02570ED539";

    public BaamqdPage() {
        Selenide.open("https://www.baaqmd.gov/");
    }

    public BaamqdPage(String link) {
        Selenide.open(link);
    }

    public String[] GetLinksFromSitemap() {
        Selenide.open("https://www.baaqmd.gov/sitemap");
        ElementsCollection siteMapLinksEl = $$(".sitemap a");

        return
                siteMapLinksEl.stream()
                        .map(link -> link.getAttribute("href"))
                        .toArray(String[]::new);
    }

    public boolean IsLogoExists() {
        SelenideElement topLogoEl = $(By.className("top-logo"));
        SelenideElement topLogoImgEl = topLogoEl.find(By.tagName("img"));
        boolean isRightImage = LogoSrc.equals(topLogoImgEl.getAttribute("src"));

        return topLogoEl.exists() && topLogoImgEl.exists() && isRightImage;
    }
}
