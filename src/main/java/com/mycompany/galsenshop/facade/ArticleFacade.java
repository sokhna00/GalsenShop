/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galsenshop.facade;



import com.mycompany.galsenshop.entity.Article;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diarra
 */


@Stateless
public class ArticleFacade extends AbstractFacade<Article> {

    @PersistenceContext(unitName = "galsenShopPU")
    private EntityManager em;


    public ArticleFacade() {
        super(Article.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Article> findArticle(String searchText) {

        String requete = "SELECT a FROM Article a WHERE a.libelle like '%" + searchText + "%' ORDER BY a.code DESC";

        Query q = em.createQuery(requete);

        return q.getResultList();

    }

    public void remove(Long artid){
        Article art = find(artid);
        em.remove(art);
        System.out.println("Employee removed......");
    }

    public List<Article> getAllArticlePaginated(int start, int size) {
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
