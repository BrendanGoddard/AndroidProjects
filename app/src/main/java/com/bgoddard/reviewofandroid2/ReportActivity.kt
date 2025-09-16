package com.bgoddard.reviewofandroid2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bgoddard.reviewofandroid2.databinding.ActivityReportBinding

class ReportActivity : AppCompatActivity() {
    lateinit var binding : ActivityReportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_report)
        binding = ActivityReportBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    // RIGHT WAY
    fun onButtonReturn(view: View) {



        finish()
    }

    // WRONG WAY
    fun onButtonReturnWrongWay(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}