package com.example.dikeledi.miwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNumbers(View view){

        Intent numbersIntent = new Intent(MainActivity.this,Numbers.class);
        startActivity(numbersIntent);
    }

    public void openFamily(View view){

        Intent familyIntent = new Intent(MainActivity.this,FamilyMembers.class);
        startActivity(familyIntent);
    }

    public void openColor(View view){

        Intent colorsIntent = new Intent(MainActivity.this, Colors.class);
        startActivity(colorsIntent);
    }

    public void openPhrase(View view){



        Intent phraseIntent = new Intent(MainActivity.this,Phrase.class);
        startActivity(phraseIntent);
    }
}
