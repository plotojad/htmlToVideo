package chatToVid;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import java.io.*;

public class XhtmlParser {
    XhtmlToImage xhtmlToImage;
    int count = 0;
    static long time;
    long bufferTime;

    public XhtmlParser() {
        xhtmlToImage = new XhtmlToImage();
    }

    public void setStatusParser(boolean online, long currentTime) throws IOException {
        if (count == 0) {
            time = 0;
            bufferTime = currentTime;
        } else {
            time = (currentTime - bufferTime) / 1000;
            bufferTime = currentTime;
        }


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
