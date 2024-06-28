package com.project.signin

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var textViewName : TextView
    private lateinit var textViewId : TextView
    private lateinit var btnFinish : Button
    private lateinit var imgView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        textViewName = findViewById(R.id.home_name_textView)
        textViewId = findViewById(R.id.home_id_textView)
        btnFinish = findViewById(R.id.home_finish_btn)
        imgView = findViewById(R.id.home_imageView)

        val id = intent.getStringExtra("id").toString()
        val name = DataBase.getDB(id)?.first

        textViewName.setText("이름 : ${name}")
        textViewId.setText("아이디 : ${id}")

        btnFinish.setOnClickListener {
            finish()
        }

        val imgList = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
        )
        val randomIndex = (0 until imgList.size).random()
        imgView.setImageResource(imgList[randomIndex])

    }
}