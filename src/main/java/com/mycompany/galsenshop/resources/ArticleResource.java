/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galsenshop.resources;

import com.mycompany.galsenshop.entity.Article;
import com.mycompany.galsenshop.facade.ArticleFacade;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author Diarra
 */
@Path("articles")
public class ArticleResource {

    @EJB
    private ArticleFacade articleFacade;



    // Lister les articles
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Article> getArticles() {

        return articleFacade.findAll();
    }



    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, "ept/article"})
    public Article getArticleById(@PathParam("id") Integer id) {
        Article e = articleFacade.find(id);
        if (e == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return e;

    }


    //1.creer un article
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Article createArticle(Article c) {
        System.out.println("createArticle "+c);
        articleFacade.create(c);
        return c;
    }


    //2.update un article
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Article updateArticle(@PathParam("id") Integer id, Article c) {

        Article c1=getArticleById(id);

        c1.setLibelle(c.getLibelle());
        c1.setDescription(c.getDescription());
        c1.setPrix_unitaire(c.getPrix_unitaire());

        c1.setQte_stock(c.getQte_stock());
        c1.setUnite(c.getUnite());

        articleFacade.edit(c1);

        return c1;

    }

    //lister les articles avec possibilite de paginer
    @GET
    @Path("/searchwithP")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Article> getArticles(@QueryParam("start") int start,
                                     @QueryParam("size") int size ){
        if(start > 0 && size > 0) {
            articleFacade.getAllArticlePaginated(start, size);
        }
        return articleFacade.findAll();
    }

    //supprimer un article
    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") Long id) {
        articleFacade.remove(id);
    }

}
