package com.example.freemarker.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.Map;

/**
 *
 * @author PaulFang
 * @date 2020/11/16
 */
public class PdfFileUtils {
    /**
     *
     * @param response 返回对象
     * @param templateName 模板名称
     * @param data 模板需要的数据
     * @throws Exception
     */
    public static void exportpdf(HttpServletResponse response, String templateName, Map<String, Object> data) throws Exception{
        // STEP 1 : creation of the document
        Document document = new Document();
        // STEP 2 : creation of the writer
        PdfWriter pdfWriter = PdfWriter.getInstance(document, response.getOutputStream());
        // STEP 3 : open the document for writing
        document.open();
        // STEP 4 : write the content of HTML to PDF
        String htmlStr = HtmlGenerator.generate(templateName, data);

        XMLWorkerHelper.getInstance().
                parseXHtml(pdfWriter, document, new ByteArrayInputStream(htmlStr.getBytes()), Charset.forName("UTF-8"), new AsianFontProvider());
        // STEP 5 : close the document
        document.close();
        System.out.println("PDF is created!");
    }
}
