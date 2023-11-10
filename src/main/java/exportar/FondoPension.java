/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exportar;

/**
 *
 * @author USUARIO
 */
public class FondoPension {
    private int codiFondPens;
    private String nombFondPens;
    private double aporFondPens;
    private double comiFondPens;
    private double primFondPens;

    public double getAporFondPens() {
        return aporFondPens;
    }

    public void setAporFondPens(double aporFondPens) {
        this.aporFondPens = aporFondPens;
    }

    public double getComiFondPens() {
        return comiFondPens;
    }

    public void setComiFondPens(double comiFondPens) {
        this.comiFondPens = comiFondPens;
    }

    public double getPrimFondPens() {
        return primFondPens;
    }

    public void setPrimFondPens(double primFondPens) {
        this.primFondPens = primFondPens;
    }

    public int getCodiFondPens() {
        return codiFondPens;
    }

    public void setCodiFondPens(int codiFondPens) {
        this.codiFondPens = codiFondPens;
    }

    public String getNombFondPens() {
        return nombFondPens;
    }

    public FondoPension() {
    }

    public FondoPension(int codiFondPens, String nombFondPens, double aporFondPens, double comiFondPens, double primFondPens) {
        this.codiFondPens = codiFondPens;
        this.nombFondPens = nombFondPens;
        this.aporFondPens = aporFondPens;
        this.comiFondPens = comiFondPens;
        this.primFondPens = primFondPens;
    }

    public void setNombFondPens(String nombFondPens) {
        this.nombFondPens = nombFondPens;
    }

    
    
}
