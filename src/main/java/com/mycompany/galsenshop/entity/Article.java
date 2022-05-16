/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galsenshop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diarra
 */

@XmlRootElement(name = "article",namespace = "http://ept.sn")
@Entity
public class Article implements Serializable {

    @Id
    private String code;
    private String libelle;
    private String description;
    private Double prix_unitaire;
    private String unite;
    private Double qte_stock;
    @JoinColumn(name = "code_categorie", referencedColumnName = "code")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private String code_categorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "code_article", fetch = FetchType.LAZY)
    private Collection<Article> ligneacticleCollection;

    public Article() {
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

    public Double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Double getQte_stock() {
        return qte_stock;
    }

    public void setQte_stock(Double qte_stock) {
        this.qte_stock = qte_stock;
    }

    public String getCode_categorie() {
        return code_categorie;
    }

    public void setCode_categorie(String code_categorie) {
        this.code_categorie = code_categorie;
    }
}


