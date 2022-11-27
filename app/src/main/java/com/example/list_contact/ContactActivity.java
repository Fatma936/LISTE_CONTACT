package com.example.list_contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class ContactActivity extends AppCompatActivity {

    ListView ls;
    String nom, num;
    HashMap<String,String> map;
    Params p= new Params();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ls=findViewById(R.id.lst);

        Bundle extras= getIntent().getExtras();
        if(extras!= null ){
            nom=extras.getString("nom");
            num=extras.getString("numero");
            map=new HashMap<String,String>();
            map.put("nom",nom);
            map.put("numero",num);
            p.values.add(map);
        }

            SimpleAdapter adapter=new SimpleAdapter(ContactActivity.this,p.values,R.layout.item,
                    new String[]{"nom","numero"},
                    new int[]{R.id.nn,R.id.nm}
                    );
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getApplicationContext(),DetailActivity.class);
                i.putExtra("position",position);
                startActivity(i);
            }
        });
    }
}