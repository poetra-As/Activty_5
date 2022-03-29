package com.example.sampelcounstrantlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada layout
        btnLogin=findViewById(R.id.btSignin);

        //Menghubungkan variabel edmail dengan componen button pada layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada layout
        edpassword=findViewById(R.id.edPassword);

        //Membuat fungsi onclik pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menyimpan input user di edittext password kedalam variabel nama
                nama = edemail.getText().toString();
                //Menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();
                //Mengeset email yang benar
                String email = "Hafiz";
                //Mengeset password yang benar
                String pwd = "321";
                //mengecek apakah isi dari Email dan Password sudah sama dengan email dan password yang sudah di set
                if (nama.isEmpty() || password.isEmpty()){
                    //membuar variabel Toast dan menampilkan pesan "edittext tidak boleh kosong"
                    Toast a = Toast.makeText(getApplicationContext(),
                            "Email dan Password wajib diisi", Toast.LENGTH_LONG);
                    //menampilkan toast
                    a.show();
                }
                else {
                    //mengecek apakah isi dari Email dan Password sudah sama dengan email dan password yang sudah di set
                    if (nama.equals(email) && password.equals(pwd)){
                        //membuar variabel Toast dan menampilkan pesan "Login sukses"
                        Toast a = Toast.makeText(getApplicationContext(), "Login Succes", Toast.LENGTH_LONG);
                        //menampilkan toast
                        a.show();
                        //membuat objek bundle
                        Bundle b = new  Bundle();
                        //memasukkan value dari variabel password password dengan kunci "a" dan di masukkan kedalam bundle
                        b.putString("a", nama.trim());
                        //memasukkan value dari variabel password password dengan kunci "a" dan di masukkan kedalam bundle
                        b.putString("b", password.trim());
                        //membuat objek intent berpindah activity dari mainactivity ke ActivityHasil
                        Intent i = new Intent(getApplicationContext(), ActivityHasil.class);
                        //memasukkan bundle kedalam intent untuk dikirimkan ke ActivityHasil
                        i.putExtras(b);
                        //berpindah ke ActivityHasil
                        startActivity(i);
                    } else {
                        //membuar variabel Toast dan menampilkan pesan "Login sukses"
                        Toast a = Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_LONG);
                        //menampilkan toast
                        a.show();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar)
        {
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}