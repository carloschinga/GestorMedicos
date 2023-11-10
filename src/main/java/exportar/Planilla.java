package exportar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Planilla {

    public static void main(String[] args) {
        TrabajadorJpaController trabaDAO= new TrabajadorJpaController();
        List<Trabajador> lista= trabaDAO.findTrabajadorEntities();
        
        Workbook libro = new XSSFWorkbook();
        final String nombreArchivo = "Planilla.xlsx";
        Sheet hoja = libro.createSheet("Hoja 1");

        String[] encabezados = {"codiTrab", "sueldBasi", "teneAsigFami", "codiFondoPens"};
        int indiceFila = 0;

        Row fila = hoja.createRow(indiceFila);
        for (int i = 0; i < encabezados.length; i++) {
            String encabezado = encabezados[i];
            Cell celda = fila.createCell(i);
            celda.setCellValue(encabezado);
        }

        indiceFila++;
        for (int i = 0; i < lista.size(); i++) {
            fila = hoja.createRow(indiceFila);
            Trabajador t = lista.get(i);
            fila.createCell(0).setCellValue(t.getCodiTrab());
            fila.createCell(3).setCellValue(t.getSueldBasi());
            fila.createCell(1).setCellValue(t.getTeneAsigFami());
            fila.createCell(2).setCellValue(t.getCodiFondPens());
            indiceFila++;
        }

        File directorioActual = new File(".");
        String ubicacion = directorioActual.getAbsolutePath();
        String ubicacionArchivoSalida = ubicacion.substring(0, ubicacion.length() - 1) + nombreArchivo;
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(ubicacionArchivoSalida);
            libro.write(outputStream);
            libro.close();
            System.out.println("Libro guardado correctamente");
        } catch (FileNotFoundException ex) {
            System.out.println("Error de filenotfound");
        } catch (IOException ex) {
            System.out.println("Error de IOException");
        }
    }
}
