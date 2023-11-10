/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author USUARIO
 */
@Embeddable
public class ProcedimientosResultadosArchPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "invnum")
    private int invnum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numitm")
    private int numitm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numfile")
    private int numfile;

    public ProcedimientosResultadosArchPK() {
    }

    public ProcedimientosResultadosArchPK(int invnum, int numitm, int numfile) {
        this.invnum = invnum;
        this.numitm = numitm;
        this.numfile = numfile;
    }

    public int getInvnum() {
        return invnum;
    }

    public void setInvnum(int invnum) {
        this.invnum = invnum;
    }

    public int getNumitm() {
        return numitm;
    }

    public void setNumitm(int numitm) {
        this.numitm = numitm;
    }

    public int getNumfile() {
        return numfile;
    }

    public void setNumfile(int numfile) {
        this.numfile = numfile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) invnum;
        hash += (int) numitm;
        hash += (int) numfile;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedimientosResultadosArchPK)) {
            return false;
        }
        ProcedimientosResultadosArchPK other = (ProcedimientosResultadosArchPK) object;
        if (this.invnum != other.invnum) {
            return false;
        }
        if (this.numitm != other.numitm) {
            return false;
        }
        if (this.numfile != other.numfile) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.ProcedimientosResultadosArchPK[ invnum=" + invnum + ", numitm=" + numitm + ", numfile=" + numfile + " ]";
    }
    
}
