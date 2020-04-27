package pdfOps; 

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import com.itextpdf.html2pdf.*;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.styledxmlparser.jsoup.nodes.Document;
import com.itextpdf.layout.* ;

public class Generate { 

	public Generate() { 
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File htmlFile = new File("./template/SampleHTML.html");
		File pdfFile = new File("./output/outPDF.pdf"); 
		
		try {
			//createPdf(htmlFile,pdfFile); 
			PdfDocument pdfDocument = new PdfDocument(new PdfWriter(pdfFile));
			pdfDocument.setDefaultPageSize(PageSize.LEGAL);
			Document document = HtmlConverter.convertToDocument(new FileInputStream(htmlFile), pdfDocument, new ConverterProperties());
			document.close();
			System.out.println("Successfully generated a PDF from a HTML!!!");

		} catch (IOException ioe) {
			 System.out.println("Caught IOException: " + ioe.getMessage().toString());
		}
		

	}
	
	public static void createPdf(File htmlFile, File pdfFile) throws IOException {
        HtmlConverter.convertToPdf(htmlFile, pdfFile);
    }

}
