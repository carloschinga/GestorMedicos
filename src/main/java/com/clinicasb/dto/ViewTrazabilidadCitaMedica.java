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
@Table(name = "view_trazabilidad_cita_medica")
@NamedQueries({
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findAll", query = "SELECT v FROM ViewTrazabilidadCitaMedica v"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findBySecuencia", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.secuencia = :secuencia"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByPreFactura", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.preFactura = :preFactura"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByPaciente", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.paciente = :paciente"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByMedico", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.medico = :medico"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByTipoPlan", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.tipoPlan = :tipoPlan"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByServicio", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.servicio = :servicio"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByTarifa", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.tarifa = :tarifa"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByFechaOrden", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByFechaFiltro", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.fechaFiltro = :fechaFiltro"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByFechaFiltroBeetwen", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.fechaFiltro BETWEEN :startDate and :endDate ORDER BY v.secuencia"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByFechaCita", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.fechaCita = :fechaCita"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByFechaPago", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.fechaPago = :fechaPago"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByFechaLlegada", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.fechaLlegada = :fechaLlegada"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByPrimeraHoraAtencion", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.primeraHoraAtencion = :primeraHoraAtencion"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByUltimaHoraAtencion", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.ultimaHoraAtencion = :ultimaHoraAtencion"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByDiagnostico1", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.diagnostico1 = :diagnostico1"),
    @NamedQuery(name = "ViewTrazabilidadCitaMedica.findByDiagnostico2", query = "SELECT v FROM ViewTrazabilidadCitaMedica v WHERE v.diagnostico2 = :diagnostico2")})
public class ViewTrazabilidadCitaMedica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Secuencia")
    private int secuencia;
    @Column(name = "PreFactura")
    private Integer preFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Paciente")
    private String paciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Medico")
    private String medico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "TipoPlan")
    private String tipoPlan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Servicio")
    private String servicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "Tarifa")
    private String tarifa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaOrden")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrden;
    @Column(name = "FechaFiltro")
    @Temporal(TemporalType.DATE)
    private Date fechaFiltro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaCita")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCita;
    @Column(name = "FechaPago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Column(name = "FechaLlegada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLlegada;
    @Size(max = 5)
    @Column(name = "PrimeraHoraAtencion")
    private String primeraHoraAtencion;
    @Size(max = 5)
    @Column(name = "UltimaHoraAtencion")
    private String ultimaHoraAtencion;
    @Size(max = 140)
    @Column(name = "Diagnostico1")
    private String diagnostico1;
    @Size(max = 140)
    @Column(name = "Diagnostico2")
    private String diagnostico2;

    public ViewTrazabilidadCitaMedica() {
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public Integer getPreFactura() {
        return preFactura;
    }

    public void setPreFactura(Integer preFactura) {
        this.preFactura = preFactura;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
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

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getPrimeraHoraAtencion() {
        return primeraHoraAtencion;
    }

    public void setPrimeraHoraAtencion(String primeraHoraAtencion) {
        this.primeraHoraAtencion = primeraHoraAtencion;
    }

    public String getUltimaHoraAtencion() {
        return ultimaHoraAtencion;
    }

    public void setUltimaHoraAtencion(String ultimaHoraAtencion) {
        this.ultimaHoraAtencion = ultimaHoraAtencion;
    }

    public String getDiagnostico1() {
        return diagnostico1;
    }

    public void setDiagnostico1(String diagnostico1) {
        this.diagnostico1 = diagnostico1;
    }

    public String getDiagnostico2() {
        return diagnostico2;
    }

    public void setDiagnostico2(String diagnostico2) {
        this.diagnostico2 = diagnostico2;
    }
    
}
