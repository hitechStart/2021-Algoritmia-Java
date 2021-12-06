package trainning.servilogist;

import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Maximiliano Di Ludovico
 */
public class Test {

    public static Map<Integer, Double> CargarUnaColeccion(Map<Integer, Double> map) {

        map.put(1, 566.0);
        map.put(18, 1267.0);
        map.put(11, 877.0);
        map.put(23, 345.0);
        map.put(26, 234.0);
        map.put(5, 122.0);
        map.put(2, 24677.0);

        return map;
    }

    public static void ficheroDeEscritura(
            Map<Integer, Double> map) {

        ObjectMapper objectMapper = new ObjectMapper();

        File archivo = new File("fichero.json");

        try {
            String json = objectMapper.writeValueAsString(map);

            if (!map.isEmpty()) {

                Writer out = null;

                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fichero.json"), "UTF-8"));

                Iterator<Integer> it = map.keySet().iterator();
                it = map.keySet().iterator();

                out.write("{" + "\n");
                while (it.hasNext()) {
                    Integer key = it.next();
                    out.write("\"" + key + "\":\"" + map.get(key) + "\"\n");
                }
                out.write("}" + "\n");
                out.close();
                // Escribimos linea a linea en el fichero
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Mensaje excepcion de escritura: " + ex.getMessage());
        }
    }

    public static void procesamiento(int contadorDeCamiones, double sumaDeLaCarga, double pesoMaximo, int numeroDeInterno) {

        String[] datos;
        String linea;
        File fichero = new File("fichero.json");
        Scanner s = null;

        try {
            s = new Scanner(fichero);

            while (s.hasNextLine()) {

                linea = s.nextLine();

                if (linea.compareTo("}") != 0 && linea.compareTo("{") != 0) {
                    linea = linea.replaceAll("\"", "");
                    datos = linea.split(":");
                    contadorDeCamiones++;
                    sumaDeLaCarga += Double.parseDouble(datos[1]);

                    if (Double.parseDouble(datos[1]) > pesoMaximo) {

                        numeroDeInterno = Integer.parseInt(datos[0]);
                        pesoMaximo = Double.parseDouble(datos[1]);
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

                System.out.println("Cantidad: " + contadorDeCamiones + " peso maximo: " + pesoMaximo);
                System.out.println("Interno :" + numeroDeInterno + " peso :" + pesoMaximo);
                System.out.println("Promedio de la carga :"
                        + Math.round((sumaDeLaCarga / contadorDeCamiones) * 100.0) / 100.0);

            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }

    }

    public static void main(String[] args) {

        Map<Integer, Double> map = new TreeMap<Integer, Double>();
        Double pesoMaximo = 0.0, sumaDeLaCarga = 0.0;
        int contadorDeCamiones = 0, numeroDeInterno = 0;

        map = CargarUnaColeccion(map);

        ficheroDeEscritura(map);

        procesamiento(contadorDeCamiones, sumaDeLaCarga, pesoMaximo, numeroDeInterno);

    }
}
