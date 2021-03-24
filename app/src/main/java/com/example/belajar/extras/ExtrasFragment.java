package com.example.belajar.extras;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.belajar.R;

public class ExtrasFragment extends Fragment {

    EditText txt_name;
    Button btn_intent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_extras, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Extras");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txt_name = view.findViewById(R.id.txt_extras);
        btn_intent = view.findViewById(R.id.btn_intent_extras);

        btn_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myName = txt_name.getText().toString();
                Log.d("name", ""+myName);

                if (myName.isEmpty()) {
                    Toast.makeText(getActivity(), "Please fill in the field", Toast.LENGTH_SHORT).show();
                } else {
                    txt_name.setText("");
                    Intent intent = new Intent(getContext(), NextExtrasActivity.class);
                    intent.putExtra("name", myName);
                    startActivity(intent);
                }
            }
        });
    }
}
