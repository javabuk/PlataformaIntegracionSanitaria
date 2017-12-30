package org.backoffice.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.backoffice.fuentedatos.CodigoDTO;
import org.backoffice.fuentedatos.CorrelacionDTO;
import org.backoffice.fuentedatos.DetectorDuplicados;
import org.backoffice.fuentedatos.FicheroHojaCalculo;
import org.backoffice.servicios.CorrelacionesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {

	Logger logger = LoggerFactory.getLogger(UploadController.class);

	// Save the uploaded file to this folder
	private static String UPLOADED_FOLDER = "D://temp//";

	private CorrelacionesService correlacionesService;

	@Autowired
	public void setCorrelacionesService(CorrelacionesService correlacionesService) {
		this.correlacionesService = correlacionesService;
	}

	@RequestMapping("/uploadFile")
	public String tabla(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		return "uploadFile";
	}

	/*
	 * @PostMapping("/recuperarSQL") public String recuperarSQL(Model model) {
	 * 
	 * return "Esto es un dato de prueba"; }
	 */

	@PostMapping("/uploadFichero") // //new annotation since 4.3
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes,
			HttpServletRequest request) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadStatus";
		}
		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();

			InputStream fichero = new ByteArrayInputStream(bytes);

			FicheroHojaCalculo ficheroHojaCalculo = new FicheroHojaCalculo(fichero);
			DetectorDuplicados detectorDuplicados = new DetectorDuplicados();

			List<CodigoDTO> codigos = ficheroHojaCalculo.recuperarCodigos("INFO33", "LAB");

			List<CodigoDTO> codigosSinDuplicados = detectorDuplicados.eliminarDuplicados(codigos);
			System.out.println("Total sin duplicados: " + codigosSinDuplicados.size());
			System.out.println("Total con duplicados: " + codigos.size());
			StringBuffer buffer = new StringBuffer();

			// Calculamos los duplicados
			List<CodigoDTO> codigosDuplicados = detectorDuplicados.buscarDuplicados(codigos);
			System.out.println("Total duplicados: " + codigosDuplicados.size());
			// codigosDuplicados.removeAll(codigosSinDuplicados);

			List<CodigoDTO> codigosB = ficheroHojaCalculo.recuperarCodigosB("INFO33", "LAB");
			List<CodigoDTO> codigosBSinDuplicados = detectorDuplicados.eliminarDuplicados(codigosB);
			List<CodigoDTO> codigosBDuplicados = detectorDuplicados.buscarDuplicados(codigosB);
			List<CodigoDTO> codigosBErroneos = codigosB.stream().filter(cod -> "No valido".equals(cod.getCodigo()))
					.collect(Collectors.toList());

			List<CorrelacionDTO> correlaciones = ficheroHojaCalculo.recuperarCorrelaciones("INFO33", "LAB", "MEDIKOSTA",
					"LAB");

			for (Iterator iterator = codigos.iterator(); iterator.hasNext();) {
				CodigoDTO codigoDTO = (CodigoDTO) iterator.next();
				buffer.append(codigoDTO.toString() + "-");
			}

			List<CodigoDTO> codigosErroneos = codigos.stream().filter(cod -> "No valido".equals(cod.getCodigo()))
					.collect(Collectors.toList());
			System.out.println("Total erroneos: " + codigosErroneos.size());

			/*
			 * //Create Workbook instance holding reference to .xlsx file
			 * XSSFWorkbook workbook = new XSSFWorkbook(fichero);
			 * 
			 * //Get first/desired sheet from the workbook XSSFSheet sheet =
			 * workbook.getSheetAt(0);
			 * 
			 * //Iterate through each rows one by one Iterator<Row> rowIterator
			 * = sheet.iterator(); StringBuffer buffer = new StringBuffer(); int
			 * contador = 0; while (rowIterator.hasNext()) { Row row =
			 * rowIterator.next(); if(contador>0){
			 * buffer.append(row.getCell(0).getNumericCellValue() + ","); }
			 * contador++; }
			 */
			/*
			 * Path path = Paths.get(UPLOAED_FOLDER +
			 * file.getOriginalFilename()); Files.write(path, bytes);
			 * 
			 * redirectAttributes.addFlashAttribute("message",
			 * "You successfully uploaded '" + file.getOriginalFilename() +
			 * "'");
			 */
			redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + buffer.toString() + "'");
			redirectAttributes.addFlashAttribute("codigos", codigosSinDuplicados);
			redirectAttributes.addFlashAttribute("codigosSinDuplicados", codigosSinDuplicados);
			redirectAttributes.addFlashAttribute("codigosDuplicados", codigosDuplicados);
			redirectAttributes.addFlashAttribute("codigosErroneos", codigosErroneos);

			redirectAttributes.addFlashAttribute("totalCodigos", codigosSinDuplicados.size());
			redirectAttributes.addFlashAttribute("totalCodigosSinDuplicados", codigosSinDuplicados.size());
			redirectAttributes.addFlashAttribute("totalCodigosDuplicados", codigosDuplicados.size());
			redirectAttributes.addFlashAttribute("totalCodigosErroneos", codigosErroneos.size());

			redirectAttributes.addFlashAttribute("codigosB", codigosB);
			redirectAttributes.addFlashAttribute("codigosBSinDuplicados", codigosBSinDuplicados);
			redirectAttributes.addFlashAttribute("codigosBDuplicados", codigosBDuplicados);
			redirectAttributes.addFlashAttribute("codigosBErroneos", codigosBErroneos);

			redirectAttributes.addFlashAttribute("totalCodigosB", codigosB.size());
			redirectAttributes.addFlashAttribute("totalCodigosBSinDuplicados", codigosBSinDuplicados.size());
			redirectAttributes.addFlashAttribute("totalCodigosBDuplicados", codigosBDuplicados.size());
			redirectAttributes.addFlashAttribute("totalCodigosBErroneos", codigosBErroneos.size());

			redirectAttributes.addFlashAttribute("correlaciones", correlaciones);

			redirectAttributes.addFlashAttribute("CodigosASQL",
					correlacionesService.generarSentenciasSQLCodigos(codigosSinDuplicados));
			redirectAttributes.addFlashAttribute("CodigosBSQL",
					correlacionesService.generarSentenciasSQLCodigos(codigosBSinDuplicados));
			redirectAttributes.addFlashAttribute("CorrelacionesSQL",
					correlacionesService.generarSentenciasSQLCorrelaciones(correlaciones));

			request.getSession().setAttribute("correl", correlaciones);
			request.getSession().setAttribute("sesionCodigosA", codigosSinDuplicados);
			request.getSession().setAttribute("sesionCodigosB", codigosBSinDuplicados);

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		// return "redirect:/uploadStatus";
		// return "redirect:/ventanaModalCodigos";
		return "redirect:/tablaCodigos";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

	@GetMapping("/ventanaModalCodigos")
	public String ventanaModalCodigos() {
		return "ventanaModalCodigos";
	}

	@GetMapping("/tablaCodigos")
	public String tablaCodigos() {
		return "tablaCodigos";
	}

}
