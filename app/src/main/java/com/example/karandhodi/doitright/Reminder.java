package com.example.karandhodi.doitright;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Reminder extends AppCompatActivity {
    TextView tv;
    Globals gApp;
    String message;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder_layout);
        tv = (TextView)findViewById(R.id.tv1);
        gApp = (Globals)getApplicationContext();
        message = gApp.getReminderMessageValue();
        tv.setText(message);
        getSupportActionBar().setTitle("\tReminder !!");
        back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
