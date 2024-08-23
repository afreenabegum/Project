package com.example.afreen;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DatePicker extends AppCompatActivity {

    android.widget.DatePicker datePicker;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_date_picker);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        datePicker = findViewById(R.id.DatePicker);
        textView = findViewById(R.id.textView);

        String date = " Day : " + datePicker.getDayOfMonth();
        String month = " Month: " + datePicker.getMonth() + 1;
        String year = " Year: " + datePicker.getYear();

        // This method displays the initial date, but not the dynamic date
        textView.setText(date + month + year);



        // This method is useful whenever we there are dynamic changes in date
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener(new android.widget.DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(android.widget.DatePicker datePicker, int i, int i1, int i2) {
                    Toast.makeText(DatePicker.this, "Date : " + i2 + " Month : " +i1 + " Year : " +i, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}