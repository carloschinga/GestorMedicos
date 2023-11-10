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
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByUsecod", query = "SELECT u FROM Usuarios u WHERE u.usecod = :usecod"),
    @NamedQuery(name = "Usuarios.findByUsepas", query = "SELECT u FROM Usuarios u WHERE u.usepas = :usepas"),
    @NamedQuery(name = "Usuarios.validar", query = "SELECT u FROM Usuarios u WHERE u.useusr = :useusr and u.passweb = :passweb and u.estado='S'"),
    @NamedQuery(name = "Usuarios.findByUsenam", query = "SELECT u FROM Usuarios u WHERE u.usenam = :usenam"),
    @NamedQuery(name = "Usuarios.findByUseusr", query = "SELECT u FROM Usuarios u WHERE u.useusr = :useusr"),
    @NamedQuery(name = "Usuarios.findByUsesgl", query = "SELECT u FROM Usuarios u WHERE u.usesgl = :usesgl"),
    @NamedQuery(name = "Usuarios.findByEstado", query = "SELECT u FROM Usuarios u WHERE u.estado = :estado"),
    @NamedQuery(name = "Usuarios.findByFeccre", query = "SELECT u FROM Usuarios u WHERE u.feccre = :feccre"),
    @NamedQuery(name = "Usuarios.findByFecumv", query = "SELECT u FROM Usuarios u WHERE u.fecumv = :fecumv"),
    @NamedQuery(name = "Usuarios.findByUsecodx", query = "SELECT u FROM Usuarios u WHERE u.usecodx = :usecodx"),
    @NamedQuery(name = "Usuarios.findByUsenamx", query = "SELECT u FROM Usuarios u WHERE u.usenamx = :usenamx"),
    @NamedQuery(name = "Usuarios.findByHostname", query = "SELECT u FROM Usuarios u WHERE u.hostname = :hostname"),
    @NamedQuery(name = "Usuarios.findByUsefor", query = "SELECT u FROM Usuarios u WHERE u.usefor = :usefor"),
    @NamedQuery(name = "Usuarios.findByUsedoc", query = "SELECT u FROM Usuarios u WHERE u.usedoc = :usedoc"),
    @NamedQuery(name = "Usuarios.findByUsepassx", query = "SELECT u FROM Usuarios u WHERE u.usepassx = :usepassx"),
    @NamedQuery(name = "Usuarios.findByUsefir", query = "SELECT u FROM Usuarios u WHERE u.usefir = :usefir"),
    @NamedQuery(name = "Usuarios.findByUsediacpass", query = "SELECT u FROM Usuarios u WHERE u.usediacpass = :usediacpass"),
    @NamedQuery(name = "Usuarios.findByFecumvpass", query = "SELECT u FROM Usuarios u WHERE u.fecumvpass = :fecumvpass"),
    @NamedQuery(name = "Usuarios.findByUsereqcpass", query = "SELECT u FROM Usuarios u WHERE u.usereqcpass = :usereqcpass"),
    @NamedQuery(name = "Usuarios.findByPassweb", query = "SELECT u FROM Usuarios u WHERE u.passweb = :passweb"),
    @NamedQuery(name = "Usuarios.findByAdmiweb", query = "SELECT u FROM Usuarios u WHERE u.admiweb = :admiweb"),
    @NamedQuery(name = "Usuarios.findByRolweb", query = "SELECT u FROM Usuarios u WHERE u.rolweb = :rolweb")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usecod")
    private Integer usecod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "usepas")
    private String usepas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usenam")
    private String usenam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "useusr")
    private String useusr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "usesgl")
    private String usesgl;
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
    @Column(name = "usecodx")
    private int usecodx;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usenamx")
    private String usenamx;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "hostname")
    private String hostname;
    @Size(max = 20)
    @Column(name = "usefor")
    private String usefor;
    @Size(max = 15)
    @Column(name = "usedoc")
    private String usedoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usepassx")
    private String usepassx;
    @Size(max = 80)
    @Column(name = "usefir")
    private String usefir;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usediacpass")
    private int usediacpass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecumvpass")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecumvpass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "usereqcpass")
    private String usereqcpass;
    @Size(max = 70)
    @Column(name = "passweb")
    private String passweb;
    @Column(name = "admiweb")
    private Integer admiweb;
    @Column(name = "rolweb")
    private Integer rolweb;

    public Usuarios() {
    }

    public Usuarios(Integer usecod) {
        this.usecod = usecod;
    }

    public Usuarios(Integer usecod, String usepas, String usenam, String useusr, String usesgl, String estado, Date feccre, Date fecumv, int usecodx, String usenamx, String hostname, String usepassx, int usediacpass, Date fecumvpass, String usereqcpass) {
        this.usecod = usecod;
        this.usepas = usepas;
        this.usenam = usenam;
        this.useusr = useusr;
        this.usesgl = usesgl;
        this.estado = estado;
        this.feccre = feccre;
        this.fecumv = fecumv;
        this.usecodx = usecodx;
        this.usenamx = usenamx;
        this.hostname = hostname;
        this.usepassx = usepassx;
        this.usediacpass = usediacpass;
        this.fecumvpass = fecumvpass;
        this.usereqcpass = usereqcpass;
    }

    public Integer getUsecod() {
        return usecod;
    }

    public void setUsecod(Integer usecod) {
        this.usecod = usecod;
    }

    public String getUsepas() {
        return usepas;
    }

    public void setUsepas(String usepas) {
        this.usepas = usepas;
    }

    public String getUsenam() {
        return usenam;
    }

    public void setUsenam(String usenam) {
        this.usenam = usenam;
    }

    public String getUseusr() {
        return useusr;
    }

    public void setUseusr(String useusr) {
        this.useusr = useusr;
    }

    public String getUsesgl() {
        return usesgl;
    }

    public void setUsesgl(String usesgl) {
        this.usesgl = usesgl;
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

    public int getUsecodx() {
        return usecodx;
    }

    public void setUsecodx(int usecodx) {
        this.usecodx = usecodx;
    }

    public String getUsenamx() {
        return usenamx;
    }

    public void setUsenamx(String usenamx) {
        this.usenamx = usenamx;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getUsefor() {
        return usefor;
    }

    public void setUsefor(String usefor) {
        this.usefor = usefor;
    }

    public String getUsedoc() {
        return usedoc;
    }

    public void setUsedoc(String usedoc) {
        this.usedoc = usedoc;
    }

    public String getUsepassx() {
        return usepassx;
    }

    public void setUsepassx(String usepassx) {
        this.usepassx = usepassx;
    }

    public String getUsefir() {
        return usefir;
    }

    public void setUsefir(String usefir) {
        this.usefir = usefir;
    }

    public int getUsediacpass() {
        return usediacpass;
    }

    public void setUsediacpass(int usediacpass) {
        this.usediacpass = usediacpass;
    }

    public Date getFecumvpass() {
        return fecumvpass;
    }

    public void setFecumvpass(Date fecumvpass) {
        this.fecumvpass = fecumvpass;
    }

    public String getUsereqcpass() {
        return usereqcpass;
    }

    public void setUsereqcpass(String usereqcpass) {
        this.usereqcpass = usereqcpass;
    }

    public String getPassweb() {
        return passweb;
    }

    public void setPassweb(String passweb) {
        this.passweb = passweb;
    }

    public Integer getAdmiweb() {
        return admiweb;
    }

    public void setAdmiweb(Integer admiweb) {
        this.admiweb = admiweb;
    }

    public Integer getRolweb() {
        return rolweb;
    }

    public void setRolweb(Integer rolweb) {
        this.rolweb = rolweb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usecod != null ? usecod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usecod == null && other.usecod != null) || (this.usecod != null && !this.usecod.equals(other.usecod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.Usuarios[ usecod=" + usecod + " ]";
    }
    
}
