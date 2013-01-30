/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfhotfolder;

import com.itextpdf.text.DocumentException;
import java.io.IOException;

/**
 *
 * @author dlaub
 */
public class PdfHotFolder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DocumentException, Exception {
        String[] dir;
        dir = new String[1];
        dir[0]= "C:\\test";
        WatchDir.main(dir);
    }
}
