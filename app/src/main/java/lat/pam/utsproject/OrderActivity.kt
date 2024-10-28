package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText

class OrderActivity : AppCompatActivity() {
    private lateinit var etFoodName: EditText
    private lateinit var etServings: EditText
    private lateinit var etName: EditText
    private lateinit var etNotes: EditText
    private lateinit var btnOrder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        etFoodName = findViewById(R.id.etFoodName)
        etServings = findViewById(R.id.etServings)
        etName = findViewById(R.id.etName)
        etNotes = findViewById(R.id.etNotes)
        btnOrder = findViewById(R.id.btnOrder)

        btnOrder.setOnClickListener {
            val foodName = etFoodName.text.toString()
            val servings = etServings.text.toString()
            val orderingName = etName.text.toString()
            val notes = etNotes.text.toString()

            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("FOOD_NAME", foodName)
                putExtra("SERVINGS", servings)
                putExtra("ORDERING_NAME", orderingName)
                putExtra("NOTES", notes)
            }
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}