package ro.pub.cs.systems.eim.practicaltest01var04

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var04MainActivity : AppCompatActivity() {

    private lateinit var input1: EditText
    private lateinit var input2: EditText

    private lateinit var input3: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var04_main)

        input3 = findViewById(R.id.input3)

        val pressMeButton = findViewById<Button>(R.id.press_me_button)

        findViewById<Button>(R.id.press_me_button).setOnClickListener {
            input3=findViewById<EditText>(R.id.input3)
            input3.setText("Anca 341c5");


        }



        val activityResultsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "The activity returned with result OK", Toast.LENGTH_LONG).show()
            }
            else if (result.resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "The activity returned with result CANCELED", Toast.LENGTH_LONG).show()
            }
        }

        val navigateToSecondaryActivityButton = findViewById<Button>(R.id.newactivity)
        navigateToSecondaryActivityButton.setOnClickListener {
            val intent = Intent(this, PracticalTest01Var04SecondaryActivity::class.java)
            activityResultsLauncher.launch(intent)
        }

    }
}