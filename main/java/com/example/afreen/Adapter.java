package com.example.afreen;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Adapter extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //AdapterView
        listView = findViewById(R.id.listView);

        //Datasource
        String[] languages = {"Kotlin", "Java", "Python", "Cpp", "Swift"};

        // Adapter connects datasource to any UI component (ListView)

        //Method 1- Connecting using ArrayAdapter
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,languages);

        //Method 2 - Custom Adaptor
        CustomAdapter customAdapter = new CustomAdapter(this, languages);

        listView.setAdapter(customAdapter);
    }
}