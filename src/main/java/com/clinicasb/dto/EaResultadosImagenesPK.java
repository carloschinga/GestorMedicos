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
public class EaResultadosImagenesPK implements Serializable {

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
    @Column(name = "numimg")
    private int numimg;

    public EaResultadosImagenesPK() {
    }

    public EaResultadosImagenesPK(int invnum, int numitm, int numimg) {
        this.invnum = invnum;
        this.numitm = numitm;
        this.numimg = numimg;
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

    public int getNumimg() {
        return numimg;
    }

    public void setNumimg(int numimg) {
        this.numimg = numimg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) invnum;
        hash += (int) numitm;
        hash += (int) numimg;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EaResultadosImagenesPK)) {
            return false;
        }
        EaResultadosImagenesPK other = (EaResultadosImagenesPK) object;
        if (this.invnum != other.invnum) {
            return false;
        }
        if (this.numitm != other.numitm) {
            return false;
        }
        if (this.numimg != other.numimg) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.EaResultadosImagenesPK[ invnum=" + invnum + ", numitm=" + numitm + ", numimg=" + numimg + " ]";
    }
    
}
