package ipsum_amet.data.models

import ipsum_amet.data.models.remote.dtos.PostDTO
import kotlinx.datetime.toKotlinLocalDateTime
import java.time.LocalDateTime
import kotlin.reflect.KProperty0

data class Post(
    val postId: String,
    val whomPosted: String,
    val postMessage: String,
    val whenPosted: LocalDateTime,
)

fun Post.toDTO(): PostDTO {
    return PostDTO(
        postId,
        whomPosted,
        postMessage,
        whenPosted.toKotlinLocalDateTime()
    )
}



