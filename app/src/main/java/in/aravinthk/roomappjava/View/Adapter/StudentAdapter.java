package in.aravinthk.roomappjava.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.aravinthk.roomappjava.DataBase.Student;
import in.aravinthk.roomappjava.R;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    Context context;
    List<Student> studentList;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {

        holder.rollNo.setText(studentList.get(position).getRollNo());
        holder.studentName.setText(studentList.get(position).getStudentName());
        holder.studentClass.setText(studentList.get(position).getStudentClass());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView rollNo;
        TextView studentName;
        TextView studentClass;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            rollNo = itemView.findViewById(R.id.rollNumberText);
            studentName = itemView.findViewById(R.id.studentNameText);
            studentClass = itemView.findViewById(R.id.studentClassText);

        }
    }
}
