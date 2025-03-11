package com.brentcodes.colesrecipes.data

import android.content.Context
import android.util.Log
import com.brentcodes.colesrecipes.model.RecipeResponse
import kotlinx.serialization.json.Json

object JsonFileReader {
    fun loadJsonFromAssetsAsString(context: Context, fileName: String): String? {
        val json = try {
            context.assets.open(fileName).bufferedReader().use {
                it.readText()
            }
        } catch(e: Exception) {
            Log.e("JSON", "Error reading JSON from local assets: ${e.message}")
            null
        }
        return json
    }

    fun parseJson(context: Context, fileName: String): RecipeResponse? {
        val jsonAsString = loadJsonFromAssetsAsString(context = context, fileName = fileName)
        if (jsonAsString.isNullOrBlank()) {
            Log.e("JSON", "JSON from local assets empty, unable to parse")
            return null
        }
        return try {
            Json.decodeFromString<RecipeResponse>(string = jsonAsString)
        } catch(e: Exception) {
            Log.e("JSON", "Error parsing JSON to RecipeResponse: ${e.message}")
            null
        }
    }
}