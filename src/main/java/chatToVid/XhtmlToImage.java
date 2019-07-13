package chatToVid;

import org.xhtmlrenderer.swing.Java2DRenderer;
import org.xhtmlrenderer.util.FSImageWriter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class XhtmlToImage {

    static Map<String, Integer> images;
    private String imagePath = null;
    private int duration = 1;


    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Map<String, Integer> getImages() {
        return images;
    }

    public XhtmlToImage() {
        File imgPath = new File(Main.videoOutput + "/images");
        if (!imgPath.exists()) {
            if (imgPath.mkdir()) {
                imagePath = null;
                System.out.println("Создана директория для сохранения снимков xhtml-страницы");
            } else {
                System.out.println("Не удалось создать директорию для сохранения снимков xhtml-страницы");
            }
        } else {
            System.out.println("Директория для сохранения снимков xhtml-страницы уже существует");
            imagePath = null;
        }
        images = new LinkedHashMap<>();

    }

    public void convertAndSave(String url, int count) throws IOException {

        imagePath = String.format("%s/images/chat%04d.png", Main.videoOutput, count);

        int width = 1280;
        int height = 720;
        File file = new File(url);
        Java2DRenderer renderer = new Java2DRenderer(file, width, height);
        BufferedImage bufferedImage = renderer.getImage();
        FSImageWriter imageWriter = new FSImageWriter();
        imageWriter.write(bufferedImage, imagePath);

        images.put(imagePath, duration);

    }

}