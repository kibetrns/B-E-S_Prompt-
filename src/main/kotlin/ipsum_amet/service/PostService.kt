package ipsum_amet.service

import ipsum_amet.data.models.remote.dtos.PostDTO
import org.bson.types.ObjectId

interface PostService {
    suspend fun createPost(postDTO: PostDTO) : Boolean
    suspend fun getAllPosts() :List<PostDTO>
    suspend fun getPostByPostId(postId: String) : PostDTO?
    suspend fun updatePost(postDTO: PostDTO) : Boolean
    suspend fun deletePost(postId: String) : Boolean
}