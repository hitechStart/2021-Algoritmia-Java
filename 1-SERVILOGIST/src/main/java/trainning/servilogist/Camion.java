
package trainning.servilogist;

/**
 * 
 * @author Maximiliano Di Ludovico
 */
public class Camion extends Vehiculo{
    
    private String patente;
    private Integer internoCamion;
    private Conductor conductor;
    private double PesoTransportado;

    public Camion() {
    }

    public Camion(String patente, Conductor conductor, double PesoTransportado) {
        this.patente = patente;
        this.conductor = conductor;
        this.PesoTransportado = PesoTransportado;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setInternoCamion(Integer internoCamion) {
        this.internoCamion = internoCamion;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

   

    public void setPesoTransportado(double PesoTransportado) {
        this.PesoTransportado = PesoTransportado;
    }

    public String getPatente() {
        return patente;
    }

    public Integer getInternoCamion() {
        return internoCamion;
    }

    public Conductor getConductor() {
        return conductor;
    }


    public double getPesoTransportado() {
        return PesoTransportado;
    }

    @Override
    public String toString() {
        return "Camion{" + "patente=" + patente + ", internoCamion=" 
                + internoCamion + ", conductor=" + conductor 
                + ", PesoTransportado=" + PesoTransportado + '}';
    }
   
    
}
