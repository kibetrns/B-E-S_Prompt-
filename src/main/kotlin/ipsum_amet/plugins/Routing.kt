package ipsum_amet.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ipsum_amet.routes.*
import ipsum_amet.service.PostService
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    val postService by inject<PostService>()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        createPost(application = application, postService = postService)
        getAllPosts(application = application, postService = postService)
        getPostByPostId(application = application, postService = postService)
        updatePost(application = application, postService = postService)
        deletePost(application = application, postService = postService)
    }
}
