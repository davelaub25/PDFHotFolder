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
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author dlaub
 */
public class PDFWriter {
    
    
    public PdfImportedPage write(PdfImportedPage pageIn) throws IOException, DocumentException{
        PdfReader reader = new PdfReader();
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        AcroFields form = stamper.getAcroFields();
        form.setField("text_1", "Bruno Lowagie");
        form.setField("text_2", "bruno");
        form.setField("text_3", "12345678", "xxxxxxxx");
        form.setFieldProperty("text_4", "textsize", new Float(12), null);
        form.regenerateField("text_4");
        stamper.close();
        reader.close();
        return pageIn;
    }
}
