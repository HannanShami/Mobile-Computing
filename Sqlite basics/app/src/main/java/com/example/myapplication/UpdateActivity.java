package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    Button update,homebtn;
    EditText studentName, studentRollNo;
    Switch enrollSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        update = findViewById(R.id.updatebtn);
        homebtn = findViewById(R.id.backbtn);
        studentName = findViewById(R.id.editTextTextStudentName);
        studentRollNo = findViewById(R.id.editTextTextStudentRollNo);
        enrollSwitch = findViewById(R.id.switch1);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            Intent intent=getIntent();
            String roll = intent.getStringExtra("RollNumber");
            StudentModel studentModel;
            @Override
            public void onClick(View view) {
                try {
                    studentModel = new StudentModel(studentName.getText().toString(),
                            Integer.parseInt(studentRollNo.getText().toString()), enrollSwitch.isChecked());

                    Toast.makeText(UpdateActivity.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(UpdateActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DBHelper dbHelper = new DBHelper(UpdateActivity.this);
                dbHelper.updateStudent(studentModel,roll);

            }
        });

    }
}