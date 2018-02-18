/**
 * IndicePeticiones.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.backoffice.clientesWs;

public interface IndicePeticiones extends java.rmi.Remote {
    public java.lang.String tratarPeticionER7(java.lang.String input) throws java.rmi.RemoteException;
    public java.lang.String tratarPeticionXML(java.lang.String input) throws java.rmi.RemoteException;
    public java.lang.String consultarPeticionesXML(java.lang.String input) throws java.rmi.RemoteException;
    public java.lang.String consultarPeticionesER7(java.lang.String input) throws java.rmi.RemoteException;
    public java.lang.String procesarMensaje(java.lang.String input) throws java.rmi.RemoteException;
}
