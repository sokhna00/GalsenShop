package com.mycompany.galsenshop;

import com.mycompany.galsenshop.entity.Categorie;
import com.mycompany.galsenshop.facade.CategorieFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;


/**
        *
        * @author Diarra
        */

    @Named(value = "ajoutCategorieBean")
    @ViewScoped
    public class AjoutCategorieBean implements Serializable {

        private Categorie categorie = new Categorie();

        @EJB
        private CategorieFacade categorieFacade;

        public AjoutCategorieBean() {
        }

        public Categorie getCategorie() {
            return categorie;
        }

        public void setCategorie(Categorie categorie) {
            this.categorie = categorie;
        }

        public String enregistrerCategorie() {
            System.out.println("categorie enregistre " + categorie);
            categorieFacade.create(categorie);
            return "listCategorie.xhtml?faces-redirect=true";
        }


    }

