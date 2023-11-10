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
@Table(name = "view_web_paquetes_detalle")
@NamedQueries({
    @NamedQuery(name = "ViewWebPaquetesDetalle.findAll", query = "SELECT v FROM ViewWebPaquetesDetalle v"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByInvnum", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.invnum = :invnum"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByPachis", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.pachis = :pachis"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByPaqfec", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.paqfec = :paqfec"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByCodpaq", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.codpaq = :codpaq"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByPacnam", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.pacnam = :pacnam"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByPlnnum", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.plnnum = :plnnum"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByPrfnum", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.prfnum = :prfnum"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByTarcod", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.tarcod = :tarcod"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByTardes", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.tardes = :tardes"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByMednam", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.mednam = :mednam"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByFeccre", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.feccre = :feccre"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByFechaFiltro", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.fechaFiltro = :fechaFiltro"),    
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByOrden", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.orden = :orden"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByNumitm", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.numitm = :numitm"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByOricod", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.oricod = :oricod"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByTtacod", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.ttacod = :ttacod"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByDestar", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.destar = :destar"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByAtendido", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.atendido = :atendido"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByFechaCitaOToma", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.fechaCitaOToma = :fechaCitaOToma"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByInvnumO", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.invnumO = :invnumO"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByEstado", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.estado = :estado"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByIntsta", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.intsta = :intsta"),
    @NamedQuery(name = "ViewWebPaquetesDetalle.findByItmsta", query = "SELECT v FROM ViewWebPaquetesDetalle v WHERE v.itmsta = :itmsta")})
public class ViewWebPaquetesDetalle implements Serializable {

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
    @Column(name = "feccre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feccre;
    @Column(name = "FechaFiltro")
    @Temporal(TemporalType.DATE)
    private Date fechaFiltro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden")
    private int orden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numitm")
    private int numitm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "oricod")
    private String oricod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ttacod")
    private String ttacod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "destar")
    private String destar;
    @Column(name = "atendido")
    private Integer atendido;
    @Column(name = "fechaCitaOToma")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCitaOToma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invnum_o")
    private int invnumO;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "itmsta")
    private String itmsta;

    public ViewWebPaquetesDetalle() {
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

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getNumitm() {
        return numitm;
    }

    public void setNumitm(int numitm) {
        this.numitm = numitm;
    }

    public String getOricod() {
        return oricod;
    }

    public void setOricod(String oricod) {
        this.oricod = oricod;
    }

    public String getTtacod() {
        return ttacod;
    }

    public void setTtacod(String ttacod) {
        this.ttacod = ttacod;
    }

    public String getDestar() {
        return destar;
    }

    public void setDestar(String destar) {
        this.destar = destar;
    }

    public Integer getAtendido() {
        return atendido;
    }

    public void setAtendido(Integer atendido) {
        this.atendido = atendido;
    }

    public Date getFechaCitaOToma() {
        return fechaCitaOToma;
    }

    public void setFechaCitaOToma(Date fechaCitaOToma) {
        this.fechaCitaOToma = fechaCitaOToma;
    }

    public int getInvnumO() {
        return invnumO;
    }

    public void setInvnumO(int invnumO) {
        this.invnumO = invnumO;
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

    public String getItmsta() {
        return itmsta;
    }

    public void setItmsta(String itmsta) {
        this.itmsta = itmsta;
    }
    
}
