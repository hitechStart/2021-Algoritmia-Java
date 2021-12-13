package trainning.labbrus;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Maximiliano Di Ludovico
 */
public class Ensayo extends Thread {

    private ArrayList<String> listado = new ArrayList<String>();
    private long initialTime;

    public Ensayo() {
    }

    public Ensayo(ArrayList<String> listaDeObjetos, long initialTime) {
        this.initialTime = initialTime;
        this.listado = listaDeObjetos;
    }

    /**
     *  Sobre escribimos el metodo run() para proporcionar un modelo y
     * diseño de solucion al enunciado siguiente:
     *
     * Desarrollar el diagrama de lógica y su correspondiente codificación en C
     * para que leyendo los datos detallados anteriormente, permita determinar e
     * informar: a) Determinar por Tipo de Material, la cantidad de ensayos
     * realizados con una Temperatura mayor a 26,6º. b) Hallar el Promedio de la
     * Conductividad al finalizar las pruebas de ensayos. c) Cual ha sido la
     * Conductividad más alta encontrada de todas las pruebas efectuadas.
     * Informar el Tipo de Material y la temperatura que corresponde a la mayor
     * Conductividad hallada.
     */
    @Override
    public void run() {
        String[] datos;
        String tipo = "";
        float suma = 0, maximo = 0, temperatura = 0;

        /*
        Definimos los objetos del paquete DecimalFormatSymbols 
        para controlar el formato y la cantidad de decimales
         */
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');

        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);

        System.out.println("Inicio de tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000);

        for (int i = 0; i < listado.size(); i++) {

            //this.esperarXsegundos(i);
            datos = listado.get(i).split("-");
            suma += Float.parseFloat(datos[1]);
        }
        System.out.println("Promedio de la conductividad del ensayo es de : " + formato1.format(suma / listado.size()));
        System.out.println("Finalizacion en: " + (System.currentTimeMillis() - this.initialTime) / 1000);

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        if (!map.isEmpty()) {

            Iterator<Character> it = map.keySet().iterator();
            it = map.keySet().iterator();

            while (it.hasNext()) {
                Character key = it.next();
                System.out.println(key + " Tiene " + map.get(key) + " veces valores mayores de températura permitida");
            }
        }

        for (int i = 0; i < listado.size(); i++) {

            /*
            Forma de recorrer e incrementar el campo de valor en uno de un mapa
             */
            datos = listado.get(i).split("-");
            if (Float.parseFloat(datos[1]) >= 26.6) {
            }
        }
        for (int i = 0; i < listado.size(); i++) {

            datos = listado.get(i).split("-");

            if (Float.parseFloat(datos[1]) >= maximo) {
                tipo = datos[0];
                maximo = Float.parseFloat(datos[1]);
                temperatura = Float.parseFloat(datos[2]);
            }
        }
        System.out.println("la Conductividad más alta encontrada de todas las pruebas efectuadas es:");
        System.out.println("Tipo :" + tipo + " Conductividad " + maximo + " temperatura: " + temperatura);

    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
