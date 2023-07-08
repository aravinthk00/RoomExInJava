package in.aravinthk.roomappjava.DataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentRepository {

    StudentDao studentDao;
    private LiveData<List<Student>> studentLiveData;

    public StudentRepository(Application application){
        StudentRoomDataBase student_room_db = StudentRoomDataBase.getDatabase(application);
        studentDao = student_room_db.studentDao();
        studentLiveData = studentDao.getStudentDataOrder();

    }

    public LiveData<List<Student>> getStudentLiveData() {
        return studentLiveData;
    }

    public void insertStudent(Student student){
        StudentRoomDataBase.databaseStudentExecutor.execute( () ->{
            studentDao.insertStudent(student);
        });
    }
}
