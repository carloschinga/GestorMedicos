/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "ea_resultados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EaResultados.findAll", query = "SELECT e FROM EaResultados e"),
    @NamedQuery(name = "EaResultados.findByInvnum", query = "SELECT e FROM EaResultados e WHERE e.eaResultadosPK.invnum = :invnum"),
    @NamedQuery(name = "EaResultados.findByNumitm", query = "SELECT e FROM EaResultados e WHERE e.eaResultadosPK.numitm = :numitm"),
    @NamedQuery(name = "EaResultados.findByExacod", query = "SELECT e FROM EaResultados e WHERE e.exacod = :exacod"),
    @NamedQuery(name = "EaResultados.findByDatres", query = "SELECT e FROM EaResultados e WHERE e.datres = :datres"),
    @NamedQuery(name = "EaResultados.findByEstres", query = "SELECT e FROM EaResultados e WHERE e.estres = :estres"),
    @NamedQuery(name = "EaResultados.findByMedcod", query = "SELECT e FROM EaResultados e WHERE e.medcod = :medcod"),
    @NamedQuery(name = "EaResultados.findByEstado", query = "SELECT e FROM EaResultados e WHERE e.estado = :estado"),
    @NamedQuery(name = "EaResultados.findByFeccre", query = "SELECT e FROM EaResultados e WHERE e.feccre = :feccre"),
    @NamedQuery(name = "EaResultados.findByFecumv", query = "SELECT e FROM EaResultados e WHERE e.fecumv = :fecumv"),
    @NamedQuery(name = "EaResultados.findByUsecod", query = "SELECT e FROM EaResultados e WHERE e.usecod = :usecod"),
    @NamedQuery(name = "EaResultados.findByUsenam", query = "SELECT e FROM EaResultados e WHERE e.usenam = :usenam"),
    @NamedQuery(name = "EaResultados.findByHostname", query = "SELECT e FROM EaResultados e WHERE e.hostname = :hostname"),
    @NamedQuery(name = "EaResultados.findByExadat", query = "SELECT e FROM EaResultados e WHERE e.exadat = :exadat"),
    @NamedQuery(name = "EaResultados.findByUsecodApr", query = "SELECT e FROM EaResultados e WHERE e.usecodApr = :usecodApr"),
    @NamedQuery(name = "EaResultados.findByUsecodRes", query = "SELECT e FROM EaResultados e WHERE e.usecodRes = :usecodRes"),
    @NamedQuery(name = "EaResultados.findByFeccreApr", query = "SELECT e FROM EaResultados e WHERE e.feccreApr = :feccreApr"),
    @NamedQuery(name = "EaResultados.findByHostnameApr", query = "SELECT e FROM EaResultados e WHERE e.hostnameApr = :hostnameApr"),
    @NamedQuery(name = "EaResultados.findByFeccreRes", query = "SELECT e FROM EaResultados e WHERE e.feccreRes = :feccreRes"),
    @NamedQuery(name = "EaResultados.findByHostnameRes", query = "SELECT e FROM EaResultados e WHERE e.hostnameRes = :hostnameRes"),
    @NamedQuery(name = "EaResultados.findByRespacs", query = "SELECT e FROM EaResultados e WHERE e.respacs = :respacs")})
public class EaResultados implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EaResultadosPK eaResultadosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "exacod")
    private String exacod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datres")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datres;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "resexa")
    private String resexa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estres")
    private String estres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "medcod")
    private String medcod;
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
    @Column(name = "exadat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exadat;
    @Column(name = "usecod_apr")
    private Integer usecodApr;
    @Column(name = "usecod_res")
    private Integer usecodRes;
    @Column(name = "feccre_apr")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feccreApr;
    @Size(max = 20)
    @Column(name = "hostname_apr")
    private String hostnameApr;
    @Column(name = "feccre_res")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feccreRes;
    @Size(max = 20)
    @Column(name = "hostname_res")
    private String hostnameRes;
    @Size(max = 200)
    @Column(name = "respacs")
    private String respacs;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "resexahtml")
    private String resexahtml;

    public EaResultados() {
    }

    public EaResultados(EaResultadosPK eaResultadosPK) {
        this.eaResultadosPK = eaResultadosPK;
    }

    public EaResultados(EaResultadosPK eaResultadosPK, String exacod, Date datres, String resexa, String estres, String medcod, String estado, Date feccre, Date fecumv, int usecod, String usenam, String hostname) {
        this.eaResultadosPK = eaResultadosPK;
        this.exacod = exacod;
        this.datres = datres;
        this.resexa = resexa;
        this.estres = estres;
        this.medcod = medcod;
        this.estado = estado;
        this.feccre = feccre;
        this.fecumv = fecumv;
        this.usecod = usecod;
        this.usenam = usenam;
        this.hostname = hostname;
    }

    public EaResultados(int invnum, int numitm) {
        this.eaResultadosPK = new EaResultadosPK(invnum, numitm);
    }

    public EaResultadosPK getEaResultadosPK() {
        return eaResultadosPK;
    }

    public void setEaResultadosPK(EaResultadosPK eaResultadosPK) {
        this.eaResultadosPK = eaResultadosPK;
    }

    public String getExacod() {
        return exacod;
    }

    public void setExacod(String exacod) {
        this.exacod = exacod;
    }

    public Date getDatres() {
        return datres;
    }

    public void setDatres(Date datres) {
        this.datres = datres;
    }

    public String getResexa() {
        return resexa;
    }

    public void setResexa(String resexa) {
        this.resexa = resexa;
    }

    public String getEstres() {
        return estres;
    }

    public void setEstres(String estres) {
        this.estres = estres;
    }

    public String getMedcod() {
        return medcod;
    }

    public void setMedcod(String medcod) {
        this.medcod = medcod;
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

    public Date getExadat() {
        return exadat;
    }

    public void setExadat(Date exadat) {
        this.exadat = exadat;
    }

    public Integer getUsecodApr() {
        return usecodApr;
    }

    public void setUsecodApr(Integer usecodApr) {
        this.usecodApr = usecodApr;
    }

    public Integer getUsecodRes() {
        return usecodRes;
    }

    public void setUsecodRes(Integer usecodRes) {
        this.usecodRes = usecodRes;
    }

    public Date getFeccreApr() {
        return feccreApr;
    }

    public void setFeccreApr(Date feccreApr) {
        this.feccreApr = feccreApr;
    }

    public String getHostnameApr() {
        return hostnameApr;
    }

    public void setHostnameApr(String hostnameApr) {
        this.hostnameApr = hostnameApr;
    }

    public Date getFeccreRes() {
        return feccreRes;
    }

    public void setFeccreRes(Date feccreRes) {
        this.feccreRes = feccreRes;
    }

    public String getHostnameRes() {
        return hostnameRes;
    }

    public void setHostnameRes(String hostnameRes) {
        this.hostnameRes = hostnameRes;
    }

    public String getRespacs() {
        return respacs;
    }

    public void setRespacs(String respacs) {
        this.respacs = respacs;
    }

    public String getResexahtml() {
        return resexahtml;
    }

    public void setResexahtml(String resexahtml) {
        this.resexahtml = resexahtml;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eaResultadosPK != null ? eaResultadosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EaResultados)) {
            return false;
        }
        EaResultados other = (EaResultados) object;
        if ((this.eaResultadosPK == null && other.eaResultadosPK != null) || (this.eaResultadosPK != null && !this.eaResultadosPK.equals(other.eaResultadosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.EaResultados[ eaResultadosPK=" + eaResultadosPK + " ]";
    }
    
}
