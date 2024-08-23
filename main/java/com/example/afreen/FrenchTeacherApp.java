package com.example.afreen;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FrenchTeacherApp extends AppCompatActivity implements View.OnClickListener{

    Button btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_french_teacher_app);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);

        //The below method increases same boiler code for diff buttons.
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.black);
//                mediaPlayer.start();
//            }
//        });
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.green);
//                mediaPlayer.start();
//            }
//        });
//
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.yellow);
//                mediaPlayer.start();
//            }
//        });
//
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.red);
//                mediaPlayer.start();
//            }
//        });
//
//        btn5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.purple);
//                mediaPlayer.start();
//            }
//        });

        // Instead follow this
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        
        int colorId = view.getId();

        if(colorId == R.id.button1) {
            playColorSound(R.raw.black);
        }

        else if(colorId == R.id.button2)
            playColorSound(R.raw.green);

        else if(colorId == R.id.button3)
            playColorSound(R.raw.yellow);

        else if(colorId == R.id.button4)
            playColorSound(R.raw.red);

        else if(colorId == R.id.button5)
            playColorSound(R.raw.purple);
    }

    private void playColorSound(int colorId) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, colorId);
        mediaPlayer.start();
    }
}