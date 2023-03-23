import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrmTests extends DriverTest {

//    надо из этого класса запросить лист Sitemap. И написать цикл, которые будет проходить его. Во время каждого цикла
//    нужно нажимать на элемент - так будет открываться новая страница
    @Test
    public void PageOpens() throws Exception {
        String[] ways = GetLinks();
//        for (String link : ways) {
            StatusIs200(ways[0]);
            TheLogoIsVisible(ways[0]);
            System.out.println("Done: "+ ways[0]);
//        }
    }
}
