package com.example.freemarker.controller;

import com.example.freemarker.util.PdfFileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PaulFang
 * @date 2020/11/16
 */
@RestController
public class TestController {

    @RequestMapping("/download")
    public void download(HttpServletResponse response) throws Exception {
        String templateName = "test.ftl";
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("user", "臭傻逼");
        // 设置强制下载
        response.setContentType("application/force-download");
        response.setHeader("Content-disposition","attachment;filename=panda.pdf");
        PdfFileUtils.exportpdf(response, templateName, data);
    }
}
