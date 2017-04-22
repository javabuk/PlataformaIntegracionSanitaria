package org.backoffice.fuentedatos;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FicheroHojaCalculo {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	public FicheroHojaCalculo(InputStream fichero) {
		try {
			workbook = new XSSFWorkbook(fichero);			
            sheet = workbook.getSheetAt(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<CodigoDTO> recuperarCodigos(String sistema, String tipo){
		
		ArrayList<CodigoDTO> resultados = new ArrayList<CodigoDTO>();
		
		//Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        
        int contador = 0;
        while (rowIterator.hasNext()) 
        {
            Row row = rowIterator.next();
            if(contador > 1){//OJO
            CodigoDTO codigo = new CodigoDTO();
            codigo.setSistema(sistema);
        	codigo.setTipo(tipo);
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) 
            {
            	Cell cell = cellIterator.next();
            	if(cell.getRowIndex()>1){
            		int indiceColumna = cell.getColumnIndex();
            		
            		if (indiceColumna == 0){
            			if(cell.getCellType()== Cell.CELL_TYPE_STRING){
            				codigo.setCodigo(cell.getStringCellValue());
            			}else{
            				codigo.setCodigo("No valido");
            			}
            		}else if(indiceColumna == 1){
            			if(cell.getCellType()== Cell.CELL_TYPE_STRING){
            				codigo.setDescripcion(cell.getStringCellValue());
            			}else{
            				codigo.setDescripcion("No es de tipo string");
            			}
            		}
            	}
            }
            /*
             * 
            String codigoA = "";
            String sistemaA = "";
            String tipoA = "";
            String codigoB = "";
            String sistemaB = "";
            String tipoB = "";
            while (cellIterator.hasNext()) 
            {
                
            	Cell cell = cellIterator.next();
            	if(cell.getRowIndex()>0){
            		int indiceColumna = cell.getColumnIndex();
            		if(indiceColumna == configuracion.getUbicacionCodigoA()){
            			switch (cell.getCellType()) 
            			{
            			case Cell.CELL_TYPE_NUMERIC:
            				codigoA = (new Integer((new Double(cell.getNumericCellValue())).intValue())).toString();
            				codigoA = obtenerCorrelacionCPTDeterminacion(configuracionAMedida,codigoA);
            				break;
            			case Cell.CELL_TYPE_STRING:
            				codigoA = cell.getStringCellValue();
            				codigoA = obtenerCorrelacionCPTDeterminacion(configuracionAMedida,codigoA);
            				break;
            			}
            			//break;            			
            		}
             * 
            
            
            // Evitamos la primera fila (con los titulos)
            if(contador>0){
            	codigo.setCodigo(row.getCell(0).getStringCellValue());
            	codigo.setDescripcion(row.getCell(1).getStringCellValue());
            	codigo.setSistema(sistema);
            	codigo.setTipo(tipo);
            }
             */
            
            resultados.add(codigo); 
            }
            contador++;
        }
		
		return resultados;
	}
	
	
public List<CodigoDTO> recuperarCodigosB(String sistema, String tipo){
		
		ArrayList<CodigoDTO> resultados = new ArrayList<CodigoDTO>();
		
		//Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        
        int contador = 0;
        while (rowIterator.hasNext()) 
        {
            Row row = rowIterator.next();
            if(contador > 1){//OJO
            CodigoDTO codigo = new CodigoDTO();
            codigo.setSistema(sistema);
        	codigo.setTipo(tipo);
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) 
            {
            	Cell cell = cellIterator.next();
            	if(cell.getRowIndex()>1){
            		int indiceColumna = cell.getColumnIndex();
            		
            		if (indiceColumna == 2){
            			if(cell.getCellType()== Cell.CELL_TYPE_STRING){
            				codigo.setCodigo(cell.getStringCellValue());
            			}else{
            				codigo.setCodigo("No valido");
            			}
            		}else if(indiceColumna == 3){
            			if(cell.getCellType()== Cell.CELL_TYPE_STRING){
            				codigo.setDescripcion(cell.getStringCellValue());
            			}else{
            				codigo.setDescripcion("No es de tipo string");
            			}
            		}
            	}
            }
            
            
            resultados.add(codigo); 
            }
            contador++;
        }
		
		return resultados;
	}
	
	
}
