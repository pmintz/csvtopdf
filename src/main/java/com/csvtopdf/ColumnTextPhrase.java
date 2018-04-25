package com.csvtopdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

 

public class ColumnTextPhrase {
 
    public static final String SRC = "C:\\resources\\pdfs\\hello.pdf";
    public static final String DEST = "c:\\dev\\column_text_phrase.pdf";
 
    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        new ColumnTextPhrase().manipulatePdf(SRC, DEST);
    }
 
    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
       // PdfReader reader = new PdfReader(src);
        //PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    	FileOutputStream fs = new FileOutputStream(dest);
    	Document doc = new Document();
    	PdfWriter writer = PdfWriter.getInstance(doc, fs);
    	doc.open();
        PdfContentByte cb = writer.getDirectContent();
        ColumnText ct = new ColumnText(cb);
        ct.setSimpleColumn(120f, 48f, 200f, 600f);
        Font f = new Font();
        Paragraph pz = new Paragraph(new Phrase(20, "Hello World!", f));
        ct.addElement(pz);
        ct.go();
        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA_BOLD, "Cp1252", BaseFont.EMBEDDED);
        f = new Font(bf, 13);
        ct = new ColumnText(cb);
        ct.setSimpleColumn(350f, 500f, 200f, 800f);
        pz = new Paragraph ("Hello World!", f);
        ct.addElement(pz);
        ct.go();
        doc.close();
        //stamper.close();
        //reader.close();
    }
}
