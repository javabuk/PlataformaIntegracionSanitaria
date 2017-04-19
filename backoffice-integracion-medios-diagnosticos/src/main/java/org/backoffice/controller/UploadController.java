package org.backoffice.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Controller
public class UploadController {

	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D://temp//";

    
    @RequestMapping("/uploadFile")
    public String tabla(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        return "uploadFile";
    }
	
	@PostMapping("/uploadFichero") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            
            
            
            InputStream fichero = new ByteArrayInputStream(bytes);
            
          //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(fichero);
            
          //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            StringBuffer buffer = new StringBuffer();
            int contador = 0;
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                if(contador>0){
                	buffer.append(row.getCell(0).getNumericCellValue() + ",");
                }
                contador++;
            }
            /*Path path = Paths.get(UPLOAED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");*/
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + buffer.toString() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}
