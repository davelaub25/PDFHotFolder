/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfhotfolder;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dlaub
 */
public class PDFWrite {
    
    
    public static void write(String pageIn) throws IOException, DocumentException{
        
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        PdfReader readIn = new PdfReader(pageIn);
        PdfStamper stamper = new PdfStamper(readIn, new FileOutputStream("M:\\LASER\\EDDM\\TEMP\\FS.pdf"));
        AcroFields form = stamper.getAcroFields();
        form.setField("zip", "19116");
        form.setField("routeNum", "C001");
        form.setField("date", date.toString());
        form.setField("totalPerBundle", "50");
        form.setField("bundleNum", "1");
        form.setField("bundleTotal", "10");
        stamper.setFormFlattening(true);
        stamper.close();
        readIn.close();
    }
}
