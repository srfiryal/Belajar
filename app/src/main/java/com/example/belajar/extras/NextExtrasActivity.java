package com.example.belajar.extras;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.belajar.R;

public class NextExtrasActivity extends AppCompatActivity {

    TextView tv_text;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_extras);
        getSupportActionBar().setTitle("Extras");

        tv_text = findViewById(R.id.tv_nextExtras);

        extras = getIntent().getExtras();

        if (extras != null) {
            tv_text.setText("Your name is " + extras.getString("name"));
        }
    }
}