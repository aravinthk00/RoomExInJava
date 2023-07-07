package in.aravinthk.roomappjava.DataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertStudent(Student studentData);

    @Update
    void updateStudent(Student studentData);

    @Query("SELECT * FROM STUDENT_TABLE")
    void getStudentData();

    @Query("SELECT * FROM STUDENT_TABLE ORDER BY Roll_No ASC")
    void getStudentDataOrder();


}
