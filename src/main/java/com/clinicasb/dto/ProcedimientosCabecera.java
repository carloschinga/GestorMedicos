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
@Table(name = "procedimientos_cabecera")
@NamedQueries({
    @NamedQuery(name = "ProcedimientosCabecera.findAll", query = "SELECT p FROM ProcedimientosCabecera p"),
    @NamedQuery(name = "ProcedimientosCabecera.findByInvnum", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.invnum = :invnum"),
    @NamedQuery(name = "ProcedimientosCabecera.findByProdat", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.prodat = :prodat"),
    @NamedQuery(name = "ProcedimientosCabecera.findByPachis", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.pachis = :pachis"),
    @NamedQuery(name = "ProcedimientosCabecera.findByPacnam", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.pacnam = :pacnam"),
    @NamedQuery(name = "ProcedimientosCabecera.findByPrfnum", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.prfnum = :prfnum"),
    @NamedQuery(name = "ProcedimientosCabecera.findByTipcli", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.tipcli = :tipcli"),
    @NamedQuery(name = "ProcedimientosCabecera.findByPlnnum", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.plnnum = :plnnum"),
    @NamedQuery(name = "ProcedimientosCabecera.findByProded", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.proded = :proded"),
    @NamedQuery(name = "ProcedimientosCabecera.findByProcoa", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.procoa = :procoa"),
    @NamedQuery(name = "ProcedimientosCabecera.findByProdes", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.prodes = :prodes"),
    @NamedQuery(name = "ProcedimientosCabecera.findByObscit", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.obscit = :obscit"),
    @NamedQuery(name = "ProcedimientosCabecera.findByPacdir", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.pacdir = :pacdir"),
    @NamedQuery(name = "ProcedimientosCabecera.findByPactel", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.pactel = :pactel"),
    @NamedQuery(name = "ProcedimientosCabecera.findByCodstd", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.codstd = :codstd"),
    @NamedQuery(name = "ProcedimientosCabecera.findByProcar", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.procar = :procar"),
    @NamedQuery(name = "ProcedimientosCabecera.findByProfvc", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.profvc = :profvc"),
    @NamedQuery(name = "ProcedimientosCabecera.findByFecanu", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.fecanu = :fecanu"),
    @NamedQuery(name = "ProcedimientosCabecera.findByUseanu", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.useanu = :useanu"),
    @NamedQuery(name = "ProcedimientosCabecera.findByConcod", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.concod = :concod"),
    @NamedQuery(name = "ProcedimientosCabecera.findBySegcod", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.segcod = :segcod"),
    @NamedQuery(name = "ProcedimientosCabecera.findByCoscom", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.coscom = :coscom"),
    @NamedQuery(name = "ProcedimientosCabecera.findByMondol", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.mondol = :mondol"),
    @NamedQuery(name = "ProcedimientosCabecera.findByInvppac", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.invppac = :invppac"),
    @NamedQuery(name = "ProcedimientosCabecera.findByInvpseg", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.invpseg = :invpseg"),
    @NamedQuery(name = "ProcedimientosCabecera.findByTipcam", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.tipcam = :tipcam"),
    @NamedQuery(name = "ProcedimientosCabecera.findByEstado", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.estado = :estado"),
    @NamedQuery(name = "ProcedimientosCabecera.findByFeccre", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.feccre = :feccre"),
    @NamedQuery(name = "ProcedimientosCabecera.findByFecumv", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.fecumv = :fecumv"),
    @NamedQuery(name = "ProcedimientosCabecera.findByUsecod", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.usecod = :usecod"),
    @NamedQuery(name = "ProcedimientosCabecera.findByUsenam", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.usenam = :usenam"),
    @NamedQuery(name = "ProcedimientosCabecera.findByHostname", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.hostname = :hostname"),
    @NamedQuery(name = "ProcedimientosCabecera.findByTotcosE", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.totcosE = :totcosE"),
    @NamedQuery(name = "ProcedimientosCabecera.findByTotcosD", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.totcosD = :totcosD"),
    @NamedQuery(name = "ProcedimientosCabecera.findByTotcos", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.totcos = :totcos"),
    @NamedQuery(name = "ProcedimientosCabecera.findByTotigvP", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.totigvP = :totigvP"),
    @NamedQuery(name = "ProcedimientosCabecera.findByTotbrtP", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.totbrtP = :totbrtP"),
    @NamedQuery(name = "ProcedimientosCabecera.findByTotigvC", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.totigvC = :totigvC"),
    @NamedQuery(name = "ProcedimientosCabecera.findByTotbrtC", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.totbrtC = :totbrtC"),
    @NamedQuery(name = "ProcedimientosCabecera.findByTotdto", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.totdto = :totdto"),
    @NamedQuery(name = "ProcedimientosCabecera.findByTotdtoP", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.totdtoP = :totdtoP"),
    @NamedQuery(name = "ProcedimientosCabecera.findByTotdtoC", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.totdtoC = :totdtoC"),
    @NamedQuery(name = "ProcedimientosCabecera.findByNetord", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.netord = :netord"),
    @NamedQuery(name = "ProcedimientosCabecera.findByIgvord", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.igvord = :igvord"),
    @NamedQuery(name = "ProcedimientosCabecera.findByTotord", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.totord = :totord"),
    @NamedQuery(name = "ProcedimientosCabecera.findByCodpaq", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.codpaq = :codpaq"),
    @NamedQuery(name = "ProcedimientosCabecera.findByInvnumP", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.invnumP = :invnumP"),
    @NamedQuery(name = "ProcedimientosCabecera.findByStacom", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.stacom = :stacom"),
    @NamedQuery(name = "ProcedimientosCabecera.findByCuseda", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.cuseda = :cuseda"),
    @NamedQuery(name = "ProcedimientosCabecera.findBySexcod", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.sexcod = :sexcod"),
    @NamedQuery(name = "ProcedimientosCabecera.findByCustel", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.custel = :custel"),
    @NamedQuery(name = "ProcedimientosCabecera.findByEstord", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.estord = :estord"),
    @NamedQuery(name = "ProcedimientosCabecera.findByCodaut", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.codaut = :codaut"),
    @NamedQuery(name = "ProcedimientosCabecera.findByCobmax", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.cobmax = :cobmax"),
    @NamedQuery(name = "ProcedimientosCabecera.findByInvnumPre", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.invnumPre = :invnumPre"),
    @NamedQuery(name = "ProcedimientosCabecera.findByNumcon", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.numcon = :numcon"),
    @NamedQuery(name = "ProcedimientosCabecera.findByCodautsited", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.codautsited = :codautsited"),
    @NamedQuery(name = "ProcedimientosCabecera.findByCodplansited", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.codplansited = :codplansited"),
    @NamedQuery(name = "ProcedimientosCabecera.findByCodbenesited", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.codbenesited = :codbenesited"),
    @NamedQuery(name = "ProcedimientosCabecera.findByAficodSited", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.aficodSited = :aficodSited"),
    @NamedQuery(name = "ProcedimientosCabecera.findByEnfcod", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.enfcod = :enfcod"),
    @NamedQuery(name = "ProcedimientosCabecera.findByMedcod", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.medcod = :medcod"),
    @NamedQuery(name = "ProcedimientosCabecera.findByMoncod", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.moncod = :moncod"),
    @NamedQuery(name = "ProcedimientosCabecera.findByOcucod", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.ocucod = :ocucod"),
    @NamedQuery(name = "ProcedimientosCabecera.findByCodprom", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.codprom = :codprom"),
    @NamedQuery(name = "ProcedimientosCabecera.findBySercod", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.sercod = :sercod"),
    @NamedQuery(name = "ProcedimientosCabecera.findBySiscod", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.siscod = :siscod"),
    @NamedQuery(name = "ProcedimientosCabecera.findByCodper", query = "SELECT p FROM ProcedimientosCabecera p WHERE p.codper = :codper")})
public class ProcedimientosCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "invnum")
    private Integer invnum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prodat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prodat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "pachis")
    private String pachis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "pacnam")
    private String pacnam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prfnum")
    private int prfnum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipcli")
    private String tipcli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "plnnum")
    private String plnnum;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "proded")
    private BigDecimal proded;
    @Basic(optional = false)
    @NotNull
    @Column(name = "procoa")
    private BigDecimal procoa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prodes")
    private BigDecimal prodes;
    @Size(max = 30)
    @Column(name = "obscit")
    private String obscit;
    @Size(max = 100)
    @Column(name = "pacdir")
    private String pacdir;
    @Size(max = 25)
    @Column(name = "pactel")
    private String pactel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codstd")
    private String codstd;
    @Size(max = 20)
    @Column(name = "procar")
    private String procar;
    @Column(name = "profvc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date profvc;
    @Column(name = "fecanu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecanu;
    @Column(name = "useanu")
    private Integer useanu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "concod")
    private String concod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "segcod")
    private String segcod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coscom")
    private BigDecimal coscom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mondol")
    private BigDecimal mondol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invppac")
    private BigDecimal invppac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invpseg")
    private BigDecimal invpseg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipcam")
    private BigDecimal tipcam;
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
    @Column(name = "totcos_e")
    private BigDecimal totcosE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totcos_d")
    private BigDecimal totcosD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totcos")
    private BigDecimal totcos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totigv_p")
    private BigDecimal totigvP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totbrt_p")
    private BigDecimal totbrtP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totigv_c")
    private BigDecimal totigvC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totbrt_c")
    private BigDecimal totbrtC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totdto")
    private BigDecimal totdto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totdto_p")
    private BigDecimal totdtoP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totdto_c")
    private BigDecimal totdtoC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "netord")
    private BigDecimal netord;
    @Basic(optional = false)
    @NotNull
    @Column(name = "igvord")
    private BigDecimal igvord;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totord")
    private BigDecimal totord;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "codpaq")
    private String codpaq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invnum_p")
    private int invnumP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "stacom")
    private String stacom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuseda")
    private int cuseda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "sexcod")
    private String sexcod;
    @Size(max = 25)
    @Column(name = "custel")
    private String custel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estord")
    private String estord;
    @Size(max = 20)
    @Column(name = "codaut")
    private String codaut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cobmax")
    private BigDecimal cobmax;
    @Column(name = "invnum_pre")
    private Integer invnumPre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numcon")
    private int numcon;
    @Size(max = 20)
    @Column(name = "codautsited")
    private String codautsited;
    @Size(max = 20)
    @Column(name = "codplansited")
    private String codplansited;
    @Size(max = 20)
    @Column(name = "codbenesited")
    private String codbenesited;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "aficod_sited")
    private String aficodSited;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "enfcod")
    private String enfcod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "medcod")
    private String medcod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "moncod")
    private String moncod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ocucod")
    private String ocucod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codprom")
    private String codprom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "sercod")
    private String sercod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "siscod")
    private int siscod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codper")
    private String codper;

    public ProcedimientosCabecera() {
    }

    public ProcedimientosCabecera(Integer invnum) {
        this.invnum = invnum;
    }

    public ProcedimientosCabecera(Integer invnum, Date prodat, String pachis, String pacnam, int prfnum, String tipcli, String plnnum, BigDecimal proded, BigDecimal procoa, BigDecimal prodes, String codstd, String concod, String segcod, BigDecimal coscom, BigDecimal mondol, BigDecimal invppac, BigDecimal invpseg, BigDecimal tipcam, String estado, Date feccre, Date fecumv, int usecod, String usenam, String hostname, BigDecimal totcosE, BigDecimal totcosD, BigDecimal totcos, BigDecimal totigvP, BigDecimal totbrtP, BigDecimal totigvC, BigDecimal totbrtC, BigDecimal totdto, BigDecimal totdtoP, BigDecimal totdtoC, BigDecimal netord, BigDecimal igvord, BigDecimal totord, String codpaq, int invnumP, String stacom, int cuseda, String sexcod, String estord, BigDecimal cobmax, int numcon, String aficodSited, String enfcod, String medcod, String moncod, String ocucod, String codprom, String sercod, int siscod, String codper) {
        this.invnum = invnum;
        this.prodat = prodat;
        this.pachis = pachis;
        this.pacnam = pacnam;
        this.prfnum = prfnum;
        this.tipcli = tipcli;
        this.plnnum = plnnum;
        this.proded = proded;
        this.procoa = procoa;
        this.prodes = prodes;
        this.codstd = codstd;
        this.concod = concod;
        this.segcod = segcod;
        this.coscom = coscom;
        this.mondol = mondol;
        this.invppac = invppac;
        this.invpseg = invpseg;
        this.tipcam = tipcam;
        this.estado = estado;
        this.feccre = feccre;
        this.fecumv = fecumv;
        this.usecod = usecod;
        this.usenam = usenam;
        this.hostname = hostname;
        this.totcosE = totcosE;
        this.totcosD = totcosD;
        this.totcos = totcos;
        this.totigvP = totigvP;
        this.totbrtP = totbrtP;
        this.totigvC = totigvC;
        this.totbrtC = totbrtC;
        this.totdto = totdto;
        this.totdtoP = totdtoP;
        this.totdtoC = totdtoC;
        this.netord = netord;
        this.igvord = igvord;
        this.totord = totord;
        this.codpaq = codpaq;
        this.invnumP = invnumP;
        this.stacom = stacom;
        this.cuseda = cuseda;
        this.sexcod = sexcod;
        this.estord = estord;
        this.cobmax = cobmax;
        this.numcon = numcon;
        this.aficodSited = aficodSited;
        this.enfcod = enfcod;
        this.medcod = medcod;
        this.moncod = moncod;
        this.ocucod = ocucod;
        this.codprom = codprom;
        this.sercod = sercod;
        this.siscod = siscod;
        this.codper = codper;
    }

    public Integer getInvnum() {
        return invnum;
    }

    public void setInvnum(Integer invnum) {
        this.invnum = invnum;
    }

    public Date getProdat() {
        return prodat;
    }

    public void setProdat(Date prodat) {
        this.prodat = prodat;
    }

    public String getPachis() {
        return pachis;
    }

    public void setPachis(String pachis) {
        this.pachis = pachis;
    }

    public String getPacnam() {
        return pacnam;
    }

    public void setPacnam(String pacnam) {
        this.pacnam = pacnam;
    }

    public int getPrfnum() {
        return prfnum;
    }

    public void setPrfnum(int prfnum) {
        this.prfnum = prfnum;
    }

    public String getTipcli() {
        return tipcli;
    }

    public void setTipcli(String tipcli) {
        this.tipcli = tipcli;
    }

    public String getPlnnum() {
        return plnnum;
    }

    public void setPlnnum(String plnnum) {
        this.plnnum = plnnum;
    }

    public BigDecimal getProded() {
        return proded;
    }

    public void setProded(BigDecimal proded) {
        this.proded = proded;
    }

    public BigDecimal getProcoa() {
        return procoa;
    }

    public void setProcoa(BigDecimal procoa) {
        this.procoa = procoa;
    }

    public BigDecimal getProdes() {
        return prodes;
    }

    public void setProdes(BigDecimal prodes) {
        this.prodes = prodes;
    }

    public String getObscit() {
        return obscit;
    }

    public void setObscit(String obscit) {
        this.obscit = obscit;
    }

    public String getPacdir() {
        return pacdir;
    }

    public void setPacdir(String pacdir) {
        this.pacdir = pacdir;
    }

    public String getPactel() {
        return pactel;
    }

    public void setPactel(String pactel) {
        this.pactel = pactel;
    }

    public String getCodstd() {
        return codstd;
    }

    public void setCodstd(String codstd) {
        this.codstd = codstd;
    }

    public String getProcar() {
        return procar;
    }

    public void setProcar(String procar) {
        this.procar = procar;
    }

    public Date getProfvc() {
        return profvc;
    }

    public void setProfvc(Date profvc) {
        this.profvc = profvc;
    }

    public Date getFecanu() {
        return fecanu;
    }

    public void setFecanu(Date fecanu) {
        this.fecanu = fecanu;
    }

    public Integer getUseanu() {
        return useanu;
    }

    public void setUseanu(Integer useanu) {
        this.useanu = useanu;
    }

    public String getConcod() {
        return concod;
    }

    public void setConcod(String concod) {
        this.concod = concod;
    }

    public String getSegcod() {
        return segcod;
    }

    public void setSegcod(String segcod) {
        this.segcod = segcod;
    }

    public BigDecimal getCoscom() {
        return coscom;
    }

    public void setCoscom(BigDecimal coscom) {
        this.coscom = coscom;
    }

    public BigDecimal getMondol() {
        return mondol;
    }

    public void setMondol(BigDecimal mondol) {
        this.mondol = mondol;
    }

    public BigDecimal getInvppac() {
        return invppac;
    }

    public void setInvppac(BigDecimal invppac) {
        this.invppac = invppac;
    }

    public BigDecimal getInvpseg() {
        return invpseg;
    }

    public void setInvpseg(BigDecimal invpseg) {
        this.invpseg = invpseg;
    }

    public BigDecimal getTipcam() {
        return tipcam;
    }

    public void setTipcam(BigDecimal tipcam) {
        this.tipcam = tipcam;
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

    public BigDecimal getTotcosE() {
        return totcosE;
    }

    public void setTotcosE(BigDecimal totcosE) {
        this.totcosE = totcosE;
    }

    public BigDecimal getTotcosD() {
        return totcosD;
    }

    public void setTotcosD(BigDecimal totcosD) {
        this.totcosD = totcosD;
    }

    public BigDecimal getTotcos() {
        return totcos;
    }

    public void setTotcos(BigDecimal totcos) {
        this.totcos = totcos;
    }

    public BigDecimal getTotigvP() {
        return totigvP;
    }

    public void setTotigvP(BigDecimal totigvP) {
        this.totigvP = totigvP;
    }

    public BigDecimal getTotbrtP() {
        return totbrtP;
    }

    public void setTotbrtP(BigDecimal totbrtP) {
        this.totbrtP = totbrtP;
    }

    public BigDecimal getTotigvC() {
        return totigvC;
    }

    public void setTotigvC(BigDecimal totigvC) {
        this.totigvC = totigvC;
    }

    public BigDecimal getTotbrtC() {
        return totbrtC;
    }

    public void setTotbrtC(BigDecimal totbrtC) {
        this.totbrtC = totbrtC;
    }

    public BigDecimal getTotdto() {
        return totdto;
    }

    public void setTotdto(BigDecimal totdto) {
        this.totdto = totdto;
    }

    public BigDecimal getTotdtoP() {
        return totdtoP;
    }

    public void setTotdtoP(BigDecimal totdtoP) {
        this.totdtoP = totdtoP;
    }

    public BigDecimal getTotdtoC() {
        return totdtoC;
    }

    public void setTotdtoC(BigDecimal totdtoC) {
        this.totdtoC = totdtoC;
    }

    public BigDecimal getNetord() {
        return netord;
    }

    public void setNetord(BigDecimal netord) {
        this.netord = netord;
    }

    public BigDecimal getIgvord() {
        return igvord;
    }

    public void setIgvord(BigDecimal igvord) {
        this.igvord = igvord;
    }

    public BigDecimal getTotord() {
        return totord;
    }

    public void setTotord(BigDecimal totord) {
        this.totord = totord;
    }

    public String getCodpaq() {
        return codpaq;
    }

    public void setCodpaq(String codpaq) {
        this.codpaq = codpaq;
    }

    public int getInvnumP() {
        return invnumP;
    }

    public void setInvnumP(int invnumP) {
        this.invnumP = invnumP;
    }

    public String getStacom() {
        return stacom;
    }

    public void setStacom(String stacom) {
        this.stacom = stacom;
    }

    public int getCuseda() {
        return cuseda;
    }

    public void setCuseda(int cuseda) {
        this.cuseda = cuseda;
    }

    public String getSexcod() {
        return sexcod;
    }

    public void setSexcod(String sexcod) {
        this.sexcod = sexcod;
    }

    public String getCustel() {
        return custel;
    }

    public void setCustel(String custel) {
        this.custel = custel;
    }

    public String getEstord() {
        return estord;
    }

    public void setEstord(String estord) {
        this.estord = estord;
    }

    public String getCodaut() {
        return codaut;
    }

    public void setCodaut(String codaut) {
        this.codaut = codaut;
    }

    public BigDecimal getCobmax() {
        return cobmax;
    }

    public void setCobmax(BigDecimal cobmax) {
        this.cobmax = cobmax;
    }

    public Integer getInvnumPre() {
        return invnumPre;
    }

    public void setInvnumPre(Integer invnumPre) {
        this.invnumPre = invnumPre;
    }

    public int getNumcon() {
        return numcon;
    }

    public void setNumcon(int numcon) {
        this.numcon = numcon;
    }

    public String getCodautsited() {
        return codautsited;
    }

    public void setCodautsited(String codautsited) {
        this.codautsited = codautsited;
    }

    public String getCodplansited() {
        return codplansited;
    }

    public void setCodplansited(String codplansited) {
        this.codplansited = codplansited;
    }

    public String getCodbenesited() {
        return codbenesited;
    }

    public void setCodbenesited(String codbenesited) {
        this.codbenesited = codbenesited;
    }

    public String getAficodSited() {
        return aficodSited;
    }

    public void setAficodSited(String aficodSited) {
        this.aficodSited = aficodSited;
    }

    public String getEnfcod() {
        return enfcod;
    }

    public void setEnfcod(String enfcod) {
        this.enfcod = enfcod;
    }

    public String getMedcod() {
        return medcod;
    }

    public void setMedcod(String medcod) {
        this.medcod = medcod;
    }

    public String getMoncod() {
        return moncod;
    }

    public void setMoncod(String moncod) {
        this.moncod = moncod;
    }

    public String getOcucod() {
        return ocucod;
    }

    public void setOcucod(String ocucod) {
        this.ocucod = ocucod;
    }

    public String getCodprom() {
        return codprom;
    }

    public void setCodprom(String codprom) {
        this.codprom = codprom;
    }

    public String getSercod() {
        return sercod;
    }

    public void setSercod(String sercod) {
        this.sercod = sercod;
    }

    public int getSiscod() {
        return siscod;
    }

    public void setSiscod(int siscod) {
        this.siscod = siscod;
    }

    public String getCodper() {
        return codper;
    }

    public void setCodper(String codper) {
        this.codper = codper;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invnum != null ? invnum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedimientosCabecera)) {
            return false;
        }
        ProcedimientosCabecera other = (ProcedimientosCabecera) object;
        if ((this.invnum == null && other.invnum != null) || (this.invnum != null && !this.invnum.equals(other.invnum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.ProcedimientosCabecera[ invnum=" + invnum + " ]";
    }
    
}
