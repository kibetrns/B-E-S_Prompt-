package ipsum_amet.service

import ipsum_amet.data.models.remote.dtos.PostDTO
import ipsum_amet.data.models.remote.dtos.toPost
import ipsum_amet.data.models.repository.PostDataSource
import ipsum_amet.data.models.toDTO
import org.bson.types.ObjectId

class PostServiceImp(
    private val repository: PostDataSource
): PostService {
    override suspend fun createPost(postDTO: PostDTO): Boolean {
        return repository.createPost(post = postDTO.toPost())
    }

    override suspend fun getAllPosts(): List<PostDTO> {
        return repository.getAllPosts().map { it.toDTO()  }
    }

    override suspend fun getPostByPostId(postId: String): PostDTO? {
        return repository.getPostByPostId(postId = postId)?.toDTO()
    }

    override suspend fun updatePost(post: PostDTO): Boolean {
        return repository.updatePost(post = post.toPost())
    }

    override suspend fun deletePost(postId: String): Boolean {
        return repository.deletePost(postId = postId)
    }

}