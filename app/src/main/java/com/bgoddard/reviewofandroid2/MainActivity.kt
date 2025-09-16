package com.bgoddard.reviewofandroid2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bgoddard.reviewofandroid2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Step One comment out old set content view!!
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editText = findViewById< EditText>(R.id.editTextName)

        val prefsEditor = getSharedPreferences("ReviewOfAndroid2", MODE_PRIVATE)
        binding.editTextName.setText(prefsEditor.getString("NAME", ""))
        binding.radioGroup.check(prefsEditor.getInt("NUM", R.id.radioButtonOne))
    }

    fun onButtonLogCat(view: View) {
        println(editText.text.toString())
        val intent = Intent(this, ReportActivity::class.java).apply {
            putExtra("NAME", binding.editTextName.text.toString())
            var sel:Int = 1
            when(binding.radioGroup.checkedRadioButtonId) {
                R.id.radioButtonOne -> sel = 1
                R.id.radioButtonTwo -> sel = 2
                R.id.radioButtonThree -> sel = 3
            }
            putExtra("NUM", sel)
        }
        startActivity(intent)
    }

    fun onRadioClick(view: View) {
        // one was of doing it
        when(view.id)
        {
            R.id.radioButtonOne -> println("one was clicked")
            R.id.radioButtonTwo -> println("two was clicked")
            R.id.radioButtonThree -> println("three was clicked")
        }


    }

    override fun onPause() {
        super.onPause()
        val prefsEditor = getSharedPreferences("ReviewOfAndroid2", MODE_PRIVATE).edit()
        prefsEditor.putString("NAME", binding.editTextName.text.toString())
        prefsEditor.putInt("NUM", binding.radioGroup.checkedRadioButtonId)
        prefsEditor.apply()
    }




}