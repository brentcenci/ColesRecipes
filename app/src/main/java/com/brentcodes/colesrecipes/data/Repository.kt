package com.brentcodes.colesrecipes.data

import android.content.Context

class Repository(private val context: Context) {

    fun getData() : RecipeResponse? {
        return JsonFileReader.parseJson(context, "recipesSample.json")
    }

}