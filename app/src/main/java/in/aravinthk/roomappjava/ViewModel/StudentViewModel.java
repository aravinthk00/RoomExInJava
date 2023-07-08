package in.aravinthk.roomappjava.ViewModel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import in.aravinthk.roomappjava.DataBase.Student;
import in.aravinthk.roomappjava.DataBase.StudentRepository;

public class StudentViewModel extends AndroidViewModel {

    private StudentRepository studentRepository;
    private final LiveData<List<Student>> listLiveData;

    public StudentViewModel(@NonNull Application application) {
        super(application);

        studentRepository = new StudentRepository(application);
        listLiveData = studentRepository.getStudentLiveData();

    }

    public LiveData<List<Student>> getListLiveData() {
        return listLiveData;
    }

    public void insertStudent(Student student){
        studentRepository.insertStudent(student);
    }
}
