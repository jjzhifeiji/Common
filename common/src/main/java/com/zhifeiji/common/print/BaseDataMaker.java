package com.zhifeiji.common.print;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * 测试数据生成器
 * 示例 实现PrintDataMaker
 * Created by liuguirong on 8/1/17.
 */

public class BaseDataMaker implements PrintDataMaker {

    private int width;
    private int height;
    private DecimalFormat df3 = new DecimalFormat("#0.000");

    public BaseDataMaker(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public List<byte[]> getPrintData(int type) {
        ArrayList<byte[]> data = new ArrayList<>();
        try {
//            PrinterWriter printer;
//            printer = new PrinterWriter58mm(height, width);
//            data.add(printer.getDataAndReset());
//            printer.setAlignCenter();
//            printer.print("检测数据");
//            printer.setAlignCenter();
//            printer.printLineFeed();
//            printer.printLineFeed();
////            printer.printInOneLine(" 地 址 ", daos.get(0).getDizhi(), 0);
////            printer.printInOneLine(" 地 址 ", daos.get(0).getDizhi(), 0);
//            printer.printLineFeed();
//            printer.printLine();
//
//            printer.setAlignLeft();
//
//            printer.setAlignCenter();
//            printer.printLineFeed();
//
////---------------------------------------------------空载制停距离----数据start---------------------------------------------------------------------------------
////            if (D1Daos.size() > 0) {
////
////                printer.setAlignCenter();
////                printer.print("- 平衡系数 8.5平衡系数试验C -");
////                printer.setAlignCenter();
////                printer.printLineFeed();
////                printer.printLineFeed();
////
////                printer.printInOneLine("序号", "检测项", "数据", 0);
////                printer.printLineFeed();
////                //内容
////                for (int i = 0; i < D1Daos.size(); i++) {
////                    printer.printLineFeed();
////                    printer.printInOneLine("  ", "上行速度", D1Daos.get(i).getUpspeed() + "m/s", 0);
////                    printer.printLineFeed();
////                    printer.printInOneLine("", "上行功率", D1Daos.get(i).getUpw() + "w", 0);
////                    printer.printLineFeed();
////                    printer.printInOneLine(i + 1 + " ", "下行速度", D1Daos.get(i).getDownspeed() + "m/s", 0);
////                    printer.printLineFeed();
////                    printer.printInOneLine(" ", "下行功率", D1Daos.get(i).getDownw() + "w", 0);
////                    printer.printLineFeed();
////                    printer.printInOneLine("", "平衡系数", df3.format(D1Daos.get(i).getEqc()) + "", 0);
////                    printer.printLineFeed();
////                    printer.printInOneLine("", "轿厢行程", D1Daos.get(i).getHight() + "", 0);
////                    printer.printLineFeed();
////                }
////                printer.printLineFeed();
////                printer.setAlignCenter();
////                printer.printLineFeed();
////            }
////-------------------------------------------------- --数据end---------------------------------------------------------------------------------
//
//            printer.printLine();
//            printer.setAlignCenter();
//            printer.printLineFeed();
//            printer.printLineFeed();
//            printer.printLineFeed();
//            printer.printLineFeed();
//            printer.printLineFeed();
//            printer.printLineFeed();
//            printer.feedPaperCutPartial();
//
//            data.add(printer.getDataAndClose());
            return data;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
