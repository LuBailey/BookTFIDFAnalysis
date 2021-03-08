import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class WebLookup {

    public String definition(String word) throws IOException {
        String url = "https://googledictionary.freecollocation.com/meaning?word=" + word;
        String definition = "";


        try {
            final Document document = Jsoup.connect(url).get();

            for (int rowNo = 1; rowNo < 9; rowNo++) {
                for (Element row : document.select("div.std > ol > div > li")) {
                    if (row.select("li:nth-of-type(" + rowNo + ")").text().equals("")) {
                        continue;
                    } else {
                        String defAndExample = row.select("li:nth-of-type(" + rowNo + ")").text();
                        definition += defAndExample + "\n";
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return definition;
    }
}

