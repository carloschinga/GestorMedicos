package com.clinicasb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream input = Test.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("No se puede encontrar el archivo config.properties");
                return;
            }

            // Cargar el archivo de configuración desde el InputStream
            properties.load(input);

            // Obtener propiedades del archivo de configuración
            String pdfdirectorio = properties.getProperty("pdf.directorio");
            
            // Utilizar las propiedades en tu aplicación
            System.out.println("PDF Directorio: " + pdfdirectorio);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
