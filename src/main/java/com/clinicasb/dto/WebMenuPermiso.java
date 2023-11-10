/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "web_menu_permiso")
@NamedQueries({
    @NamedQuery(name = "WebMenuPermiso.findAll", query = "SELECT w FROM WebMenuPermiso w"),
    @NamedQuery(name = "WebMenuPermiso.findByCodrol", query = "SELECT w FROM WebMenuPermiso w WHERE w.webMenuPermisoPK.codrol = :codrol"),
    @NamedQuery(name = "WebMenuPermiso.findByCodmen", query = "SELECT w FROM WebMenuPermiso w WHERE w.webMenuPermisoPK.codmen = :codmen"),
    @NamedQuery(name = "WebMenuPermiso.findByAsigperm", query = "SELECT w FROM WebMenuPermiso w WHERE w.asigperm = :asigperm")})
public class WebMenuPermiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WebMenuPermisoPK webMenuPermisoPK;
    @Column(name = "asigperm")
    private Integer asigperm;

    public WebMenuPermiso() {
    }

    public WebMenuPermiso(WebMenuPermisoPK webMenuPermisoPK) {
        this.webMenuPermisoPK = webMenuPermisoPK;
    }

    public WebMenuPermiso(int codrol, int codmen) {
        this.webMenuPermisoPK = new WebMenuPermisoPK(codrol, codmen);
    }

    public WebMenuPermisoPK getWebMenuPermisoPK() {
        return webMenuPermisoPK;
    }

    public void setWebMenuPermisoPK(WebMenuPermisoPK webMenuPermisoPK) {
        this.webMenuPermisoPK = webMenuPermisoPK;
    }

    public Integer getAsigperm() {
        return asigperm;
    }

    public void setAsigperm(Integer asigperm) {
        this.asigperm = asigperm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webMenuPermisoPK != null ? webMenuPermisoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebMenuPermiso)) {
            return false;
        }
        WebMenuPermiso other = (WebMenuPermiso) object;
        if ((this.webMenuPermisoPK == null && other.webMenuPermisoPK != null) || (this.webMenuPermisoPK != null && !this.webMenuPermisoPK.equals(other.webMenuPermisoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.WebMenuPermiso[ webMenuPermisoPK=" + webMenuPermisoPK + " ]";
    }
    
}
