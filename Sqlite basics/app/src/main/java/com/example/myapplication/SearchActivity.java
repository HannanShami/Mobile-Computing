package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.SearchEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class SearchActivity extends AppCompatActivity {
    Button deletebutton, updatebutton, BackButton, search;
    EditText RollNumber;
    ListView searchlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        deletebutton = findViewById(R.id.buttondelete);
        updatebutton = findViewById(R.id.buttonUpdate);
        BackButton = findViewById(R.id.backbutton);
        search = findViewById(R.id.searchbtn);
        RollNumber = findViewById(R.id.SearchRollNo);
        searchlist = findViewById(R.id.list);

        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelper dbHelper = new DBHelper(SearchActivity.this);
                dbHelper.deleteStudent(RollNumber.getText().toString());
                Toast.makeText(SearchActivity.this, "Successfully Deleted", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this,UpdateActivity.class);
                intent.putExtra("RollNumber", RollNumber.getText().toString());
                startActivity(intent);

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(SearchActivity.this);
                List<StudentModel> list = dbHelper.getSingleStudent(Integer.parseInt(RollNumber.getText().toString()));
                ArrayAdapter<StudentModel> arrayAdapter = new ArrayAdapter<StudentModel>
                        (SearchActivity.this, android.R.layout.simple_list_item_1, list);
                searchlist.setAdapter(arrayAdapter);
            }
        });

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}