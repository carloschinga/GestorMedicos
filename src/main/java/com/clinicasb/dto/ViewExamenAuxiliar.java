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
import javax.persistence.Lob;
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
@Table(name = "view_examen_auxiliar")
@NamedQueries({
    @NamedQuery(name = "ViewExamenAuxiliar.findAll", query = "SELECT v FROM ViewExamenAuxiliar v"),
        @NamedQuery(name = "ViewExamenAuxiliar.findByFechaFiltroBeetwen", query = "SELECT v FROM ViewExamenAuxiliar v WHERE  v.medcod = :medcod and v.fechaFiltro BETWEEN :startDate and :endDate  ORDER BY v.secuencia"),
    @NamedQuery(name = "ViewExamenAuxiliar.findBySecuencia", query = "SELECT v FROM ViewExamenAuxiliar v WHERE v.secuencia = :secuencia"),
    @NamedQuery(name = "ViewExamenAuxiliar.findByNumitm", query = "SELECT v FROM ViewExamenAuxiliar v WHERE v.numitm = :numitm"),
    @NamedQuery(name = "ViewExamenAuxiliar.findByHistoria", query = "SELECT v FROM ViewExamenAuxiliar v WHERE v.historia = :historia"),
    @NamedQuery(name = "ViewExamenAuxiliar.findByPaciente", query = "SELECT v FROM ViewExamenAuxiliar v WHERE v.paciente = :paciente"),
    @NamedQuery(name = "ViewExamenAuxiliar.findByTipoPlan", query = "SELECT v FROM ViewExamenAuxiliar v WHERE v.tipoPlan = :tipoPlan"),
    @NamedQuery(name = "ViewExamenAuxiliar.findByExacod", query = "SELECT v FROM ViewExamenAuxiliar v WHERE v.exacod = :exacod"),
    @NamedQuery(name = "ViewExamenAuxiliar.findByExamen", query = "SELECT v FROM ViewExamenAuxiliar v WHERE v.examen = :examen"),
    @NamedQuery(name = "ViewExamenAuxiliar.findByFechaOrden", query = "SELECT v FROM ViewExamenAuxiliar v WHERE v.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "ViewExamenAuxiliar.findByFechaCreacion", query = "SELECT v FROM ViewExamenAuxiliar v WHERE v.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ViewExamenAuxiliar.findByFechaFiltro", query = "SELECT v FROM ViewExamenAuxiliar v WHERE v.fechaFiltro = :fechaFiltro"),
    @NamedQuery(name = "ViewExamenAuxiliar.findByTieneCreacion", query = "SELECT v FROM ViewExamenAuxiliar v WHERE v.tieneCreacion = :tieneCreacion"),
    @NamedQuery(name = "ViewExamenAuxiliar.findByFechaTomaExamen", query = "SELECT v FROM ViewExamenAuxiliar v WHERE v.fechaTomaExamen = :fechaTomaExamen"),
    @NamedQuery(name = "ViewExamenAuxiliar.findByMedcod", query = "SELECT v FROM ViewExamenAuxiliar v WHERE v.medcod = :medcod"),
    @NamedQuery(name = "ViewExamenAuxiliar.findByUsecodApr", query = "SELECT v FROM ViewExamenAuxiliar v WHERE v.usecodApr = :usecodApr")})
public class ViewExamenAuxiliar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Secuencia")
    private int secuencia;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numitm")
    private int numitm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "Historia")
    private String historia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Paciente")
    private String paciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "TipoPlan")
    private String tipoPlan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "exacod")
    private String exacod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Examen")
    private String examen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaOrden")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "FechaFiltro")
    @Temporal(TemporalType.DATE)
    private Date fechaFiltro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TieneCreacion")
    private int tieneCreacion;
    @Column(name = "FechaTomaExamen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTomaExamen;
    @Size(max = 4)
    @Column(name = "medcod")
    private String medcod;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "resexahtml")
    private String resexahtml;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "resexa")
    private String resexa;
    @Column(name = "usecod_apr")
    private Integer usecodApr;

    public ViewExamenAuxiliar() {
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public int getNumitm() {
        return numitm;
    }

    public void setNumitm(int numitm) {
        this.numitm = numitm;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public String getExacod() {
        return exacod;
    }

    public void setExacod(String exacod) {
        this.exacod = exacod;
    }

    public String getExamen() {
        return examen;
    }

    public void setExamen(String examen) {
        this.examen = examen;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaFiltro() {
        return fechaFiltro;
    }

    public void setFechaFiltro(Date fechaFiltro) {
        this.fechaFiltro = fechaFiltro;
    }

    public int getTieneCreacion() {
        return tieneCreacion;
    }

    public void setTieneCreacion(int tieneCreacion) {
        this.tieneCreacion = tieneCreacion;
    }

    public Date getFechaTomaExamen() {
        return fechaTomaExamen;
    }

    public void setFechaTomaExamen(Date fechaTomaExamen) {
        this.fechaTomaExamen = fechaTomaExamen;
    }

    public String getMedcod() {
        return medcod;
    }

    public void setMedcod(String medcod) {
        this.medcod = medcod;
    }

    public String getResexahtml() {
        return resexahtml;
    }

    public void setResexahtml(String resexahtml) {
        this.resexahtml = resexahtml;
    }

    public String getResexa() {
        return resexa;
    }

    public void setResexa(String resexa) {
        this.resexa = resexa;
    }

    public Integer getUsecodApr() {
        return usecodApr;
    }

    public void setUsecodApr(Integer usecodApr) {
        this.usecodApr = usecodApr;
    }
    
}
