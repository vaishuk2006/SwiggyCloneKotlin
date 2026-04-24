package com.example.swiggyclone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.listOf
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val cartList = ArrayList<FoodItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val btnCart = findViewById<Button>(R.id.btnCart)

        val foodList = listOf(
            FoodItem("Burger", 120, R.drawable.burger),
            FoodItem("Pizza", 250, R.drawable.pizza),
            FoodItem("Biryani", 180, R.drawable.biryani),
            FoodItem ("Momos", 100, R.drawable.momos),
            FoodItem("Noodles", 90, R.drawable.noodles),
            FoodItem("Fries", 80, R.drawable.fries),
            FoodItem("Coke", 50, R.drawable.coke),
            FoodItem("CupCake", 65, R.drawable.cupcake)
        );

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = FoodAdapter(foodList) { selectedItem ->
            cartList.add(selectedItem)

            Toast.makeText(
                this,
                "${selectedItem.name} added to cart",
                Toast.LENGTH_SHORT
            ).show()
        }

        btnCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)

            intent.putExtra("cart", cartList)
            startActivity(intent)

            Toast.makeText(this, "Cart size: ${cartList.size}", Toast.LENGTH_SHORT).show()
        }
    }
}