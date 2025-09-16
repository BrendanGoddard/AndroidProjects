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
    lateinit var reportBinding : ActivityReportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_report)
        reportBinding = ActivityReportBinding.inflate(layoutInflater)
        setContentView(reportBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        reportBinding.textViewReport.setText(intent.getStringExtra("NAME"))
        var spinValue:Int = intent.getIntExtra("NUM", 0)
        reportBinding.spinner.setSelection(spinValue - 1)


    }

    // RIGHT WAY
    fun onButtonReturn(view: View) {

        MainActivity.numS = reportBinding.spinner.selectedItemPosition+1
        // add one (0,1,2 is pos, 1,2,3 are values)

        finish()
    }

    // WRONG WAY
    fun onButtonReturnWrongWay(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}