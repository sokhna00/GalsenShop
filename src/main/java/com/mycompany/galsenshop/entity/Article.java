/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galsenshop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diarra
 */

@XmlRootElement(name = "article",namespace = "http://ept.sn")
@Entity
public class Article implements Serializable {

    @Id
   @Column 
    private String code;
    @Column
    private String libelle;
    @Column
    private String description;
    @Column
    private Double prix_unitaire;
    @Column
    private String unite;
    @Column
    private Double qte_stock;
     @ManyToOne
    @JoinColumn(name = "categorie_code",updatable = false)
    private Categorie categorie;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<LigneArticle> ligneArticles = new HashSet<>();

    public Article() {
    }

    public Article(String code, String libelle, String description, Double prix_unitaire, String unite, Double qte_stock, Categorie categorie) {
        this.code = code;
        this.libelle = libelle;
        this.description = description;
        this.prix_unitaire = prix_unitaire;
        this.unite = unite;
        this.qte_stock = qte_stock;
        this.categorie = categorie;
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

   
}

        