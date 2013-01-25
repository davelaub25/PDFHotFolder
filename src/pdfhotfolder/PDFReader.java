/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package pdfhotfolder;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;

/**
 * First iText example: Hello World.
 */
public class PDFReader {

    /** Path to the resulting PDF file. */
    
    /**
     * Reads a PDF file
     //
     */
    public static void main(String args)
    	throws DocumentException, IOException {
    	new PDFReader().readPDF(args);
    }

    /**
     * Reads a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException 
     * @throws    IOException 
     */
    public static String readPDF(String filename)
	throws DocumentException, IOException {
        
        String firstPdf = null;
        
        PdfReader reader = new PdfReader(filename);
        Rectangle pageSize = reader.getPageSize(1);
        String pdfInfo;        
        pdfInfo = reader.getInfo().get("Facing Slip Info");
        Double facingSlips = Math.ceil(reader.getNumberOfPages() / 50);
        int numBundles = facingSlips.intValue();
        
        //Open reader for each facing slip.
        PdfReader reader2 = new PdfReader("M:\\LASER\\EDDM\\FacingSlips\\4.25X11_FacingSlip.pdf");
        PdfReader reader3 = new PdfReader("M:\\LASER\\EDDM\\FacingSlips\\6.25X9_FacingSlip.pdf");
        PdfReader reader4 = new PdfReader("M:\\LASER\\EDDM\\FacingSlips\\8.5X11_FacingSlip.pdf");
        PdfReader reader5 = new PdfReader("M:\\LASER\\EDDM\\FacingSlips\\12X15_FacingSlip.pdf");
                
        //Get page size for each facing slip
        Rectangle pageSize2 = reader2.getPageSize(1);
        Rectangle pageSize3 = reader3.getPageSize(1);
        Rectangle pageSize4 = reader4.getPageSize(1);
        Rectangle pageSize5 = reader5.getPageSize(1);
                
        System.out.println(pageSize2.toString());
        System.out.println(pageSize3.toString());
        System.out.println(pageSize4.toString());
        System.out.println(pageSize5.toString());
                
        if(pageSize.toString().equals(pageSize2.toString())){
            firstPdf = "M:\\LASER\\EDDM\\FacingSlips\\4.25X11_FacingSlip.pdf";
        }
        else if(pageSize.toString().equals(pageSize3.toString())){
            firstPdf = "M:\\LASER\\EDDM\\FacingSlips\\6.25X9_FacingSlip.pdf";
        }
        else if(pageSize.toString().equals(pageSize4.toString())){
            firstPdf = "M:\\LASER\\EDDM\\FacingSlips\\8.5X11_FacingSlip.pdf";
        }
        else if(pageSize.toString().equals(pageSize5.toString())){
            firstPdf = "M:\\LASER\\EDDM\\FacingSlips\\12X15_FacingSlip.pdf";
        }
        
        String secondPdf = filename;
        
        String fileNameOnly = new File(filename).getName();
        String dest = "C:\\TEST2\\Tester.pdf";
        int firstChunkSize = 1;
        int secondChunkSize = 50;
        merge.merger(firstPdf, secondPdf, dest, firstChunkSize, secondChunkSize);
        
        System.out.println(pdfInfo);
        
        return pdfInfo;
        
    }
}