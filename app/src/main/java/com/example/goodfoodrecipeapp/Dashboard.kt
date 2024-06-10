package com.example.goodfoodrecipeapp

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val profileButton: Button = findViewById(R.id.buttonProfile)

        profileButton.setOnClickListener {
            startActivity(Intent(this, activity_profile::class.java))
        }

        val recipes = listOf(
            Recipe("Spaghetti Carbonara", R.drawable.spaghetti_carbonara),
            Recipe("Chicken Alfredo", R.drawable.chicken_alfredo),
            Recipe("Beef Stroganoff", R.drawable.beefstroganoff),
            Recipe("Vegetable Stir Fry", R.drawable.vegetable_stir_fry),
            Recipe("Pancakes", R.drawable.pancakes)
        )

        val infoButton: Button = findViewById(R.id.infoButton)

        infoButton.setOnClickListener {
            startActivity(Intent(this, infopopup::class.java))
        }

        val adapter = RecipeAdapter(this, recipes)
        val listView: ListView = findViewById(R.id.recipe_list)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedRecipe = recipes[position]
            val intent = Intent(this, IngredientsActivity::class.java).apply {
                putExtra("RECIPE_NAME", selectedRecipe.name)
                putExtra("RECIPE_IMAGE_RES_ID", selectedRecipe.imageResource)
            }
            startActivity(intent)
        }


    }
}
