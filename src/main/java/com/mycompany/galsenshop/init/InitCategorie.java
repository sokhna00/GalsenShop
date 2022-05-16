/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galsenshop.init;

import com.mycompany.galsenshop.entity.Categorie;
import com.mycompany.galsenshop.facade.CategorieFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Diarra
 */


@Singleton
@Startup
public class InitCategorie {

    @EJB
    private CategorieFacade categorieFacade;

    //permet de créer l'objet au démarrage
    @PostConstruct
    public void init() {
        System.out.println("Demarrage de l'application");

        if (categorieFacade.count() == 0) {

            System.out.println("la BD contient :" + categorieFacade.count() + "elements");

            Categorie c1 = new Categorie("BSE", "biens sociaux essentiels", "les médicaments,appareils médico-chirurgicaux,le papier journal, les livres, les journaux",0.0);
            Categorie c2 = new Categorie("BPN", "biens de premières nécessités", "Les matières premières de base, les biens d'équipement et les intrants spécifiques", 0.05);
            Categorie c3 = new Categorie("IPI", "Intrants et produits intermédiares", "", 0.1);
            Categorie c4 = new Categorie("BCF", "Biens de consommation finale", "Catégorie par défaut", 0.2);


            categorieFacade.create(c1);
            categorieFacade.create(c2);
            categorieFacade.create(c3);
            categorieFacade.create(c4);

        }


    }
}
