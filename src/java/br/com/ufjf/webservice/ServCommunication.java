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
@WebService(serviceName = "ServCommunication", portName = "ServCommunicationPort", endpointInterface = "br.com.ufjf.webservice.servcommunication.ServCommunication", targetNamespace = "http://servcommunication.webservice.ufjf.com.br/", wsdlLocation = "WEB-INF/wsdl/ServCommunication/localhost_8080/plscience-ws/ServCommunication.wsdl")
public class ServCommunication {

    public java.lang.String hello(java.lang.String name) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.String fullCommunicationXML(int idRationale, int idEmissor, int idReceptor, java.lang.String mensagem) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
