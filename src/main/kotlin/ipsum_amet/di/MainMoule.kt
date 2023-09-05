package ipsum_amet.di

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.dsl.module
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module(createdAtStart = true) {
    single { provideDatabase() }

    single { provideNormalHttpClient() }
}

private fun provideDatabase() : CoroutineDatabase {

    //TODO("Use environment variable instead")

    return  KMongo.createClient("mongodb+srv://osmontmagnus:0svIoHKqA0RaMnTr@cluster0.v59rl4k.mongodb.net/?retryWrites=true&w=majority")
        .coroutine
        .getDatabase("BACKEND-ASSEMENT-PROMPT-NA'AMAL")
}

@OptIn(ExperimentalSerializationApi::class)
private fun provideNormalHttpClient() : HttpClient {
    return HttpClient(CIO) {


        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                explicitNulls = false
            })
        }
    }
}