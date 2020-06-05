package com.example.msgshareapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.msgshareapp.R
import com.example.msgshareapp.constants.USER_MSG_KEY
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {
        val TAG: String = SecondActivity :: class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)
        val bundle: Bundle? = intent.extras

        bundle?.let {
            val msg = bundle.getString(USER_MSG_KEY)
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
            textViewMessage.text = msg
        }

    }
}