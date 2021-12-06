
package trainning.servilogist;

/**
 * 
 * @author Maximiliano Di Ludovico
 */
public class Vehiculo {
    
    private String modelo;
    private String marca;
    private long kilometraje;
    private String Tipo;
    private String color;
    private int velocidad;
    private double peso;

    public Vehiculo() {
    }

    public Vehiculo(String modelo, String marca, long kilometraje, String Tipo, String color, int velocidad, double peso) {
        this.modelo = modelo;
        this.marca = marca;
        this.kilometraje = kilometraje;
        this.Tipo = Tipo;
        this.color = color;
        this.velocidad = velocidad;
        this.peso = peso;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public long getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(long kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "modelo=" + modelo + ", marca=" + marca + ", kilometraje=" + kilometraje + ", Tipo=" + Tipo + ", color=" + color + ", velocidad=" + velocidad + ", peso=" + peso + '}';
    }
    
    
}
