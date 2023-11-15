package com.lin.video.controller;

import com.lin.video.utils.JsonFormattingExample;
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


@RestController
@RequestMapping("JsonFormattingController")
public class JsonFormattingController {
    private static final Logger log = LoggerFactory.getLogger(JsonFormattingController.class);

    /**
     * 这是一个用于格式化JSON的示例方法
     *
     * @param json 要格式化的JSON字符串
     * @return 格式化后的JSON字符串
     * @throws Exception 可能发生的异常
     */
    @GetMapping("jsonFormatting")
    public String jsonFormatting(@RequestParam String json) throws Exception {
        return JsonFormattingExample.JsonFormatting(json);
    }

}
