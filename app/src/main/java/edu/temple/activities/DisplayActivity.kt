package edu.temple.activities

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

const val RESULT_KEY = "reply_message"
class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value


    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button
    lateinit var resultTextView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById<Button?>(R.id.textSizeSelectorButton)

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK) {
                it.data?.apply {
                    resultTextView.text = getStringExtra(RESULT_KEY)

                }
            }
        }



        // take intent and extract float for text size
        textSizeSelectorButton.setOnClickListener(){
            val launchIntent = Intent(this@DisplayActivity, TextSizeActivity::class.java)

            startActivity(launchIntent)
        }

    }
}