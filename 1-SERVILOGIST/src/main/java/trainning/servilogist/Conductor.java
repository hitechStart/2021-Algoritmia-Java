
package trainning.servilogist;

/**
 * 
 * @author Maximiliano Di Ludovico
 */
public class Conductor extends Persona{
    
    private double legajo;

    public Conductor() {
    }

    public Conductor(double legajo ) {
        this.legajo = legajo;
    }
    
      public Conductor(double legajo,int dni, String nombre, String apellido, char sexo, int edad) {
       
          super(dni,nombre,apellido,sexo,edad);
          this.legajo = legajo;
    }

    public double getLegajo() {
        return legajo;
    }

    public void setLegajo(double legajo) {
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return "Conductor{" + "legajo=" + legajo + '}';
    }
      
      
    
    
    
}
