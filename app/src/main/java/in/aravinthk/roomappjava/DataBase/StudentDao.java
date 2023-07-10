package in.aravinthk.roomappjava.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertStudent(Student studentData);

//    @Update
//    void updateStudent(Student studentData);
//
//    @Query("SELECT * FROM STUDENT_TABLE")
//    //void getStudentData();

    @Query("SELECT * FROM STUDENT_TABLE ORDER BY Roll_No ASC")
    LiveData<List<Student>> getStudentDataOrder();

//    @Query("DELETE FROM STUDENT_TABLE")
//    void deleteAll();

}
