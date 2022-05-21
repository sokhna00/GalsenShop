/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galsenshop;

import com.mycompany.galsenshop.entity.Categorie;
import com.mycompany.galsenshop.facade.CategorieFacade;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Named;

/**
 *
 * @author Diarra
 */
@Named(value="supprimerCategorieBean")
@ViewScoped
public class SupprimeCategorieBean {

    private Map<Integer, Categorie> categories = new HashMap();

    public SupprimeCategorieBean() {
    }

    public Map<Integer, Categorie> getCategories() {
        return categories;
    }

    public void setCategories(Map<Integer, Categorie> categories) {
        this.categories = categories;
    }
    
      



    public void supprimerCategorie(int idCategorie) throws Exception {
        Categorie categorie = categories.get(idCategorie);
        if (categorie != null) {
            categories.remove(idCategorie);
        } else {
            throw new Exception("ligne non trouvee");
        }
    }
}
