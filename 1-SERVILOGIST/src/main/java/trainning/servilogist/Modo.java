package trainning.servilogist;

/**
 *
 * @author Maximiliano Di Ludovico
 */
public interface Modo {

    /**
     * El metodo mando tiene por objetivo explicar la forma en que se maneja el vehiculo
     * @param guiaDeMando Tipo de mando. Ejemplo: un Camion utiliza un volante
     * @param TipoDeacelerador Forma de acelerar el vehiculo. Ejemplo un acelerador de
     * pie mecanico
     * @param FormaDeFrenado Forma de freno. Ejemplo de un camion es el freno de pie
     * mecanico.
     */
    public String mando(String guiaDeMando,String TipoDeacelerador,String FormaDeFrenado);

}
