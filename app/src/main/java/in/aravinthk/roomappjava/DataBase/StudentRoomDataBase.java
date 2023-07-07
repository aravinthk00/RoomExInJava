package in.aravinthk.roomappjava.DataBase;

import androidx.room.Database;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class StudentRoomDataBase {
}
