package com.example.belajar.result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.belajar.R;

public class NextResultsActivity extends AppCompatActivity {

    EditText txt_name;
    Button btn_save;

    String myName;
    final int RESULT_CODE = 201;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_result);
        getSupportActionBar().setTitle("Results");

        txt_name = findViewById(R.id.txt_nextResult);
        btn_save = findViewById(R.id.btn_save_nextResult);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myName = txt_name.getText().toString();

                if (myName.isEmpty()) {
                    Toast.makeText(NextResultsActivity.this, "Please fill in the field", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(NextResultsActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (myName == null) {
            Toast.makeText(this, "Please fill in the field", Toast.LENGTH_SHORT).show();
        } else if (myName.isEmpty()) {
            Toast.makeText(this, "Please fill in the field", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra("name", myName);
            setResult(RESULT_CODE, intent);
            super.onBackPressed();
        }
    }
}