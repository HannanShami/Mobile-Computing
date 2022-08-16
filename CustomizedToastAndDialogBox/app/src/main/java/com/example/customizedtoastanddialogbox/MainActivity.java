package com.example.customizedtoastanddialogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //code to make a customized toast

        LayoutInflater layoutInflater = getLayoutInflater();
        View myLayout=layoutInflater.inflate(R.layout.cust_toast,null);
        ImageView imageView=myLayout.findViewById(R.id.imageViewCustToast);
        imageView.setImageResource(R.drawable.a5);
        TextView myMessage= myLayout.findViewById(R.id.textViewCustToast);
        myMessage.setText("My Custom Toast");
        Toast myToast=new Toast(getApplicationContext());
        myToast.setDuration(Toast.LENGTH_LONG);
        myToast.setView(myLayout);
        myToast.show();

        //code for alert dialog

        public void showDialog(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("It is message");
            builder.setTitle("Title");
            builder.setCancelable(false);
            builder.setPositiveButton(
                    "Positive Button",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int asdf)
                        {
                            finish();
                        }
                    });
            builder.setNegativeButton(
                    "Negative Button",
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
    }
}