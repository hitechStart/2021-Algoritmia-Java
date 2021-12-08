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

/*
Especificacion de requisitos:

La empresa de logística SERVILOGIST desea analizar el peso de la carga transportada por sus 155 camiones.
Le empresa cuenta con una báscula pública que tiene a la salida de los vehículos. Cuenta con los siguientes
datos de cada camión:
- número de interno (int, entre 301 y 500).
- peso de la carga transportada (float).
Desarrollar el diagrama de lógica y su correspondiente codificación en C para que permita determinar e
informar:
a) El número de interno del camión que más peso ha tenido.
b) Hallar el Promedio del peso de los camiones.
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
        boolean isNumeric = true;
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

                    if (contadorDeCamiones > 155 || contadorDeCamiones <= 0) {
                        System.out.println("Se produjo un error. La cantidad de camiones es mayor que el de la flota(155)");
                        System.exit(1);
                    }

                    if (isNumeric != datos[0].matches("[+-]?\\d*(\\.\\d+)?") || isNumeric != datos[1].matches("[+-]?\\d*(\\.\\d+)?")) {

                        System.out.println("Error. Exite un dato que no es numerico.Revise los datos de lectura.");
                        System.exit(1);
                    }
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

                System.out.println("Interno :" + numeroDeInterno + " peso :" + pesoMaximo + " contiene el peso maximo");
                System.out.println("El promedio de la carga de la flota es :"
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
