package com.brentcodes.colesrecipes.data

import android.content.Context
import kotlinx.serialization.json.Json

object JsonFileReader {
    fun loadJsonFromAssetsAsString(context: Context, fileName: String): String? {
        val json = try {
            context.assets.open(fileName).bufferedReader().use {
                it.readText()
            }
        } catch(e: Exception) {
            print(e.message)
            null
        }
        return json
    }

    fun parseJson(context: Context, fileName: String): RecipeResponse? {
        val jsonAsString = loadJsonFromAssetsAsString(context = context, fileName = fileName)
        if (jsonAsString.isNullOrBlank()) {
            return null
        }
        return try {
            Json.decodeFromString<RecipeResponse>(string = jsonAsString)
        } catch(e: Exception) {
            print(e.message)
            null
        }
    }
}