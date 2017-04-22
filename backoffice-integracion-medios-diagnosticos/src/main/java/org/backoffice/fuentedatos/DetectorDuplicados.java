package org.backoffice.fuentedatos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectorDuplicados {

	public List<CodigoDTO> findDuplicates(List<CodigoDTO> listContainingDuplicates)
	{ 
	  final Set<CodigoDTO> setToReturn = new HashSet(); 
	  final Set<CodigoDTO> set1 = new HashSet();

	  for (CodigoDTO yourInt : listContainingDuplicates)
	  {
	   if (!set1.add(yourInt))
	   {
	    setToReturn.add(yourInt);
	   }
	  }
	  
	  List<CodigoDTO> listaCodigosDuplicados = new ArrayList<CodigoDTO>();
	  listaCodigosDuplicados.addAll(setToReturn);
	  return listaCodigosDuplicados;
	}
	
	
	public List<CodigoDTO> eliminarDuplicadoss(List<CodigoDTO> listaOriginal){
		List<CodigoDTO> arrayList = new ArrayList<CodigoDTO>();
		Set<CodigoDTO> uniqueElements = new HashSet<CodigoDTO>(listaOriginal);
		arrayList.clear();
		arrayList.addAll(uniqueElements);
		return arrayList;
	}
	
	public List<CodigoDTO> eliminarDuplicados(List<CodigoDTO> listaOriginal){
		ArrayList<CodigoDTO> listaDuplicados = new ArrayList<CodigoDTO>();// unique
	    for (CodigoDTO codigo : listaOriginal) {
	    	if (!listaDuplicados.contains(codigo)) {
	    		listaDuplicados.add(codigo);
	        }
	    }
	    return listaDuplicados;
	}
	
	public List<CodigoDTO> buscarDuplicados(List<CodigoDTO> listaOriginal){
		ArrayList<CodigoDTO> listaDuplicados = new ArrayList<CodigoDTO>();// unique
		ArrayList<CodigoDTO> listaNoDuplicados = new ArrayList<CodigoDTO>();// unique
	    for (CodigoDTO codigo : listaOriginal) {
	    	if (!listaDuplicados.contains(codigo)) {
	    		listaDuplicados.add(codigo);
	        }else{
	        	listaNoDuplicados.add(codigo);
	        }
	    }
	    return listaNoDuplicados;
	}
	
}
