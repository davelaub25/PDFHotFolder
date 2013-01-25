/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pdfhotfolder;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Dave
 */
public class merge{public static String RESULT;
    public static String duplex;
    public static String filename;
    public static String filePath;
    public static String temp = "c:/temp.pdf";
    /**
     * Merges pages from two PDFs in specified intervals
     * @param firstPdf the path of the first PDF to pull pages from
     * @param secondPdf the path of the second PDF to pull pages from
     * @param dest the path of the resulting PDF
     * @param firstChunkSize the number of pages to pull at a time from the first PDF
     * @param secondChunkSize the number of pages to pull at a time from the second PDF
     * @throws IOException
     * @throws DocumentException
     * @throws SQLException
     */
    public static void merger(String firstPdf, String secondPdf, String dest, int firstChunkSize, int secondChunkSize)
        throws IOException, DocumentException {
        int totalChunkSize = firstChunkSize + secondChunkSize;
    	PdfReader reader1 = new PdfReader(firstPdf);
        PdfReader reader2 = new PdfReader(secondPdf);
        int firstTotal = reader1.getNumberOfPages();
        int secondTotal = reader2.getNumberOfPages();
        Double facingSlips = Math.ceil(secondTotal / 50 + 1);
        int facingSlipsReq = facingSlips.intValue();
        int combinedTotal = facingSlipsReq + secondTotal;
        Rectangle firstPageSize = reader1.getPageSize(1);
        //Rectangle secondPageSize = reader2.getPageSize(1);
        Document document;
        document = new Document(firstPageSize, 0, 0, 0, 0);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfContentByte cb = writer.getDirectContent();
        PdfImportedPage page;
        Rectangle currentSize;
        int firstPageGet = 0;
        int secondPageGet = 0;
        int firstNumPagesNsertd = 0;
        int secondNumPagesNsertd = 0;
        int totalNsertd = 0;
        for ( int i = 0; i < combinedTotal; i = totalNsertd ) {
            for ( int j = 0; j < firstChunkSize; j++ ){
                if( firstNumPagesNsertd == facingSlipsReq ){ break; }
                firstPageGet++;
                firstNumPagesNsertd++;
                document.newPage();   
                //currentSize = reader1.getPageSize( firstPageGet );
                page = writer.getImportedPage(reader1, 1);
                cb.addTemplate(page, 0, 0);
                }
            for ( int k = 0; k < secondChunkSize; k++ ){
                if( secondNumPagesNsertd == secondTotal ){ break; }
                secondPageGet++;
                document.newPage();   
                //currentSize = reader2.getPageSize( secondPageGet );
                page = writer.getImportedPage(reader2, (secondPageGet));
                cb.addTemplate(page, 0, 0);
                secondNumPagesNsertd++;
                }
            totalNsertd = firstNumPagesNsertd + secondNumPagesNsertd;
            }
        document.close();
    }
}
