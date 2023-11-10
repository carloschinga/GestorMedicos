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

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "procedimientos_resultados")
@NamedQueries({
    @NamedQuery(name = "ProcedimientosResultados.findAll", query = "SELECT p FROM ProcedimientosResultados p"),
    @NamedQuery(name = "ProcedimientosResultados.findByInvnum", query = "SELECT p FROM ProcedimientosResultados p WHERE p.procedimientosResultadosPK.invnum = :invnum"),
    @NamedQuery(name = "ProcedimientosResultados.findByNumitm", query = "SELECT p FROM ProcedimientosResultados p WHERE p.procedimientosResultadosPK.numitm = :numitm"),
    @NamedQuery(name = "ProcedimientosResultados.findByDatres", query = "SELECT p FROM ProcedimientosResultados p WHERE p.datres = :datres"),
    @NamedQuery(name = "ProcedimientosResultados.findByEstres", query = "SELECT p FROM ProcedimientosResultados p WHERE p.estres = :estres"),
    @NamedQuery(name = "ProcedimientosResultados.findByMedcod", query = "SELECT p FROM ProcedimientosResultados p WHERE p.medcod = :medcod"),
    @NamedQuery(name = "ProcedimientosResultados.findByEstado", query = "SELECT p FROM ProcedimientosResultados p WHERE p.estado = :estado"),
    @NamedQuery(name = "ProcedimientosResultados.findByFeccre", query = "SELECT p FROM ProcedimientosResultados p WHERE p.feccre = :feccre"),
    @NamedQuery(name = "ProcedimientosResultados.findByFecumv", query = "SELECT p FROM ProcedimientosResultados p WHERE p.fecumv = :fecumv"),
    @NamedQuery(name = "ProcedimientosResultados.findByUsecod", query = "SELECT p FROM ProcedimientosResultados p WHERE p.usecod = :usecod"),
    @NamedQuery(name = "ProcedimientosResultados.findByUsenam", query = "SELECT p FROM ProcedimientosResultados p WHERE p.usenam = :usenam"),
    @NamedQuery(name = "ProcedimientosResultados.findByHostname", query = "SELECT p FROM ProcedimientosResultados p WHERE p.hostname = :hostname"),
    @NamedQuery(name = "ProcedimientosResultados.findByFeccreApr", query = "SELECT p FROM ProcedimientosResultados p WHERE p.feccreApr = :feccreApr"),
    @NamedQuery(name = "ProcedimientosResultados.findByUsecodApr", query = "SELECT p FROM ProcedimientosResultados p WHERE p.usecodApr = :usecodApr"),
    @NamedQuery(name = "ProcedimientosResultados.findByHostnameApr", query = "SELECT p FROM ProcedimientosResultados p WHERE p.hostnameApr = :hostnameApr"),
    @NamedQuery(name = "ProcedimientosResultados.findByExadat", query = "SELECT p FROM ProcedimientosResultados p WHERE p.exadat = :exadat"),
    @NamedQuery(name = "ProcedimientosResultados.findByTarcod", query = "SELECT p FROM ProcedimientosResultados p WHERE p.tarcod = :tarcod")})
public class ProcedimientosResultados implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcedimientosResultadosPK procedimientosResultadosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datres")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datres;
    @Lob
    @Size(max = 2147483647)
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
    @Column(name = "feccre_apr")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feccreApr;
    @Column(name = "usecod_apr")
    private Integer usecodApr;
    @Size(max = 20)
    @Column(name = "hostname_apr")
    private String hostnameApr;
    @Column(name = "exadat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exadat;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "resexahml")
    private String resexahml;    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tarcod")
    private String tarcod;

    public ProcedimientosResultados() {
    }

    public ProcedimientosResultados(ProcedimientosResultadosPK procedimientosResultadosPK) {
        this.procedimientosResultadosPK = procedimientosResultadosPK;
    }

    public ProcedimientosResultados(ProcedimientosResultadosPK procedimientosResultadosPK, Date datres, String estres, String medcod, String estado, Date feccre, Date fecumv, int usecod, String usenam, String hostname, int invnum1, int numitm1, String tarcod) {
        this.procedimientosResultadosPK = procedimientosResultadosPK;
        this.datres = datres;
        this.estres = estres;
        this.medcod = medcod;
        this.estado = estado;
        this.feccre = feccre;
        this.fecumv = fecumv;
        this.usecod = usecod;
        this.usenam = usenam;
        this.hostname = hostname;
        this.tarcod = tarcod;
    }

    public ProcedimientosResultados(int invnum, int numitm) {
        this.procedimientosResultadosPK = new ProcedimientosResultadosPK(invnum, numitm);
    }

    public ProcedimientosResultadosPK getProcedimientosResultadosPK() {
        return procedimientosResultadosPK;
    }

    public void setProcedimientosResultadosPK(ProcedimientosResultadosPK procedimientosResultadosPK) {
        this.procedimientosResultadosPK = procedimientosResultadosPK;
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

    public Date getFeccreApr() {
        return feccreApr;
    }

    public void setFeccreApr(Date feccreApr) {
        this.feccreApr = feccreApr;
    }

    public Integer getUsecodApr() {
        return usecodApr;
    }

    public void setUsecodApr(Integer usecodApr) {
        this.usecodApr = usecodApr;
    }

    public String getHostnameApr() {
        return hostnameApr;
    }

    public void setHostnameApr(String hostnameApr) {
        this.hostnameApr = hostnameApr;
    }

    public Date getExadat() {
        return exadat;
    }

    public void setExadat(Date exadat) {
        this.exadat = exadat;
    }

    public String getResexahml() {
        return resexahml;
    }

    public void setResexahml(String resexahml) {
        this.resexahml = resexahml;
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
        hash += (procedimientosResultadosPK != null ? procedimientosResultadosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedimientosResultados)) {
            return false;
        }
        ProcedimientosResultados other = (ProcedimientosResultados) object;
        if ((this.procedimientosResultadosPK == null && other.procedimientosResultadosPK != null) || (this.procedimientosResultadosPK != null && !this.procedimientosResultadosPK.equals(other.procedimientosResultadosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.ProcedimientosResultados[ procedimientosResultadosPK=" + procedimientosResultadosPK + " ]";
    }
    
}
