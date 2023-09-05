package ipsum_amet.service

import ipsum_amet.data.models.Post
import ipsum_amet.data.models.remote.dtos.PostDTO

interface PostService {
    suspend fun createPost(post: Post) : Boolean
    suspend fun getAllPosts() :List<PostDTO>
    suspend fun getPostByPostId(postId: String) : PostDTO?
    suspend fun updatePost(post: Post) : Boolean
    suspend fun deletePost(postId: String) : Boolean
}