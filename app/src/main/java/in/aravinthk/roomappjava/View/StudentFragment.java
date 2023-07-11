package in.aravinthk.roomappjava.View;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import in.aravinthk.roomappjava.DataBase.Student;
import in.aravinthk.roomappjava.R;
import in.aravinthk.roomappjava.View.Adapter.StudentAdapter;
import in.aravinthk.roomappjava.ViewModel.StudentViewModel;
import in.aravinthk.roomappjava.databinding.StudentFragmentBinding;

public class StudentFragment extends Fragment implements StudentAdapter.StudentItemClickListener {

    public static final String TAG = "StudentFragment";
    StudentFragmentBinding binding;
    Context context;
    StudentViewModel studentViewModel;
    StudentAdapter studentAdapter;
    StudentAdapter.StudentItemClickListener itemClickListener;

    List<Student> studentDataList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = StudentFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: ");
        super.onViewCreated(view, savedInstanceState);
        context = requireContext();

        getData();
        binding.fab.setOnClickListener(view1 -> {
            showDialog("add", 0);
        });
    }

    private void getData() {

        studentViewModel = ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())
                .create(StudentViewModel.class);

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(context));
        studentViewModel.getListLiveData().observe(getActivity(), studentList -> {

                    if (studentList != null && !studentList.isEmpty()) {
                        studentDataList = studentList;
                        for (Student s : studentList) {
                            Log.d("TAG", "getData: " + s.getRollNo());
                        }
                        studentAdapter = new StudentAdapter(context, studentList, this );
                        binding.recyclerview.setAdapter(studentAdapter);
                        studentAdapter.notifyDataSetChanged();
                    }
                }
        );
    }

    private void showDialog(String dialog_purpose, int position) {

        TextInputEditText student_roll_no_edit, student_name_edit, student_class_edit;
        Button add_student_button;
        ConstraintLayout editingContainer, viewContainer;
        TextView dialogStudentNameText, dialogStudentRollText, dialogStudentClassText;

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.add_student_dialog_layout, null);
        dialogBuilder.setView(dialogView);

        student_roll_no_edit = (TextInputEditText) dialogView.findViewById(R.id.rollNumberEdit);
        student_name_edit = (TextInputEditText) dialogView.findViewById(R.id.studentNameEdit);
        student_class_edit = (TextInputEditText) dialogView.findViewById(R.id.studentClassEdit);

        add_student_button = (Button) dialogView.findViewById(R.id.studentAddButton);

        editingContainer = (ConstraintLayout) dialogView.findViewById(R.id.editingContainer);
        viewContainer = (ConstraintLayout) dialogView.findViewById(R.id.viewContainer);

        dialogStudentNameText = (TextView) dialogView.findViewById(R.id.studentNameDialogText);
        dialogStudentRollText = (TextView) dialogView.findViewById(R.id.rollNumberDialogText);
        dialogStudentClassText = (TextView) dialogView.findViewById(R.id.studentClassDialogText);

        if (dialog_purpose.equalsIgnoreCase("add")) {
            editingContainer.setVisibility(View.VISIBLE);
            viewContainer.setVisibility(View.GONE);

        } else if (dialog_purpose.equalsIgnoreCase("view")) {
            editingContainer.setVisibility(View.GONE);
            viewContainer.setVisibility(View.VISIBLE);
        }

        add_student_button.setOnClickListener(view -> {
            Log.d("TAG", "showDialog: ");
            String student_name, student_roll_no, student_class;
            if (student_roll_no_edit.getText().toString().isEmpty()) {
                student_roll_no_edit.setError("Ender valid detail");
                return;
            }

            if (student_name_edit.getText().toString().isEmpty()) {
                student_name_edit.setError("Ender valid detail");
                return;
            }
            if (student_class_edit.getText().toString().isEmpty()) {
                student_class_edit.setError("Ender valid detail");
                return;
            }

            student_roll_no = student_roll_no_edit.getText().toString();
            student_name = student_name_edit.getText().toString();
            student_class = student_class_edit.getText().toString();

            Student student = new Student(Integer.parseInt(student_roll_no), student_name, Integer.parseInt(student_class), "A");
            studentViewModel.insertStudent(student);

            //getData();

        });

        Log.d(TAG, "showDialog: "+ studentDataList.get(position).getStudentName());
        dialogStudentNameText.setText(studentDataList.get(position).getStudentName());
        dialogStudentRollText.setText(String.valueOf(studentDataList.get(position).getRollNo()));
        dialogStudentClassText.setText(String.valueOf(studentDataList.get(position).getStudentClass()));

        dialogBuilder.create();
        dialogBuilder.show();

    }

    @Override
    public void studentItemClicked(int position) {
        try {
            showDialog("view", position);
        }catch (NullPointerException e){
            Log.d(TAG, "studentItemClicked: NullPointerException " + e);
        }

    }

    @Override
    public void studentUpdateItemClick(int position) {

    }

    @Override
    public void studentDeleteItemClick(int positon) {

    }
}
