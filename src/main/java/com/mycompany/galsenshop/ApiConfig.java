/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galsenshop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Diarra
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Service web Galsen Shop",
                description = "Le service de la boutique Galsen SHOP",
                contact = @Contact(name = "Sokhna Diarra Diop", email = "dsokhnadiarra@ept.sn", url = "http://ept.sn")
        ),
        servers = @Server(
                url = "http://localhost:8080/GalsenShop/"
        )
        
)


@ApplicationPath("api")
public class ApiConfig extends Application {
    
    
    
}
