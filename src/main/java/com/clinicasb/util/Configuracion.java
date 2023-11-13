package com.clinicasb.util;

import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletContext;

public class Configuracion {
    //private static final String PROPERTIES_FILE = "/WEB-INF/configuracion.properties";
    private static final String PROPERTIES_FILE = "/WEB-INF/classes/config.properties";
    
    
    private Properties properties;

    public Configuracion(ServletContext sc) {
        try (InputStream input = sc.getResourceAsStream(PROPERTIES_FILE)) {
            properties = new Properties();
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getValor(String clave) {
        return properties.getProperty(clave);
    }
}


/*Properties properties = new Properties();
            try (InputStream input = getServletContext().getResourceAsStream("/WEB-INF/classes/config.properties")) {
                if (input == null) {
                    System.out.println("No se puede encontrar el archivo config.properties");
                    return;
                }
                properties.load(input);
                resultado = "{\"resultado\":\"ok\",\"rutapdf\":\"" + properties.getProperty("pdf.directorio") + "\",\"directoriofirmas\":\""+properties.getProperty("fima.directorio")+"\" }";
            } catch (IOException ex) {
                resultado = "{\"resultado\":\"error\"}";
            }*/