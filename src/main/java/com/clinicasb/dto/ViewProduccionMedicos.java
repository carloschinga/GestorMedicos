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
@Table(name = "view_produccion_medicos")
@NamedQueries({
    @NamedQuery(name = "ViewProduccionMedicos.findAll", query = "SELECT v FROM ViewProduccionMedicos v"),
    @NamedQuery(name = "ViewProduccionMedicos.findBySercod", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.sercod = :sercod"),
    @NamedQuery(name = "ViewProduccionMedicos.findByMedcod", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.medcod = :medcod"),
    @NamedQuery(name = "ViewProduccionMedicos.findByPronum", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.pronum = :pronum"),
    @NamedQuery(name = "ViewProduccionMedicos.findByMednam", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.mednam = :mednam"),
    @NamedQuery(name = "ViewProduccionMedicos.findBySerdes", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.serdes = :serdes"),
    @NamedQuery(name = "ViewProduccionMedicos.findByNombre", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "ViewProduccionMedicos.findByDescon", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.descon = :descon"),
    @NamedQuery(name = "ViewProduccionMedicos.findByPromes", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.promes = :promes"),
    @NamedQuery(name = "ViewProduccionMedicos.findByTurrat", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.turrat = :turrat"),
    @NamedQuery(name = "ViewProduccionMedicos.findByFecha", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "ViewProduccionMedicos.findByHorini", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.horini = :horini"),
    @NamedQuery(name = "ViewProduccionMedicos.findByHorfin", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.horfin = :horfin"),
    @NamedQuery(name = "ViewProduccionMedicos.findByPacxHora", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.pacxHora = :pacxHora"),
    @NamedQuery(name = "ViewProduccionMedicos.findByCantMin", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.cantMin = :cantMin"),
    @NamedQuery(name = "ViewProduccionMedicos.filtro", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.fecha BETWEEN :startDate and :endDate and v.sercod like :sercod "),
    @NamedQuery(name = "ViewProduccionMedicos.findByPacientesProgramados", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.pacientesProgramados = :pacientesProgramados"),
    @NamedQuery(name = "ViewProduccionMedicos.findByPacientesAtendidos", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.pacientesAtendidos = :pacientesAtendidos"),
    @NamedQuery(name = "ViewProduccionMedicos.findByPacientesCitados", query = "SELECT v FROM ViewProduccionMedicos v WHERE v.pacientesCitados = :pacientesCitados")})
public class ViewProduccionMedicos implements Serializable {

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
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pronum")
    private int pronum;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 83)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "descon")
    private String descon;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "promes")
    private String promes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "turrat")
    private int turrat;
    @Id
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horini;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horfin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horfin;
    @Column(name = "PacxHora")
    private Integer pacxHora;
    @Column(name = "CantMin")
    private Integer cantMin;
    @Column(name = "PacientesProgramados")
    private Integer pacientesProgramados;
    @Column(name = "PacientesAtendidos")
    private Integer pacientesAtendidos;
    @Column(name = "PacientesCitados")
    private Integer pacientesCitados;

    public ViewProduccionMedicos() {
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

    public int getPronum() {
        return pronum;
    }

    public void setPronum(int pronum) {
        this.pronum = pronum;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescon() {
        return descon;
    }

    public void setDescon(String descon) {
        this.descon = descon;
    }

    public String getPromes() {
        return promes;
    }

    public void setPromes(String promes) {
        this.promes = promes;
    }

    public int getTurrat() {
        return turrat;
    }

    public void setTurrat(int turrat) {
        this.turrat = turrat;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHorini() {
        return horini;
    }

    public void setHorini(Date horini) {
        this.horini = horini;
    }

    public Date getHorfin() {
        return horfin;
    }

    public void setHorfin(Date horfin) {
        this.horfin = horfin;
    }

    public Integer getPacxHora() {
        return pacxHora;
    }

    public void setPacxHora(Integer pacxHora) {
        this.pacxHora = pacxHora;
    }

    public Integer getCantMin() {
        return cantMin;
    }

    public void setCantMin(Integer cantMin) {
        this.cantMin = cantMin;
    }

    public Integer getPacientesProgramados() {
        return pacientesProgramados;
    }

    public void setPacientesProgramados(Integer pacientesProgramados) {
        this.pacientesProgramados = pacientesProgramados;
    }

    public Integer getPacientesAtendidos() {
        return pacientesAtendidos;
    }

    public void setPacientesAtendidos(Integer pacientesAtendidos) {
        this.pacientesAtendidos = pacientesAtendidos;
    }

    public Integer getPacientesCitados() {
        return pacientesCitados;
    }

    public void setPacientesCitados(Integer pacientesCitados) {
        this.pacientesCitados = pacientesCitados;
    }
    
}
