/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dto;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tarifario")
@NamedQueries({
    @NamedQuery(name = "Tarifario.findAll", query = "SELECT t FROM Tarifario t"),
    @NamedQuery(name = "Tarifario.findByTarcod", query = "SELECT t FROM Tarifario t WHERE t.tarcod = :tarcod"),
    @NamedQuery(name = "Tarifario.findByTardes", query = "SELECT t FROM Tarifario t WHERE t.tardes = :tardes"),
    @NamedQuery(name = "Tarifario.findByTaruni", query = "SELECT t FROM Tarifario t WHERE t.taruni = :taruni"),
    @NamedQuery(name = "Tarifario.findByTarund", query = "SELECT t FROM Tarifario t WHERE t.tarund = :tarund"),
    @NamedQuery(name = "Tarifario.findByCodcue", query = "SELECT t FROM Tarifario t WHERE t.codcue = :codcue"),
    @NamedQuery(name = "Tarifario.findByTarsta", query = "SELECT t FROM Tarifario t WHERE t.tarsta = :tarsta"),
    @NamedQuery(name = "Tarifario.findByTarint", query = "SELECT t FROM Tarifario t WHERE t.tarint = :tarint"),
    @NamedQuery(name = "Tarifario.findByTarcos", query = "SELECT t FROM Tarifario t WHERE t.tarcos = :tarcos"),
    @NamedQuery(name = "Tarifario.findByTarcod2", query = "SELECT t FROM Tarifario t WHERE t.tarcod2 = :tarcod2"),
    @NamedQuery(name = "Tarifario.findByTarigv", query = "SELECT t FROM Tarifario t WHERE t.tarigv = :tarigv"),
    @NamedQuery(name = "Tarifario.findByTarmpri", query = "SELECT t FROM Tarifario t WHERE t.tarmpri = :tarmpri"),
    @NamedQuery(name = "Tarifario.findByTarpcta", query = "SELECT t FROM Tarifario t WHERE t.tarpcta = :tarpcta"),
    @NamedQuery(name = "Tarifario.findByTarded", query = "SELECT t FROM Tarifario t WHERE t.tarded = :tarded"),
    @NamedQuery(name = "Tarifario.findByEstado", query = "SELECT t FROM Tarifario t WHERE t.estado = :estado"),
    @NamedQuery(name = "Tarifario.findByFeccre", query = "SELECT t FROM Tarifario t WHERE t.feccre = :feccre"),
    @NamedQuery(name = "Tarifario.findByFecumv", query = "SELECT t FROM Tarifario t WHERE t.fecumv = :fecumv"),
    @NamedQuery(name = "Tarifario.findByUsecod", query = "SELECT t FROM Tarifario t WHERE t.usecod = :usecod"),
    @NamedQuery(name = "Tarifario.findByUsenam", query = "SELECT t FROM Tarifario t WHERE t.usenam = :usenam"),
    @NamedQuery(name = "Tarifario.findByHostname", query = "SELECT t FROM Tarifario t WHERE t.hostname = :hostname"),
    @NamedQuery(name = "Tarifario.findByTarref", query = "SELECT t FROM Tarifario t WHERE t.tarref = :tarref"),
    @NamedQuery(name = "Tarifario.findByTarmod", query = "SELECT t FROM Tarifario t WHERE t.tarmod = :tarmod"),
    @NamedQuery(name = "Tarifario.findByTarcosD", query = "SELECT t FROM Tarifario t WHERE t.tarcosD = :tarcosD"),
    @NamedQuery(name = "Tarifario.findByTartes", query = "SELECT t FROM Tarifario t WHERE t.tartes = :tartes"),
    @NamedQuery(name = "Tarifario.findByTarfme", query = "SELECT t FROM Tarifario t WHERE t.tarfme = :tarfme"),
    @NamedQuery(name = "Tarifario.findByTarfen", query = "SELECT t FROM Tarifario t WHERE t.tarfen = :tarfen"),
    @NamedQuery(name = "Tarifario.findByTarfob", query = "SELECT t FROM Tarifario t WHERE t.tarfob = :tarfob"),
    @NamedQuery(name = "Tarifario.findByTarfte", query = "SELECT t FROM Tarifario t WHERE t.tarfte = :tarfte"),
    @NamedQuery(name = "Tarifario.findByTardesL", query = "SELECT t FROM Tarifario t WHERE t.tardesL = :tardesL"),
    @NamedQuery(name = "Tarifario.findByTardisVir", query = "SELECT t FROM Tarifario t WHERE t.tardisVir = :tardisVir"),
    @NamedQuery(name = "Tarifario.findByTardisPre", query = "SELECT t FROM Tarifario t WHERE t.tardisPre = :tardisPre"),
    @NamedQuery(name = "Tarifario.findByTarserTip", query = "SELECT t FROM Tarifario t WHERE t.tarserTip = :tarserTip"),
    @NamedQuery(name = "Tarifario.findByTarabrv", query = "SELECT t FROM Tarifario t WHERE t.tarabrv = :tarabrv"),
    @NamedQuery(name = "Tarifario.findByStasgl", query = "SELECT t FROM Tarifario t WHERE t.stasgl = :stasgl"),
    @NamedQuery(name = "Tarifario.findByTartipPln", query = "SELECT t FROM Tarifario t WHERE t.tartipPln = :tartipPln"),
    @NamedQuery(name = "Tarifario.findByCencos", query = "SELECT t FROM Tarifario t WHERE t.cencos = :cencos"),
    @NamedQuery(name = "Tarifario.findByMoncod", query = "SELECT t FROM Tarifario t WHERE t.moncod = :moncod"),
    @NamedQuery(name = "Tarifario.findByTipccod", query = "SELECT t FROM Tarifario t WHERE t.tipccod = :tipccod"),
    @NamedQuery(name = "Tarifario.findByTtacod", query = "SELECT t FROM Tarifario t WHERE t.ttacod = :ttacod")})
