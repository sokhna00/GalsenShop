/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galsenshop.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Diarra
 */

@Entity
public class LigneArticle implements Serializable {

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.articlePkey);
        hash = 89 * hash + Objects.hashCode(this.quantite);
        hash = 89 * hash + Objects.hashCode(this.idArticle);
        hash = 89 * hash + Objects.hashCode(this.article);
        hash = 89 * hash + Objects.hashCode(this.idFacture);
        hash = 89 * hash + Objects.hashCode(this.facture);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LigneArticle other = (LigneArticle) obj;
        if (!Objects.equals(this.articlePkey, other.articlePkey)) {
            return false;
        }
        if (!Objects.equals(this.idArticle, other.idArticle)) {
            return false;
        }
        if (!Objects.equals(this.quantite, other.quantite)) {
            return false;
        }
        if (!Objects.equals(this.article, other.article)) {
            return false;
        }
        if (!Objects.equals(this.idFacture, other.idFacture)) {
            return false;
        }
        return Objects.equals(this.facture, other.facture);
    }

    public LigneArticle(String articlePkey, Double quantite, String idArticle, Article article, Integer idFacture, Facture facture) {
        this.articlePkey = articlePkey;
        this.quantite = quantite;
        this.idArticle = idArticle;
        this.article = article;
        this.idFacture = idFacture;
        this.facture = facture;
    }

    public String getArticlePkey() {
        return articlePkey;
    }

    public void setArticlePkey(String articlePkey) {
        this.articlePkey = articlePkey;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public String getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Integer getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Integer idFacture) {
        this.idFacture = idFacture;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
    
      @Id
    private String articlePkey;

    @Column
    private Double quantite;
    
    @Column( nullable = false)
    private String idArticle;
    
     @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(updatable = false,insertable = false)
    private Article article;
     
    @Column(nullable = false)
    private Integer idFacture;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(updatable = false,insertable = false)
    private Facture facture;

   

    public LigneArticle(String articlePkey, Double quantite, Integer idFacture, String idArticle, Facture facture, Article article) {
        this.articlePkey = articlePkey;
        this.quantite = quantite;
        this.idFacture = idFacture;
        this.idArticle = idArticle;
        this.facture = facture;
        this.article = article;
    }

    
}
