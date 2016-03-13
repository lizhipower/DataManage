package Infomations;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhiLI on 2016/3/1.
 */
public class ReadExcelRow {
    ArrayList<String> rowContentList = new ArrayList<String>();

    public ReadExcelRow(Sheet sheet, int rowNum) {
        int colNum = sheet.getColumns();
        Cell cell;
        for(int col = 0; col< colNum; col++) {
            cell = sheet.getCell(col, rowNum);
            String cellContent = cell.getContents();
//            cellContent =
            if (cellContent.equals("")) {
                cellContent = "need more information";
            }
            rowContentList.add(cellContent);
        }

    }

    public ArrayList<String> getRowContentList() {
        return rowContentList;
    }



}
