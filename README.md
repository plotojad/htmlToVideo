# htmlToVideo
Initially, this solution was developed for archiving an audio conference in a browser chat. The point is to use the library to parse the xhtml-page and then convert it into a video file. At each event in the chat (for example, if someone started talking or changed status) a new xhtml-page is generated and after being converted into an image, it is added to the array (written to disk in the folder with images). The path to each image and the duration (this is necessary for ffmpeg) is written into a separate text file. Then, using ffmdeg, all the images and the audio file are compiled into a video file.