package org.backoffice.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.backoffice.dao.CodigoRepository;
import org.backoffice.dao.ConfiguracionRepository;
import org.backoffice.model.Codigo;
import org.backoffice.model.Configuracion;
import org.backoffice.model.DatosSituacionActual;
import org.backoffice.model.MensajeConfirmacion;
import org.backoffice.model.MensajeHL7;
import org.backoffice.servicios.GeneracionHL7Service;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	private GeneracionHL7Service hl7Service;

	@Autowired
	public void setCService(GeneracionHL7Service hl7Service) {
		this.hl7Service = hl7Service;
	}

	@Autowired
	ConfiguracionRepository configuracionRepository;

	@Autowired
	CodigoRepository codigoRepository;

	@RequestMapping("/login")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);

		Configuracion nuevaConfiguracion = new Configuracion(new Long(500), "LOGIN", name);
		configuracionRepository.save(nuevaConfiguracion);

		for (Configuracion configuracion : configuracionRepository.findAll()) {
			System.out.println(configuracion);
		}

		return "login";
	}

	@RequestMapping("/menuprincipal")
	public String menuPrincipal(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);

		/*
		 * Codigo nuevoCodigo = new Codigo();
		 * 
		 * nuevoCodigo.setCodigo((new Integer ((new
		 * Random()).nextInt())).toString()); //nuevoCodigo.setCodigo("1");
		 * nuevoCodigo.setDescripcion("Descripcion " + (new
		 * Random()).nextInt()); //nuevoCodigo.setDescripcion("Descripcion 1");
		 * nuevoCodigo.setIdSistema("INFO33"); nuevoCodigo.setTipo("LAB");
		 * 
		 * codigoRepository.save(nuevoCodigo);
		 */

		for (Codigo codigoAll : codigoRepository.findAll()) {
			System.out.println(codigoAll);
		}

		return "menuprincipal";
	}

	@RequestMapping("/tabla")
	public String tabla(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {

		return "tabla";
	}

	@RequestMapping("/form")
	public String form(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {

		return "form";
	}

	@RequestMapping("/upload")
	public String upload(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {

		return "upload";
	}

	@RequestMapping("/generarInforme")
	public String generarInforme(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		return "generarInforme";
	}

	@RequestMapping("/mensajeOMLWizard")
	public String mensajeOMLWizard(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("mensajeHL7", new MensajeHL7());
		return "mensajeOMLWizard";
	}

	@RequestMapping(value = "/ResultadoMensajesHL7", method = RequestMethod.POST)
	public String ResultadoMensajesHL7(Model model, MensajeHL7 mensaje) {
		// mensaje.setMensaje(hl7Service.convertirMensajeOML(mensaje.getSistemaOrigen(),
		// mensaje.getSistemaDestino(), mensaje.getMensaje()));
		mensaje.setMensaje(hl7Service.convertirMensajeOML(mensaje));
		model.addAttribute("mensaje", mensaje);
		return "ResultadoMensajesHL7";
	}

	@PostMapping("/confirmacionInforme") // //new annotation since 4.3
	public String confirmacionInforme(@RequestParam("file") MultipartFile file, Model model,
			RedirectAttributes redirectAttributes, HttpServletRequest request,
			MensajeConfirmacion mensajeConfirmacion) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadStatus";
		}
		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();

			InputStream fichero = new ByteArrayInputStream(bytes);

			String nombreFichero = file.getOriginalFilename();
			mensajeConfirmacion.setMensaje(nombreFichero);

			// Blank Document
			XWPFDocument document = new XWPFDocument();

			// Write the Document in file system
			FileOutputStream out = new FileOutputStream(new File("D://TEMP//OUT_Prueba_poi.docx"));

			// Write first Text in the beginning
			XWPFParagraph para = document.createParagraph();
			XWPFRun run = para.createRun();
			run.setText("Hi");

			// create table
			XWPFTable table = document.createTable();

			table.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(500));

			// create first row
			XWPFTableRow tableRowOne = table.getRow(0);
			tableRowOne.getCell(0).setText("col one, row one");
			tableRowOne.addNewTableCell().setText("col two, row one");
			tableRowOne.addNewTableCell().setText("col three, row one");

			// create second row
			XWPFTableRow tableRowTwo = table.createRow();
			tableRowTwo.getCell(0).setText("col one, row two");
			tableRowTwo.getCell(1).setText("col two, row two");
			tableRowTwo.getCell(2).setText("col three, row two");

			// create third row
			XWPFTableRow tableRowThree = table.createRow();
			tableRowThree.getCell(0).setText("col one, row three");
			tableRowThree.getCell(1).setText("col two, row three");
			tableRowThree.getCell(2).setText("col three, row three");

			XWPFParagraph para2 = document.createParagraph();
			XWPFRun run2 = para2.createRun();
			run2.setText("Bye");

			// Create a new table with 6 rows and 3 columns
			int nRows = 6;
			int nCols = 3;

			XWPFTable tableConFormato = document.createTable(nRows, nCols);

			// Set the table style. If the style is not defined, the table style
			// will become "Normal".
			CTTblPr tblPr = tableConFormato.getCTTbl().getTblPr();
			CTString styleStr = tblPr.addNewTblStyle();
			styleStr.setVal("StyledTable");

			// Get a list of the rows in the table
			List<XWPFTableRow> rows = tableConFormato.getRows();
			int rowCt = 0;
			int colCt = 0;
			for (XWPFTableRow row : rows) {
				// get table row properties (trPr)
				CTTrPr trPr = row.getCtRow().addNewTrPr();
				// set row height; units = twentieth of a point, 360 = 0.25"
				CTHeight ht = trPr.addNewTrHeight();
				ht.setVal(BigInteger.valueOf(360));

				// get the cells in this row
				List<XWPFTableCell> cells = row.getTableCells();
				// add content to each cell
				for (XWPFTableCell cell : cells) {
					// get a table cell properties element (tcPr)
					CTTcPr tcpr = cell.getCTTc().addNewTcPr();
					// set vertical alignment to "center"
					CTVerticalJc va = tcpr.addNewVAlign();
					va.setVal(STVerticalJc.CENTER);

					CTTblWidth tblWidth = table.getRow(0).getCell(0).getCTTc().addNewTcPr().addNewTcW();
					tblWidth.setW(BigInteger.valueOf(2 * 1440));
					// STTblWidth.DXA is used to specify width in twentieths of
					// a point.
					tblWidth.setType(STTblWidth.DXA);

					// create cell color element
					CTShd ctshd = tcpr.addNewShd();
					ctshd.setColor("auto");
					ctshd.setVal(STShd.CLEAR);
					if (rowCt == 0) {
						// header row
						ctshd.setFill("A7BFDE");
					} else if (rowCt % 2 == 0) {
						// even row
						ctshd.setFill("D3DFEE");
					} else {
						// odd row
						ctshd.setFill("EDF2F8");
					}

					// get 1st paragraph in cell's paragraph list
					XWPFParagraph paraConFormato = cell.getParagraphs().get(0);
					// create a run to contain the content
					XWPFRun rh = paraConFormato.createRun();
					// style cell as desired
					if (colCt == nCols - 1) {
						// last column is 10pt Courier
						rh.setFontSize(10);
						rh.setFontFamily("Courier");
					}
					if (rowCt == 0) {
						// header row
						rh.setText("header row, col " + colCt);
						rh.setBold(true);
						para.setAlignment(ParagraphAlignment.CENTER);
					} else {
						// other rows
						rh.setText("row " + rowCt + ", col " + colCt);
						para.setAlignment(ParagraphAlignment.LEFT);
					}
					colCt++;
				} // for cell
				colCt = 0;
				rowCt++;
			} // for row

			document.write(out);
			out.close();

			/*
			 * WordprocessingMLPackage wordMLPackage =
			 * WordprocessingMLPackage.createPackage();
			 * 
			 * String outputfilepath = "D://TEMP/" + "/OUT_Prueba.docx";
			 * 
			 * wordMLPackage.getMainDocumentPart().addParagraphOfText("x");
			 * wordMLPackage.getMainDocumentPart().addParagraphOfText("x");
			 * wordMLPackage.getMainDocumentPart().addParagraphOfText(
			 * nombreFichero);
			 * 
			 * // create a table int writableWidthTwips =
			 * wordMLPackage.getDocumentModel().getSections().get(0).
			 * getPageDimensions() .getWritableWidthTwips(); Tbl tbl =
			 * TblFactory.createTable(3, 3, writableWidthTwips / 3);
			 * tbl.getTblGrid().getGridCol();
			 * 
			 * 
			 * Tr headerRow = (Tr) tbl.getContent().get(0);
			 * 
			 * int f = 0; for (Column column : tableDef.getColumns()) { Tc
			 * column = (Tc) headerRow.getContent().get(f); f++; Text text =
			 * factory.createText(); text.setValue(column.getName()); R run =
			 * factory.createR(); run.getContent().add(text);
			 * column.getContent().add(run); headerRow.getContent().add(column);
			 * }
			 * 
			 * wordMLPackage.getMainDocumentPart().addObject(tbl);
			 * 
			 * SaveToZipFile saver = new SaveToZipFile(wordMLPackage);
			 * saver.save(outputfilepath);
			 */

		} catch (IOException e) {
			mensajeConfirmacion.setMensaje(e.getMessage());
			mensajeConfirmacion.setExcepcion(e);
			e.printStackTrace();
		} /*
			 * catch (InvalidFormatException e) {
			 * mensajeConfirmacion.setMensaje(e.getMessage());
			 * mensajeConfirmacion.setExcepcion(e); e.printStackTrace(); } catch
			 * (Docx4JException e) {
			 * mensajeConfirmacion.setMensaje(e.getMessage());
			 * mensajeConfirmacion.setExcepcion(e); e.printStackTrace(); }
			 */
		model.addAttribute("mensaje", mensajeConfirmacion);
		return "confirmacionInforme";
	}

	@RequestMapping("/codigos")
	public String codigos(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("codigosExistentes", codigoRepository.findAll());
		return "codigos";
	}

	@RequestMapping("/formulariocodigo")
	public String formulariocodigo(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model, Codigo datosCodigo) {
		model.addAttribute("datosCodigo", datosCodigo);
		return "formulariocodigo";
	}

	@RequestMapping(value = "/GrabarCodigo", method = RequestMethod.POST)
	public String grabarExamen(Model model, Codigo datosCodigo, MensajeConfirmacion mensajeConfirmacion) {

		try {
			codigoRepository.save(datosCodigo);
			mensajeConfirmacion.setMensaje("Insercion correcta");
		} catch (Exception e) {
			mensajeConfirmacion.setMensaje(e.getMessage());
			mensajeConfirmacion.setExcepcion(e);
			e.printStackTrace();
		}

		model.addAttribute("mensaje", mensajeConfirmacion);
		return "resultadoCodigo";
	}

	@RequestMapping("/situacionActual")
	public String situacionActual(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model, DatosSituacionActual datos) {
		// model.addAttribute("datos", datosCodigo);
		return "situacionActual";
	}

}
