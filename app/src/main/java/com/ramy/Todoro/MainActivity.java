package com.ramy.Todoro;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn00);
        btn.setText(R.string.text1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Welcome to Todoro",Toast.LENGTH_SHORT).show();
            }
        });


        Button btn1 =(Button) findViewById(R.id.btn01);




    }
    public void GoToPmdr(View v){
        Toast.makeText(this,"Congratolations",Toast.LENGTH_LONG).show();
    }
    public void gopomo(View view){
        Intent intent = new Intent(MainActivity.this, Pomodoro.class);
        startActivity(intent);
    }

}