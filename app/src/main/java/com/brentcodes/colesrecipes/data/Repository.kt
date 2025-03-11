package com.brentcodes.colesrecipes.data

import android.content.Context

interface ColesRepository {
    fun getData(): RecipeResponse?
}

class ColesRepositoryImpl(private val context: Context) : ColesRepository {

    override fun getData() : RecipeResponse? {
        return JsonFileReader.parseJson(context, "recipesSample.json")
    }

}