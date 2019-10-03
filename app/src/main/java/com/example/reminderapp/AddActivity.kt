package com.example.reminderapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*

const val EXTRA_REMINDER = "EXTRA_REMINDER"
class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)


        initViews()

    }

    private fun initViews() {
        fab.setOnClickListener {
            onSaveClick()
        }
    }

    private fun onSaveClick() {
        val reminder = etAddReminder.text.toString()

        if(reminder.trim().length> 0) {
            val r = Reminder(reminder)
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_REMINDER, r)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"The reminder cannot be empty"
                , Toast.LENGTH_SHORT).show()

        }
    }


}
