/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galsenshop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diarra
 */

@XmlRootElement(name = "categorie",namespace = "http://ept.sn")
@Entity
public class Categorie implements Serializable {


    @Id
    private String code;
    private String libelle;
    private String description;
    private Double tva;
     @OneToMany
    @JoinColumn(name = "categorie_code")
    private Set<Article> Desarticles= new HashSet<>();

    public Categorie() {
    }

    public Categorie(String code, String libelle, String description, Double tva) {
        this.code = code;
        this.libelle = libelle;
        this.description = description;
        this.tva = tva;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTva() {
        return tva;
    }

    public void setTva(Double tva) {
        this.tva = tva;
    }


    @Override
    public String toString() {
        return "Categorie{" +
                "code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                ", description='" + description + '\'' +
                ", tva=" + tva +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return Objects.equals(code, categorie.code) && Objects.equals(libelle, categorie.libelle) && Objects.equals(description, categorie.description) && Objects.equals(tva, categorie.tva);
    }

    @PrePersist
    private void initTVA(){
        if(tva == null){
            tva = 0.0;
            System.out.println("La TVA est initialie a : " +tva);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, libelle, description, tva);
    }


}


