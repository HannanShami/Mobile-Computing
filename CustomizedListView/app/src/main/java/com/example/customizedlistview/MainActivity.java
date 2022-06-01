package com.example.customizedlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView lv = findViewById(R.id.list1);

        ArrayList<Student> studentArrayList = new ArrayList<Student>();

        studentArrayList.add(new Student("ALI","1",R.drawable.ic_launcher_background));
        studentArrayList.add(new Student("Ahmed","2",R.drawable.ic_launcher_background));
        studentArrayList.add(new Student("Saad","3",R.drawable.ic_launcher_background));
        studentArrayList.add(new Student("Bilal","4",R.drawable.ic_launcher_background));

        MyAdapter ad = new MyAdapter(this,0,studentArrayList);

        lv.setAdapter(ad);

    }
}