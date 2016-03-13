package Infomations;

/**
 * Created by ZhiLI on 2016/3/2.
 */
public class InfoClass {
    private String className, majorName, grade;
    private InfoClassMonitor classMonitor;

    public InfoClass(String className, String majorName, String grade, InfoClassMonitor classMonitor) {
        this.className = className;
        this.majorName = majorName;
        this.grade = grade;
        this.classMonitor = classMonitor;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public InfoClassMonitor getClassMonitor() {
        return classMonitor;
    }

    public void setClassMonitor(InfoClassMonitor classMonitor) {
        this.classMonitor = classMonitor;
    }
}
