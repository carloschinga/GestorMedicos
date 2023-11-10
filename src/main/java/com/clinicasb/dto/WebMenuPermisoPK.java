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
public class WebMenuPermisoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codrol")
    private int codrol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codmen")
    private int codmen;

    public WebMenuPermisoPK() {
    }

    public WebMenuPermisoPK(int codrol, int codmen) {
        this.codrol = codrol;
        this.codmen = codmen;
    }

    public int getCodrol() {
        return codrol;
    }

    public void setCodrol(int codrol) {
        this.codrol = codrol;
    }

    public int getCodmen() {
        return codmen;
    }

    public void setCodmen(int codmen) {
        this.codmen = codmen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codrol;
        hash += (int) codmen;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebMenuPermisoPK)) {
            return false;
        }
        WebMenuPermisoPK other = (WebMenuPermisoPK) object;
        if (this.codrol != other.codrol) {
            return false;
        }
        if (this.codmen != other.codmen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.WebMenuPermisoPK[ codrol=" + codrol + ", codmen=" + codmen + " ]";
    }
    
}
