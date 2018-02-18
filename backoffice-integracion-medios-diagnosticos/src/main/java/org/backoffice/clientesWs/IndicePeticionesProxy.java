package org.backoffice.clientesWs;

public class IndicePeticionesProxy implements org.backoffice.clientesWs.IndicePeticiones {
  private String _endpoint = null;
  private org.backoffice.clientesWs.IndicePeticiones indicePeticiones = null;
  
  public IndicePeticionesProxy() {
    _initIndicePeticionesProxy();
  }
  
  public IndicePeticionesProxy(String endpoint) {
    _endpoint = endpoint;
    _initIndicePeticionesProxy();
  }
  
  private void _initIndicePeticionesProxy() {
    try {
      indicePeticiones = (new org.backoffice.clientesWs.IndicePeticionesPortBindingQSServiceLocator()).getIndicePeticionesPortBindingQSPort();
      if (indicePeticiones != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)indicePeticiones)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)indicePeticiones)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (indicePeticiones != null)
      ((javax.xml.rpc.Stub)indicePeticiones)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.backoffice.clientesWs.IndicePeticiones getIndicePeticiones() {
    if (indicePeticiones == null)
      _initIndicePeticionesProxy();
    return indicePeticiones;
  }
  
  public java.lang.String tratarPeticionER7(java.lang.String input) throws java.rmi.RemoteException{
    if (indicePeticiones == null)
      _initIndicePeticionesProxy();
    return indicePeticiones.tratarPeticionER7(input);
  }
  
  public java.lang.String tratarPeticionXML(java.lang.String input) throws java.rmi.RemoteException{
    if (indicePeticiones == null)
      _initIndicePeticionesProxy();
    return indicePeticiones.tratarPeticionXML(input);
  }
  
  public java.lang.String consultarPeticionesXML(java.lang.String input) throws java.rmi.RemoteException{
    if (indicePeticiones == null)
      _initIndicePeticionesProxy();
    return indicePeticiones.consultarPeticionesXML(input);
  }
  
  public java.lang.String consultarPeticionesER7(java.lang.String input) throws java.rmi.RemoteException{
    if (indicePeticiones == null)
      _initIndicePeticionesProxy();
    return indicePeticiones.consultarPeticionesER7(input);
  }
  
  public java.lang.String procesarMensaje(java.lang.String input) throws java.rmi.RemoteException{
    if (indicePeticiones == null)
      _initIndicePeticionesProxy();
    return indicePeticiones.procesarMensaje(input);
  }
  
  
}