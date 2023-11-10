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
@Table(name = "view_trazabilidad_procedimiento")
@NamedQueries({
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findAll", query = "SELECT v FROM ViewTrazabilidadProcedimiento v"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaFiltroBeetwen", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaFiltro BETWEEN :startDate and :endDate ORDER BY v.secuencia"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findBySecuencia", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.secuencia = :secuencia"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByNumitm", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.numitm = :numitm"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByHistoria", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.historia = :historia"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByPaciente", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.paciente = :paciente"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByTipoPlan", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.tipoPlan = :tipoPlan"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByExamen", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.examen = :examen"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaOrden", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaCreacion", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaFiltro", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaFiltro = :fechaFiltro"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByTieneCreacion", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.tieneCreacion = :tieneCreacion"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaPago", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaPago = :fechaPago"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByTienePago", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.tienePago = :tienePago"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByDiasDemoraPago", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.diasDemoraPago = :diasDemoraPago"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaTomaExamen", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaTomaExamen = :fechaTomaExamen"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByTieneTomaExamen", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.tieneTomaExamen = :tieneTomaExamen"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByDiasDemoraExamen", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.diasDemoraExamen = :diasDemoraExamen"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaResultado", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaResultado = :fechaResultado"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByTieneResultado", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.tieneResultado = :tieneResultado"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByDiasDemoraResultado", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.diasDemoraResultado = :diasDemoraResultado"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaAprobado", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaAprobado = :fechaAprobado"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByTieneAprobado", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.tieneAprobado = :tieneAprobado"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByDiasDemoraAprobado", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.diasDemoraAprobado = :diasDemoraAprobado"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByMes", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.mes = :mes"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByDia", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.dia = :dia"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByAnio", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.anio = :anio"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findBySemana", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.semana = :semana"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByMedcod", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.medcod = :medcod"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByExaapr", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.exaapr = :exaapr")})
public class ViewTrazabilidadProcedimiento implements Serializable {

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
    @Size(min = 1, max = 70)
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
    @Column(name = "FechaPago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TienePago")
    private int tienePago;
    @Column(name = "diasDemoraPago")
    private Integer diasDemoraPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaTomaExamen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTomaExamen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TieneTomaExamen")
    private int tieneTomaExamen;
    @Column(name = "diasDemoraExamen")
    private Integer diasDemoraExamen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaResultado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaResultado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TieneResultado")
    private int tieneResultado;
    @Column(name = "diasDemoraResultado")
    private Integer diasDemoraResultado;
    @Column(name = "FechaAprobado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAprobado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TieneAprobado")
    private int tieneAprobado;
    @Column(name = "diasDemoraAprobado")
    private Integer diasDemoraAprobado;
    @Column(name = "mes")
    private Integer mes;
    @Column(name = "dia")
    private Integer dia;
    @Column(name = "anio")
    private Integer anio;
    @Column(name = "semana")
    private Integer semana;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "medcod")
    private String medcod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "exaapr")
    private String exaapr;

    public ViewTrazabilidadProcedimiento() {
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

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getTienePago() {
        return tienePago;
    }

    public void setTienePago(int tienePago) {
        this.tienePago = tienePago;
    }

    public Integer getDiasDemoraPago() {
        return diasDemoraPago;
    }

    public void setDiasDemoraPago(Integer diasDemoraPago) {
        this.diasDemoraPago = diasDemoraPago;
    }

    public Date getFechaTomaExamen() {
        return fechaTomaExamen;
    }

    public void setFechaTomaExamen(Date fechaTomaExamen) {
        this.fechaTomaExamen = fechaTomaExamen;
    }

    public int getTieneTomaExamen() {
        return tieneTomaExamen;
    }

    public void setTieneTomaExamen(int tieneTomaExamen) {
        this.tieneTomaExamen = tieneTomaExamen;
    }

    public Integer getDiasDemoraExamen() {
        return diasDemoraExamen;
    }

    public void setDiasDemoraExamen(Integer diasDemoraExamen) {
        this.diasDemoraExamen = diasDemoraExamen;
    }

    public Date getFechaResultado() {
        return fechaResultado;
    }

    public void setFechaResultado(Date fechaResultado) {
        this.fechaResultado = fechaResultado;
    }

    public int getTieneResultado() {
        return tieneResultado;
    }

    public void setTieneResultado(int tieneResultado) {
        this.tieneResultado = tieneResultado;
    }

    public Integer getDiasDemoraResultado() {
        return diasDemoraResultado;
    }

    public void setDiasDemoraResultado(Integer diasDemoraResultado) {
        this.diasDemoraResultado = diasDemoraResultado;
    }

    public Date getFechaAprobado() {
        return fechaAprobado;
    }

    public void setFechaAprobado(Date fechaAprobado) {
        this.fechaAprobado = fechaAprobado;
    }

    public int getTieneAprobado() {
        return tieneAprobado;
    }

    public void setTieneAprobado(int tieneAprobado) {
        this.tieneAprobado = tieneAprobado;
    }

    public Integer getDiasDemoraAprobado() {
        return diasDemoraAprobado;
    }

    public void setDiasDemoraAprobado(Integer diasDemoraAprobado) {
        this.diasDemoraAprobado = diasDemoraAprobado;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getSemana() {
        return semana;
    }

    public void setSemana(Integer semana) {
        this.semana = semana;
    }

    public String getMedcod() {
        return medcod;
    }

    public void setMedcod(String medcod) {
        this.medcod = medcod;
    }

    public String getExaapr() {
        return exaapr;
    }

    public void setExaapr(String exaapr) {
        this.exaapr = exaapr;
    }
    
}
