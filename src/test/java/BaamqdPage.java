import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BaamqdPage {

    public final String Src = "https://www.baaqmd.gov/~/media/dotgov/images/logos/logo-with-tagline.png?h=54&la=en&w=343&hash=7D45CEF8C8222A67E15B7D02570ED539";

    public String[] siteMapLinks;

    public BaamqdPage() {
        Selenide.open("https://www.baaqmd.gov/sitemap");
        ElementsCollection siteMapLinksEl = $$(".sitemap a");
        siteMapLinks = siteMapLinksEl.stream().map(link -> link.getAttribute("href")).toArray(String[]::new);
    }

    public SelenideElement BaaqmdLogo(String link){
        Selenide.open(link);
        SelenideElement topLogoEl = $(By.className("top-logo"));
        topLogoEl.exists();
        SelenideElement topLogoImgEl = topLogoEl.find(By.tagName("img"));
        topLogoImgEl.exists();
        return topLogoImgEl;
    }
}
