
package trainning.labbrus;

/**
 *
 * @author Maximiliano Di Ludovico
 */
public class ObjetosJson {
    
    private char tipo;
    private float conductividad; 
    private float temperatura;

    public ObjetosJson() {
    }

    public ObjetosJson(char tipo, float conductividad, float temperatura) {
        this.tipo = tipo;
        this.conductividad = conductividad;
        this.temperatura = temperatura;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public float getConductividad() {
        return conductividad;
    }

    public void setConductividad(float conductividad) {
        this.conductividad = conductividad;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public String getNombreCompleto() {
        return tipo + "-" + conductividad+"-"+ temperatura;
    }
    
}
