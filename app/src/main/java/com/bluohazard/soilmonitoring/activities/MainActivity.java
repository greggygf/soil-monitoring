package com.bluohazard.soilmonitoring.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bluohazard.soilmonitoring.R;
import com.bluohazard.soilmonitoring.models.Soil;
import com.bluohazard.soilmonitoring.viewholders.SoilViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;

import java.text.SimpleDateFormat;
import java.time.OffsetTime;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextClock tClock;

    private DatabaseReference mDatabase;

    // Deklarasi Variable

    private TextView getSuhu, getAir, getKelembaban, getOksigen, getStatus, getStatusText;
    private FirebaseDatabase getDatabase;
    private DatabaseReference getReference;

    int number = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //date-------------------------------------------------------
        String date_n = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(new Date());
        //get hold of textview.
        TextView date = findViewById(R.id.mydateText);
        //set it as current date.
        date.setText(date_n);
        //-----------------------------------------------------------


        //time-------------------------------------------------------
        tClock = (TextClock) findViewById(R.id.textClock1);
        //-----------------------------------------------------------

        mDatabase = FirebaseDatabase.getInstance().getReference();

        getAir = findViewById(R.id.textWater);
        getKelembaban = findViewById(R.id.textWet);
        getOksigen = findViewById(R.id.textWind);
        getSuhu = findViewById(R.id.textTemperature);
        getStatus = findViewById(R.id.baro);
        getStatusText = findViewById(R.id.statusBaro);

        getDatabase = FirebaseDatabase.getInstance();
        getReference = getDatabase.getReference();

        /*
         * Mendapatkan referensi dari lokasi Admin dan tutunannya yaitu User ID dari masing-masing
         * akun user dan menambahkan ChildListener untuk menangani kejadian saat data ditambahkan,
         * diubah, dihapus dan dialihkan.
         */

        getReference.child("tanah0").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Mengambil daftar item dari database, setiap kali ada turunannya

                Soil soil = dataSnapshot.getValue(Soil.class);

                getAir.setText(soil.getAir() + "%");
                getKelembaban.setText(soil.getKelembaban() + "%");
                getOksigen.setText(soil.getOksigen() + "%");
                getSuhu.setText(soil.getSuhu() + "°");

                getStatus.setText(dataSnapshot.child("status").getValue() + " %");

                if (getStatus.getText().equals("40 %")) {
                    getStatusText.setText("Kondisi tanah anda kurang baik!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void onRandom(View view) {
        getReference.child("tanah" + number).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Mengambil daftar item dari database, setiap kali ada turunannya

                Soil soil = dataSnapshot.getValue(Soil.class);

                getAir.setText(soil.getAir() + "%");
                getKelembaban.setText(soil.getKelembaban() + "%");
                getOksigen.setText(soil.getOksigen() + "%");
                getSuhu.setText(soil.getSuhu() + "°");

                getStatus.setText(dataSnapshot.child("status").getValue() + " %");

                if (getStatus.getText().equals("40 %")) {
                    getStatusText.setText("Kondisi tanah anda kurang baik!");
                } else if (getStatus.getText().equals("50 %")) {
                    getStatusText.setText("Kondisi tanah anda baik!");
                } else if (getStatus.getText().equals("60 %")) {
                    getStatusText.setText("Kondisi tanah anda baik!");
                } else if (getStatus.getText().equals("85 %")) {
                    getStatusText.setText("Kondisi tanah anda sangat baik!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        number++;

        if (number == 4) {
            number = 0;
        }
    }

    public void history(View view) {
        Intent intent = new Intent(MainActivity.this,History.class);
        startActivity(intent);
        finish();
    }
}
