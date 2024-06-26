package com.project.signin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf

class SignUpActivity : AppCompatActivity() {
    private lateinit var editTextName :EditText
    private lateinit var editTextId : EditText
    private lateinit var editTextPw : EditText
    private lateinit var btnSignUp : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        editTextName = findViewById(R.id.signUp_name_editText)
        editTextId = findViewById(R.id.signUp_id_editText)
        editTextPw = findViewById(R.id.signUp_pw_EditText)
        btnSignUp = findViewById(R.id.signUp_btn_signUp)

        btnSignUp.setOnClickListener {
            val name = editTextName.text.toString()
            val id =editTextId.text.toString()
            val pw = editTextPw.text.toString()
            if( name != ""&& id != "" && pw != ""){
                if(DataBase.getDB(id) != null){
                    Toast.makeText(this,"계정이 있습니다",Toast.LENGTH_SHORT).show()
                }else{
                    DataBase.addDB(name,id,pw)
                    val intent = Intent(this,SignInActivity::class.java)
                    val bundel : Bundle = bundleOf("id" to id, "pw" to pw)
                    intent.putExtras(bundel)
                    setResult(RESULT_OK,intent)
                    finish()
                }
            }else{
                Toast.makeText(this,"입력되지 않은 정보가 있습니다",Toast.LENGTH_SHORT).show()
            }
        }


    }
}