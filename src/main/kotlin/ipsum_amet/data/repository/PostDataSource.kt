package ipsum_amet.data.models.repository

import ipsum_amet.data.models.Post

interface PostDataSource {
    suspend fun createPost(post: Post) : Boolean
    suspend fun getAllPosts() :List<Post>
    suspend fun getPostByPostId(postId: String) : Post?
    suspend fun updatePost(post: Post) : Boolean
    suspend fun deletePost(postId: String) : Boolean
}