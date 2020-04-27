package pdfOps;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;

public class mergePDFs { 
	
	public mergePDFs() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException
	{
		File outPDFFile = new File("./output/mergedPDF.pdf"); 
		try{	
			
			File dir = new File("./output/unitFiles");
			File[] srcFiles = dir.listFiles();
			PdfWriter writer = new PdfWriter(outPDFFile); 
			PdfDocument pdf = new PdfDocument(writer);
			PdfMerger merger = new PdfMerger(pdf);
			for (int i=0; i< srcFiles.length; i++) {
				PdfDocument temp = new PdfDocument(new PdfReader(dir.toString() + "/" + srcFiles[i].getName()));
				merger.merge(temp, 1, temp.getNumberOfPages());
				temp.close();
			    }
			System.out.println("Successfully Merged Documents!!!");
			pdf.close();
			}
		catch(IOException ioe) {
			    System.out.println("Caught IOException: " + ioe.getMessage());
			    }
		catch(Exception e) {
		    System.out.println("Caught IOException: " + e.getMessage());
		    }
	}

}
