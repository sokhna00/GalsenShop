/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galsenshop.resources;


import com.mycompany.galsenshop.entity.Categorie;
import com.mycompany.galsenshop.facade.CategorieFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Diarra
 
 */
@Path("categories")
public class CategorieResource {
    
    @EJB
    private CategorieFacade categorieFacade;
    
    
     
    // Lister les categories
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categorie> getCategories() {
        
        return categorieFacade.findAll();
    }
    
   
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, "ept/categorie"})
    public Categorie getCategorieById(@PathParam("id") Integer id) {
        Categorie e = categorieFacade.find(id);
        if (e == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return e;
        
    }
    
    
    //1.creer une categorie
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Categorie createCategorie(Categorie c) {
        System.out.println("createCategorie "+c);
        categorieFacade.create(c);
        return c;
    }
    
    
    
    
    //2.update une cateogorie
     @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Categorie updateCategorie(@PathParam("id") Integer id, Categorie c) {
        
        Categorie c1=getCategorieById(id);
        
        c1.setLibelle(c.getLibelle());
        
        categorieFacade.edit(c1);
        
        return c1;
        
    }

    //supprimer une categorie
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        categorieFacade.remove(id);
    }

    
    //rechercher une categorie
    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categorie> findCategorie(@QueryParam("text") String searchText) {
        return categorieFacade.findCategorie(searchText);
    }
    
    
    
    
    
    
    
}
