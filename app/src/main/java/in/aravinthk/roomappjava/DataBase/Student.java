package in.aravinthk.roomappjava.DataBase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "STUDENT_TABLE")
public class Student {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name= "Roll_No")
    Integer rollNo;
    @ColumnInfo(name= "Student_Name")
    String studentName;
    @ColumnInfo(name= "Student_Class")
    Integer studentClass;
    @ColumnInfo(name= "Class_Sec")
    String classSec;

    public Student(@NonNull Integer rollNo, String studentName, Integer studentClass, String classSec) {
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.classSec = classSec;
    }

    @NonNull
    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(@NonNull Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(Integer studentClass) {
        this.studentClass = studentClass;
    }

    public String getClassSec() {
        return classSec;
    }

    public void setClassSec(String classSec) {
        this.classSec = classSec;
    }
}
