package com.example.applic0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {
    val TAG = "@@MainActivity"

    private var username:String? = null
    private var password:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iptUsername = findViewById<EditText>(R.id.ipt_username)
        val iptPassword = findViewById<EditText>(R.id.ipt_password)

        val usernameWatcher = object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.i(TAG,"beforeTextChanged : $s")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.i(TAG,"onTextChanged : $s")
            }

            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG,"afterTextChanged : $s")
                username = s?.toString()
            }

        }
        val passwordWatcher = object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.i(TAG,"beforeTextChanged : $s")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.i(TAG,"onTextChanged : $s")
            }

            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG,"afterTextChanged : $s")
                password = s?.toString()
            }

        }

        iptUsername.addTextChangedListener(usernameWatcher)
        iptPassword.addTextChangedListener(passwordWatcher)
    }

    fun onClick(view: View){
        Log.d(TAG,"username = $username")
        Log.d(TAG,"password = $password")

        AlertDialog.Builder(this)
            .setTitle("?????????")
            .setMessage("????????????????????????")
            .setNegativeButton("??????"){d,w->
                Toast.makeText(this,"?????????", Toast.LENGTH_LONG).show()
            }
            .setPositiveButton("??????"){d,w->
                toLogin()
            }
            .show()
    }

    private fun toLogin() {
        val process = findViewById<ProgressBar>(R.id.progress)
        process.visibility = View.VISIBLE
        process.progress = 0
        // TODO: ???????????? ??????
        val timer = Timer()
        val context = this
        val task = object : TimerTask(){
            override fun run() {
                Log.d(TAG,"progress = ${process.progress}")
                process.progress = process.progress + 1
                if(process.progress == 10){
                    timer.cancel()
//                    runOnUiThread {
//                        process.visibility = View.GONE
//                    }
                    Handler(Looper.getMainLooper()).post {
                        process.visibility = View.GONE
                        startActivity(Intent(context,ListActivity::class.java))
                    }
                }
            }
        }
        timer.schedule(task,0,1000)
    }
}

