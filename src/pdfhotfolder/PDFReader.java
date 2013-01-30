
package pdfhotfolder;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.util.StringUtils;
import java.io.File;


public class PDFReader {

    public static void main(String args)
    	throws DocumentException, IOException, Exception {
    	new PDFReader().readPDF(args);
    }

    /**
     * @param filename the path to the new PDF document
     * @throws    DocumentException 
     * @throws    IOException 
     */
    public static String readPDF(String filename)
	throws DocumentException, IOException, Exception {
        
        String firstPdf = null;
        
        PdfReader reader = new PdfReader(filename);
        Rectangle pageSize = reader.getPageSize(1);
        String pdfInfo;        
        pdfInfo = reader.getInfo().get("Facing Slip Info");
        String[] values = StringUtils.commaDelimitedListToStringArray(pdfInfo);
        
        Double facingSlips = Math.ceil(reader.getNumberOfPages() / 50);
        int numBundles = facingSlips.intValue();
        
        //Open reader for each facing slip.
        PdfReader reader2 = new PdfReader("M:\\LASER\\EDDM\\FacingSlips\\4.25X11_FacingSlip.pdf");
        PdfReader reader3 = new PdfReader("M:\\LASER\\EDDM\\FacingSlips\\6.25X9_FacingSlip.pdf");
        PdfReader reader4 = new PdfReader("M:\\LASER\\EDDM\\FacingSlips\\8.5X11_FacingSlip.pdf");
        PdfReader reader5 = new PdfReader("M:\\LASER\\EDDM\\FacingSlips\\12X15_FacingSlip.pdf");
                
        //Get page size for each facing slip
        Rectangle pageSize1 = reader2.getPageSize(1);
        Rectangle pageSize2 = reader3.getPageSize(1);
        Rectangle pageSize3 = reader4.getPageSize(1);
        Rectangle pageSize4 = reader5.getPageSize(1);
        
        
        String formSize = null;
        String one = pageSize1.toString();
        String dest = null;
        String fileNameOnly = new File(filename).getName();
        String secondPdf = filename;
        
        if(pageSize.toString().equals(pageSize1.toString())){
            formSize = "1";
            firstPdf = "M:\\LASER\\EDDM\\FacingSlips\\4.25X11_FacingSlip.pdf";
            dest = "C:\\TEST2\\4.25x11\\" + fileNameOnly;
        }
        else if(pageSize.toString().equals(pageSize2.toString())){
            formSize = "2";
            firstPdf = "M:\\LASER\\EDDM\\FacingSlips\\6.25X9_FacingSlip.pdf";
            dest = "C:\\TEST2\\6.25x9\\" + fileNameOnly;
        }
        else if(pageSize.toString().equals(pageSize3.toString())){
            formSize = "3";
            firstPdf = "M:\\LASER\\EDDM\\FacingSlips\\8.5X11_FacingSlip.pdf";
            dest = "C:\\TEST2\\8.5x11\\" + fileNameOnly;
        }
        else if(pageSize.toString().equals(pageSize4.toString())){
            formSize = "4";
            firstPdf = "M:\\LASER\\EDDM\\FacingSlips\\12X15_FacingSlip.pdf";
            dest = "C:\\TEST2\\12x15\\" + fileNameOnly;            
        }
        
        int firstChunkSize = 1;
        int secondChunkSize = 50;
        String zip = "1";
        String[] zips = {"1"};
        String route = "1";
        String deliverType = "1";
                    
        //merge.merger(firstPdf, secondPdf, dest, zip, route, deliverType, firstChunkSize, secondChunkSize);
        
        Schedule.main(zips);
        
        System.out.println(pdfInfo);
        
        return pdfInfo;        
    }
}