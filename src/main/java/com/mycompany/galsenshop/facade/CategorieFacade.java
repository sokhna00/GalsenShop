/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galsenshop.facade;

import com.mycompany.galsenshop.entity.Categorie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Diarra
 */

@Stateless
public class CategorieFacade extends AbstractFacade<Categorie>{

    @PersistenceContext(unitName = "StockManagementPU")
    private EntityManager em;
    
    
        public CategorieFacade() {
        super(Categorie.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
     public List<Categorie> findCategorie(String searchText) {
        
        String requete = "SELECT c FROM Categorie c WHERE c.libelle like '%" + searchText + "%' ORDER BY c.code DESC";

        Query q = em.createQuery(requete);

        return q.getResultList();

    }

    public void remove(Long categid){
        Categorie categ = find(categid);
        em.remove(categ);
        System.out.println("Employee removed......");
    }
}
