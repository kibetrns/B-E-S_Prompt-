package ipsum_amet.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ipsum_amet.data.models.remote.dtos.PostDTO
import ipsum_amet.service.PostService
import kotlinx.coroutines.async
import java.util.*

fun Route.createPost(application: Application, postService: PostService) {

    post("post") {

        try {

            val request = call.receive<PostDTO>()

            val postDTO  = PostDTO(
                postId = request.postId,
                whomPosted = request.whomPosted,
                postMessage =  request.postMessage,
                whenPosted = request.whenPosted
            )


            println("tttttttttttttttttttttttttttttt $postDTO")

            val isPostCreated = postService.createPost(postDTO = postDTO)

            if (isPostCreated) {
                call.respond(HttpStatusCode.Created, "Post Created.")
            }
        } catch (ex: Exception) {
            application.log.error(ex.message)

            call.respond(HttpStatusCode.InternalServerError, ex.localizedMessage)
        }
    }

}

fun Route.getAllPosts(application: Application, postService: PostService) {


    get("post") {
        call.respond(HttpStatusCode.OK, postService.getAllPosts())
    }
}

fun Route.getPostByPostId(application: Application, postService: PostService) {
    get("post") {
        val postId = call.request.queryParameters["postId"] ?: ""

        try {
            val result =  postService.getPostByPostId(postId = postId)
            if (result != null) {
                call.respond(HttpStatusCode.OK, result)
            } else {
                call.respond(HttpStatusCode.NotFound, "Post not found")
            }
        } catch (ex: Exception) {
            call.respond(HttpStatusCode.InternalServerError, ex.localizedMessage)
        }
    }
}



fun Route.updatePost(application: Application, postService: PostService) {
    put("post") {

        val post = call.receive<PostDTO>()

        println(post.toString())

        try {
            val resultSuccess = postService.updatePost(postDTO = post)

            if (resultSuccess) {
                call.respond(HttpStatusCode.OK, "Update Successful")
            } else {
                call.respond(
                    HttpStatusCode.Conflict,
                    "Update NOT Successful"
                )
                return@put
            }
        } catch (ex: Exception) {
            call.respond(HttpStatusCode.InternalServerError, ex.localizedMessage)
        }
    }
}


fun Route.deletePost(application: Application, postService: PostService) {
    delete("post") {

        val postId = call.request.queryParameters["postId"] ?: ""

        try {
            val postToDelete = postService.getPostByPostId(postId = postId)

            if (postToDelete != null) {
                val resultSuccess = postService.deletePost(postId = postId)

                if (resultSuccess) {
                    call.respond(HttpStatusCode.OK, "Deleted Successfully")
                } else {
                    call.respond(HttpStatusCode.InternalServerError, "Failed to delete the post")
                }
            } else {
                call.respond(HttpStatusCode.NotFound, "Post not found")
            }
        } catch (ex: Exception) {
            call.respond(HttpStatusCode.InternalServerError, ex.localizedMessage)
        }
    }
}
