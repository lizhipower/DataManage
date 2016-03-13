package Infomations;

import java.util.*;

/**
 * Created by ZhiLI on 2016/3/2.
 */
public class GradeInfoSet {
    private Set<InfoClass> gradeInfoSet = new HashSet<InfoClass>();
    public GradeInfoSet(ArrayList<ExcelRow> excelList) {
        for (ExcelRow row : excelList) {
            String className, major, grade;
            String classMonitorName, classMonitorTelLong, classMonitorTelShort, classMonitorMail;

            major = row.getMajor();
            grade = row.getGrade();

            className = row.getClassName();
            classMonitorName = row.getClassMonitor();
            classMonitorTelLong = row.getMonitorTelLong();
            classMonitorTelShort = row.getMonitorTelShort();
            classMonitorMail = row.getMonitorMail();

            InfoClassMonitor classMonitor = new InfoClassMonitor(classMonitorName, classMonitorTelLong, classMonitorTelShort, classMonitorMail);
            InfoClass classInfo = new InfoClass(className, major, grade, classMonitor);

            gradeInfoSet.add(classInfo);
//            Object
//            gradeInfoSet.put(row)
        }
    }

    public Set<InfoClass> getGradeInfoSet() {
        return gradeInfoSet;
    }
}
