package com.brentcodes.colesrecipes

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.brentcodes.colesrecipes.data.JsonFileReader
import com.brentcodes.colesrecipes.model.RecipeResponse
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class JsonFileReaderTest {

    /*
    * Android Instrumented Tests used here due to the need for the Android context: Context
    * object when parsing the Json from the assets file.
    *
    * Rather than mocking or faking this Context implementation, I have used
    * the Android ApplicationProvider to retrieve a context in these tests.
    * */
    private val context: Context = ApplicationProvider.getApplicationContext()

    @Test
    fun checkParseJsonWhenValid() {
        val result = JsonFileReader.parseJson(context, "test_valid.json")
        assertNotNull(result)
        assertTrue(result is RecipeResponse)
    }

    @Test
    fun checkParseJsonWhenMissing() {
        val result = JsonFileReader.parseJson(context, "missing.json")
        /*
        * Could also throw the error in the parseJson function,
        * and validate the error type here - but currently just validating
        * that null result is obtained.
        * */
        assertNull(result)
    }

    @Test
    fun checkParseJsonWhenInvalid() {
        val result = JsonFileReader.parseJson(context, "test_invalid.json")
        assertNull(result)
    }
}
