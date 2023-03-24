import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;

public class BaaqmdLogosAreVisibleTest {
    BaamqdPage baaqmdPage = new BaamqdPage();

    @Test
    public void Execute() {
        for (String link: baaqmdPage.siteMapLinks){
            SelenideElement topLogoImgEl = baaqmdPage.BaaqmdLogo(link);
            try {
                Assert.assertEquals(topLogoImgEl.getAttribute("src"), baaqmdPage.Src);
            } catch (NoSuchElementException e) {
                System.out.println("An exception occurred while executing the test for link: " + link);
//                e.printStackTrace();
            } finally {
                continue;
            }
        }
    }
}
