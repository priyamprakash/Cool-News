package com.anushka.newsapiclient.data.api


import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPIServiceTest {

    private lateinit var service: NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    private fun enqueueMockResponse(
      fileName:String
    ){
      val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
      val source = inputStream.source().buffer()
      val mockResponse = MockResponse()
      mockResponse.setBody(source.readString(Charsets.UTF_8))
      server.enqueue(mockResponse)

    }

    @Test
    fun getTopHeadlines_sentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines("us",1).body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=b7122b5c5f8948eda9715867b6240ce6")
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctPageSize(){
      runBlocking {
          enqueueMockResponse("newsresponse.json")
          val responseBody = service.getTopHeadlines("us",1).body()
          val articlesList = responseBody!!.articles
          assertThat(articlesList.size).isEqualTo(20)
      }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctContent(){
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines("us",1).body()
            val articlesList = responseBody!!.articles
            val article = articlesList[0]
            assertThat(article.author).isEqualTo("Saheli Roy Choudhury")
            assertThat(article.url).isEqualTo("https://www.cnbc.com/2021/01/04/samsung-galaxy-unpacked-2021.html")
            assertThat(article.publishedAt).isEqualTo("2021-01-04T03:25:00Z")
        }
    }

    @After
    fun tearDown() {
       server.shutdown()
    }
}