package chatToVid;

import java.io.IOException;

public class RecordAndEncodeVideo {
    Process process;

    public void imgToVideo() {
        {
            try {
                process = Runtime.getRuntime().exec("ffmpeg -f concat -safe 0 -i /home/plotoSUSE/input.txt -i " +
                        "/home/plotoSUSE/IdeaProjects/htmlToVideo/POPDUBDeeBOP_Flame_on_wheels.mp3 -codec:a copy " +
                        "-vcodec mpeg2video -pix_fmt yuv420p -vf fps=1 /home/plotoSUSE/Видео/OUTPUT.mp4");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
