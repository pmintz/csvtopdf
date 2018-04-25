package com.csvtopdf;

	 
	import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
	import com.itextpdf.text.Paragraph;
	import com.itextpdf.text.Rectangle;
	import com.itextpdf.text.pdf.ColumnText;
	import com.itextpdf.text.pdf.PdfContentByte;
	import com.itextpdf.text.pdf.PdfReader;
	import com.itextpdf.text.pdf.PdfStamper;
	import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
	import java.io.FileOutputStream;
	import java.io.IOException;

	public class ColumnsAndRectangles{
	 
	    public static final String SRC = "c:\\dev\\ColumnsAndRectangles.pdf";
	    public static final String DEST = "c:\\dev\\ColumnsAndRectanglesResults.pdf";
	    public static void main(String[] args) throws IOException, DocumentException {
	        File file = new File(DEST);
	        file.getParentFile().mkdirs();
	        new ColumnsAndRectangles().manipulatePdf(SRC, DEST);
	    }
	 
	    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
	    	FileOutputStream fs = new FileOutputStream(dest);
	    	Document doc = new Document();
	    	PdfWriter writer = PdfWriter.getInstance(doc, fs);
	    	doc.open();
	        PdfContentByte cb = writer.getDirectContent();
	        PdfTemplate xobject = cb.createTemplate(80, 120);
	        ColumnText column = new ColumnText(xobject);
	        column.setSimpleColumn(new Rectangle(80, 120));
	        column.addElement(new Paragraph("Mike paragraph"));
	        column.go();
	        cb.addTemplate(xobject, 1, 700);
	        double angle = Math.PI / 4;
	        cb.addTemplate(xobject,
	                (float)Math.cos(angle), -(float)Math.sin(angle),
	                (float)Math.cos(angle), (float)Math.sin(angle),
	                150, 600);
	        doc.close();
	    }
	 
	}
