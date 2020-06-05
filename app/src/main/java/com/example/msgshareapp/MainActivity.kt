package com.example.msgshareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener{
            //code
            Log.i("MainActivity", "Button was clicked")
            Toast.makeText(this,"Button was clicked", Toast.LENGTH_SHORT).show()
        }
        submitMessage.setOnClickListener{
            val message: String = message.text.toString()


            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("key_message",message)
            startActivity(intent)
        }
        btnShare.setOnClickListener {
            val message: String = message.text.toString()
            val intent = Intent()

            intent.action = Intent.ACTION_SEND

            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent,"Share to :"))
        }
    }
}