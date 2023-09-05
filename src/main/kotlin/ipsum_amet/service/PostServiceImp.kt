package ipsum_amet.service

import ipsum_amet.data.models.Post
import ipsum_amet.data.models.remote.dtos.PostDTO
import ipsum_amet.data.models.repository.PostDataSource
import ipsum_amet.data.models.toDTO

class PostServiceImp(
    private val repository: PostDataSource
): PostService {
    override suspend fun createPost(post: Post): Boolean {
        return repository.createPost(post)
    }

    override suspend fun getAllPosts(): List<PostDTO> {
        return repository.getAllPosts().map { it.toDTO()  }
    }

    override suspend fun getPostByPostId(postId: String): PostDTO? {
        return repository.getPostByPostId(postId = postId)?.toDTO()
    }

    override suspend fun updatePost(post: Post): Boolean {
        return repository.updatePost(post = post)
    }

    override suspend fun deletePost(postId: String): Boolean {
        return repository.deletePost(postId = postId)
    }

}