package com.example.swiggyclone

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val listView = findViewById<ListView>(R.id.orderList)
        val totalText = findViewById<TextView>(R.id.finalTotal)
        val confirmBtn = findViewById<Button>(R.id.confirmBtn)
        val userDetails = findViewById<TextView>(R.id.userDetails)

        // ✅ FIX 1: correct way to get data
        val cart = intent.getSerializableExtra("cart") as? ArrayList<FoodItem>
        val total = intent.getIntExtra("total", 0)




        if (cart == null) {
            Toast.makeText(this, "No items found", Toast.LENGTH_SHORT).show()
            return
        }

        val items = cart.map { "${it.name} - ₹${it.price}" }

        listView.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            items
        )

        totalText.text = "Total: ₹$total"

        // ✅ FIX 2: Toast must have .show()
        confirmBtn.setOnClickListener {
            Toast.makeText(this, "Order Placed Successfully 🎉", Toast.LENGTH_LONG).show()
        }
    }
}