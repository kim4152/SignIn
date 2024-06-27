package com.project.signin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var editTextId: EditText
    private lateinit var editTextPw: EditText

    private lateinit var btnSignIn: Button
    private lateinit var btnSignUp: Button

    private lateinit var myIntent : ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        myIntent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result->
            if (result.resultCode == RESULT_OK){
                val id = result.data?.extras?.getString("id")?: ""
                val pw = result.data?.extras?.getString("pw")?: ""

                editTextId.setText(id)
                editTextPw.setText(pw)
            }
        }

        editTextId = findViewById(R.id.signIn_id_editText)
        editTextPw = findViewById(R.id.signIn_pw_EditText)

        btnSignIn = findViewById(R.id.signIn_btn_signIn)
        btnSignUp = findViewById(R.id.signIn_btn_signUp)

        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            myIntent.launch(intent)
        }

        btnSignIn.setOnClickListener {
            val userInfo = DataBase.getDB(editTextId.text.toString())
            if(userInfo!=null && userInfo.second == editTextPw.text.toString()){
                val intent = Intent(this,HomeActivity::class.java)
                intent.putExtra("id",editTextId.text.toString())
                myIntent.launch(intent)
            }else{
                Toast.makeText(this,"계정 정보가 없습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }

}

