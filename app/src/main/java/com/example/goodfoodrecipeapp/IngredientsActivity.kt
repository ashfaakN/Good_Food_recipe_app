package com.example.goodfoodrecipeapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IngredientsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)

        val backButton: Button = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            onBackPressed()
        }

        val recipeName = intent.getStringExtra("RECIPE_NAME")
        val recipeImageResId = intent.getIntExtra("RECIPE_IMAGE_RES_ID", 0)

        val ingredients = when (recipeName) {
            "Spaghetti Carbonara" -> listOf(
                "Spaghetti",
                "Eggs",
                "Parmesan cheese",
                "Pancetta",
                "Pepper",
                "Salt"
            )
            "Chicken Alfredo" -> listOf(
                "Fettuccine pasta",
                "Chicken breast",
                "Heavy cream",
                "Parmesan cheese",
                "Garlic",
                "Butter",
                "Salt",
                "Pepper"
            )
            "Beef Stroganoff" -> listOf(
                "Beef",
                "Mushrooms",
                "Onions",
                "Sour cream",
                "Beef broth",
                "Flour",
                "Butter",
                "Salt",
                "Pepper"
            )
            "Vegetable Stir Fry" -> listOf(
                "Broccoli",
                "Carrots",
                "Bell peppers",
                "Snow peas",
                "Soy sauce",
                "Garlic",
                "Ginger",
                "Olive oil",
                "Salt",
                "Pepper"
            )
            "Pancakes" -> listOf(
                "Flour",
                "Milk",
                "Eggs",
                "Baking powder",
                "Sugar",
                "Salt",
                "Butter"
            )
            else -> emptyList()
        }

        val recipeImageView: ImageView = findViewById(R.id.recipe_image)
        recipeImageView.setImageResource(recipeImageResId)

        val ingredientsTextView: TextView = findViewById(R.id.ingredients_text)
        ingredientsTextView.text = ingredients.joinToString("\n")
    }
}
