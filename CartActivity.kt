package com.example.swiggyclone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val recycler = findViewById<RecyclerView>(R.id.cartRecycler)
        val totalText = findViewById<TextView>(R.id.totalText)
        val orderBtn = findViewById<Button>(R.id.orderBtn)

        val cart = intent.getSerializableExtra("cart") as ArrayList<FoodItem>

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = CartAdapter(cart)

        val total = cart.sumOf { it.price }
        totalText.text = "Total: ₹$total"

        orderBtn.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)

            intent.putExtra("cart", cart)
            intent.putExtra("total", total)

            startActivity(intent)
        }
    }
}