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
@Table(name = "view_web_paquetes_cabecera")
@NamedQueries({
    @NamedQuery(name = "ViewWebPaquetesCabecera.findAll", query = "SELECT v FROM ViewWebPaquetesCabecera v"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByInvnum", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.invnum = :invnum"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByPachis", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.pachis = :pachis"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByPaqfec", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.paqfec = :paqfec"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByCodpaq", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.codpaq = :codpaq"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByPacnam", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.pacnam = :pacnam"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByPlnnum", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.plnnum = :plnnum"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByPlndes", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.plndes = :plndes"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByPrfnum", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.prfnum = :prfnum"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByTarcod", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.tarcod = :tarcod"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByTardes", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.tardes = :tardes"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByMednam", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.mednam = :mednam"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByUseusr", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.useusr = :useusr"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByFeccre", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.feccre = :feccre"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByFechaFiltro", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.fechaFiltro = :fechaFiltro"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByFechaFiltroBeetwen", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.fechaFiltro BETWEEN :startDate and :endDate"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByEstado", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.estado = :estado"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByIntsta", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.intsta = :intsta"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByAtendido", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.atendido = :atendido"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByTotal", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.total = :total"),
    @NamedQuery(name = "ViewWebPaquetesCabecera.findByDetalle", query = "SELECT v FROM ViewWebPaquetesCabecera v WHERE v.detalle = :detalle")})
public class ViewWebPaquetesCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "invnum")
    private int invnum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "pachis")
    private String pachis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paqfec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paqfec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "codpaq")
    private String codpaq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "pacnam")
    private String pacnam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "plnnum")
    private String plnnum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "plndes")
    private String plndes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prfnum")
    private int prfnum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tarcod")
    private String tarcod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "tardes")
    private String tardes;
    @Size(max = 40)
    @Column(name = "mednam")
    private String mednam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "useusr")
    private String useusr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "feccre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feccre;
    @Column(name = "FechaFiltro")
    @Temporal(TemporalType.DATE)
    private Date fechaFiltro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "intsta")
    private String intsta;
    @Column(name = "atendido")
    private Integer atendido;
    @Column(name = "total")
    private Integer total;
    @Size(max = 2147483647)
    @Column(name = "detalle")
    private String detalle;

    public ViewWebPaquetesCabecera() {
    }

    public int getInvnum() {
        return invnum;
    }

    public void setInvnum(int invnum) {
        this.invnum = invnum;
    }

    public String getPachis() {
        return pachis;
    }

    public void setPachis(String pachis) {
        this.pachis = pachis;
    }

    public Date getPaqfec() {
        return paqfec;
    }

    public void setPaqfec(Date paqfec) {
        this.paqfec = paqfec;
    }

    public String getCodpaq() {
        return codpaq;
    }

    public void setCodpaq(String codpaq) {
        this.codpaq = codpaq;
    }

    public String getPacnam() {
        return pacnam;
    }

    public void setPacnam(String pacnam) {
        this.pacnam = pacnam;
    }

    public String getPlnnum() {
        return plnnum;
    }

    public void setPlnnum(String plnnum) {
        this.plnnum = plnnum;
    }

    public String getPlndes() {
        return plndes;
    }

    public void setPlndes(String plndes) {
        this.plndes = plndes;
    }

    public int getPrfnum() {
        return prfnum;
    }

    public void setPrfnum(int prfnum) {
        this.prfnum = prfnum;
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

    public String getMednam() {
        return mednam;
    }

    public void setMednam(String mednam) {
        this.mednam = mednam;
    }

    public String getUseusr() {
        return useusr;
    }

    public void setUseusr(String useusr) {
        this.useusr = useusr;
    }

    public Date getFeccre() {
        return feccre;
    }

    public void setFeccre(Date feccre) {
        this.feccre = feccre;
    }

    public Date getFechaFiltro() {
        return fechaFiltro;
    }

    public void setFechaFiltro(Date fechaFiltro) {
        this.fechaFiltro = fechaFiltro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIntsta() {
        return intsta;
    }

    public void setIntsta(String intsta) {
        this.intsta = intsta;
    }

    public Integer getAtendido() {
        return atendido;
    }

    public void setAtendido(Integer atendido) {
        this.atendido = atendido;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
}
