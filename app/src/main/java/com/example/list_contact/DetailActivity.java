package com.example.list_contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {
    EditText name,nmr;
    Button mod,supp;
    int position;
    Params p=new Params();
    HashMap<String,String> m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        name=findViewById(R.id.name);
        nmr=findViewById(R.id.nmr);
        mod=findViewById(R.id.modifier);
        supp=findViewById(R.id.supp);

        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            position=extras.getInt("position");
        }
        m=p.values.get(position);
        name.setText(m.get("nom"));
        nmr.setText(m.get("numero"));

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.put("nom",name.getText().toString());
                m.put("numero",nmr.getText().toString());
                Intent i=new Intent(getApplicationContext(),ContactActivity.class);
                startActivity(i);
                finish();
            }
        });

        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.values.remove(position);
                Intent i=new Intent(getApplicationContext(),ContactActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}