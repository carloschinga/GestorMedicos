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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ea_ordenes_detalle")
@NamedQueries({
    @NamedQuery(name = "EaOrdenesDetalle.findAll", query = "SELECT e FROM EaOrdenesDetalle e"),
    @NamedQuery(name = "EaOrdenesDetalle.findByInvnum", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.eaOrdenesDetallePK.invnum = :invnum"),
    @NamedQuery(name = "EaOrdenesDetalle.findByNumitm", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.eaOrdenesDetallePK.numitm = :numitm"),
    @NamedQuery(name = "EaOrdenesDetalle.findByExades", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.exades = :exades"),
    @NamedQuery(name = "EaOrdenesDetalle.findByEstexa", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.estexa = :estexa"),
    @NamedQuery(name = "EaOrdenesDetalle.findByExapri", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.exapri = :exapri"),
    @NamedQuery(name = "EaOrdenesDetalle.findByQtyexa", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.qtyexa = :qtyexa"),
    @NamedQuery(name = "EaOrdenesDetalle.findByExadto", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.exadto = :exadto"),
    @NamedQuery(name = "EaOrdenesDetalle.findByIgvexa", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.igvexa = :igvexa"),
    @NamedQuery(name = "EaOrdenesDetalle.findByCoaexa", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.coaexa = :coaexa"),
    @NamedQuery(name = "EaOrdenesDetalle.findByTotpar", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.totpar = :totpar"),
    @NamedQuery(name = "EaOrdenesDetalle.findByMedcod", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.medcod = :medcod"),
    @NamedQuery(name = "EaOrdenesDetalle.findByCodalm", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.codalm = :codalm"),
    @NamedQuery(name = "EaOrdenesDetalle.findByTotppac", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.totppac = :totppac"),
    @NamedQuery(name = "EaOrdenesDetalle.findByTotpseg", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.totpseg = :totpseg"),
    @NamedQuery(name = "EaOrdenesDetalle.findByCoscom", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.coscom = :coscom"),
    @NamedQuery(name = "EaOrdenesDetalle.findByCospro", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.cospro = :cospro"),
    @NamedQuery(name = "EaOrdenesDetalle.findByExacosE", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.exacosE = :exacosE"),
    @NamedQuery(name = "EaOrdenesDetalle.findByExaapr", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.exaapr = :exaapr"),
    @NamedQuery(name = "EaOrdenesDetalle.findByInvigvP", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.invigvP = :invigvP"),
    @NamedQuery(name = "EaOrdenesDetalle.findByInvigvC", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.invigvC = :invigvC"),
    @NamedQuery(name = "EaOrdenesDetalle.findByPrftab", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.prftab = :prftab"),
    @NamedQuery(name = "EaOrdenesDetalle.findByExadat", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.exadat = :exadat"),
    @NamedQuery(name = "EaOrdenesDetalle.findByPlnrgdia", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.plnrgdia = :plnrgdia"),
    @NamedQuery(name = "EaOrdenesDetalle.findByPlnrgdiaP", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.plnrgdiaP = :plnrgdiaP"),
    @NamedQuery(name = "EaOrdenesDetalle.findByParexa", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.parexa = :parexa"),
    @NamedQuery(name = "EaOrdenesDetalle.findByInvbrtP", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.invbrtP = :invbrtP"),
    @NamedQuery(name = "EaOrdenesDetalle.findByInvbrtC", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.invbrtC = :invbrtC"),
    @NamedQuery(name = "EaOrdenesDetalle.findByIgvpar", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.igvpar = :igvpar"),
    @NamedQuery(name = "EaOrdenesDetalle.findByBrtpar", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.brtpar = :brtpar"),
    @NamedQuery(name = "EaOrdenesDetalle.findByInvdto", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.invdto = :invdto"),
    @NamedQuery(name = "EaOrdenesDetalle.findByInvdtoP", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.invdtoP = :invdtoP"),
    @NamedQuery(name = "EaOrdenesDetalle.findByInvdtoC", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.invdtoC = :invdtoC"),
    @NamedQuery(name = "EaOrdenesDetalle.findByCodper", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.codper = :codper"),
    @NamedQuery(name = "EaOrdenesDetalle.findByDtoproA", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.dtoproA = :dtoproA"),
    @NamedQuery(name = "EaOrdenesDetalle.findByPribrt", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.pribrt = :pribrt"),
    @NamedQuery(name = "EaOrdenesDetalle.findByPribrtF", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.pribrtF = :pribrtF"),
    @NamedQuery(name = "EaOrdenesDetalle.findByExapriO", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.exapriO = :exapriO"),
    @NamedQuery(name = "EaOrdenesDetalle.findByStampri", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.stampri = :stampri"),
    @NamedQuery(name = "EaOrdenesDetalle.findByExacod", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.exacod = :exacod"),
    @NamedQuery(name = "EaOrdenesDetalle.findByInvnum1", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.invnum1 = :invnum1"),
    @NamedQuery(name = "EaOrdenesDetalle.findByMedcod1", query = "SELECT e FROM EaOrdenesDetalle e WHERE e.medcod1 = :medcod1")})
public class EaOrdenesDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EaOrdenesDetallePK eaOrdenesDetallePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "exades")
    private String exades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estexa")
    private String estexa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "exapri")
    private BigDecimal exapri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtyexa")
    private int qtyexa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exadto")
    private BigDecimal exadto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "igvexa")
    private BigDecimal igvexa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coaexa")
    private BigDecimal coaexa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totpar")
    private BigDecimal totpar;
    @Size(max = 4)
    @Column(name = "medcod")
    private String medcod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codalm")
    private String codalm;
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
    @Column(name = "coscom")
    private BigDecimal coscom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cospro")
    private BigDecimal cospro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exacos_e")
    private BigDecimal exacosE;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "exaapr")
    private String exaapr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invigv_p")
    private BigDecimal invigvP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invigv_c")
    private BigDecimal invigvC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prftab")
    private BigDecimal prftab;
    @Column(name = "exadat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exadat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plnrgdia")
    private BigDecimal plnrgdia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plnrgdia_p")
    private BigDecimal plnrgdiaP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parexa")
    private BigDecimal parexa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invbrt_p")
    private BigDecimal invbrtP;
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
    @Size(min = 1, max = 4)
    @Column(name = "codper")
    private String codper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtopro_a")
    private BigDecimal dtoproA;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pribrt")
    private BigDecimal pribrt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pribrt_f")
    private BigDecimal pribrtF;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exapri_o")
    private BigDecimal exapriO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "stampri")
    private String stampri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "exacod")
    private String exacod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invnum")
    private int invnum1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "medcod1")
    private String medcod1;

    public EaOrdenesDetalle() {
    }

    public EaOrdenesDetalle(EaOrdenesDetallePK eaOrdenesDetallePK) {
        this.eaOrdenesDetallePK = eaOrdenesDetallePK;
    }

    public EaOrdenesDetalle(EaOrdenesDetallePK eaOrdenesDetallePK, String exades, String estexa, BigDecimal exapri, int qtyexa, BigDecimal exadto, BigDecimal igvexa, BigDecimal coaexa, BigDecimal totpar, String codalm, BigDecimal totppac, BigDecimal totpseg, BigDecimal coscom, BigDecimal cospro, BigDecimal exacosE, String exaapr, BigDecimal invigvP, BigDecimal invigvC, BigDecimal prftab, BigDecimal plnrgdia, BigDecimal plnrgdiaP, BigDecimal parexa, BigDecimal invbrtP, BigDecimal invbrtC, BigDecimal igvpar, BigDecimal brtpar, BigDecimal invdto, BigDecimal invdtoP, BigDecimal invdtoC, String codper, BigDecimal dtoproA, BigDecimal pribrt, BigDecimal pribrtF, BigDecimal exapriO, String stampri, String exacod, int invnum1, String medcod1) {
        this.eaOrdenesDetallePK = eaOrdenesDetallePK;
        this.exades = exades;
        this.estexa = estexa;
        this.exapri = exapri;
        this.qtyexa = qtyexa;
        this.exadto = exadto;
        this.igvexa = igvexa;
        this.coaexa = coaexa;
        this.totpar = totpar;
        this.codalm = codalm;
        this.totppac = totppac;
        this.totpseg = totpseg;
        this.coscom = coscom;
        this.cospro = cospro;
        this.exacosE = exacosE;
        this.exaapr = exaapr;
        this.invigvP = invigvP;
        this.invigvC = invigvC;
        this.prftab = prftab;
        this.plnrgdia = plnrgdia;
        this.plnrgdiaP = plnrgdiaP;
        this.parexa = parexa;
        this.invbrtP = invbrtP;
        this.invbrtC = invbrtC;
        this.igvpar = igvpar;
        this.brtpar = brtpar;
        this.invdto = invdto;
        this.invdtoP = invdtoP;
        this.invdtoC = invdtoC;
        this.codper = codper;
        this.dtoproA = dtoproA;
        this.pribrt = pribrt;
        this.pribrtF = pribrtF;
        this.exapriO = exapriO;
        this.stampri = stampri;
        this.exacod = exacod;
        this.invnum1 = invnum1;
        this.medcod1 = medcod1;
    }

    public EaOrdenesDetalle(int invnum, int numitm) {
        this.eaOrdenesDetallePK = new EaOrdenesDetallePK(invnum, numitm);
    }

    public EaOrdenesDetallePK getEaOrdenesDetallePK() {
        return eaOrdenesDetallePK;
    }

    public void setEaOrdenesDetallePK(EaOrdenesDetallePK eaOrdenesDetallePK) {
        this.eaOrdenesDetallePK = eaOrdenesDetallePK;
    }

    public String getExades() {
        return exades;
    }

    public void setExades(String exades) {
        this.exades = exades;
    }

    public String getEstexa() {
        return estexa;
    }

    public void setEstexa(String estexa) {
        this.estexa = estexa;
    }

    public BigDecimal getExapri() {
        return exapri;
    }

    public void setExapri(BigDecimal exapri) {
        this.exapri = exapri;
    }

    public int getQtyexa() {
        return qtyexa;
    }

    public void setQtyexa(int qtyexa) {
        this.qtyexa = qtyexa;
    }

    public BigDecimal getExadto() {
        return exadto;
    }

    public void setExadto(BigDecimal exadto) {
        this.exadto = exadto;
    }

    public BigDecimal getIgvexa() {
        return igvexa;
    }

    public void setIgvexa(BigDecimal igvexa) {
        this.igvexa = igvexa;
    }

    public BigDecimal getCoaexa() {
        return coaexa;
    }

    public void setCoaexa(BigDecimal coaexa) {
        this.coaexa = coaexa;
    }

    public BigDecimal getTotpar() {
        return totpar;
    }

    public void setTotpar(BigDecimal totpar) {
        this.totpar = totpar;
    }

    public String getMedcod() {
        return medcod;
    }

    public void setMedcod(String medcod) {
        this.medcod = medcod;
    }

    public String getCodalm() {
        return codalm;
    }

    public void setCodalm(String codalm) {
        this.codalm = codalm;
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

    public BigDecimal getCoscom() {
        return coscom;
    }

    public void setCoscom(BigDecimal coscom) {
        this.coscom = coscom;
    }

    public BigDecimal getCospro() {
        return cospro;
    }

    public void setCospro(BigDecimal cospro) {
        this.cospro = cospro;
    }

    public BigDecimal getExacosE() {
        return exacosE;
    }

    public void setExacosE(BigDecimal exacosE) {
        this.exacosE = exacosE;
    }

    public String getExaapr() {
        return exaapr;
    }

    public void setExaapr(String exaapr) {
        this.exaapr = exaapr;
    }

    public BigDecimal getInvigvP() {
        return invigvP;
    }

    public void setInvigvP(BigDecimal invigvP) {
        this.invigvP = invigvP;
    }

    public BigDecimal getInvigvC() {
        return invigvC;
    }

    public void setInvigvC(BigDecimal invigvC) {
        this.invigvC = invigvC;
    }

    public BigDecimal getPrftab() {
        return prftab;
    }

    public void setPrftab(BigDecimal prftab) {
        this.prftab = prftab;
    }

    public Date getExadat() {
        return exadat;
    }

    public void setExadat(Date exadat) {
        this.exadat = exadat;
    }

    public BigDecimal getPlnrgdia() {
        return plnrgdia;
    }

    public void setPlnrgdia(BigDecimal plnrgdia) {
        this.plnrgdia = plnrgdia;
    }

    public BigDecimal getPlnrgdiaP() {
        return plnrgdiaP;
    }

    public void setPlnrgdiaP(BigDecimal plnrgdiaP) {
        this.plnrgdiaP = plnrgdiaP;
    }

    public BigDecimal getParexa() {
        return parexa;
    }

    public void setParexa(BigDecimal parexa) {
        this.parexa = parexa;
    }

    public BigDecimal getInvbrtP() {
        return invbrtP;
    }

    public void setInvbrtP(BigDecimal invbrtP) {
        this.invbrtP = invbrtP;
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

    public String getCodper() {
        return codper;
    }

    public void setCodper(String codper) {
        this.codper = codper;
    }

    public BigDecimal getDtoproA() {
        return dtoproA;
    }

    public void setDtoproA(BigDecimal dtoproA) {
        this.dtoproA = dtoproA;
    }

    public BigDecimal getPribrt() {
        return pribrt;
    }

    public void setPribrt(BigDecimal pribrt) {
        this.pribrt = pribrt;
    }

    public BigDecimal getPribrtF() {
        return pribrtF;
    }

    public void setPribrtF(BigDecimal pribrtF) {
        this.pribrtF = pribrtF;
    }

    public BigDecimal getExapriO() {
        return exapriO;
    }

    public void setExapriO(BigDecimal exapriO) {
        this.exapriO = exapriO;
    }

    public String getStampri() {
        return stampri;
    }

    public void setStampri(String stampri) {
        this.stampri = stampri;
    }

    public String getExacod() {
        return exacod;
    }

    public void setExacod(String exacod) {
        this.exacod = exacod;
    }

    public int getInvnum1() {
        return invnum1;
    }

    public void setInvnum1(int invnum1) {
        this.invnum1 = invnum1;
    }

    public String getMedcod1() {
        return medcod1;
    }

    public void setMedcod1(String medcod1) {
        this.medcod1 = medcod1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eaOrdenesDetallePK != null ? eaOrdenesDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EaOrdenesDetalle)) {
            return false;
        }
        EaOrdenesDetalle other = (EaOrdenesDetalle) object;
        if ((this.eaOrdenesDetallePK == null && other.eaOrdenesDetallePK != null) || (this.eaOrdenesDetallePK != null && !this.eaOrdenesDetallePK.equals(other.eaOrdenesDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.EaOrdenesDetalle[ eaOrdenesDetallePK=" + eaOrdenesDetallePK + " ]";
    }
    
}
