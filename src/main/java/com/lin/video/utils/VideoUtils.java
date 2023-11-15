package com.lin.video.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class VideoUtils {
    private static final Logger log = LoggerFactory.getLogger(VideoUtils.class);
    private static final String VIDEO_FORMAT = ".mp4";

    /**
     * 视频转码
     *
     * @param inputPath  输入路径
     * @param outputPath 输出路径
     * @throws Exception
     */
    public static void processVideo(String inputPath, String outputPath) throws Exception {
        log.info("开始进行 ts 格式转 MP4：{}", inputPath);

        try (InputStream inputStream = new FileInputStream(inputPath);
             OutputStream outputStream = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            log.info("视频转换完成：{}，输出路径：{}", inputPath, outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将输入流转换为输出流
     *
     * @param outputStream 输出流
     * @param inputStream  输入流
     * @throws IOException 当读取输入流或写入输出流发生错误时抛出该异常
     */
    public static void processVideoByStream(OutputStream outputStream, InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        log.info("视频转换完成");
    }
}
