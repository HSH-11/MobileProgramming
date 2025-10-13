package com.example.event;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RadioGroup group;
    RadioButton button1, button2, button3;
    Button button;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("Survey");

        group = (RadioGroup) findViewById(R.id.radioGroup1);
        button1 = (RadioButton) findViewById(R.id.radio0);
        button2 = (RadioButton) findViewById(R.id.radio1);
        button3 = (RadioButton) findViewById(R.id.radio2);

        button1.setOnClickListener(radio_listener);
        button2.setOnClickListener(radio_listener);
        button3.setOnClickListener(radio_listener);

        button = (Button) findViewById(R.id.button1);
        image = (ImageView) findViewById(R.id.imageView1);
    }

    View.OnClickListener radio_listener = new View.OnClickListener() {
        public void onClick(View arg0) {
            int id = group.getCheckedRadioButtonId();
            if( id == R.id.radio0)
                image.setImageResource(R.drawable.image0);
            else if( id == R.id.radio1)
                image.setImageResource(R.drawable.image1);
            else if( id == R.id.radio2)
                image.setImageResource(R.drawable.image2);
        }
    };
}