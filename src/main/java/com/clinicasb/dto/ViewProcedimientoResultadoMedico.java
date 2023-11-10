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
@Table(name = "view_procedimiento_resultado_medico")
@NamedQueries({
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findAll", query = "SELECT v FROM ViewProcedimientoResultadoMedico v"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findBySecuencia", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.secuencia = :secuencia"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findByPachis", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.pachis = :pachis"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findByPrfnum", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.prfnum = :prfnum"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findByPaciente", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.paciente = :paciente"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findByTipoPlan", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.tipoPlan = :tipoPlan"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findByNumitm", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.numitm = :numitm"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findByTarcod", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.tarcod = :tarcod"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findByTardes", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.tardes = :tardes"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findByFechaOrden", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findByFechaFiltro", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.fechaFiltro = :fechaFiltro"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findByMedcod", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.medcod = :medcod"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findByUsecodApr", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.usecodApr = :usecodApr"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findByExaapr", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.exaapr = :exaapr"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findByCodstd", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.codstd = :codstd"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findByFeccreApr", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.feccreApr = :feccreApr"),
    @NamedQuery(name = "ViewProcedimientoResultadoMedico.findByNamfile", query = "SELECT v FROM ViewProcedimientoResultadoMedico v WHERE v.namfile = :namfile")})
public class ViewProcedimientoResultadoMedico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "secuencia")
    private int secuencia;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "pachis")
    private String pachis;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prfnum")
    private int prfnum;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Paciente")
    private String paciente;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "TipoPlan")
    private String tipoPlan;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numitm")
    private int numitm;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tarcod")
    private String tarcod;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "tardes")
    private String tardes;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaOrden")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrden;    
    @Column(name = "FechaFiltro")
    @Temporal(TemporalType.DATE)
    private Date fechaFiltro;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "resexa")
    private String resexa;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "medcod")
    private String medcod;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "resexahml")
    private String resexahml;
    @Column(name = "usecod_apr")
    private Integer usecodApr;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "exaapr")
    private String exaapr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codstd")
    private String codstd;
    @Column(name = "feccre_apr")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feccreApr;
    @Size(max = 200)
    @Column(name = "namfile")
    private String namfile;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "tarhtml")
    private String tarhtml;

    public ViewProcedimientoResultadoMedico() {
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public String getPachis() {
        return pachis;
    }

    public void setPachis(String pachis) {
        this.pachis = pachis;
    }

    public int getPrfnum() {
        return prfnum;
    }

    public void setPrfnum(int prfnum) {
        this.prfnum = prfnum;
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

    public int getNumitm() {
        return numitm;
    }

    public void setNumitm(int numitm) {
        this.numitm = numitm;
    }

    public String getTarcod() {
        return tarcod;
    }

    public void setTarcod(String tarcod) {
        this.tarcod = tarcod;
    }

    public String getTardes() {
        return tardes;
    }

    public void setTardes(String tardes) {
        this.tardes = tardes;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Date getFechaFiltro() {
        return fechaFiltro;
    }

    public void setFechaFiltro(Date fechaFiltro) {
        this.fechaFiltro = fechaFiltro;
    }

    public String getResexa() {
        return resexa;
    }

    public void setResexa(String resexa) {
        this.resexa = resexa;
    }

    public String getMedcod() {
        return medcod;
    }

    public void setMedcod(String medcod) {
        this.medcod = medcod;
    }

    public String getResexahml() {
        return resexahml;
    }

    public void setResexahml(String resexahml) {
        this.resexahml = resexahml;
    }

    public Integer getUsecodApr() {
        return usecodApr;
    }

    public void setUsecodApr(Integer usecodApr) {
        this.usecodApr = usecodApr;
    }

    public String getExaapr() {
        return exaapr;
    }

    public void setExaapr(String exaapr) {
        this.exaapr = exaapr;
    }

    public String getCodstd() {
        return codstd;
    }

    public void setCodstd(String codstd) {
        this.codstd = codstd;
    }

    public Date getFeccreApr() {
        return feccreApr;
    }

    public void setFeccreApr(Date feccreApr) {
        this.feccreApr = feccreApr;
    }

    public String getNamfile() {
        return namfile;
    }

    public void setNamfile(String namfile) {
        this.namfile = namfile;
    }

    public String getTarhtml() {
        return tarhtml;
    }

    public void setTarhtml(String tarhtml) {
        this.tarhtml = tarhtml;
    }
    
}
