/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "procedimientos_resultados_arch")
@NamedQueries({
    @NamedQuery(name = "ProcedimientosResultadosArch.findAll", query = "SELECT p FROM ProcedimientosResultadosArch p"),
    @NamedQuery(name = "ProcedimientosResultadosArch.findByInvnum", query = "SELECT p FROM ProcedimientosResultadosArch p WHERE p.procedimientosResultadosArchPK.invnum = :invnum"),
    @NamedQuery(name = "ProcedimientosResultadosArch.findByNumitm", query = "SELECT p FROM ProcedimientosResultadosArch p WHERE p.procedimientosResultadosArchPK.numitm = :numitm"),
    @NamedQuery(name = "ProcedimientosResultadosArch.findByNumfile", query = "SELECT p FROM ProcedimientosResultadosArch p WHERE p.procedimientosResultadosArchPK.numfile = :numfile"),
    @NamedQuery(name = "ProcedimientosResultadosArch.findByNamfile", query = "SELECT p FROM ProcedimientosResultadosArch p WHERE p.namfile = :namfile")})
public class ProcedimientosResultadosArch implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcedimientosResultadosArchPK procedimientosResultadosArchPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "namfile")
    private String namfile;

    public ProcedimientosResultadosArch() {
    }

    public ProcedimientosResultadosArch(ProcedimientosResultadosArchPK procedimientosResultadosArchPK) {
        this.procedimientosResultadosArchPK = procedimientosResultadosArchPK;
    }

    public ProcedimientosResultadosArch(ProcedimientosResultadosArchPK procedimientosResultadosArchPK, String namfile) {
        this.procedimientosResultadosArchPK = procedimientosResultadosArchPK;
        this.namfile = namfile;
    }

    public ProcedimientosResultadosArch(int invnum, int numitm, int numfile) {
        this.procedimientosResultadosArchPK = new ProcedimientosResultadosArchPK(invnum, numitm, numfile);
    }

    public ProcedimientosResultadosArchPK getProcedimientosResultadosArchPK() {
        return procedimientosResultadosArchPK;
    }

    public void setProcedimientosResultadosArchPK(ProcedimientosResultadosArchPK procedimientosResultadosArchPK) {
        this.procedimientosResultadosArchPK = procedimientosResultadosArchPK;
    }

    public String getNamfile() {
        return namfile;
    }

    public void setNamfile(String namfile) {
        this.namfile = namfile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procedimientosResultadosArchPK != null ? procedimientosResultadosArchPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedimientosResultadosArch)) {
            return false;
        }
        ProcedimientosResultadosArch other = (ProcedimientosResultadosArch) object;
        if ((this.procedimientosResultadosArchPK == null && other.procedimientosResultadosArchPK != null) || (this.procedimientosResultadosArchPK != null && !this.procedimientosResultadosArchPK.equals(other.procedimientosResultadosArchPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.ProcedimientosResultadosArch[ procedimientosResultadosArchPK=" + procedimientosResultadosArchPK + " ]";
    }
    
}
