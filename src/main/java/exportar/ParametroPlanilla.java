/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exportar;

/**
 *
 * @author USUARIO
 */
public class ParametroPlanilla {
    private int codiParaPlani;
    private String nombParaPlani;
    private double valoParaPlani;

    public int getCodiParaPlani() {
        return codiParaPlani;
    }

    public void setCodiParaPlani(int codiParaPlani) {
        this.codiParaPlani = codiParaPlani;
    }

    public String getNombParaPlani() {
        return nombParaPlani;
    }

    public void setNombParaPlani(String nombParaPlani) {
        this.nombParaPlani = nombParaPlani;
    }

    public double getValoParaPlani() {
        return valoParaPlani;
    }

    public void setValoParaPlani(double valoParaPlani) {
        this.valoParaPlani = valoParaPlani;
    }

    public ParametroPlanilla(int codiParaPlani, String nombParaPlani, double valoParaPlani) {
        this.codiParaPlani = codiParaPlani;
        this.nombParaPlani = nombParaPlani;
        this.valoParaPlani = valoParaPlani;
    }

    public ParametroPlanilla() {
    }
    
}
