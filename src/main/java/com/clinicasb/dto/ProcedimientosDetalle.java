/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "procedimientos_detalle")
@NamedQueries({
    @NamedQuery(name = "ProcedimientosDetalle.findAll", query = "SELECT p FROM ProcedimientosDetalle p"),
    @NamedQuery(name = "ProcedimientosDetalle.findByInvnum", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.procedimientosDetallePK.invnum = :invnum"),
    @NamedQuery(name = "ProcedimientosDetalle.findByNumitm", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.procedimientosDetallePK.numitm = :numitm"),
    @NamedQuery(name = "ProcedimientosDetalle.findByTardes", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.tardes = :tardes"),
    @NamedQuery(name = "ProcedimientosDetalle.findByProcan", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.procan = :procan"),
    @NamedQuery(name = "ProcedimientosDetalle.findByPropar", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.propar = :propar"),
    @NamedQuery(name = "ProcedimientosDetalle.findByProigv", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.proigv = :proigv"),
    @NamedQuery(name = "ProcedimientosDetalle.findByProdes", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.prodes = :prodes"),
    @NamedQuery(name = "ProcedimientosDetalle.findByTarint", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.tarint = :tarint"),
    @NamedQuery(name = "ProcedimientosDetalle.findByMedcod", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.medcod = :medcod"),
    @NamedQuery(name = "ProcedimientosDetalle.findByDtopro", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.dtopro = :dtopro"),
    @NamedQuery(name = "ProcedimientosDetalle.findByPropri", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.propri = :propri"),
    @NamedQuery(name = "ProcedimientosDetalle.findByProcoa", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.procoa = :procoa"),
    @NamedQuery(name = "ProcedimientosDetalle.findByCoscom", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.coscom = :coscom"),
    @NamedQuery(name = "ProcedimientosDetalle.findByTotppac", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.totppac = :totppac"),
    @NamedQuery(name = "ProcedimientosDetalle.findByTotpseg", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.totpseg = :totpseg"),
    @NamedQuery(name = "ProcedimientosDetalle.findByTarcosE", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.tarcosE = :tarcosE"),
    @NamedQuery(name = "ProcedimientosDetalle.findByTarcos", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.tarcos = :tarcos"),
    @NamedQuery(name = "ProcedimientosDetalle.findByTarcosD", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.tarcosD = :tarcosD"),
    @NamedQuery(name = "ProcedimientosDetalle.findByInvigvP", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.invigvP = :invigvP"),
    @NamedQuery(name = "ProcedimientosDetalle.findByInvbrtP", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.invbrtP = :invbrtP"),
    @NamedQuery(name = "ProcedimientosDetalle.findByInvigvC", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.invigvC = :invigvC"),
    @NamedQuery(name = "ProcedimientosDetalle.findByInvbrtC", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.invbrtC = :invbrtC"),
    @NamedQuery(name = "ProcedimientosDetalle.findByIgvpar", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.igvpar = :igvpar"),
    @NamedQuery(name = "ProcedimientosDetalle.findByBrtpar", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.brtpar = :brtpar"),
    @NamedQuery(name = "ProcedimientosDetalle.findByInvdto", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.invdto = :invdto"),
    @NamedQuery(name = "ProcedimientosDetalle.findByInvdtoP", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.invdtoP = :invdtoP"),
    @NamedQuery(name = "ProcedimientosDetalle.findByInvdtoC", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.invdtoC = :invdtoC"),
    @NamedQuery(name = "ProcedimientosDetalle.findByTotpar", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.totpar = :totpar"),
    @NamedQuery(name = "ProcedimientosDetalle.findByEstexa", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.estexa = :estexa"),
    @NamedQuery(name = "ProcedimientosDetalle.findByExaapr", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.exaapr = :exaapr"),
    @NamedQuery(name = "ProcedimientosDetalle.findByFlgden", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.flgden = :flgden"),
    @NamedQuery(name = "ProcedimientosDetalle.findByPiecod", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.piecod = :piecod"),
    @NamedQuery(name = "ProcedimientosDetalle.findByTipsdeCod", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.tipsdeCod = :tipsdeCod"),
    @NamedQuery(name = "ProcedimientosDetalle.findByStampri", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.stampri = :stampri"),
    @NamedQuery(name = "ProcedimientosDetalle.findByPropriO", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.propriO = :propriO"),
    @NamedQuery(name = "ProcedimientosDetalle.findByInvnum1", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.invnum1 = :invnum1"),
    @NamedQuery(name = "ProcedimientosDetalle.findByTarcod", query = "SELECT p FROM ProcedimientosDetalle p WHERE p.tarcod = :tarcod")})
public class ProcedimientosDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcedimientosDetallePK procedimientosDetallePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "tardes")
    private String tardes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "procan")
    private BigDecimal procan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "propar")
    private BigDecimal propar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proigv")
    private BigDecimal proigv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prodes")
    private BigDecimal prodes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tarint")
    private String tarint;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "medcod")
    private String medcod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtopro")
    private BigDecimal dtopro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "propri")
    private BigDecimal propri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "procoa")
    private BigDecimal procoa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coscom")
    private BigDecimal coscom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totppac")
    private BigDecimal totppac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totpseg")
    private BigDecimal totpseg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarcos_e")
    private BigDecimal tarcosE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarcos")
    private BigDecimal tarcos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarcos_d")
    private BigDecimal tarcosD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invigv_p")
    private BigDecimal invigvP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invbrt_p")
    private BigDecimal invbrtP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invigv_c")
    private BigDecimal invigvC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invbrt_c")
    private BigDecimal invbrtC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "igvpar")
    private BigDecimal igvpar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "brtpar")
    private BigDecimal brtpar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invdto")
    private BigDecimal invdto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invdto_p")
    private BigDecimal invdtoP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invdto_c")
    private BigDecimal invdtoC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totpar")
    private BigDecimal totpar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estexa")
    private String estexa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "exaapr")
    private String exaapr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "flgden")
    private String flgden;
    @Size(max = 3)
    @Column(name = "piecod")
    private String piecod;
    @Size(max = 2)
    @Column(name = "tipsde_cod")
    private String tipsdeCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "stampri")
    private String stampri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "propri_o")
    private BigDecimal propriO;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invnum")
    private int invnum1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tarcod")
    private String tarcod;

    public ProcedimientosDetalle() {
    }

    public ProcedimientosDetalle(ProcedimientosDetallePK procedimientosDetallePK) {
        this.procedimientosDetallePK = procedimientosDetallePK;
    }

    public ProcedimientosDetalle(ProcedimientosDetallePK procedimientosDetallePK, String tardes, BigDecimal procan, BigDecimal propar, BigDecimal proigv, BigDecimal prodes, String tarint, String medcod, BigDecimal dtopro, BigDecimal propri, BigDecimal procoa, BigDecimal coscom, BigDecimal totppac, BigDecimal totpseg, BigDecimal tarcosE, BigDecimal tarcos, BigDecimal tarcosD, BigDecimal invigvP, BigDecimal invbrtP, BigDecimal invigvC, BigDecimal invbrtC, BigDecimal igvpar, BigDecimal brtpar, BigDecimal invdto, BigDecimal invdtoP, BigDecimal invdtoC, BigDecimal totpar, String estexa, String exaapr, String flgden, String stampri, BigDecimal propriO, int invnum1, String tarcod) {
        this.procedimientosDetallePK = procedimientosDetallePK;
        this.tardes = tardes;
        this.procan = procan;
        this.propar = propar;
        this.proigv = proigv;
        this.prodes = prodes;
        this.tarint = tarint;
        this.medcod = medcod;
        this.dtopro = dtopro;
        this.propri = propri;
        this.procoa = procoa;
        this.coscom = coscom;
        this.totppac = totppac;
        this.totpseg = totpseg;
        this.tarcosE = tarcosE;
        this.tarcos = tarcos;
        this.tarcosD = tarcosD;
        this.invigvP = invigvP;
        this.invbrtP = invbrtP;
        this.invigvC = invigvC;
        this.invbrtC = invbrtC;
        this.igvpar = igvpar;
        this.brtpar = brtpar;
        this.invdto = invdto;
        this.invdtoP = invdtoP;
        this.invdtoC = invdtoC;
        this.totpar = totpar;
        this.estexa = estexa;
        this.exaapr = exaapr;
        this.flgden = flgden;
        this.stampri = stampri;
        this.propriO = propriO;
        this.invnum1 = invnum1;
        this.tarcod = tarcod;
    }

    public ProcedimientosDetalle(int invnum, int numitm) {
        this.procedimientosDetallePK = new ProcedimientosDetallePK(invnum, numitm);
    }

    public ProcedimientosDetallePK getProcedimientosDetallePK() {
        return procedimientosDetallePK;
    }

    public void setProcedimientosDetallePK(ProcedimientosDetallePK procedimientosDetallePK) {
        this.procedimientosDetallePK = procedimientosDetallePK;
    }

    public String getTardes() {
        return tardes;
    }

    public void setTardes(String tardes) {
        this.tardes = tardes;
    }

    public BigDecimal getProcan() {
        return procan;
    }

    public void setProcan(BigDecimal procan) {
        this.procan = procan;
    }

    public BigDecimal getPropar() {
        return propar;
    }

    public void setPropar(BigDecimal propar) {
        this.propar = propar;
    }

    public BigDecimal getProigv() {
        return proigv;
    }

    public void setProigv(BigDecimal proigv) {
        this.proigv = proigv;
    }

    public BigDecimal getProdes() {
        return prodes;
    }

    public void setProdes(BigDecimal prodes) {
        this.prodes = prodes;
    }

    public String getTarint() {
        return tarint;
    }

    public void setTarint(String tarint) {
        this.tarint = tarint;
    }

    public String getMedcod() {
        return medcod;
    }

    public void setMedcod(String medcod) {
        this.medcod = medcod;
    }

    public BigDecimal getDtopro() {
        return dtopro;
    }

    public void setDtopro(BigDecimal dtopro) {
        this.dtopro = dtopro;
    }

    public BigDecimal getPropri() {
        return propri;
    }

    public void setPropri(BigDecimal propri) {
        this.propri = propri;
    }

    public BigDecimal getProcoa() {
        return procoa;
    }

    public void setProcoa(BigDecimal procoa) {
        this.procoa = procoa;
    }

    public BigDecimal getCoscom() {
        return coscom;
    }

    public void setCoscom(BigDecimal coscom) {
        this.coscom = coscom;
    }

    public BigDecimal getTotppac() {
        return totppac;
    }

    public void setTotppac(BigDecimal totppac) {
        this.totppac = totppac;
    }

    public BigDecimal getTotpseg() {
        return totpseg;
    }

    public void setTotpseg(BigDecimal totpseg) {
        this.totpseg = totpseg;
    }

    public BigDecimal getTarcosE() {
        return tarcosE;
    }

    public void setTarcosE(BigDecimal tarcosE) {
        this.tarcosE = tarcosE;
    }

    public BigDecimal getTarcos() {
        return tarcos;
    }

    public void setTarcos(BigDecimal tarcos) {
        this.tarcos = tarcos;
    }

    public BigDecimal getTarcosD() {
        return tarcosD;
    }

    public void setTarcosD(BigDecimal tarcosD) {
        this.tarcosD = tarcosD;
    }

    public BigDecimal getInvigvP() {
        return invigvP;
    }

    public void setInvigvP(BigDecimal invigvP) {
        this.invigvP = invigvP;
    }

    public BigDecimal getInvbrtP() {
        return invbrtP;
    }

    public void setInvbrtP(BigDecimal invbrtP) {
        this.invbrtP = invbrtP;
    }

    public BigDecimal getInvigvC() {
        return invigvC;
    }

    public void setInvigvC(BigDecimal invigvC) {
        this.invigvC = invigvC;
    }

    public BigDecimal getInvbrtC() {
        return invbrtC;
    }

    public void setInvbrtC(BigDecimal invbrtC) {
        this.invbrtC = invbrtC;
    }

    public BigDecimal getIgvpar() {
        return igvpar;
    }

    public void setIgvpar(BigDecimal igvpar) {
        this.igvpar = igvpar;
    }

    public BigDecimal getBrtpar() {
        return brtpar;
    }

    public void setBrtpar(BigDecimal brtpar) {
        this.brtpar = brtpar;
    }

    public BigDecimal getInvdto() {
        return invdto;
    }

    public void setInvdto(BigDecimal invdto) {
        this.invdto = invdto;
    }

    public BigDecimal getInvdtoP() {
        return invdtoP;
    }

    public void setInvdtoP(BigDecimal invdtoP) {
        this.invdtoP = invdtoP;
    }

    public BigDecimal getInvdtoC() {
        return invdtoC;
    }

    public void setInvdtoC(BigDecimal invdtoC) {
        this.invdtoC = invdtoC;
    }

    public BigDecimal getTotpar() {
        return totpar;
    }

    public void setTotpar(BigDecimal totpar) {
        this.totpar = totpar;
    }

    public String getEstexa() {
        return estexa;
    }

    public void setEstexa(String estexa) {
        this.estexa = estexa;
    }

    public String getExaapr() {
        return exaapr;
    }

    public void setExaapr(String exaapr) {
        this.exaapr = exaapr;
    }

    public String getFlgden() {
        return flgden;
    }

    public void setFlgden(String flgden) {
        this.flgden = flgden;
    }

    public String getPiecod() {
        return piecod;
    }

    public void setPiecod(String piecod) {
        this.piecod = piecod;
    }

    public String getTipsdeCod() {
        return tipsdeCod;
    }

    public void setTipsdeCod(String tipsdeCod) {
        this.tipsdeCod = tipsdeCod;
    }

    public String getStampri() {
        return stampri;
    }

    public void setStampri(String stampri) {
        this.stampri = stampri;
    }

    public BigDecimal getPropriO() {
        return propriO;
    }

    public void setPropriO(BigDecimal propriO) {
        this.propriO = propriO;
    }

    public int getInvnum1() {
        return invnum1;
    }

    public void setInvnum1(int invnum1) {
        this.invnum1 = invnum1;
    }

    public String getTarcod() {
        return tarcod;
    }

    public void setTarcod(String tarcod) {
        this.tarcod = tarcod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procedimientosDetallePK != null ? procedimientosDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedimientosDetalle)) {
            return false;
        }
        ProcedimientosDetalle other = (ProcedimientosDetalle) object;
        if ((this.procedimientosDetallePK == null && other.procedimientosDetallePK != null) || (this.procedimientosDetallePK != null && !this.procedimientosDetallePK.equals(other.procedimientosDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.ProcedimientosDetalle[ procedimientosDetallePK=" + procedimientosDetallePK + " ]";
    }
    
}
