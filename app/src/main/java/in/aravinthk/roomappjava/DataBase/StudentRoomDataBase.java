package in.aravinthk.roomappjava.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class StudentRoomDataBase extends RoomDatabase {

    public abstract StudentDao studentDao();

    private static volatile StudentRoomDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseStudentExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static StudentRoomDataBase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (StudentRoomDataBase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            StudentRoomDataBase.class,
                            "student_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
