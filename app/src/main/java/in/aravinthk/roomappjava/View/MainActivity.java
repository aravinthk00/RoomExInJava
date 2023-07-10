package in.aravinthk.roomappjava.View;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.textfield.TextInputEditText;

import in.aravinthk.roomappjava.DataBase.Student;
import in.aravinthk.roomappjava.R;
import in.aravinthk.roomappjava.View.Adapter.StudentAdapter;
import in.aravinthk.roomappjava.ViewModel.StudentViewModel;
import in.aravinthk.roomappjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    ActivityMainBinding mainBinding;
    Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        context = getApplicationContext();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        StudentFragment studentFragment = new StudentFragment();
        transaction.add(mainBinding.fragmentConatiner.getId(),studentFragment,StudentFragment.TAG);
        transaction.addToBackStack(StudentFragment.TAG);
        transaction.commit();
    }

}
