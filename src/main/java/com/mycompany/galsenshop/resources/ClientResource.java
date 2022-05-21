/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galsenshop.resources;

import com.mycompany.galsenshop.entity.Client;
import com.mycompany.galsenshop.facade.ClientFacade;

import javax.ws.rs.*;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author Diarra
 */
@Path("clients")
public class ClientResource {

    @EJB
    private ClientFacade clientFacade;



    // Lister les clients
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Client> getClients() {

        return clientFacade.findAll();
    }



    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, "ept/client"})
    public Client getClientById(@PathParam("id") Integer id) {
        Client e = clientFacade.find(id);
        if (e == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return e;

    }


    //1.creer une client
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Client createClient(Client c) {
        System.out.println("createClient "+c);
        clientFacade.create(c);
        return c;
    }




    //2.update un client
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Client updateClient(@PathParam("id") Integer id, Client c) {

        Client c1=getClientById(id);

        c1.setNom(c.getNom());

        clientFacade.edit(c1);

        return c1;

    }

    //supprimer un client
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        clientFacade.remove(id);
    }


    //rechercher un client a partir de son numero
    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Client> findClientByNum(@QueryParam("text") String searchText) {
        return clientFacade.findClientByNum(searchText);
    }

    //lister les clients avec possibilite de paginer
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Client> getClients(@QueryParam("start") int start,
                                     @QueryParam("size") int size ){
        if(start > 0 && size > 0) {
            clientFacade.getAllClientPaginated(start, size);
        }
        return clientFacade.findAll();
    }


}
