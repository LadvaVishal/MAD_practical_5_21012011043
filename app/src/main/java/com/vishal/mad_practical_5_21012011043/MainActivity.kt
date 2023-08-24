package com.vishal.mad_practical_5_21012011043

import android.content.Intent
import android.graphics.Camera
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Gallery

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Browse : Button =findViewById(R.id.btnBrowser)
        val editBrowser: EditText =findViewById(R.id.editTextBrowse)
        Browse.setOnClickListener {
            open_url(editBrowser.text.toString())
                                }
            val Call: Button=findViewById(R.id.btnCall)
            val call_text:EditText=findViewById(R.id.editTextCall)
            Call.setOnClickListener {
                call(call_text.text.toString())
                                  }
        val callLog:Button=findViewById(R.id.btnCallLog)
        callLog.setOnClickListener {
            call_log()
        }
        val Gallery:Button=findViewById(R.id.btnGallary)
        Gallery.setOnClickListener {
            Gallary()
        }
        val Camera:Button=findViewById(R.id.btnCamera)
        Camera.setOnClickListener { Camera() }

        val Alarm:Button=findViewById(R.id.btnAlarm)
        Alarm.setOnClickListener { Alarm() }

    }

    fun open_url(url:String)
    {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) }
    }
    fun call(number: String) {
         Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number")).also { startActivity(it) }
    }
    fun call_log(){
Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
    }
    fun Gallary(){
        Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
    }
    fun Camera()
    {

        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
    }
    fun Alarm()
    {
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
    }
}