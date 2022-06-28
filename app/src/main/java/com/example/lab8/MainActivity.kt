package com.example.lab8

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.preference.PreferenceManager
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<TextView>(R.id.textView)
        tv.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()

        val tv = findViewById<TextView>(R.id.textView)
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val name = pref.getString("Name", "")
        val size = pref.getString("Size", "")
        val italic = pref.getBoolean("Italic", false)

        //Snackbar.make(this, tv, "name ${name}", Snackbar.LENGTH_SHORT).show()

        //name
        if (name != "") {
            tv.setText(name)
        }
        else {
            tv.setText("Hello World!")
        }

        //size
        if (size == "small") {
            tv.setTextSize(10F)
        }
        else if (size == "medium") {
            tv.setTextSize(14F)
        }
        else if (size == "big") {
            tv.setTextSize(20F)
        }

        //italic
        if (italic == false) {
            tv.setTypeface(null, Typeface.NORMAL)
        }
        else if (italic == true) {
            tv.setTypeface(null, Typeface.ITALIC)
        }
    }
}