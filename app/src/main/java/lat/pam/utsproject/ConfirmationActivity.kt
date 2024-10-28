package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil data dari Intent
        val foodName = intent.getStringExtra("FOOD_NAME") ?: "N/A"
        val servings = intent.getStringExtra("SERVINGS") ?: "N/A"
        val orderingName = intent.getStringExtra("ORDERING_NAME") ?: "N/A"
        val notes = intent.getStringExtra("NOTES") ?: "N/A"

        // Log untuk debugging
        Log.d("ConfirmationActivity", "Food Name: $foodName, Servings: $servings, Ordering Name: $orderingName, Notes: $notes")

        // Set teks pada TextView
        findViewById<TextView>(R.id.tvTitle).text = "Order Food"
        findViewById<TextView>(R.id.foodName).text = "Food Name: $foodName"
        findViewById<TextView>(R.id.servings).text = "Number of Servings: $servings pax"
        findViewById<TextView>(R.id.orderingName).text = "Ordering Name: $orderingName"
        findViewById<TextView>(R.id.notes).text = "Additional Notes: $notes"

        // Set up tombol untuk kembali ke menu
        findViewById<Button>(R.id.backtoMenu).setOnClickListener {
            // Kembali ke Menu atau ListFoodActivity
           val intent = Intent(this,ListFoodActivity::class.java)
            startActivity(intent)
        }
    }
}