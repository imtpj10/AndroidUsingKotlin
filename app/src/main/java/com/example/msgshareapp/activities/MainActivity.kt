package com.example.msgshareapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.msgshareapp.R
import com.example.msgshareapp.constants.USER_MSG_KEY
import com.example.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            //code
            Log.i(TAG, "Button was clicked")
            showToast("Button was clicked", Toast.LENGTH_LONG)
            // Toast.makeText(this, "Button was clicked", Toast.LENGTH_SHORT).show()
        }
        submitMessage.setOnClickListener {
            val message: String = message.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(USER_MSG_KEY, message)
            startActivity(intent)
        }
        btnShare.setOnClickListener {
            val message: String = message.text.toString()
            val intent = Intent()

            intent.action = Intent.ACTION_SEND

            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to :"))
        }
        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(
                this,
                HobbiesActivity::class.java
            )
            startActivity(intent)
        }
    }
}
