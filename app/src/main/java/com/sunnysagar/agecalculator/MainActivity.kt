package com.sunnysagar.agecalculator

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.*

class MainActivity : AppCompatActivity() {
//    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.butn)
        button.setOnClickListener { view -> printAge(view) }
    }
//    @RequiresApi(Build.VERSION_CODES.N)
    private fun printAge(view:View)
    {
        var myCalendar = Calendar.getInstance()
        var year = myCalendar.get(Calendar.YEAR)
        var month = myCalendar.get(Calendar.MONTH)
        var day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
            val selectedDate = "$day/${month+1}/$year"

            var tv1 = findViewById<TextView>(R.id.tv1)
            tv1.text = selectedDate

            var dob = Calendar.getInstance()
            dob.set(year,month, day)
            var age = myCalendar.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
            if(myCalendar.get(Calendar.DAY_OF_YEAR)<dob.get(Calendar.DAY_OF_YEAR))
                age--
            var tv2 = findViewById<TextView>(R.id.tv2)
            tv2.text = "You are $age year old."
        }
        ,year,month,day).show()
    }
}