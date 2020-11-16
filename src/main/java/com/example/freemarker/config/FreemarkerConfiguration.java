package com.example.freemarker.config;

import freemarker.template.Configuration;

/**
 *
 * @author PaulFang
 * @date 2020/11/16
 */
public class FreemarkerConfiguration {
    private static Configuration config = null;
    static {
        config = new Configuration(Configuration.VERSION_2_3_23);
        config.setClassForTemplateLoading(FreemarkerConfiguration.class, "/templates/");
    }
    public static Configuration getConfiguration() {
        return config;
    }
}