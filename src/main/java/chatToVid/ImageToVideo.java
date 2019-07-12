package chatToVid;

import java.io.IOException;

public class ImageToVideo {
    Process process;
    String mp3Path = null;
    String videoPath = null;
    String inputImagesFilePath;
    InputFileForITV inputFileForITV;

    public String getMp3Path() {
        return mp3Path;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public ImageToVideo(String mp3Path, String videoPath) {
        this.mp3Path = mp3Path;
        this.videoPath = videoPath;
    }

    public void imgToVideo() {

        inputFileForITV = new InputFileForITV(XhtmlToImage.images);
        inputFileForITV.makeFile();

        {
            try {
                process = Runtime.getRuntime().exec("ffmpeg -f concat -safe 0 -i /home/plotoSUSE/input.txt -i " +
                        mp3Path + " -codec:a copy " +
                        "-vcodec mpeg2video -pix_fmt yuv420p -vf fps=1 " + videoPath + "/OUTPUT.mp4");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
