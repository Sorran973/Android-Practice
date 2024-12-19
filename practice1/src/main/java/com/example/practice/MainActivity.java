package com.example.practice;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    TextView textView;
    private String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d(TAG, "Activity is created");

        textView = findViewById(R.id.text_view);
        textView.setMovementMethod(new ScrollingMovementMethod());
        text += "Activity is created";
        textView.setText(text);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Activity is started");
        text += "\nActivity is started";
        textView.setText(text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Activity is resumed");
        text += "\nActivity is resumed";
        textView.setText(text);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Activity is restarted");
        text += "\nActivity is restarted";
        textView.setText(text);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Activity is paused");
        text += "\nActivity is paused";
        textView.setText(text);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Activity is stopped");
        text += "\nActivity is stopped";
        textView.setText(text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activity is destroyed");
        text += "\nActivity is destroyed";
        textView.setText(text);
    }
}