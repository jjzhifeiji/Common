package com.zhifeiji.common.savepdf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;

import com.zhifeiji.common.R;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SavePdf {

    private DecimalFormat df3 = new DecimalFormat("#0.000");

    public SavePdf() {
    }

    //  : 2019/5/27 保存pdf文件
    public String saveAllPdf(Context mContext, int num) {

        String name = "";
        SimpleDateFormat sTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String FileTime = sTimeFormat.format(new Date());//获取系统时间
        String pdfFolder = Environment.getExternalStorageDirectory() + "/" + name + FileTime.replace(":", "") + num + ".pdf";


        try {


            // 1.新建documnet对象
            Document doc = new Document(PageSize.A4, 0, 0, 30, 0);//SUPPRESS
            //建立一个书写器
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(pdfFolder));

            // 字体设置
            @SuppressLint("ResourceType") String yaHeiFontName = mContext.getResources().getString(R.raw.simsun);
            yaHeiFontName += ",1";
            BaseFont baseFont = BaseFont.createFont(yaHeiFontName, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            // 创建字体对象
            Font font = new Font(baseFont, 14, Font.NORMAL);//SUPPRESS
            Font font1 = new Font(baseFont, 16, Font.BOLD);//SUPPRESS
            Font font2 = new Font(baseFont, 21, Font.BOLD);//SUPPRESS

            //打开写入
            doc.open();

            /**
             *  添加3列表格
             */
            PdfPTable table = new PdfPTable(3);//SUPPRESS

            // 设置各列列宽
            table.setTotalWidth(new float[]{100, 100, 100});//SUPPRESS

            // 添加表格内容
            PdfPCell pCell = new PdfPCell(new Paragraph("产品检测报告", font2));
            pCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            pCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pCell.setRowspan(2);//SUPPRESS
            pCell.setColspan(3);//SUPPRESS
            pCell.setMinimumHeight(30);//SUPPRESS
            table.addCell(pCell);

//            table.addCell(mergeCol("基本信息", font, 3));//SUPPRESS
//            table.addCell(getPDFCell("检验单位", font));
//            table.addCell(mergeCol(selDataDaos.get(0).getJianyandanwei(), font, 3));//SUPPRESS
//            table.addCell(getPDFCell("受检(使用)单位", font));
//            table.addCell(mergeCol(selDataDaos.get(0).getShiyongdanwei(), font, 3));//SUPPRESS
//            table.addCell(getPDFCell("计量证书", font));
//            table.addCell(mergeCol(selDataDaos.get(0).getJiliangzhengshu(), font, 3));//SUPPRESS
//            table.addCell(getPDFCell("电梯出厂编号", font));
//            table.addCell(mergeCol(selDataDaos.get(0).getShebeibianhao(), font, 3));//SUPPRESS
//            table.addCell(getPDFCell("检验人员", font));
//            table.addCell(mergeCol(selDataDaos.get(0).getJianyanrenyuan(), font, 3));//SUPPRESS
//            table.addCell(getPDFCell("检测时间", font));
//            table.addCell(mergeCol(selDataDaos.get(0).getJianceshijian(), font, 3));//SUPPRESS
//            table.addCell(getPDFCell("联系方式", font));
//            table.addCell(mergeCol(selDataDaos.get(0).getLianxifangshi(), font, 3));//SUPPRESS
//            table.addCell(getPDFCell(" 地  址 ", font));
//            table.addCell(mergeCol(selDataDaos.get(0).getDizhi(), font, 3));//SUPPRESS

            doc.add(table);

            doc.add(nullLine(font, 90));
            doc.add(titleLine("检测数据", font));


//------------------------------------------------ --数据start---------------------------------------------------------------------------------

//            if (D4Daos.size() > 0) {
//                doc.add(nullLine(font, 90));
//
//                doc.add(titleLine("电梯制定距离", font1));
//
//                // 标题
//                PdfPTable table1 = new PdfPTable(3);//SUPPRESS
//                table1.setTotalWidth(new float[]{50, 100, 100});//SUPPRESS
//                table1.addCell(getPDFCell("序号", font));
//                table1.addCell(getPDFCell("检测项", font));
//                table1.addCell(getPDFCell("数据", font));
//                doc.add(table1);
//
//                //内容
//                for (int i = 0; i < D4Daos.size(); i++) {
//
//                    PdfPTable table21 = new PdfPTable(3);//SUPPRESS
//                    // 设置各列列宽
//                    table21.setTotalWidth(new float[]{50, 100, 100});//SUPPRESS
//
//                    table21.addCell(mergeRow(i + 1 + "", font, 1));
//
//
//                    table21.addCell(getPDFCell("制动距离", font));
//                    table21.addCell(getPDFCell(df3.format(D4Daos.get(i).getCureqc()), font));
//
//                    doc.add(table21);
//
//                }
//
//            }
//-----------------------------------------------------额载制停距离--数据end---------------------------------------------------------------------------------

            //-----------------------------------------------------检规----------------------------------------------------------------------------------------------


            doc.add(nullLine(font, 90));
            doc.add(titleLine("电梯监督检验和定期检验规则", font));
            doc.add(nullLine(font, 90));
            doc.add(nullLine(font, 90));


//-----------------------------------------------------检规----------------------------------------------------------------------------------------------
            Paragraph end2 = new Paragraph("检验单位", font);
            end2.setFirstLineIndent(90);//SUPPRESS
            Paragraph end1 = new Paragraph("   年  月  日", font);
            end1.setFirstLineIndent(90);//SUPPRESS
            doc.add(end2);
            doc.add(end1);

            //关闭文档
            doc.close();
            //关闭书写器
            writer.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pdfFolder;

    }

    //空行
    public static Paragraph nullLine(Font font, int i) {

        Paragraph nullline = new Paragraph("     ", font);
        nullline.setPaddingTop(i);//SUPPRESS
        return nullline;
    }

    //标题
    public static PdfPTable titleLine(String name, Font font) {

        PdfPTable tablecenter = new PdfPTable(3);//SUPPRESS
        try {
            tablecenter.setTotalWidth(new float[]{100, 100, 100});//SUPPRESS
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        PdfPCell pCell1 = new PdfPCell(new Paragraph(name, font));
        pCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        pCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pCell1.setRowspan(2);//SUPPRESS
        pCell1.setColspan(3);//SUPPRESS
        pCell1.setMinimumHeight(30);//SUPPRESS
        tablecenter.addCell(pCell1);
        return tablecenter;
    }

    //内容
    public static PdfPTable contentLine(String name, Font font) {

        PdfPTable tablecenter = new PdfPTable(3);//SUPPRESS
        try {
            tablecenter.setTotalWidth(new float[]{100, 100, 100});//SUPPRESS
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        PdfPCell pCell1 = new PdfPCell(new Paragraph(name, font));
        pCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        pCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pCell1.setRowspan(2);//SUPPRESS
        pCell1.setColspan(3);//SUPPRESS
        pCell1.setMinimumHeight(30);//SUPPRESS
        tablecenter.addCell(pCell1);
        return tablecenter;
    }

    //合并行的静态函数
    public static PdfPCell mergeRow(String str, Font font, int i) {

        //创建单元格对象，将内容及字体传入
        PdfPCell cell = new PdfPCell(new Paragraph(str, font));
        //设置单元格内容居中
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        //将该单元格所在列包括该单元格在内的i行单元格合并为一个单元格
        cell.setRowspan(i);

        return cell;
    }

    //合并列的静态函数
    public static PdfPCell mergeCol(String str, Font font, int i) {

        PdfPCell cell = new PdfPCell(new Paragraph(str, font));
        cell.setMinimumHeight(25);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        //将该单元格所在行包括该单元格在内的i列单元格合并为一个单元格
        cell.setColspan(i);

        return cell;
    }

    //获取指定内容与字体的单元格
    public static PdfPCell getPDFCell(String string, Font font) {
        //创建单元格对象，将内容与字体放入段落中作为单元格内容
        PdfPCell cell = new PdfPCell(new Paragraph(string, font));

        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

        //设置最小单元格高度
        cell.setMinimumHeight(25);
        return cell;
    }


}
