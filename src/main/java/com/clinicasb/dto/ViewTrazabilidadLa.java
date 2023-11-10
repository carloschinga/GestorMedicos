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
@Table(name = "view_trazabilidad_la")
@NamedQueries({
    @NamedQuery(name = "ViewTrazabilidadLa.findAll", query = "SELECT v FROM ViewTrazabilidadLa v"),
    @NamedQuery(name = "ViewTrazabilidadLa.findBySecuencia", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.secuencia = :secuencia"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByHistoria", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.historia = :historia"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByPaciente", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.paciente = :paciente"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByTipoPlan", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.tipoPlan = :tipoPlan"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByExamen", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.examen = :examen"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByFechaOrden", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByFechaCreacion", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByFechaFiltro", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.fechaFiltro = :fechaFiltro"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByFechaFiltroBeetwen", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.fechaFiltro BETWEEN :startDate and :endDate ORDER BY v.secuencia"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByTieneCreacion", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.tieneCreacion = :tieneCreacion"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByFechaPago", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.fechaPago = :fechaPago"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByTienePago", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.tienePago = :tienePago"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByDiasDemoraPago", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.diasDemoraPago = :diasDemoraPago"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByFechaTomaExamen", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.fechaTomaExamen = :fechaTomaExamen"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByTieneTomaExamen", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.tieneTomaExamen = :tieneTomaExamen"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByDiasDemoraExamen", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.diasDemoraExamen = :diasDemoraExamen"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByFechaResultado", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.fechaResultado = :fechaResultado"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByTieneResultado", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.tieneResultado = :tieneResultado"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByDiasDemoraResultado", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.diasDemoraResultado = :diasDemoraResultado"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByFechaAprobado", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.fechaAprobado = :fechaAprobado"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByTieneAprobado", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.tieneAprobado = :tieneAprobado"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByDiasDemoraAprobado", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.diasDemoraAprobado = :diasDemoraAprobado"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByMes", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.mes = :mes"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByDia", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.dia = :dia"),
    @NamedQuery(name = "ViewTrazabilidadLa.findByAnio", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.anio = :anio"),
    @NamedQuery(name = "ViewTrazabilidadLa.findBySemana", query = "SELECT v FROM ViewTrazabilidadLa v WHERE v.semana = :semana")})
public class ViewTrazabilidadLa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Secuencia")
    private int secuencia;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "Historia")
    private String historia;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Paciente")
    private String paciente;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "TipoPlan")
    private String tipoPlan;
    @Id
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
    @Column(name = "FechaPago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TienePago")
    private int tienePago;
    @Column(name = "diasDemoraPago")
    private Integer diasDemoraPago;
    @Column(name = "FechaTomaExamen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTomaExamen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TieneTomaExamen")
    private int tieneTomaExamen;
    @Column(name = "diasDemoraExamen")
    private Integer diasDemoraExamen;
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

    public ViewTrazabilidadLa() {
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
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

}
