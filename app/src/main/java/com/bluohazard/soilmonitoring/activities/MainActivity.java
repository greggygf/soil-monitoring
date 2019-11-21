package com.bluohazard.soilmonitoring.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluohazard.soilmonitoring.R;
import com.bluohazard.soilmonitoring.models.Soil;
import com.bluohazard.soilmonitoring.viewholders.SoilViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MainActivity extends AppCompatActivity {

    // [START define_database_reference]
    private DatabaseReference mDatabase;
    // [END define_database_reference]

    private FirebaseRecyclerAdapter<Soil, SoilViewHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

//        mRecycler = findViewById(R.id.list_beach);
//        mRecycler.setHasFixedSize(true);

        mManager = new LinearLayoutManager(this);
//        mRecycler.setLayoutManager(mManager);

        // Set up FirebaseRecyclerAdapter with the Query
        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Soil>()
                .setQuery(query, Soil.class)
                .build();

//        mAdapter = new FirebaseRecyclerAdapter<Soil, SoilViewHolder>(options) {
////            @Override
////            public SoilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////            }
//
//            @Override
//            protected void onBindViewHolder(@NonNull SoilViewHolder holder, int position, @NonNull final Soil model) {
//                holder.bindToSoil(model, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                    }
//                });
//            }
//        };

        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

    private Query getQuery(DatabaseReference mDatabase) {
        Query query = mDatabase.child("beach").orderByChild("id");
        return query;
    }
}
