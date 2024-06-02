package com.example.quizapp
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            Firebase.auth.createUserWithEmailAndPassword(
              binding.emailid.editableText.toString(),// yha ab ma edit.text kar du kya ?
                binding.password.editableText.toString()
            )
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "User Created", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "User Not Created", Toast.LENGTH_LONG).show()

                    }

                }
        }
    }
}