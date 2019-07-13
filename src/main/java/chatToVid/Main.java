package chatToVid;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static String videoOutput = null;

    public static void main(String[] args) throws IOException {

        ImageToVideo imageToVideo;
        String mp3Path = null;


        Scanner scannerOfPath = new Scanner(System.in);
        System.out.println("Введи путь к файлу mp3");
        mp3Path = scannerOfPath.nextLine();
        System.out.println("Введи путь к папке, в которую необходимо записать видеофайл");
        videoOutput = scannerOfPath.nextLine();
        imageToVideo = new ImageToVideo(mp3Path, videoOutput);


        int orline = 0;
        Person mitya = new Person("Mitya", false);
        mitya.setStatus(false);
        System.out.println("Привет! Тебя зовут Митя и ты находишься в чате\n" +
                "Сейчас ты не в сети - Offline :(\n" +
                "Чтобы стать Online нажми 1, Offline - 0.\n" +
                "Чтобы выйти - нажми 5\n");

        while (orline != 5) {

            orline = scannerOfPath.nextInt();

            switch (orline) {
                case 1:
                    mitya.setStatus(true);
                    System.out.println("Митя Online");
                    break;
                case 0:
                    mitya.setStatus(false);
                    System.out.println("Митя Offline");
                    break;
                case 5:
                    scannerOfPath.close();
                    mitya.setStatus(false);
                    imageToVideo.imgToVideo();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Теперь смотри видео файл в директории " + videoOutput);
            }
        }

    }
}
