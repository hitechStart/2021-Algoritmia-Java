package trainning.labbrus;

/**
 *
 * @author Maximiliano Di Ludovico
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LecturaFichero {

    public ArrayList<String> lecturaDeFichero(ObjetosJson obj, ArrayList<String> lista) {

        File fichero = new File("fichero.json");
        Scanner s = null;
        String[] datos;
        String linea;
        int i = 0;

        try {
            // Leemos el contenido del fichero
            s = new Scanner(fichero);

            // Leemos linea a linea el fichero
            while (s.hasNextLine()) {
                linea = s.nextLine(); 	// Guardamos la linea en un String

                if (linea.compareTo("}") != 0 && linea.compareTo("{") != 0) {

                    linea = linea.replaceAll("\"", "");
                    datos = linea.split(":");

                    if ((datos[1].charAt(0)) != 'G') {

                        obj.setTipo(datos[1].charAt(0));

                        linea = s.nextLine();
                        linea = linea.replaceAll("\"", "");
                        datos = linea.split(":");
                        obj.setConductividad(Float.parseFloat(datos[1]));

                        linea = s.nextLine();
                        linea = linea.replaceAll("\"", "");
                        datos = linea.split(":");
                        obj.setTemperatura(Float.parseFloat(datos[1]));

                        lista.add(obj.getNombreCompleto());                
                    }
                }
            }
          

        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (s != null) {
                    s.close();
                }
                return lista;
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
        return lista;
    }
}
