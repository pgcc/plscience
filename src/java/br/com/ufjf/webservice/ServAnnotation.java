/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.webservice;

import javax.jws.WebService;

/**
 *
 * @author vitorfs
 */
@WebService(serviceName = "ServAnnotation", portName = "ServAnnotationPort", endpointInterface = "br.com.ufjf.webservice.servannotation.ServAnnotation", targetNamespace = "http://servannotation.webservice.ufjf.com.br/", wsdlLocation = "WEB-INF/wsdl/ServAnnotation/localhost_8080/plscience-ws/ServAnnotation.wsdl")
public class ServAnnotation {

    public java.lang.String hello(java.lang.String name) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.String fullNotesXML(java.lang.String description, int idRationale) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
