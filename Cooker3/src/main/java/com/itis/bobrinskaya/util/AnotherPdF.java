package com.itis.bobrinskaya.util;

import com.itis.bobrinskaya.model.Orders;
import com.itis.bobrinskaya.model.Productinorder;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.function.Function;

/**
 * Created by Ekaterina on 07.05.2016.
 */

@Component
public class AnotherPdF implements Function<Orders, Document> {
    /**
     * Applies this function to the given argument.
     *
     * @param order the function argument
     * @return the function result
     */
    private Font font;
    @Override
    public Document apply(Orders order) {

        Document document = new Document(PageSize.A4);
        document.addAuthor("Катя");
        document.addTitle("appointment number " + order.getId());

        try {
            String fontpath = "C:\\Users\\Ekaterina\\IdeaProjects\\Cooker3\\src\\main\\webapp\\fonts\\arial.ttf";
            BaseFont helvetica = BaseFont.createFont(fontpath, "cp1251", BaseFont.EMBEDDED);
            font = new Font(helvetica, 10, Font.NORMAL);
            String path = "C:\\Users\\Ekaterina\\IdeaProjects\\Cooker3\\src\\main\\java\\com\\itis\\bobrinskaya\\util\\";
            PdfWriter.getInstance(document, new FileOutputStream(  path + order.getId() + ".pdf"));
            document.open();

            Paragraph paragraph1 = new Paragraph(Element.ALIGN_RIGHT, "Заказ № " + order.getId(), font);
            Paragraph paragraph5 = new Paragraph(Element.ALIGN_RIGHT, "Дата: " + order.getDate(), font);
            Paragraph paragraph2 = new Paragraph(Element.ALIGN_RIGHT, "Клиент: " + order.getUser().getLogin(), font);
            Paragraph paragraph3 = new Paragraph(Element.ALIGN_RIGHT, "Адрес: " + order.getAddress(), font);
            Paragraph paragraph4 = new Paragraph(Element.ALIGN_RIGHT, "Примечание: " + order.getNote(), font);
            PdfPTable table = new PdfPTable(2);
            PdfPCell header1 = new PdfPCell(new Phrase("Наименование", font));
            PdfPCell header3 = new PdfPCell(new Phrase("Цена", font));
            header1.setHorizontalAlignment(Element.ALIGN_LEFT);
            header3.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(header1);
            table.addCell(header3);
            Collection<Productinorder> products = order.getProductinorderList();
            for (Productinorder product : products) {
                table.addCell(new PdfPCell(new Phrase(product.getProduct().getName(), font)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(product.getProduct().getPrice()), font)));
            }
            document.add(paragraph1);
            addEmptyParagraph(document);
            addEmptyParagraph(document);
            document.add(paragraph5);
            addEmptyParagraph(document);
            document.add(paragraph2);
            addEmptyParagraph(document);
            document.add(paragraph3);
            addEmptyParagraph(document);
            document.add(paragraph4);
            addEmptyParagraph(document);
            document.add(table);
            addEmptyParagraph(document);
            Paragraph total = new Paragraph("Итого: " + order.getPrice(),font);
            document.add(total);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return document;
    }

    private void addTableLine(PdfPTable table, String name, String info) {
        PdfPCell cell;
        cell = new PdfPCell(new Phrase(name, font));
        cell.setColspan(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(info, font));
        cell.setColspan(2);
        table.addCell(cell);
    }

    private static void addEmptyParagraph(Document document) throws DocumentException {
        document.add(new Paragraph("            "));
    }
}
