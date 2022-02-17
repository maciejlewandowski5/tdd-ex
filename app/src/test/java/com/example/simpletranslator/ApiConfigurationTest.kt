package com.example.simpletranslator
// ktlint-disable no-wildcard-imports

import com.example.simpletranslator.model.DefinitionItem
import com.example.simpletranslator.resources.response
import com.example.simpletranslator.rest.api.ApiConfiguration
import com.example.simpletranslator.rest.api.DictionaryService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class TranslateServiceWebServerTest {

    @Test
    fun verifyApiConfiguration() {
        // given
        val server = MockWebServer()
        server.enqueue(MockResponse().setBody(response))
        val service = ApiConfiguration()
            .createConfiguration(server.url("/"))
            .create(DictionaryService::class.java)

        // when
        val translation = service.translate("word").blockingFirst()
        translation

        // then

        val request = server.takeRequest()
        assertEquals("/word", request.path)
        assertEquals("application/json", request.getHeader("Accept"))
        server.shutdown()

        val itemType = object : TypeToken<List<DefinitionItem>>() {}.type

        assertEquals(
            translation, Gson().fromJson(response, itemType)
        )
        server.shutdown()
    }
}
