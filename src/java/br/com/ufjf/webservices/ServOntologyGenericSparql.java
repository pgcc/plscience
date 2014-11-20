/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.webservices;

import javax.jws.WebService;

/**
 *
 * @author vitorfs
 */
@WebService(serviceName = "ServOntologyGenericSparql", portName = "ServOntologyGenericSparqlPort", endpointInterface = "br.com.ufjf.webservice.servontologygenericsparql.ServOntologyGenericSparql", targetNamespace = "http://servontologygenericsparql.webservice.ufjf.com.br/", wsdlLocation = "WEB-INF/wsdl/ServOntologyGenericSparql/192.241.177.47_8080/plscience-ws/ServOntologyGenericSparql.wsdl")
public class ServOntologyGenericSparql {

    public java.lang.String returnGenericSparql(java.lang.String urlOntologia, java.lang.String sparql) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.String hello(java.lang.String name) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
