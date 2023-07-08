package in.aravinthk.roomappjava.View;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import in.aravinthk.roomappjava.R;
import in.aravinthk.roomappjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        context = getApplicationContext();
        mainBinding.fab.setOnClickListener( view -> {
            showDialog();
        });
    }

    private void showDialog() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.add_student_dialog_layout, null);
        dialogBuilder.setView(dialogView);

        TextInputEditText student_roll_no_edit = (TextInputEditText) dialogView.findViewById(R.id.rollNumberEdit);
        TextInputEditText student_name_edit = (TextInputEditText) dialogView.findViewById(R.id.studentNameEdit);
        TextInputEditText student_class_edit = (TextInputEditText) dialogView.findViewById(R.id.studentClassEdit);

        Button add_student_button = (Button) dialogView.findViewById(R.id.studentAddButton);

        add_student_button.setOnClickListener(view -> {
            Log.d("TAG", "showDialog: ");
        });

        dialogBuilder.create();
        dialogBuilder.show();


    }
}
