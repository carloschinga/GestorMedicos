/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "web_menu_rol")
@NamedQueries({
    @NamedQuery(name = "WebMenuRol.findAll", query = "SELECT w FROM WebMenuRol w"),
    @NamedQuery(name = "WebMenuRol.findByCodrol", query = "SELECT w FROM WebMenuRol w WHERE w.codrol = :codrol"),
    @NamedQuery(name = "WebMenuRol.findByNomrol", query = "SELECT w FROM WebMenuRol w WHERE w.nomrol = :nomrol")})
public class WebMenuRol implements Serializable , Comparable<WebMenuRol>{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codrol")
    private Integer codrol;
    @Size(max = 30)
    @Column(name = "nomrol")
    private String nomrol;

    public WebMenuRol() {
    }

    public WebMenuRol(Integer codrol) {
        this.codrol = codrol;
    }

    public Integer getCodrol() {
        return codrol;
    }

    public void setCodrol(Integer codrol) {
        this.codrol = codrol;
    }

    public String getNomrol() {
        return nomrol;
    }

    public void setNomrol(String nomrol) {
        this.nomrol = nomrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codrol != null ? codrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebMenuRol)) {
            return false;
        }
        WebMenuRol other = (WebMenuRol) object;
        if ((this.codrol == null && other.codrol != null) || (this.codrol != null && !this.codrol.equals(other.codrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.WebMenuRol[ codrol=" + codrol + " ]";
    }
    public int compareTo(WebMenuRol s) {
        int compare = s.nomrol.compareTo(nomrol);

        if (compare < 0) {
            return 1;
        } else if (compare > 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
