package org.backoffice.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.backoffice.dao.CorrelacionRepository;
import org.backoffice.dao.SistemaRepository;
import org.backoffice.dao.TrazaRepository;
import org.backoffice.fuentedatos.DatosCodigoMorris;
import org.backoffice.fuentedatos.DatosListadoTrazasJSON;
import org.backoffice.fuentedatos.DatosListadoTrazasSistemaJSON;
import org.backoffice.model.BusquedaSistemas;
import org.backoffice.model.Codigo;
import org.backoffice.model.Correlacion;
import org.backoffice.model.DatosSituacionActual;
import org.backoffice.model.MensajeConfirmacion;
import org.backoffice.model.MensajeHL7;
import org.backoffice.model.Sistema;
import org.backoffice.model.SistemaOculto;
import org.backoffice.servicios.GeneracionHL7Service;
import org.backoffice.servicios.TrazasService;
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
import org.springframework.beans.factory.annotation.Value;
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
	private TrazasService trazasService;

	/* Recuperamos informacion del fichero de propiedades */
	@Value("${spring.profiles.active}")
	private String perfil;

	@Autowired
	public void setCService(GeneracionHL7Service hl7Service) {
		this.hl7Service = hl7Service;
	}

	@Autowired
	public void setTrazasService(TrazasService trazasService) {
		this.trazasService = trazasService;
	}

	@Autowired
	CodigoRepository codigoRepository;

	@Autowired
	TrazaRepository trazaRepository;

	@Autowired
	SistemaRepository sistemaRepository;

	@Autowired
	CorrelacionRepository correlacionRepository;

	@RequestMapping("/login")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);

		/*
		 * Configuracion nuevaConfiguracion = new Configuracion(new Long(500),
		 * "LOGIN", name); configuracionRepository.save(nuevaConfiguracion);
		 * 
		 * for (Configuracion configuracion : configuracionRepository.findAll())
		 * { System.out.println(configuracion); }
		 */
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
		 * 
		 * 
		 * for (Codigo codigoAll : codigoRepository.findAll()) {
		 * System.out.println(codigoAll); }
		 * 
		 * for (Traza trazaAll : trazaRepository.findAll()) {
		 * System.out.println(trazaAll); }
		 */
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

	@RequestMapping("/busquedaGeneral")
	public String busquedaGeneral(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		return "busquedaGeneral";
	}

	@RequestMapping("/mensajeOMLWizard")
	public String mensajeOMLWizard(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("mensajeHL7", new MensajeHL7());
		return "mensajeOMLWizard";
	}

	@RequestMapping(value = "/ResultadoMensajesHL7", method = RequestMethod.POST)
	public String ResultadoMensajesHL7(Model model, MensajeHL7 mensaje,
			@RequestParam(value = "busquedaPorDNI", required = false) String mensajeBusquedaPorDni) {
		// mensaje.setMensaje(hl7Service.convertirMensajeOML(mensaje.getSistemaOrigen(),
		// mensaje.getSistemaDestino(), mensaje.getMensaje()));
		mensaje.setMensaje(hl7Service.convertirMensajeOML(mensaje));
		mensajeBusquedaPorDni = hl7Service.generarConsultaPorDNI(mensaje);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("busquedaPorDNI", mensajeBusquedaPorDni);
		return "MensajesOML";
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

	@RequestMapping("/sistemas")
	public String sistemas(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model, HttpServletRequest request) {
		// if (!model.containsAttribute("sistemasExistentes")) {
		/*
		 * if (request.getSession().getAttribute("sistemasExistentes") != null)
		 * { model.addAttribute("sistemasExistentes",
		 * request.getSession().getAttribute("sistemasExistentes")); } else {
		 * model.addAttribute("sistemasExistentes",
		 * sistemaRepository.findAll()); } if
		 * (request.getSession().getAttribute("busquedaSistemasExistentes") !=
		 * null) { model.addAttribute("busquedaSistemasExistentes",
		 * request.getSession().getAttribute("busquedaSistemasExistentes")); }
		 * else { model.addAttribute("busquedaSistemasExistentes", new
		 * BusquedaSistemas("", "")); }
		 */
		request.getSession().setAttribute("sistemasExistentes", sistemaRepository.findAll());
		return "sistemas";
	}

	@RequestMapping("/buscarSistemas")
	public String buscarSistemas(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model, BusquedaSistemas datosSistema, HttpServletRequest request) {
		List<Sistema> resultados = null;
		if (datosSistema.getIdSistemaBusq() == null
				|| (datosSistema.getIdSistemaBusq() != null && datosSistema.getIdSistemaBusq().length() == 0)) {
			resultados = sistemaRepository.findByDescripcion(datosSistema.getDescripcionBusq());
		} else if (datosSistema.getDescripcionBusq() == null
				|| (datosSistema.getDescripcionBusq() != null && datosSistema.getDescripcionBusq().length() == 0)) {
			resultados = sistemaRepository.findByIdSistema(datosSistema.getIdSistemaBusq());
		} else {
			resultados = sistemaRepository.findSistemas(datosSistema.getIdSistemaBusq(),
					datosSistema.getDescripcionBusq());
		}

		model.addAttribute("sistemasExistentes", resultados);
		model.addAttribute("busquedaSistemasExistentes", datosSistema);
		request.getSession().setAttribute("sistemasExistentes", resultados);
		request.getSession().setAttribute("busquedaSistemasExistentes", datosSistema);
		return "busquedaSistemas";
	}

	@RequestMapping("/busquedaSistemas")
	public String busquedaSistemas(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model, BusquedaSistemas datosSistema, HttpServletRequest request) {

		if (request.getSession().getAttribute("sistemasExistentes") != null) {
			model.addAttribute("sistemasExistentes", request.getSession().getAttribute("sistemasExistentes"));
		} else {
			model.addAttribute("sistemasExistentes", sistemaRepository.findAll());
		}
		return "busquedaSistemas";
	}

	@RequestMapping("/modificarSistema")
	public String modificarSistema(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model, Sistema datosSistema) {

		try {
			sistemaRepository.save(datosSistema);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "sistemas";
	}

	@RequestMapping("/formulariocodigo")
	public String formulariocodigo(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model, Codigo datosCodigo) {
		model.addAttribute("datosCodigo", datosCodigo);
		return "formulariocodigo";
	}

	@RequestMapping("/formularioSistemas")
	public String formularioSistema(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model, Sistema datosSistema) {
		model.addAttribute("datosSistema", datosSistema);
		return "formularioSistemas";
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

	@RequestMapping(value = "/GrabarSistema", method = RequestMethod.POST)
	public String grabarSistema(Model model, Sistema datosSistema, MensajeConfirmacion mensajeConfirmacion) {

		try {
			sistemaRepository.save(datosSistema);
			mensajeConfirmacion.setMensaje("Insercion correcta");
		} catch (Exception e) {
			mensajeConfirmacion.setMensaje(e.getMessage());
			mensajeConfirmacion.setExcepcion(e);
			e.printStackTrace();
		}

		model.addAttribute("mensaje", mensajeConfirmacion);
		return "resultadoCodigo";
	}

	@RequestMapping(value = "/eliminarSistema", method = RequestMethod.POST)
	public String eliminarSistema(Model model, SistemaOculto datosSistema) {

		try {
			sistemaRepository.delete(datosSistema.getIdSistemaOculto());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sistemas";
	}

	@RequestMapping("/correlaciones")
	public String correlaciones(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model, HttpServletRequest request) {

		request.getSession().setAttribute("correlacionesExistentes", correlacionRepository.findAll());
		// model.addAttribute("correlacionesExistentes",
		// correlacionRepository.findAll());

		// return "correlaciones";
		return "redirect:correlacionesListado";
	}

	@RequestMapping("/correlacionesListado")
	public String correlacionesListado(

			@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model,
			HttpServletRequest request) {

		model.addAttribute("correlacionesExistentes", request.getSession().getAttribute("correlacionesExistentes"));
		return "correlaciones";
	}

	@RequestMapping("/formularioCorrelacion")
	public String formularioCorrelacion(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model,
			Correlacion datosCorrelacion) {
		model.addAttribute("datosCorrelacion", datosCorrelacion);
		return "formularioCorrelacion";
	}

	@RequestMapping(value = "/GrabarCorrelacion", method = RequestMethod.POST)
	public String grabarCorrelacion(Model model, Correlacion datosCorrelacion,
			MensajeConfirmacion mensajeConfirmacion) {

		try {
			correlacionRepository.save(datosCorrelacion);
			mensajeConfirmacion.setMensaje("Insercion correcta");
		} catch (Exception e) {
			mensajeConfirmacion.setMensaje(e.getMessage());
			mensajeConfirmacion.setExcepcion(e);
			e.printStackTrace();
		}

		model.addAttribute("mensaje", mensajeConfirmacion);
		return "resultadoCodigo";
	}

	@RequestMapping("/buscarCorrelacion")
	public String buscarCorrelacion(@RequestParam(value = "codigoABusqueda", required = false) String name, Model model,
			HttpServletRequest request) {
		// model.addAttribute("correlacionesExistentes",
		// correlacionRepository.findByCodigoA(name));
		request.getSession().setAttribute("correlacionesExistentes", correlacionRepository.findByCodigoA(name));

		return "redirect:correlacionesListado";
	}

	@RequestMapping("/situacionActual")
	public String situacionActual(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model, DatosSituacionActual datos) {
		// model.addAttribute("datos", datosCodigo);
		return "situacionActual";
	}

	@RequestMapping("/pruebas")
	public String pruebas(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		// model.addAttribute("datos", datosCodigo);
		return "ejemploTabla";
	}

	@RequestMapping("/resumen")
	public String resumen(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model, DatosSituacionActual datos) {

		List<Object[]> trazasSistema = trazaRepository.findTrazasPorDiaPorSistema();
		List<DatosListadoTrazasSistemaJSON> datosTrazasSistemaListado = new ArrayList<DatosListadoTrazasSistemaJSON>();
		for (Object[] datosListadoTrazasSistemaJSON : trazasSistema) {
			DatosListadoTrazasSistemaJSON datoTraza = new DatosListadoTrazasSistemaJSON();
			datoTraza.setTotal((Long) datosListadoTrazasSistemaJSON[0]);
			datoTraza.setLeyenda((String) datosListadoTrazasSistemaJSON[1]);
			datoTraza.setSistema((String) datosListadoTrazasSistemaJSON[2]);

			datosTrazasSistemaListado.add(datoTraza);
		}

		List<Object[]> trazas = trazaRepository.findTrazasPorDia();
		List<DatosListadoTrazasJSON> datosTrazasListado = new ArrayList<DatosListadoTrazasJSON>();

		for (Object[] datosListadoTrazasJSON : trazas) {
			DatosListadoTrazasJSON datoTraza = new DatosListadoTrazasJSON();
			datoTraza.setTotal((Long) datosListadoTrazasJSON[0]);
			datoTraza.setLeyenda((String) datosListadoTrazasJSON[1]);

			datosTrazasListado.add(datoTraza);
		}

		List<Object[]> resultados = codigoRepository.findDatosCodigos();

		List<DatosCodigoMorris> datosCodigos = new ArrayList<DatosCodigoMorris>();

		for (Object[] datosCodigosMorris : resultados) {

			DatosCodigoMorris datoCodigo = new DatosCodigoMorris();
			datoCodigo.value = (Long) datosCodigosMorris[0];
			datoCodigo.label = (String) datosCodigosMorris[1];

			datosCodigos.add(datoCodigo);
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		try {
			Date yesterday = dateFormat.parse(dateFormat.format(cal.getTime()));

			Timestamp ultimaSemana = new Timestamp(yesterday.getTime());
			Timestamp hoy = new Timestamp(System.currentTimeMillis());

			model.addAttribute("datosTrazas", trazaRepository.findTrazasEntreFechas(ultimaSemana, hoy));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		model.addAttribute("datosTrazasSistemaListado", datosTrazasSistemaListado);
		model.addAttribute("datosTrazasListado", datosTrazasListado);
		model.addAttribute("datosCodigos", datosCodigos);
		model.addAttribute("totalCodigos", codigoRepository.count());
		model.addAttribute("totalCorrelaciones", correlacionRepository.count());
		return "resumen";
	}

	@RequestMapping("/tablaTrazas")
	public String tablaTrazas(@RequestParam(value = "listaSistemas", required = false) String sistemaOrigen,
			Model model) {

		System.out.println("Sistema Origen " + sistemaOrigen);
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); // Time
		 * part // has // discarded Calendar cal = Calendar.getInstance();
		 * cal.add(Calendar.DATE, -1); try { Date yesterday =
		 * dateFormat.parse(dateFormat.format(cal.getTime()));
		 * 
		 * Timestamp ultimaSemana = new Timestamp(yesterday.getTime());
		 * Timestamp hoy = new Timestamp(System.currentTimeMillis());
		 * 
		 * model.addAttribute("datosSistemas", sistemaRepository.findAll());
		 * model.addAttribute("datosTrazas",
		 * trazaRepository.findTrazasEntreFechas(ultimaSemana, hoy));
		 * 
		 * } catch (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } // get yesterday's Date without time part
		 */

		model.addAttribute("datosSistemas", sistemaRepository.findAll());
		model.addAttribute("datosTrazas", trazasService.buscarTrazasPorSistemaYFechas(sistemaOrigen, null, null));

		return "tablaTrazas";
	}

}
