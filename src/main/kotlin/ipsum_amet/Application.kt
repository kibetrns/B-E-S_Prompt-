package ipsum_amet

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import ipsum_amet.di.configureKoin
import ipsum_amet.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
            .start(wait = true)
}

fun Application.module() {
    configureKoin()
    configureHTTP()
    configureSerialization()
    configureRouting()
}
