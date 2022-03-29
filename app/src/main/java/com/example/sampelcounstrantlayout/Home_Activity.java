package com.example.sampleconstraintlayout;

import android.content.Intent;
import android.support.v4.app..AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private ListView list;

    private com.example.sampleconstraintlayout.ListViewAdapter adapter;

    String[] listNama;

    public static ArrayList<com.example.sampleconstraintlayout.ClassNama> classNamaArrayList = new ArrayList<com.example.sampleconstraintlayout.ClassNama>();

    Bundle bundle = new Bundle();

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listNama = new String[]{"Inayah", "Ilham", "Eris", "Fikri", "Maul", "Intan",
                "Vina", "Gita", "vian ", "Lutfi"};

        list = findViewById(R.id.listkontak);

        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listNama.length; i++) {
            com.example.sampleconstraintlayout.ClassNama classNama = new com.example.sampleconstraintlayout.ClassNama(listNama[i]);

            classNamaArrayList.add(classNama);
        }
        adapter = new com.example.sampleconstraintlayout.ListViewAdapter(this);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String nama = classNamaArrayList.get(position).getName();

                bundle.putString("a", nama.trim());

                PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                pm.setOnMenuItemClickListener(Home_Activity.this);

                pm.inflate(R.menu.popup_menu);

                pm.show();
            }
        });
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.mnView:
                intent = new Intent(getApplicationContext(), ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(), "Ini untuk edit kontak",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}