package com.example.quizapp
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityQuizBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private lateinit var list: ArrayList<QuestionModel>
    private var count: Int = 0
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = ArrayList<QuestionModel>()
        Firebase.firestore.collection("quiz")
            .get().addOnSuccessListener {
                doct->
                list.clear()
                for(i in doct.documents){
                    var questionModel=i.toObject(QuestionModel::class.java)
                    //QuestionModel=i.toObject(QuestionModel::class.java)
                    list.add(questionModel!!)
                }
                binding.question.setText(list.get(0).question)
                binding.option1.setText(list.get(0).option1)
                binding.option2.setText(list.get(0).option2)
                binding.option3.setText(list.get(0).option3)
                binding.option4.setText(list.get(0).option4)
            }
       // list.add(QuestionModel("Who is the PM of India?", "MODI", "RAHUL", "KEJU", "OTHER", "MODI"))
      //  list.add(QuestionModel("Who is the PM of India?", "RAHUL", "MODI", "KEJU", "OTHER", "MODI"))
       // list.add(QuestionModel("Who is the PM of India?", "MODI", "RAHUL", "KEJU", "OTHER", "MODI"))
       // list.add(QuestionModel("Who is the PM of India?", "RAHUL", "MODI", "KEJU", "OTHER", "MODI"))

        binding.option1.setOnClickListener {
            nextdata(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener {
            nextdata(binding.option2.text.toString())

        }
        binding.option3.setOnClickListener {
            nextdata(binding.option3.text.toString())

        }
        binding.option4.setOnClickListener {
            nextdata(binding.option4.text.toString())

        }

    }

    private fun nextdata(i: String) {
        if (count<list.size) {
           // Toast.makeText(this@QuizActivity, "i",Toast.LENGTH_LONG).show()

            if (list.get(count).ans.equals(i)) {
                score++
            }
        }
        count++
        if (count>=list.size) {
          //  Toast.makeText(this@QuizActivity,score.toString(),Toast.LENGTH_LONG).show()
            val intent=Intent(this,ScoreActivity::class.java)
            intent.putExtra("SCORE",score)
            startActivity(intent)
            finish()
        }
        else {
            binding.question.setText(list.get(count).question)
            binding.option1.setText(list.get(count).option1)
            binding.option2.setText(list.get(count).option2)
            binding.option3.setText(list.get(count).option3)
            binding.option4.setText(list.get(count).option4)
        }
    }
}





