package com.example.reminderapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    var String1 = "";
    var String2 = "";
    var String3 = "";
    var String4 = "";
    var String5 = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
        Log.d("Test","Heyyoooo")
        val Input1: EditText = findViewById(R.id.Input1)

        val Input2: EditText = findViewById(R.id.Input2)
        val Input3: EditText = findViewById(R.id.Input3)
        val Input4: EditText = findViewById(R.id.Input4)
        val Input5: EditText = findViewById(R.id.Input5)
        Input1.setText(String1)
        Input2.setText(String2)
        Input3.setText(String3)
        Input4.setText(String4)
        Input5.setText(String5)
        val Button: Button = findViewById(R.id.button)
        Button.setOnClickListener(View.OnClickListener {
            saveData(Input1.text.toString(),Input2.text.toString(),Input3.text.toString(),Input4.text.toString(),Input5.text.toString());
            Toast.makeText(this,"Values Saved.", Toast.LENGTH_SHORT).show();

        })

    }



    fun saveData(string1:String,string2:String,string3:String,string4:String,string5:String) {
        Log.d("1",String1)
        Log.d("2,",String2)
        val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString("StoredInput1",string1);
            apply()
        }
        with (sharedPref.edit()) {
            putString("StoredInput2",string2);
            apply()
        }
        with (sharedPref.edit()) {
            putString("StoredInput3",string3);
            apply()
        }
        with (sharedPref.edit()) {
            putString("StoredInput4",string4);
            apply()
        }
        with (sharedPref.edit()) {
            putString("StoredInput5",string5);
            apply()
        }
    }
    fun loadData() {
        val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
        String1 = sharedPref.getString("StoredInput1","").toString();
        String2 = sharedPref.getString("StoredInput2","").toString();
        String3 = sharedPref.getString("StoredInput3","").toString();
        String4 = sharedPref.getString("StoredInput4","").toString();
        String5 = sharedPref.getString("StoredInput5","").toString();
        Log.d("1",String1)
        Log.d("2,",String2)


    }


}