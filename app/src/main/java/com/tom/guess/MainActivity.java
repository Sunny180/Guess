package com.tom.guess;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int secret = new Random().nextInt(10)+1;
    int counter;
    private EditText edNumber;
    private TextView edCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edNumber = findViewById(R.id.ed_number);
        edCounter = findViewById(R.id.counter);
        edCounter.setText(String.valueOf(counter));
        FloatingActionButton fab = findViewById(R.id.fab);
        Button button = findViewById(R.id.button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void guess(View view){
        int n =Integer.parseInt(edNumber.getText().toString());
        edNumber.setText(Integer.toString(n));
        counter++;
        edCounter.setText(counter+"");
            if (n < secret){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Ha")
                        .setMessage("Bigger")
                        .setPositiveButton("OK",null)
                        .show();
                Toast.makeText(MainActivity.this, "Bigger", Toast.LENGTH_SHORT).show();
            }else if (n>secret){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Ha")
                        .setMessage("Smaller")
                        .setPositiveButton("OK",null)
                        .show();
                Toast.makeText(MainActivity.this, "Smaller", Toast.LENGTH_SHORT).show();
            }else {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Jo li hi")
                        .setMessage("Bingo")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                secret = new Random().nextInt(10)+1;
                                counter = 0;
                                edCounter.setText(counter + "");
                            }
                        })
                        .show();
                Toast.makeText(MainActivity.this, "Bingo", Toast.LENGTH_SHORT).show();
            }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
