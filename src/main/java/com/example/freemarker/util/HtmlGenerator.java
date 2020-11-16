package com.example.freemarker.util;

import com.example.freemarker.config.FreemarkerConfiguration;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.Map;

/**
 *
 * @author PaulFang
 * @date 2020/11/16
 */
public class HtmlGenerator {
    /**
     *
     * @param template 模板名称
     * @param params 模板需要的数据
     * @return
     * @throws Exception
     */
    public static String generate(String template, Map params) throws Exception {
        Configuration config = FreemarkerConfiguration.getConfiguration();
        config.setDefaultEncoding("UTF-8");
        Template tp = config.getTemplate(template);
        StringWriter writer = new StringWriter();
        tp.setOutputEncoding("UTF-8");
        tp.process(params, writer);
        String htmlStr = writer.toString();
        writer.flush();
        writer.close();
        return htmlStr;
    }
}