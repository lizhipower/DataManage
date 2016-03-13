package Infomations;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;

/**
 * Created by ZhiLI on 2016/3/1.
 */
public class ExcelRow {
    //    班级 人数 班长 手机 短号 邮件 年级 专业
    private String className, classNum, classMonitor,
            monitorTelLong, monitorTelShort, monitorMail, grade, major;
    private int id;
    private static  int rowID = 1;
    public ExcelRow(ArrayList<String> rowString) {
        this.className = rowString.get(0);
        this.classNum = rowString.get(1);
        this.classMonitor = rowString.get(2);
        this.monitorTelLong = rowString.get(3);
        this.monitorTelShort = rowString.get(4);
        this.monitorMail = rowString.get(5);
        this.grade = rowString.get(6);
        this.major = rowString.get(7);
        this.id = rowID++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public static int getRowID() {
        return rowID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getClassMonitor() {
        return classMonitor;
    }

    public void setClassMonitor(String classMonitor) {
        this.classMonitor = classMonitor;
    }

    public String getMonitorTelLong() {
        return monitorTelLong;
    }

    public void setMonitorTelLong(String monitorTelLong) {
        this.monitorTelLong = monitorTelLong;
    }

    public String getMonitorTelShort() {
        return monitorTelShort;
    }

    public void setMonitorTelShort(String monitorTelShort) {
        this.monitorTelShort = monitorTelShort;
    }

    public String getMonitorMail() {
        return monitorMail;
    }

    public void setMonitorMail(String monitorMail) {
        this.monitorMail = monitorMail;
    }
}
