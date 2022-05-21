/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galsenshop.facade;

import com.mycompany.galsenshop.entity.Article;
import com.mycompany.galsenshop.entity.Categorie;
import com.mycompany.galsenshop.entity.Client;

import java.util.ArrayList;
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
    //rechercher un client a partir de son numero
    public List<Client> findClientByNum(String searchText) {

        String requete = "SELECT c FROM Client c WHERE c.telephone like '%" + searchText + "%' OR c.telephone like '%" + searchText + "%' ORDER BY c.id DESC";

        Query q = em.createQuery(requete);

        return q.getResultList();

    }

    public List<Client> findClient(String searchText) {

        String requete = "SELECT c FROM Client c WHERE c.nom like '%" + searchText + "%' ORDER BY c.nom DESC";

        Query q = em.createQuery(requete);

        return q.getResultList();

    }

    public void remove(Long clientid){
        Client client = find(clientid);
        em.remove(client);
        System.out.println("Client removed......");
    }

    public List<Article> getAllClientPaginated(int start, int size) {
        String requete = "SELECT * FROM Article";
        Query q = em.createQuery(requete);
        List<Article> articles = new ArrayList<Article>();
        articles = q.getResultList();
        if (start + size > articles.size()) {
            return new ArrayList<Article>();
        }
        System.out.println(articles);
        return articles.subList(start, start + size);
    }
}
