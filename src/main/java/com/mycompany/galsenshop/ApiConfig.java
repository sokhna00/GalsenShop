/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galsenshop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author DIARRA
 */

@OpenAPIDefinition(info
        = @Info(
                title = "GalsenShop Rest API",
                version = "1.0",
                description = "Projet GalsenSHop By SOKHNA DIARRA DIOP",
                license = @License(name = "Apache 2.0", url = "http://foo.bar"),
                contact = @Contact(url = "https://ept.sn", name = "Sokhna DIARRA DIOP", email = "dsokhnadiarra.sn")
        )
)

@ApplicationPath("api")
public class ApiConfig extends Application{
    
}
