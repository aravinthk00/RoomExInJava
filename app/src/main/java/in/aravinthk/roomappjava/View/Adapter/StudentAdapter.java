package in.aravinthk.roomappjava.View.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.aravinthk.roomappjava.DataBase.Student;
import in.aravinthk.roomappjava.R;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    public static final String TAG = "StudentAdapter";
    Context context;
    List<Student> studentList;

    StudentItemClickListener itemClickListener;

    public StudentAdapter(Context context, List<Student> studentList, StudentItemClickListener itemClickListener) {
        this.context = context;
        this.studentList = studentList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        for (Student s: studentList){
            Log.d("TAG", "onBindViewHolder: " + s.getRollNo());
        }
        Log.d("TAG", "onBindViewHolder: "+ studentList.get(position).getRollNo());
        holder.rollNo.setText(String.valueOf(studentList.get(position).getRollNo()));
        holder.studentName.setText(studentList.get(position).getStudentName());
        holder.studentClass.setText(String.valueOf(studentList.get(position).getStudentClass()));

        holder.mainContainer.setOnClickListener(view -> {
            try {
                itemClickListener.studentItemClicked(position);
            } catch (NullPointerException e){
                Log.d(TAG, "studentItemClicked: NullPointerException " + e);
            }
        });

        holder.updateCompatButton.setOnClickListener(view -> itemClickListener.studentUpdateItemClick(position));

        holder.deleteCompatButton.setOnClickListener(view -> itemClickListener.studentDeleteItemClick(position));


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView rollNo;
        TextView studentName;
        TextView studentClass;
        ConstraintLayout updateButtonLayout, deleteButtonLayout, mainContainer;
        AppCompatImageButton updateCompatButton, deleteCompatButton;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            rollNo = itemView.findViewById(R.id.rollNumberText);
            studentName = itemView.findViewById(R.id.studentNameText);
            studentClass = itemView.findViewById(R.id.studentClassText);
            mainContainer = itemView.findViewById(R.id.mainContainer);
            updateButtonLayout = itemView.findViewById(R.id.updateButtonConstrainLayout);
            deleteButtonLayout = itemView.findViewById(R.id.deleteButtonConstrainLayout);
            updateCompatButton = itemView.findViewById(R.id.itemUpdateButton);
            deleteCompatButton = itemView.findViewById(R.id.itemDeleteButton);

        }
    }

    public interface StudentItemClickListener{
        void studentItemClicked(int position);

        void studentUpdateItemClick(int position);

        void studentDeleteItemClick(int positon);
    }
}
