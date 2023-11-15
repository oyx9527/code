package com.lin.video.controller;

import com.lin.video.utils.VideoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("videoController")
public class VideoController {
    private static final Logger log = LoggerFactory.getLogger(VideoController.class);

    /**
     * 视频转码
     *
     * @param inputResource 输入视频资源
     * @param outputResource 输出视频资源
     * @return 转码后的视频资源
     * @throws Exception 转码过程中可能抛出异常
     */
    @GetMapping("queryAppPage")
    public String queryAppPage(@RequestParam String inputResource, @RequestParam String outputResource) throws Exception {
        VideoUtils.processVideo(inputResource,outputResource);
        return outputResource;
    }

    /**
     * 处理视频
     *
     * @param file 视频文件
     * @return ResponseEntity<StreamingResponseBody>
     */
    @PostMapping("/processVideo")
    public ResponseEntity<StreamingResponseBody> processVideo(@RequestBody MultipartFile file ) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getOriginalFilename() + "\"");

        StreamingResponseBody responseBody = outputStream -> {
            try {
                // 在输出流上执行视频处理并同时写入输出流
                VideoUtils.processVideoByStream(outputStream, file.getInputStream());
                log.info("视频转换完成");
            } catch (IOException e) {
                // 处理异常
                e.printStackTrace();
            }
        };
        return new ResponseEntity<>(responseBody, headers, HttpStatus.OK);
    }
}
