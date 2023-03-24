import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

class DriverTest {
//    SelenideElement logo = $(By.xpath("//*[@id=\"header_1_headermiddle_0_scLinkLogoLink\"]/img"));
    //SelenideElement logo = $(By.className("top-logo")).find(By.tagName("img")).getAttribute("src");
    public static String[] GetLinks(){
        Selenide.open("https://www.baaqmd.gov/sitemap");

        ElementsCollection linkElements = $$(By.className("sitemap"));
        ElementsCollection siteMapLinks = linkElements.filterBy(Condition.cssClass("a"));
        List<String> links = siteMapLinks.stream()
                .map(link -> link.getAttribute("href"))
                .collect(Collectors.toList());
        String[] linksArray = links.toArray(new String[0]);

        return linksArray;
    }

//    public void StatusIs200(String address) throws Exception {
//        URL url = new URL(address);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//        connection.setConnectTimeout(5000);
//        connection.connect();
//        int statusCode = connection.getResponseCode();
//        assert statusCode == 200;
//        connection.disconnect();
//    }

//    public void TheLogoIsVisible(String address) {
//        Selenide.open(address);
//        //logo.shouldBe(Condition.visible);
//    }
}

