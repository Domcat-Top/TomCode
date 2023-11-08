package com.tom.testmodule.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.tom.testmodule.entity.DeleteVo;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author: Tom
 * @date: 2023/11/8 14:26
 * @description:
 */
@Slf4j
public class FileUtils {

    /**
     * 读取 JSON 文件，转化为 String 字符串
     * @param filePath 文件路径
     * @return
     */
    private static String turnJsonFileToString(String filePath) throws IOException {

        int temp = 0;
        StringBuffer stringBuffer = new StringBuffer();
        Reader reader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
        while((temp = reader.read()) != -1) {
            stringBuffer.append((char)temp);
        }
        reader.close();
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws IOException {

        String s = turnJsonFileToString("E:\\Test\\test.json");
        JSONObject jsonString = JSON.parseObject(s);
        String type = (String) jsonString.get("type");
        JSONArray tomInfo = jsonString.getJSONArray("tomInfo");
        for (Object tom : tomInfo) {
            JSONObject toms = (JSONObject) tom;
            String name = (String) toms.get("name");
            // 再获取game
            JSONObject game = toms.getJSONObject("game");
            DeleteVo deleteVo = new DeleteVo();
            deleteVo.setType((String) game.get("type"));
            log.info("{} 名字： {}；对象字符串：{}", type, name, deleteVo.toString());
        }

    }



}















