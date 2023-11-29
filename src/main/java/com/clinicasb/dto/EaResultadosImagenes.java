/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "ea_resultados_imagenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EaResultadosImagenes.findAll", query = "SELECT e FROM EaResultadosImagenes e"),
    @NamedQuery(name = "EaResultadosImagenes.findByInvnum", query = "SELECT e FROM EaResultadosImagenes e WHERE e.eaResultadosImagenesPK.invnum = :invnum"),
    @NamedQuery(name = "EaResultadosImagenes.findByInvnum", query = "SELECT e FROM EaResultadosImagenes e WHERE e.eaResultadosImagenesPK.invnum = :invnum"),
    @NamedQuery(name = "EaResultadosImagenes.findByNumitm", query = "SELECT e FROM EaResultadosImagenes e WHERE e.eaResultadosImagenesPK.numitm = :numitm"),
    @NamedQuery(name = "EaResultadosImagenes.findByNumimg", query = "SELECT e FROM EaResultadosImagenes e WHERE e.eaResultadosImagenesPK.numimg = :numimg"),
    @NamedQuery(name = "EaResultadosImagenes.findByImgpath", query = "SELECT e FROM EaResultadosImagenes e WHERE e.imgpath = :imgpath")})
public class EaResultadosImagenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EaResultadosImagenesPK eaResultadosImagenesPK;
    @Size(max = 1200)
    @Column(name = "imgpath")
    private String imgpath;

    public EaResultadosImagenes() {
    }

    public EaResultadosImagenes(EaResultadosImagenesPK eaResultadosImagenesPK) {
        this.eaResultadosImagenesPK = eaResultadosImagenesPK;
    }

    public EaResultadosImagenes(int invnum, int numitm, int numimg) {
        this.eaResultadosImagenesPK = new EaResultadosImagenesPK(invnum, numitm, numimg);
    }

    public EaResultadosImagenesPK getEaResultadosImagenesPK() {
        return eaResultadosImagenesPK;
    }

    public void setEaResultadosImagenesPK(EaResultadosImagenesPK eaResultadosImagenesPK) {
        this.eaResultadosImagenesPK = eaResultadosImagenesPK;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eaResultadosImagenesPK != null ? eaResultadosImagenesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EaResultadosImagenes)) {
            return false;
        }
        EaResultadosImagenes other = (EaResultadosImagenes) object;
        if ((this.eaResultadosImagenesPK == null && other.eaResultadosImagenesPK != null) || (this.eaResultadosImagenesPK != null && !this.eaResultadosImagenesPK.equals(other.eaResultadosImagenesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.EaResultadosImagenes[ eaResultadosImagenesPK=" + eaResultadosImagenesPK + " ]";
    }
    
}
