package Infomations;

import jxl.*;
import net.sf.json.JSONArray;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by ZhiLI on 2016/3/1.
 */
public class ReadExcel {
    private Set<InfoClass> infoGrade = new HashSet<InfoClass>();

    public ReadExcel(String fileDir) {
        Sheet gradeInfoSheet;
        Workbook gradeInfosBook;

        ArrayList<String> headers = new ArrayList<String>();
        try {
            gradeInfosBook = Workbook.getWorkbook(new File(fileDir));

            gradeInfoSheet = gradeInfosBook.getSheet(0);

            ArrayList<String> rowContentListTemp = new ArrayList<String>();
            ArrayList<ExcelRow> rowList = new ArrayList<ExcelRow>();

            Map<String, Object> gradeInfos = new HashMap<String, Object>();

            System.out.println("gradeInfoSheet " + gradeInfoSheet.getRows());
            for (int rowNum = 1; rowNum<gradeInfoSheet.getRows(); rowNum++){
                ReadExcelRow rowContent = new ReadExcelRow(gradeInfoSheet, rowNum);
                rowContentListTemp = rowContent.getRowContentList();
                ExcelRow excelRow = new ExcelRow(rowContentListTemp);
                rowList.add(excelRow);

            }

            GradeInfoSet gradeInfoSet = new GradeInfoSet(rowList);

            infoGrade = gradeInfoSet.getGradeInfoSet();
            gradeInfosBook.close();
            System.out.println("parse Excel successfully");

        }
        catch (Exception e) {
            System.out.println("error ReadExcel");
        }
    }

    public Set<InfoClass> getInfoGrade() {
        return infoGrade;
    }

    public static void main(String[] args) throws IOException {

        String fileDir = "C:/JavaTest/UploadData/GradeInfo.xls";
        ReadExcel excel = new ReadExcel(fileDir);
        Set<InfoClass> infoGrade = new HashSet<InfoClass>();
        infoGrade = excel.getInfoGrade();

        JSONArray array = new JSONArray();
        array = JSONArray.fromObject(infoGrade);
        System.out.println(array.toString());
//        while (it.hasNext()) {
//            jsonArray.put(it.next());
//        }
        System.out.println("parse Excel successfully");
    }
}
