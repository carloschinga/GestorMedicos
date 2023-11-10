/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "view_web_usuarios")
@NamedQueries({
    @NamedQuery(name = "ViewWebUsuarios.findAll", query = "SELECT v FROM ViewWebUsuarios v"),
    @NamedQuery(name = "ViewWebUsuarios.findByUsecod", query = "SELECT v FROM ViewWebUsuarios v WHERE v.usecod = :usecod"),
    @NamedQuery(name = "ViewWebUsuarios.findBySiscod", query = "SELECT v FROM ViewWebUsuarios v WHERE v.siscod = :siscod"),
    @NamedQuery(name = "ViewWebUsuarios.findByUsepas", query = "SELECT v FROM ViewWebUsuarios v WHERE v.usepas = :usepas"),
    @NamedQuery(name = "ViewWebUsuarios.findByUsenam", query = "SELECT v FROM ViewWebUsuarios v WHERE v.usenam = :usenam"),
    @NamedQuery(name = "ViewWebUsuarios.findByUseusr", query = "SELECT v FROM ViewWebUsuarios v WHERE v.useusr = :useusr"),
    @NamedQuery(name = "ViewWebUsuarios.findByUsesgl", query = "SELECT v FROM ViewWebUsuarios v WHERE v.usesgl = :usesgl"),
    @NamedQuery(name = "ViewWebUsuarios.findByGrucod", query = "SELECT v FROM ViewWebUsuarios v WHERE v.grucod = :grucod"),
    @NamedQuery(name = "ViewWebUsuarios.findByEstado", query = "SELECT v FROM ViewWebUsuarios v WHERE v.estado = :estado"),
    @NamedQuery(name = "ViewWebUsuarios.findByPassweb", query = "SELECT v FROM ViewWebUsuarios v WHERE v.passweb = :passweb"),
    @NamedQuery(name = "ViewWebUsuarios.findByAdmiweb", query = "SELECT v FROM ViewWebUsuarios v WHERE v.admiweb = :admiweb"),
    @NamedQuery(name = "ViewWebUsuarios.findByRolweb", query = "SELECT v FROM ViewWebUsuarios v WHERE v.rolweb = :rolweb"),
    @NamedQuery(name = "ViewWebUsuarios.findByCodrol", query = "SELECT v FROM ViewWebUsuarios v WHERE v.codrol = :codrol"),
    @NamedQuery(name = "ViewWebUsuarios.findByNomrol", query = "SELECT v FROM ViewWebUsuarios v WHERE v.nomrol = :nomrol")})
public class ViewWebUsuarios implements Serializable, Comparable<ViewWebUsuarios>{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usecod")
    private int usecod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "siscod")
    private int siscod;
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
    @Size(min = 1, max = 6)
    @Column(name = "grucod")
    private String grucod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado")
    private String estado;
    @Size(max = 70)
    @Column(name = "passweb")
    private String passweb;
    @Column(name = "admiweb")
    private Integer admiweb;
    @Column(name = "rolweb")
    private Integer rolweb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codrol")
    private int codrol;
    @Size(max = 30)
    @Column(name = "nomrol")
    private String nomrol;

    public ViewWebUsuarios() {
    }

    public int getUsecod() {
        return usecod;
    }

    public void setUsecod(int usecod) {
        this.usecod = usecod;
    }

    public int getSiscod() {
        return siscod;
    }

    public void setSiscod(int siscod) {
        this.siscod = siscod;
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

    public String getGrucod() {
        return grucod;
    }

    public void setGrucod(String grucod) {
        this.grucod = grucod;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public int getCodrol() {
        return codrol;
    }

    public void setCodrol(int codrol) {
        this.codrol = codrol;
    }

    public String getNomrol() {
        return nomrol;
    }

    public void setNomrol(String nomrol) {
        this.nomrol = nomrol;
    }
    
    public int compareTo(ViewWebUsuarios s) {
        int compare = s.usenam.compareTo(usenam);

        if (compare < 0) {
            return 1;
        } else if (compare > 0) {
            return -1;
        } else {
            return 0;
        }
    }
    
}
