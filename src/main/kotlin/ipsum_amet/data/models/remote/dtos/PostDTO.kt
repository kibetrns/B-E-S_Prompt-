package ipsum_amet.data.models.remote.dtos

import ipsum_amet.data.models.Post
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toJavaLocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class PostDTO(
    val postId: String,
    val whomPosted: String,
    val postMessage: String,
    val whenPosted: LocalDateTime,
)

fun PostDTO.toPost(): Post {
    return Post(
        postId = postId,
        whomPosted = whomPosted,
        postMessage = postMessage,
        whenPosted = whenPosted.toJavaLocalDateTime()
    )
}
