package com.example.customizedlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.customizedlistview.R;
import com.example.customizedlistview.Student;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Student> {
    public MyAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View conversion, ViewGroup parent)
    {
        Student s = getItem(position);
        View convertView = LayoutInflater.from(getContext()).inflate(R.layout.studentlayout, parent, false);
        TextView n = convertView.findViewById(R.id.textView);
        TextView i = convertView.findViewById(R.id.textView2);
        ImageView im = convertView.findViewById(R.id.imageView2);

        n.setText(s.getName());
        i.setText(s.getId());
        im.setImageResource(s.getImageid());

        return convertView;
    }
}
