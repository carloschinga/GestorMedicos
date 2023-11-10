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
@Table(name = "web_menu")
@NamedQueries({
    @NamedQuery(name = "WebMenu.findAll", query = "SELECT w FROM WebMenu w"),
    @NamedQuery(name = "WebMenu.findByCodmen", query = "SELECT w FROM WebMenu w WHERE w.codmen = :codmen"),
    @NamedQuery(name = "WebMenu.findByNommen", query = "SELECT w FROM WebMenu w WHERE w.nommen = :nommen"),
    @NamedQuery(name = "WebMenu.findByIclass", query = "SELECT w FROM WebMenu w WHERE w.iclass = :iclass"),
    @NamedQuery(name = "WebMenu.findByHtml", query = "SELECT w FROM WebMenu w WHERE w.html = :html"),
    @NamedQuery(name = "WebMenu.findByTipmen", query = "SELECT w FROM WebMenu w WHERE w.tipmen = :tipmen"),
    @NamedQuery(name = "WebMenu.habiles", query = "SELECT w FROM WebMenu w WHERE w.codmas <> -1"),
    @NamedQuery(name = "WebMenu.findByCodmas", query = "SELECT w FROM WebMenu w WHERE w.codmas = :codmas")})
public class WebMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codmen")
    private Integer codmen;
    @Size(max = 100)
    @Column(name = "nommen")
    private String nommen;
    @Size(max = 150)
    @Column(name = "iclass")
    private String iclass;
    @Size(max = 150)
    @Column(name = "html")
    private String html;
    @Size(max = 10)
    @Column(name = "tipmen")
    private String tipmen;
    @Column(name = "codmas")
    private Integer codmas;

    public WebMenu() {
    }

    public WebMenu(Integer codmen) {
        this.codmen = codmen;
    }

    public Integer getCodmen() {
        return codmen;
    }

    public void setCodmen(Integer codmen) {
        this.codmen = codmen;
    }

    public String getNommen() {
        return nommen;
    }

    public void setNommen(String nommen) {
        this.nommen = nommen;
    }

    public String getIclass() {
        return iclass;
    }

    public void setIclass(String iclass) {
        this.iclass = iclass;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getTipmen() {
        return tipmen;
    }

    public void setTipmen(String tipmen) {
        this.tipmen = tipmen;
    }

    public Integer getCodmas() {
        return codmas;
    }

    public void setCodmas(Integer codmas) {
        this.codmas = codmas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmen != null ? codmen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebMenu)) {
            return false;
        }
        WebMenu other = (WebMenu) object;
        if ((this.codmen == null && other.codmen != null) || (this.codmen != null && !this.codmen.equals(other.codmen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.WebMenu[ codmen=" + codmen + " ]";
    }
    
}
