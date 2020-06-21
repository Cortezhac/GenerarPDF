/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOPersona;
import Model.Persona;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class ListarPDF extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("application/PDF");
        OutputStream salida = response.getOutputStream();
        try {
            Document PDF = new Document();
            PdfWriter.getInstance(PDF, salida);// LLama la documento
            PDF.open();
            // Crear Metadata
            PDF.addAuthor("Irvin Cortez");
            PDF.addCreator("itext Java 5.2");
            PDF.addHeader("BD Registrar Personas", "Lista de datos de la bd");
            PDF.addKeywords("Java, JSP, itext");
            // Fuentes
            Font fTitulos = new Font(Font.FontFamily.TIMES_ROMAN, 14,Font.BOLD,BaseColor.DARK_GRAY);
            Font fParrafos = new Font(Font.FontFamily.HELVETICA, 10,Font.NORMAL,BaseColor.DARK_GRAY);
            // Parrados 
            Paragraph Titulo = new Paragraph();
            Titulo.add(new Phrase("Registro Personas",fTitulos));
            Titulo.setAlignment(Chunk.ALIGN_CENTER);
            Titulo.add(Chunk.NEWLINE);
            Titulo.add(Chunk.NEWLINE);
            // Agregar
            PDF.add(Titulo);
            // Tabla
            PdfPTable tabla = new PdfPTable(3);
            PdfPCell celda = new PdfPCell();
            celda.setPaddingBottom(5);
            //Cabecera
            celda.setPhrase(new Paragraph("ID"));
            tabla.addCell(celda);
            celda.setPhrase(new Paragraph("NOMBRE"));
            tabla.addCell(celda);
            celda.setPhrase(new Paragraph("APELLIDO"));
            tabla.addCell(celda);
            //Cuerpo
            DAOPersona utilidades = new DAOPersona();
            List<Persona> registros = utilidades.listar();
            for(int i = 0; i < registros.size(); i++){
                Persona persona = registros.get(i);
                celda.setPhrase(new Paragraph(persona.getDui_persona()));
                tabla.addCell(celda);
                celda.setPhrase(new Paragraph(persona.getNombre_persona()));
                tabla.addCell(celda);
                celda.setPhrase(new Paragraph(persona.getApellidos_persona()));
                tabla.addCell(celda);
            }
            PDF.add(tabla);
            PDF.close();
        } catch (DocumentException e) {
            System.out.println("error" + e);
        }finally{
            
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
