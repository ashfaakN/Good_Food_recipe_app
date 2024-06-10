package com.example.goodfoodrecipeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class RecipeAdapter(private val context: Context, private val dataSource: List<Recipe>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: inflater.inflate(R.layout.list_item_recipe, parent, false)

        val recipe = getItem(position) as Recipe

        val recipeNameTextView = view.findViewById<TextView>(R.id.recipe_name)
        val recipeImageView = view.findViewById<ImageView>(R.id.recipe_image)

        recipeNameTextView.text = recipe.name
        recipeImageView.setImageResource(recipe.imageResource)

        return view
    }
}

data class Recipe(val name: String, val imageResource: Int)