public class Tarifario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taruni")
    private BigDecimal taruni;
    @Column(name = "tarund")
    private BigDecimal tarund;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "codcue")
    private String codcue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tarsta")
    private String tarsta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tarint")
    private String tarint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarcos")
    private BigDecimal tarcos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tarcod2")
    private String tarcod2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarigv")
    private BigDecimal tarigv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarmpri")
    private Character tarmpri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarpcta")
    private Character tarpcta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tarded")
    private String tarded;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "feccre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feccre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecumv")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecumv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usecod")
    private int usecod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usenam")
    private String usenam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "hostname")
    private String hostname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarref")
    private BigDecimal tarref;
    @Size(max = 60)
    @Column(name = "tarmod")
    private String tarmod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarcos_d")
    private BigDecimal tarcosD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tartes")
    private int tartes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarfme")
    private BigDecimal tarfme;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarfen")
    private BigDecimal tarfen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarfob")
    private BigDecimal tarfob;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarfte")
    private BigDecimal tarfte;
    @Size(max = 250)
    @Column(name = "tardes_l")
    private String tardesL;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tardis_vir")
    private String tardisVir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tardis_pre")
    private String tardisPre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tarser_tip")
    private String tarserTip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tarabrv")
    private String tarabrv;
    @Size(max = 1)
    @Column(name = "stasgl")
    private String stasgl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tartip_pln")
    private String tartipPln;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "tarhtml")
    private String tarhtml;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cencos")
    private String cencos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "moncod")
    private String moncod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tipccod")
    private String tipccod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ttacod")
    private String ttacod;

    public Tarifario() {
    }

    public Tarifario(String tarcod) {
        this.tarcod = tarcod;
    }

    public Tarifario(String tarcod, String tardes, String codcue, String tarsta, String tarint, BigDecimal tarcos, String tarcod2, BigDecimal tarigv, Character tarmpri, Character tarpcta, String tarded, String estado, Date feccre, Date fecumv, int usecod, String usenam, String hostname, BigDecimal tarref, BigDecimal tarcosD, int tartes, BigDecimal tarfme, BigDecimal tarfen, BigDecimal tarfob, BigDecimal tarfte, String tardisVir, String tardisPre, String tarserTip, String tarabrv, String tartipPln, String cencos, String moncod, String tipccod, String ttacod) {
        this.tarcod = tarcod;
        this.tardes = tardes;
        this.codcue = codcue;
        this.tarsta = tarsta;
        this.tarint = tarint;
        this.tarcos = tarcos;
        this.tarcod2 = tarcod2;
        this.tarigv = tarigv;
        this.tarmpri = tarmpri;
        this.tarpcta = tarpcta;
        this.tarded = tarded;
        this.estado = estado;
        this.feccre = feccre;
        this.fecumv = fecumv;
        this.usecod = usecod;
        this.usenam = usenam;
        this.hostname = hostname;
        this.tarref = tarref;
        this.tarcosD = tarcosD;
        this.tartes = tartes;
        this.tarfme = tarfme;
        this.tarfen = tarfen;
        this.tarfob = tarfob;
        this.tarfte = tarfte;
        this.tardisVir = tardisVir;
        this.tardisPre = tardisPre;
        this.tarserTip = tarserTip;
        this.tarabrv = tarabrv;
        this.tartipPln = tartipPln;
        this.cencos = cencos;
        this.moncod = moncod;
        this.tipccod = tipccod;
        this.ttacod = ttacod;
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

    public BigDecimal getTaruni() {
        return taruni;
    }

    public void setTaruni(BigDecimal taruni) {
        this.taruni = taruni;
    }

    public BigDecimal getTarund() {
        return tarund;
    }

    public void setTarund(BigDecimal tarund) {
        this.tarund = tarund;
    }

    public String getCodcue() {
        return codcue;
    }

    public void setCodcue(String codcue) {
        this.codcue = codcue;
    }

    public String getTarsta() {
        return tarsta;
    }

    public void setTarsta(String tarsta) {
        this.tarsta = tarsta;
    }

    public String getTarint() {
        return tarint;
    }

    public void setTarint(String tarint) {
        this.tarint = tarint;
    }

    public BigDecimal getTarcos() {
        return tarcos;
    }

    public void setTarcos(BigDecimal tarcos) {
        this.tarcos = tarcos;
    }

    public String getTarcod2() {
        return tarcod2;
    }

    public void setTarcod2(String tarcod2) {
        this.tarcod2 = tarcod2;
    }

    public BigDecimal getTarigv() {
        return tarigv;
    }

    public void setTarigv(BigDecimal tarigv) {
        this.tarigv = tarigv;
    }

    public Character getTarmpri() {
        return tarmpri;
    }

    public void setTarmpri(Character tarmpri) {
        this.tarmpri = tarmpri;
    }

    public Character getTarpcta() {
        return tarpcta;
    }

    public void setTarpcta(Character tarpcta) {
        this.tarpcta = tarpcta;
    }

    public String getTarded() {
        return tarded;
    }

    public void setTarded(String tarded) {
        this.tarded = tarded;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFeccre() {
        return feccre;
    }

    public void setFeccre(Date feccre) {
        this.feccre = feccre;
    }

    public Date getFecumv() {
        return fecumv;
    }

    public void setFecumv(Date fecumv) {
        this.fecumv = fecumv;
    }

    public int getUsecod() {
        return usecod;
    }

    public void setUsecod(int usecod) {
        this.usecod = usecod;
    }

    public String getUsenam() {
        return usenam;
    }

    public void setUsenam(String usenam) {
        this.usenam = usenam;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public BigDecimal getTarref() {
        return tarref;
    }

    public void setTarref(BigDecimal tarref) {
        this.tarref = tarref;
    }

    public String getTarmod() {
        return tarmod;
    }

    public void setTarmod(String tarmod) {
        this.tarmod = tarmod;
    }

    public BigDecimal getTarcosD() {
        return tarcosD;
    }

    public void setTarcosD(BigDecimal tarcosD) {
        this.tarcosD = tarcosD;
    }

    public int getTartes() {
        return tartes;
    }

    public void setTartes(int tartes) {
        this.tartes = tartes;
    }

    public BigDecimal getTarfme() {
        return tarfme;
    }

    public void setTarfme(BigDecimal tarfme) {
        this.tarfme = tarfme;
    }

    public BigDecimal getTarfen() {
        return tarfen;
    }

    public void setTarfen(BigDecimal tarfen) {
        this.tarfen = tarfen;
    }

    public BigDecimal getTarfob() {
        return tarfob;
    }

    public void setTarfob(BigDecimal tarfob) {
        this.tarfob = tarfob;
    }

    public BigDecimal getTarfte() {
        return tarfte;
    }

    public void setTarfte(BigDecimal tarfte) {
        this.tarfte = tarfte;
    }

    public String getTardesL() {
        return tardesL;
    }

    public void setTardesL(String tardesL) {
        this.tardesL = tardesL;
    }

    public String getTardisVir() {
        return tardisVir;
    }

    public void setTardisVir(String tardisVir) {
        this.tardisVir = tardisVir;
    }

    public String getTardisPre() {
        return tardisPre;
    }

    public void setTardisPre(String tardisPre) {
        this.tardisPre = tardisPre;
    }

    public String getTarserTip() {
        return tarserTip;
    }

    public void setTarserTip(String tarserTip) {
        this.tarserTip = tarserTip;
    }

    public String getTarabrv() {
        return tarabrv;
    }

    public void setTarabrv(String tarabrv) {
        this.tarabrv = tarabrv;
    }

    public String getStasgl() {
        return stasgl;
    }

    public void setStasgl(String stasgl) {
        this.stasgl = stasgl;
    }

    public String getTartipPln() {
        return tartipPln;
    }

    public void setTartipPln(String tartipPln) {
        this.tartipPln = tartipPln;
    }

    public String getTarhtml() {
        return tarhtml;
    }

    public void setTarhtml(String tarhtml) {
        this.tarhtml = tarhtml;
    }

    public String getCencos() {
        return cencos;
    }

    public void setCencos(String cencos) {
        this.cencos = cencos;
    }

    public String getMoncod() {
        return moncod;
    }

    public void setMoncod(String moncod) {
        this.moncod = moncod;
    }

    public String getTipccod() {
        return tipccod;
    }

    public void setTipccod(String tipccod) {
        this.tipccod = tipccod;
    }

    public String getTtacod() {
        return ttacod;
    }

    public void setTtacod(String ttacod) {
        this.ttacod = ttacod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tarcod != null ? tarcod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifario)) {
            return false;
        }
        Tarifario other = (Tarifario) object;
        if ((this.tarcod == null && other.tarcod != null) || (this.tarcod != null && !this.tarcod.equals(other.tarcod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.Tarifario[ tarcod=" + tarcod + " ]";
    }
    
}
