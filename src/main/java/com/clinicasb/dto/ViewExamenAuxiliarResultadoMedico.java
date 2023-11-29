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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "view_examen_auxiliar_resultado_medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findAll", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findBySecuencia", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.secuencia = :secuencia"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByFechaFiltroBeetwen", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE  v.medcod = :medcod and v.fechaFiltro BETWEEN :startDate and :endDate  ORDER BY v.secuencia"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByNumitm", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.numitm = :numitm"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByPrfnum", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.prfnum = :prfnum"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByPacdoc", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.pacdoc = :pacdoc"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByHistoria", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.historia = :historia"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByPaciente", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.paciente = :paciente"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByFechaNaci", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.fechaNaci = :fechaNaci"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByTipoPlan", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.tipoPlan = :tipoPlan"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByExacod", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.exacod = :exacod"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByExamen", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.examen = :examen"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByFechaOrden", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByFechaCreacion", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByFechaFiltro", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.fechaFiltro = :fechaFiltro"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByTieneCreacion", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.tieneCreacion = :tieneCreacion"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByFechaTomaExamen", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.fechaTomaExamen = :fechaTomaExamen"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByMedcod", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.medcod = :medcod"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByUsecodApr", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.usecodApr = :usecodApr"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findByFeccreApr", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.feccreApr = :feccreApr"),
    @NamedQuery(name = "ViewExamenAuxiliarResultadoMedico.findBySexcod", query = "SELECT v FROM ViewExamenAuxiliarResultadoMedico v WHERE v.sexcod = :sexcod")})
public class ViewExamenAuxiliarResultadoMedico implements Serializable {

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
    @Column(name = "prfnum")
    private int prfnum;
    @Size(max = 20)
    @Column(name = "pacdoc")
    private String pacdoc;
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
    @Column(name = "FechaNaci")
    @Temporal(TemporalType.DATE)
    private Date fechaNaci;
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
    @Column(name = "feccre_apr")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feccreApr;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "exahtml")
    private String exahtml;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "sexcod")
    private String sexcod;

    public ViewExamenAuxiliarResultadoMedico() {
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

    public int getPrfnum() {
        return prfnum;
    }

    public void setPrfnum(int prfnum) {
        this.prfnum = prfnum;
    }

    public String getPacdoc() {
        return pacdoc;
    }

    public void setPacdoc(String pacdoc) {
        this.pacdoc = pacdoc;
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

    public Date getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(Date fechaNaci) {
        this.fechaNaci = fechaNaci;
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

    public Date getFeccreApr() {
        return feccreApr;
    }

    public void setFeccreApr(Date feccreApr) {
        this.feccreApr = feccreApr;
    }

    public String getExahtml() {
        return exahtml;
    }

    public void setExahtml(String exahtml) {
        this.exahtml = exahtml;
    }

    public String getSexcod() {
        return sexcod;
    }

    public void setSexcod(String sexcod) {
        this.sexcod = sexcod;
    }
    
}
