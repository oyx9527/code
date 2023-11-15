package com.lin.video.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.video.bean.JsonFormattingPerson;

public class JsonFormattingExample {
    public static String JsonFormatting(String jsonString) {
        try {
            // 创建 ObjectMapper 对象
            ObjectMapper objectMapper = new ObjectMapper();
            // 将 JSON 字符串解析为 Java 对象
            // 注意：你需要定义一个对应的 Java 类，具有与 JSON 字符串匹配的字段
            JsonFormattingPerson person = objectMapper.readValue(jsonString, JsonFormattingPerson.class);
            // 将 Java 对象转换为格式化的 JSON 字符串
            // 打印格式化的 JSON 字符串
           return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
