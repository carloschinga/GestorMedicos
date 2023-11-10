/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exportar;

import java.io.Serializable;


public class Trabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer codiTrab;
    private int codiTipoDocu;
    private String numeDocu;
    private String appaTrab;
    private String apmaTrab;
    private String nombTrab;
    private double sueldBasi;
    private int teneAsigFami;
    private int codiFondoPens;
    public Trabajador() {
    }

    public Trabajador(Integer codiTrab) {
        this.codiTrab = codiTrab;
    }

    public Trabajador(Integer codiTrab, int codiTipoDocu, String numeDocu, String appaTrab, String apmaTrab, String nombTrab, double sueldBasi, int teneAsigFami) {
        this.codiTrab = codiTrab;
        this.codiTipoDocu = codiTipoDocu;
        this.numeDocu = numeDocu;
        this.appaTrab = appaTrab;
        this.apmaTrab = apmaTrab;
        this.nombTrab = nombTrab;
        this.sueldBasi = sueldBasi;
        this.teneAsigFami = teneAsigFami;
    }

    public Integer getCodiTrab() {
        return codiTrab;
    }

    public void setCodiTrab(Integer codiTrab) {
        this.codiTrab = codiTrab;
    }

    public int getCodiTipoDocu() {
        return codiTipoDocu;
    }

    public void setCodiTipoDocu(int codiTipoDocu) {
        this.codiTipoDocu = codiTipoDocu;
    }

    public String getNumeDocu() {
        return numeDocu;
    }

    public void setNumeDocu(String numeDocu) {
        this.numeDocu = numeDocu;
    }

    public String getAppaTrab() {
        return appaTrab;
    }

    public void setAppaTrab(String appaTrab) {
        this.appaTrab = appaTrab;
    }

    public String getApmaTrab() {
        return apmaTrab;
    }

    public void setApmaTrab(String apmaTrab) {
        this.apmaTrab = apmaTrab;
    }

    public String getNombTrab() {
        return nombTrab;
    }

    public void setNombTrab(String nombTrab) {
        this.nombTrab = nombTrab;
    }

    public double getSueldBasi() {
        return sueldBasi;
    }

    public void setSueldBasi(double sueldBasi) {
        this.sueldBasi = sueldBasi;
    }

    public int getTeneAsigFami() {
        return teneAsigFami;
    }

    public void setTeneAsigFami(Character teneAsigFami) {
        this.teneAsigFami = teneAsigFami;
    }
     public int getCodiFondPens() {
        return codiFondoPens;
    }

    public void setCodiFondPens(int codiFondPens) {
        this.codiFondoPens= codiFondPens;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiTrab != null ? codiTrab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.codiTrab == null && other.codiTrab != null) || (this.codiTrab != null && !this.codiTrab.equals(other.codiTrab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Trabajador[ codiTrab=" + codiTrab + " ]";
    }
    
}
