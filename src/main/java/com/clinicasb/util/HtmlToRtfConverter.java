/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author sbdeveloperw
 */
public class HtmlToRtfConverter {

    public static void main(String[] args) {
        String htmlContent = "<div>ABCD.</div>";
        htmlContent=htmlContent.replaceAll("<div>", "<p>");
        htmlContent=htmlContent.replaceAll("</div>", "</p>");

        try {
            String rtfContent = convertHtmlToRtf(htmlContent);
            //writeRtfToFile(rtfContent, "output.rtf");
            System.out.println(rtfContent);
            System.out.println("Conversión completada con éxito.");
        } catch (Exception e) {
            System.err.println("Error durante la conversión: " + e.getMessage());
        }
    }

    public static String convertHtmlToRtf(String htmlContent) {
        Document document = Jsoup.parse(htmlContent);
        Elements elements = document.body().children();

        StringBuilder rtfContent = new StringBuilder("{\\rtf1\\ansi\\deff0");

        convertHtmlToRtfRecursive(elements, rtfContent);

        rtfContent.append("}");

        return rtfContent.toString();
    }

    private static void convertHtmlToRtfRecursive(Elements elements, StringBuilder rtfContent) {
        for (Element element : elements) {
            String tag = element.tagName();

            if ("p".equals(tag)) {
                rtfContent.append("\\par ");
            } else if ("ul".equals(tag)) {
                rtfContent.append("\\par ");
                convertHtmlToRtfRecursive(element.children(), rtfContent);
            } else if ("li".equals(tag)) {
                rtfContent.append("\\par\\bullet ").append(element.text()).append(" ");
            } else {
                convertHtmlToRtfRecursive(element.children(), rtfContent);
            }
        }
    }

    private static void writeRtfToFile(String rtfContent, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(rtfContent);
        }
    }
}
