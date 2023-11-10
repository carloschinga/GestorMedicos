/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "view_programacion_medico_deta")
@NamedQueries({
    @NamedQuery(name = "ViewProgramacionMedicoDeta.findAll", query = "SELECT v FROM ViewProgramacionMedicoDeta v"),
    @NamedQuery(name = "ViewProgramacionMedicoDeta.findByMedcodSercod", query = "SELECT v FROM ViewProgramacionMedicoDeta v WHERE v.sercod = :sercod and v.medcod = :medcod and v.promes = :promes"),
    @NamedQuery(name = "ViewProgramacionMedicoDeta.findBySercod", query = "SELECT v FROM ViewProgramacionMedicoDeta v WHERE v.sercod = :sercod"),
    @NamedQuery(name = "ViewProgramacionMedicoDeta.findByMedcod", query = "SELECT v FROM ViewProgramacionMedicoDeta v WHERE v.medcod = :medcod"),
    @NamedQuery(name = "ViewProgramacionMedicoDeta.findByMednam", query = "SELECT v FROM ViewProgramacionMedicoDeta v WHERE v.mednam = :mednam"),
    @NamedQuery(name = "ViewProgramacionMedicoDeta.findBySerdes", query = "SELECT v FROM ViewProgramacionMedicoDeta v WHERE v.serdes = :serdes"),
    @NamedQuery(name = "ViewProgramacionMedicoDeta.findByPronum", query = "SELECT v FROM ViewProgramacionMedicoDeta v WHERE v.pronum = :pronum"),
    @NamedQuery(name = "ViewProgramacionMedicoDeta.findByPromes", query = "SELECT v FROM ViewProgramacionMedicoDeta v WHERE v.promes = :promes"),
    @NamedQuery(name = "ViewProgramacionMedicoDeta.findByProfec", query = "SELECT v FROM ViewProgramacionMedicoDeta v WHERE v.profec = :profec"),
    @NamedQuery(name = "ViewProgramacionMedicoDeta.findByFecha", query = "SELECT v FROM ViewProgramacionMedicoDeta v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "ViewProgramacionMedicoDeta.findByFechaFormateada", query = "SELECT v FROM ViewProgramacionMedicoDeta v WHERE v.fechaFormateada = :fechaFormateada"),
    @NamedQuery(name = "ViewProgramacionMedicoDeta.findByHora", query = "SELECT v FROM ViewProgramacionMedicoDeta v WHERE v.hora = :hora"),
    @NamedQuery(name = "ViewProgramacionMedicoDeta.findByDescon", query = "SELECT v FROM ViewProgramacionMedicoDeta v WHERE v.descon = :descon")})
public class ViewProgramacionMedicoDeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "sercod")
    private String sercod;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "medcod")
    private String medcod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "mednam")
    private String mednam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "serdes")
    private String serdes;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pronum")
    private int pronum;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "promes")
    private String promes;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "profec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date profec;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 17)
    @Column(name = "FechaFormateada")
    private String fechaFormateada;
    @Size(max = 13)
    @Column(name = "Hora")
    private String hora;
    @Size(max = 8000)
    @Column(name = "descon")
    private String descon;

    public ViewProgramacionMedicoDeta() {
    }

    public String getSercod() {
        return sercod;
    }

    public void setSercod(String sercod) {
        this.sercod = sercod;
    }

    public String getMedcod() {
        return medcod;
    }

    public void setMedcod(String medcod) {
        this.medcod = medcod;
    }

    public String getMednam() {
        return mednam;
    }

    public void setMednam(String mednam) {
        this.mednam = mednam;
    }

    public String getSerdes() {
        return serdes;
    }

    public void setSerdes(String serdes) {
        this.serdes = serdes;
    }

    public int getPronum() {
        return pronum;
    }

    public void setPronum(int pronum) {
        this.pronum = pronum;
    }

    public String getPromes() {
        return promes;
    }

    public void setPromes(String promes) {
        this.promes = promes;
    }

    public Date getProfec() {
        return profec;
    }

    public void setProfec(Date profec) {
        this.profec = profec;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFechaFormateada() {
        return fechaFormateada;
    }

    public void setFechaFormateada(String fechaFormateada) {
        this.fechaFormateada = fechaFormateada;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescon() {
        return descon;
    }

    public void setDescon(String descon) {
        this.descon = descon;
    }
    
}
