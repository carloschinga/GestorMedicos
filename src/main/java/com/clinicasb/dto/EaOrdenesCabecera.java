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
@Table(name = "ea_ordenes_cabecera")
@NamedQueries({
    @NamedQuery(name = "EaOrdenesCabecera.findAll", query = "SELECT e FROM EaOrdenesCabecera e"),
    @NamedQuery(name = "EaOrdenesCabecera.findByInvnum", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.invnum = :invnum"),
    @NamedQuery(name = "EaOrdenesCabecera.findByPrfnum", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.prfnum = :prfnum"),
    @NamedQuery(name = "EaOrdenesCabecera.findByTipcli", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.tipcli = :tipcli"),
    @NamedQuery(name = "EaOrdenesCabecera.findByCuscod", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.cuscod = :cuscod"),
    @NamedQuery(name = "EaOrdenesCabecera.findByCusnam", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.cusnam = :cusnam"),
    @NamedQuery(name = "EaOrdenesCabecera.findByCusadr", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.cusadr = :cusadr"),
    @NamedQuery(name = "EaOrdenesCabecera.findByDatord", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.datord = :datord"),
    @NamedQuery(name = "EaOrdenesCabecera.findByEstord", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.estord = :estord"),
    @NamedQuery(name = "EaOrdenesCabecera.findByTotord", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.totord = :totord"),
    @NamedQuery(name = "EaOrdenesCabecera.findByNetord", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.netord = :netord"),
    @NamedQuery(name = "EaOrdenesCabecera.findByIgvord", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.igvord = :igvord"),
    @NamedQuery(name = "EaOrdenesCabecera.findByCodstd", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.codstd = :codstd"),
    @NamedQuery(name = "EaOrdenesCabecera.findByMedcod", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.medcod = :medcod"),
    @NamedQuery(name = "EaOrdenesCabecera.findByTarcod", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.tarcod = :tarcod"),
    @NamedQuery(name = "EaOrdenesCabecera.findByInvgnc", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.invgnc = :invgnc"),
    @NamedQuery(name = "EaOrdenesCabecera.findByInvppac", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.invppac = :invppac"),
    @NamedQuery(name = "EaOrdenesCabecera.findByInvpseg", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.invpseg = :invpseg"),
    @NamedQuery(name = "EaOrdenesCabecera.findByInvcoa", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.invcoa = :invcoa"),
    @NamedQuery(name = "EaOrdenesCabecera.findByInvigv", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.invigv = :invigv"),
    @NamedQuery(name = "EaOrdenesCabecera.findByDestotN", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.destotN = :destotN"),
    @NamedQuery(name = "EaOrdenesCabecera.findByMednam", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.mednam = :mednam"),
    @NamedQuery(name = "EaOrdenesCabecera.findByOrdobs", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.ordobs = :ordobs"),
    @NamedQuery(name = "EaOrdenesCabecera.findByFecanu", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.fecanu = :fecanu"),
    @NamedQuery(name = "EaOrdenesCabecera.findByUseanu", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.useanu = :useanu"),
    @NamedQuery(name = "EaOrdenesCabecera.findByCodalm", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.codalm = :codalm"),
    @NamedQuery(name = "EaOrdenesCabecera.findByNumcon", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.numcon = :numcon"),
    @NamedQuery(name = "EaOrdenesCabecera.findByCoscom", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.coscom = :coscom"),
    @NamedQuery(name = "EaOrdenesCabecera.findByCospro", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.cospro = :cospro"),
    @NamedQuery(name = "EaOrdenesCabecera.findByMondol", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.mondol = :mondol"),
    @NamedQuery(name = "EaOrdenesCabecera.findByEstado", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.estado = :estado"),
    @NamedQuery(name = "EaOrdenesCabecera.findByFeccre", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.feccre = :feccre"),
    @NamedQuery(name = "EaOrdenesCabecera.findByFecumv", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.fecumv = :fecumv"),
    @NamedQuery(name = "EaOrdenesCabecera.findByUsecod", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.usecod = :usecod"),
    @NamedQuery(name = "EaOrdenesCabecera.findByUsenam", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.usenam = :usenam"),
    @NamedQuery(name = "EaOrdenesCabecera.findByHostname", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.hostname = :hostname"),
    @NamedQuery(name = "EaOrdenesCabecera.findByTotcosE", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.totcosE = :totcosE"),
    @NamedQuery(name = "EaOrdenesCabecera.findByTotigvP", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.totigvP = :totigvP"),
    @NamedQuery(name = "EaOrdenesCabecera.findByTotigvC", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.totigvC = :totigvC"),
    @NamedQuery(name = "EaOrdenesCabecera.findByOrdtcod", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.ordtcod = :ordtcod"),
    @NamedQuery(name = "EaOrdenesCabecera.findByOrdtnum", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.ordtnum = :ordtnum"),
    @NamedQuery(name = "EaOrdenesCabecera.findByPlnrgdia", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.plnrgdia = :plnrgdia"),
    @NamedQuery(name = "EaOrdenesCabecera.findByTotbrtP", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.totbrtP = :totbrtP"),
    @NamedQuery(name = "EaOrdenesCabecera.findByTotbrtC", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.totbrtC = :totbrtC"),
    @NamedQuery(name = "EaOrdenesCabecera.findByTotdto", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.totdto = :totdto"),
    @NamedQuery(name = "EaOrdenesCabecera.findByTotdtoP", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.totdtoP = :totdtoP"),
    @NamedQuery(name = "EaOrdenesCabecera.findByTotdtoC", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.totdtoC = :totdtoC"),
    @NamedQuery(name = "EaOrdenesCabecera.findByCodpaq", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.codpaq = :codpaq"),
    @NamedQuery(name = "EaOrdenesCabecera.findByChkrgdia", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.chkrgdia = :chkrgdia"),
    @NamedQuery(name = "EaOrdenesCabecera.findByDtoproA", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.dtoproA = :dtoproA"),
    @NamedQuery(name = "EaOrdenesCabecera.findByStacom", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.stacom = :stacom"),
    @NamedQuery(name = "EaOrdenesCabecera.findByCuseda", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.cuseda = :cuseda"),
    @NamedQuery(name = "EaOrdenesCabecera.findBySexcod", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.sexcod = :sexcod"),
    @NamedQuery(name = "EaOrdenesCabecera.findByCustel", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.custel = :custel"),
    @NamedQuery(name = "EaOrdenesCabecera.findByTipcam", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.tipcam = :tipcam"),
    @NamedQuery(name = "EaOrdenesCabecera.findByCodaut", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.codaut = :codaut"),
    @NamedQuery(name = "EaOrdenesCabecera.findByResent", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.resent = :resent"),
    @NamedQuery(name = "EaOrdenesCabecera.findByFecent", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.fecent = :fecent"),
    @NamedQuery(name = "EaOrdenesCabecera.findByOrddoa", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.orddoa = :orddoa"),
    @NamedQuery(name = "EaOrdenesCabecera.findByUsecodEnt", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.usecodEnt = :usecodEnt"),
    @NamedQuery(name = "EaOrdenesCabecera.findByInvnumPre", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.invnumPre = :invnumPre"),
    @NamedQuery(name = "EaOrdenesCabecera.findByAutsta1", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.autsta1 = :autsta1"),
    @NamedQuery(name = "EaOrdenesCabecera.findByUseaut1", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.useaut1 = :useaut1"),
    @NamedQuery(name = "EaOrdenesCabecera.findByAutfec1", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.autfec1 = :autfec1"),
    @NamedQuery(name = "EaOrdenesCabecera.findByAutobs1", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.autobs1 = :autobs1"),
    @NamedQuery(name = "EaOrdenesCabecera.findByAutsta2", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.autsta2 = :autsta2"),
    @NamedQuery(name = "EaOrdenesCabecera.findByUseaut2", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.useaut2 = :useaut2"),
    @NamedQuery(name = "EaOrdenesCabecera.findByAutfec2", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.autfec2 = :autfec2"),
    @NamedQuery(name = "EaOrdenesCabecera.findByAutobs2", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.autobs2 = :autobs2"),
    @NamedQuery(name = "EaOrdenesCabecera.findByCobmax", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.cobmax = :cobmax"),
    @NamedQuery(name = "EaOrdenesCabecera.findByOcucod", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.ocucod = :ocucod"),
    @NamedQuery(name = "EaOrdenesCabecera.findByPlnnumea", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.plnnumea = :plnnumea"),
    @NamedQuery(name = "EaOrdenesCabecera.findByPlnnum", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.plnnum = :plnnum"),
    @NamedQuery(name = "EaOrdenesCabecera.findByCodprom", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.codprom = :codprom"),
    @NamedQuery(name = "EaOrdenesCabecera.findBySercod", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.sercod = :sercod"),
    @NamedQuery(name = "EaOrdenesCabecera.findBySiscod", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.siscod = :siscod"),
    @NamedQuery(name = "EaOrdenesCabecera.findByCodper", query = "SELECT e FROM EaOrdenesCabecera e WHERE e.codper = :codper")})
public class EaOrdenesCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "invnum")
    private Integer invnum;
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
    @Size(min = 1, max = 7)
    @Column(name = "cuscod")
    private String cuscod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "cusnam")
    private String cusnam;
    @Size(max = 100)
    @Column(name = "cusadr")
    private String cusadr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datord")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datord;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estord")
    private String estord;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "totord")
    private BigDecimal totord;
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
    @Size(min = 1, max = 2)
    @Column(name = "codstd")
    private String codstd;
    @Size(max = 4)
    @Column(name = "medcod")
    private String medcod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tarcod")
    private String tarcod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invgnc")
    private BigDecimal invgnc;
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
    @Column(name = "invcoa")
    private BigDecimal invcoa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invigv")
    private BigDecimal invigv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "destot_n")
    private BigDecimal destotN;
    @Size(max = 40)
    @Column(name = "mednam")
    private String mednam;
    @Size(max = 255)
    @Column(name = "ordobs")
    private String ordobs;
    @Column(name = "fecanu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecanu;
    @Column(name = "useanu")
    private Integer useanu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codalm")
    private String codalm;
    @Column(name = "numcon")
    private Integer numcon;
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
    @Column(name = "mondol")
    private BigDecimal mondol;
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
    @Column(name = "totigv_p")
    private BigDecimal totigvP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totigv_c")
    private BigDecimal totigvC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ordtcod")
    private String ordtcod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordtnum")
    private int ordtnum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plnrgdia")
    private BigDecimal plnrgdia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totbrt_p")
    private BigDecimal totbrtP;
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
    @Size(min = 1, max = 6)
    @Column(name = "codpaq")
    private String codpaq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "chkrgdia")
    private String chkrgdia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtopro_a")
    private BigDecimal dtoproA;
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
    @Column(name = "tipcam")
    private BigDecimal tipcam;
    @Size(max = 10)
    @Column(name = "codaut")
    private String codaut;
    @Size(max = 70)
    @Column(name = "resent")
    private String resent;
    @Column(name = "fecent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecent;
    @Size(max = 200)
    @Column(name = "orddoa")
    private String orddoa;
    @Column(name = "usecod_ent")
    private Integer usecodEnt;
    @Column(name = "invnum_pre")
    private Integer invnumPre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "autsta1")
    private String autsta1;
    @Column(name = "useaut1")
    private Integer useaut1;
    @Column(name = "autfec1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date autfec1;
    @Size(max = 40)
    @Column(name = "autobs1")
    private String autobs1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "autsta2")
    private String autsta2;
    @Column(name = "useaut2")
    private Integer useaut2;
    @Column(name = "autfec2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date autfec2;
    @Size(max = 40)
    @Column(name = "autobs2")
    private String autobs2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cobmax")
    private BigDecimal cobmax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ocucod")
    private String ocucod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "plnnumea")
    private String plnnumea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "plnnum")
    private String plnnum;
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

    public EaOrdenesCabecera() {
    }

    public EaOrdenesCabecera(Integer invnum) {
        this.invnum = invnum;
    }

    public EaOrdenesCabecera(Integer invnum, int prfnum, String tipcli, String cuscod, String cusnam, Date datord, String estord, BigDecimal totord, BigDecimal netord, BigDecimal igvord, String codstd, String tarcod, BigDecimal invgnc, BigDecimal invppac, BigDecimal invpseg, BigDecimal invcoa, BigDecimal invigv, BigDecimal destotN, String codalm, BigDecimal coscom, BigDecimal cospro, BigDecimal mondol, String estado, Date feccre, Date fecumv, int usecod, String usenam, String hostname, BigDecimal totcosE, BigDecimal totigvP, BigDecimal totigvC, String ordtcod, int ordtnum, BigDecimal plnrgdia, BigDecimal totbrtP, BigDecimal totbrtC, BigDecimal totdto, BigDecimal totdtoP, BigDecimal totdtoC, String codpaq, String chkrgdia, BigDecimal dtoproA, String stacom, int cuseda, String sexcod, BigDecimal tipcam, String autsta1, String autsta2, BigDecimal cobmax, String ocucod, String plnnumea, String plnnum, String codprom, String sercod, int siscod, String codper) {
        this.invnum = invnum;
        this.prfnum = prfnum;
        this.tipcli = tipcli;
        this.cuscod = cuscod;
        this.cusnam = cusnam;
        this.datord = datord;
        this.estord = estord;
        this.totord = totord;
        this.netord = netord;
        this.igvord = igvord;
        this.codstd = codstd;
        this.tarcod = tarcod;
        this.invgnc = invgnc;
        this.invppac = invppac;
        this.invpseg = invpseg;
        this.invcoa = invcoa;
        this.invigv = invigv;
        this.destotN = destotN;
        this.codalm = codalm;
        this.coscom = coscom;
        this.cospro = cospro;
        this.mondol = mondol;
        this.estado = estado;
        this.feccre = feccre;
        this.fecumv = fecumv;
        this.usecod = usecod;
        this.usenam = usenam;
        this.hostname = hostname;
        this.totcosE = totcosE;
        this.totigvP = totigvP;
        this.totigvC = totigvC;
        this.ordtcod = ordtcod;
        this.ordtnum = ordtnum;
        this.plnrgdia = plnrgdia;
        this.totbrtP = totbrtP;
        this.totbrtC = totbrtC;
        this.totdto = totdto;
        this.totdtoP = totdtoP;
        this.totdtoC = totdtoC;
        this.codpaq = codpaq;
        this.chkrgdia = chkrgdia;
        this.dtoproA = dtoproA;
        this.stacom = stacom;
        this.cuseda = cuseda;
        this.sexcod = sexcod;
        this.tipcam = tipcam;
        this.autsta1 = autsta1;
        this.autsta2 = autsta2;
        this.cobmax = cobmax;
        this.ocucod = ocucod;
        this.plnnumea = plnnumea;
        this.plnnum = plnnum;
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

    public String getCuscod() {
        return cuscod;
    }

    public void setCuscod(String cuscod) {
        this.cuscod = cuscod;
    }

    public String getCusnam() {
        return cusnam;
    }

    public void setCusnam(String cusnam) {
        this.cusnam = cusnam;
    }

    public String getCusadr() {
        return cusadr;
    }

    public void setCusadr(String cusadr) {
        this.cusadr = cusadr;
    }

    public Date getDatord() {
        return datord;
    }

    public void setDatord(Date datord) {
        this.datord = datord;
    }

    public String getEstord() {
        return estord;
    }

    public void setEstord(String estord) {
        this.estord = estord;
    }

    public BigDecimal getTotord() {
        return totord;
    }

    public void setTotord(BigDecimal totord) {
        this.totord = totord;
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

    public String getCodstd() {
        return codstd;
    }

    public void setCodstd(String codstd) {
        this.codstd = codstd;
    }

    public String getMedcod() {
        return medcod;
    }

    public void setMedcod(String medcod) {
        this.medcod = medcod;
    }

    public String getTarcod() {
        return tarcod;
    }

    public void setTarcod(String tarcod) {
        this.tarcod = tarcod;
    }

    public BigDecimal getInvgnc() {
        return invgnc;
    }

    public void setInvgnc(BigDecimal invgnc) {
        this.invgnc = invgnc;
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

    public BigDecimal getInvcoa() {
        return invcoa;
    }

    public void setInvcoa(BigDecimal invcoa) {
        this.invcoa = invcoa;
    }

    public BigDecimal getInvigv() {
        return invigv;
    }

    public void setInvigv(BigDecimal invigv) {
        this.invigv = invigv;
    }

    public BigDecimal getDestotN() {
        return destotN;
    }

    public void setDestotN(BigDecimal destotN) {
        this.destotN = destotN;
    }

    public String getMednam() {
        return mednam;
    }

    public void setMednam(String mednam) {
        this.mednam = mednam;
    }

    public String getOrdobs() {
        return ordobs;
    }

    public void setOrdobs(String ordobs) {
        this.ordobs = ordobs;
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

    public String getCodalm() {
        return codalm;
    }

    public void setCodalm(String codalm) {
        this.codalm = codalm;
    }

    public Integer getNumcon() {
        return numcon;
    }

    public void setNumcon(Integer numcon) {
        this.numcon = numcon;
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

    public BigDecimal getMondol() {
        return mondol;
    }

    public void setMondol(BigDecimal mondol) {
        this.mondol = mondol;
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

    public BigDecimal getTotigvP() {
        return totigvP;
    }

    public void setTotigvP(BigDecimal totigvP) {
        this.totigvP = totigvP;
    }

    public BigDecimal getTotigvC() {
        return totigvC;
    }

    public void setTotigvC(BigDecimal totigvC) {
        this.totigvC = totigvC;
    }

    public String getOrdtcod() {
        return ordtcod;
    }

    public void setOrdtcod(String ordtcod) {
        this.ordtcod = ordtcod;
    }

    public int getOrdtnum() {
        return ordtnum;
    }

    public void setOrdtnum(int ordtnum) {
        this.ordtnum = ordtnum;
    }

    public BigDecimal getPlnrgdia() {
        return plnrgdia;
    }

    public void setPlnrgdia(BigDecimal plnrgdia) {
        this.plnrgdia = plnrgdia;
    }

    public BigDecimal getTotbrtP() {
        return totbrtP;
    }

    public void setTotbrtP(BigDecimal totbrtP) {
        this.totbrtP = totbrtP;
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

    public String getCodpaq() {
        return codpaq;
    }

    public void setCodpaq(String codpaq) {
        this.codpaq = codpaq;
    }

    public String getChkrgdia() {
        return chkrgdia;
    }

    public void setChkrgdia(String chkrgdia) {
        this.chkrgdia = chkrgdia;
    }

    public BigDecimal getDtoproA() {
        return dtoproA;
    }

    public void setDtoproA(BigDecimal dtoproA) {
        this.dtoproA = dtoproA;
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

    public BigDecimal getTipcam() {
        return tipcam;
    }

    public void setTipcam(BigDecimal tipcam) {
        this.tipcam = tipcam;
    }

    public String getCodaut() {
        return codaut;
    }

    public void setCodaut(String codaut) {
        this.codaut = codaut;
    }

    public String getResent() {
        return resent;
    }

    public void setResent(String resent) {
        this.resent = resent;
    }

    public Date getFecent() {
        return fecent;
    }

    public void setFecent(Date fecent) {
        this.fecent = fecent;
    }

    public String getOrddoa() {
        return orddoa;
    }

    public void setOrddoa(String orddoa) {
        this.orddoa = orddoa;
    }

    public Integer getUsecodEnt() {
        return usecodEnt;
    }

    public void setUsecodEnt(Integer usecodEnt) {
        this.usecodEnt = usecodEnt;
    }

    public Integer getInvnumPre() {
        return invnumPre;
    }

    public void setInvnumPre(Integer invnumPre) {
        this.invnumPre = invnumPre;
    }

    public String getAutsta1() {
        return autsta1;
    }

    public void setAutsta1(String autsta1) {
        this.autsta1 = autsta1;
    }

    public Integer getUseaut1() {
        return useaut1;
    }

    public void setUseaut1(Integer useaut1) {
        this.useaut1 = useaut1;
    }

    public Date getAutfec1() {
        return autfec1;
    }

    public void setAutfec1(Date autfec1) {
        this.autfec1 = autfec1;
    }

    public String getAutobs1() {
        return autobs1;
    }

    public void setAutobs1(String autobs1) {
        this.autobs1 = autobs1;
    }

    public String getAutsta2() {
        return autsta2;
    }

    public void setAutsta2(String autsta2) {
        this.autsta2 = autsta2;
    }

    public Integer getUseaut2() {
        return useaut2;
    }

    public void setUseaut2(Integer useaut2) {
        this.useaut2 = useaut2;
    }

    public Date getAutfec2() {
        return autfec2;
    }

    public void setAutfec2(Date autfec2) {
        this.autfec2 = autfec2;
    }

    public String getAutobs2() {
        return autobs2;
    }

    public void setAutobs2(String autobs2) {
        this.autobs2 = autobs2;
    }

    public BigDecimal getCobmax() {
        return cobmax;
    }

    public void setCobmax(BigDecimal cobmax) {
        this.cobmax = cobmax;
    }

    public String getOcucod() {
        return ocucod;
    }

    public void setOcucod(String ocucod) {
        this.ocucod = ocucod;
    }

    public String getPlnnumea() {
        return plnnumea;
    }

    public void setPlnnumea(String plnnumea) {
        this.plnnumea = plnnumea;
    }

    public String getPlnnum() {
        return plnnum;
    }

    public void setPlnnum(String plnnum) {
        this.plnnum = plnnum;
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
        if (!(object instanceof EaOrdenesCabecera)) {
            return false;
        }
        EaOrdenesCabecera other = (EaOrdenesCabecera) object;
        if ((this.invnum == null && other.invnum != null) || (this.invnum != null && !this.invnum.equals(other.invnum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.EaOrdenesCabecera[ invnum=" + invnum + " ]";
    }
    
}
