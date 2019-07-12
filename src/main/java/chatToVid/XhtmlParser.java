package chatToVid;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import java.io.*;
import java.util.Date;

public class XhtmlParser {
    int count = 0;
    long time;

    public void setStatusParser(boolean online, long date) throws IOException {
        time = date - time;


        XhtmlToImage xhtmlToImage = new XhtmlToImage();
        Document xhtmlFile = null;
        xhtmlToImage.setDuration((int) time);

        InputStream fis = new FileInputStream(new File("chat.xhtml"));


        xhtmlFile = Jsoup.parse(fis, null, "", Parser.xmlParser());
        Element div = xhtmlFile.getElementById("quadred");
        if (online) {
            div.select("div[id$=quadred]").attr("class", "statusOnline");
        } else {
            div.select("div[id$=quadred]").attr("class", "statusOffline");
        }
        fis.close();


        FileWriter fw = new FileWriter("chat.xhtml");
        fw.write(xhtmlFile.toString());
        fw.flush();
        fw.close();


        xhtmlToImage.convertAndSave("chat.xhtml", count);
        count++;

    }
}
