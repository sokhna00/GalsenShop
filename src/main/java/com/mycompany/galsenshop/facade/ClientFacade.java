/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galsenshop.facade;

import com.mycompany.galsenshop.entity.Client;
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
public class ClientFacade extends AbstractFacade<Client> {

    @PersistenceContext(unitName = "galsenShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
    
      public List<Client> SearchClientByNOrPhone(String searchText) {

        
        String requete = "SELECT c FROM Client c WHERE c.nom like '%" + searchText + "%' OR c.telephone like '%" + searchText + "%' ORDER BY c.id DESC";

        Query q = em.createQuery(requete);

        return q.getResultList();

    }
}
