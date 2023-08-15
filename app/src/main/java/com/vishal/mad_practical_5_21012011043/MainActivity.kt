package com.vishal.mad_practical_5_21012011043

import android.content.Intent
import android.graphics.Camera
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CallLog
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


    }

    fun open_url(url:String)
    {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) }
    }
    fun call(call:String)
    {
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel,$call")).also { startActivity(it) }
    }
    fun call_log(){
Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
    }
    fun Gallary(){
        Intent(Intent.ACTION_GET_CONTENT).setType("image/*").also { startActivity(it) }
    }
    fun Camera()
    {

       // Intent(Intent.ACTION_CAMERA_BUTTON).
    }
    fun Alarm()
    {

    }
}