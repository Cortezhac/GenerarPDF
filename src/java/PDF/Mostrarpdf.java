/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = ("/pdf"))
public class Mostrarpdf extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/pdf");
        OutputStream salida = response.getOutputStream();//nombre del pdf

        try {

            try {
                Document Documento = new Document();
                PdfWriter.getInstance(Documento, salida);
                Documento.open();// abrir documento
                // Metadatos
                Documento.addAuthor("Irvin Cortez OwO");
                Documento.addCreator("Irvin Cortez");
                Documento.addSubject("Usando itext OwO");
                Documento.addKeywords("7u7, PDF, iText, OwO, UwU");
                
                Paragraph titulo = new Paragraph();
                Paragraph parrafo = new Paragraph(); // objeto parrafo contiene el string
                // Propiedades de la fuente
                Font font_titulo = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD, BaseColor.BLACK);
                Font font_parrafos = new Font(Font.FontFamily.COURIER, 11,Font.NORMAL, BaseColor.DARK_GRAY);
                // Agregar texto
                titulo.add(new Phrase("Reporte con itextpdf",font_titulo));
                titulo.setAlignment(Element.ALIGN_CENTER);
                // agregar saltos de linea
                titulo.add(new Phrase(Chunk.NEWLINE));
                titulo.add(new Phrase(Chunk.NEWLINE));
                Documento.add(titulo); // Agregar el elemento al pdf
                parrafo.setAlignment(Element.ALIGN_JUSTIFIED);
                parrafo.add(new Phrase("Lista de usuarios disponibles de la base de datos", font_parrafos));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                Documento.add(parrafo);// Agregar elemento al pdf

                //Agregar tabla
                PdfPTable tabla = new PdfPTable(2);// Columnas
                //                                           texto      fuente
                PdfPCell celda1 = new PdfPCell(new Paragraph("Codigo", FontFactory.getFont("Arial Black",12,BaseColor.ORANGE)));
                PdfPCell celda2 = new PdfPCell(new Paragraph("Nombre", FontFactory.getFont("Arial Black",12,BaseColor.ORANGE)));
                PdfPCell celda3 = new PdfPCell(new Paragraph("0123456788", FontFactory.getFont("Arial Black",12,BaseColor.BLACK)));
                PdfPCell celda4 = new PdfPCell(new Paragraph("Rojas", FontFactory.getFont("Arial Black",12,BaseColor.BLACK)));
                
                celda1.setPaddingBottom(5);// padding
                celda3.setPaddingBottom(5);// padding
                //Agregar celdas a la tabla aconsejo usar un bucle para esto
                tabla.addCell(celda1);
                tabla.addCell(celda2);
                tabla.addCell(celda3);
                tabla.addCell(celda4);
                
                
                Documento.add(tabla);// Meter al documento
                Documento.close();// no olvidar cerrar el doc
            } catch (DocumentException e) {
                System.out.println("Uff que hiciste perro " + e);
            }
            
        } finally{
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
