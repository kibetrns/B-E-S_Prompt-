package ipsum_amet.data.models.repository

import com.mongodb.client.model.Updates.set
import ipsum_amet.data.models.Post
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq
import org.litote.kmongo.set
import org.litote.kmongo.setTo

class PostDataSourceImpl (db: CoroutineDatabase) : PostDataSource{

    private val postsCollection = db.getCollection<Post>()

    override suspend fun createPost(post: Post): Boolean {
        return postsCollection.insertOne(
            Post(
                postId = post.postId,
                whomPosted = post.whomPosted,
                postMessage =  post.postMessage,
                whenPosted = post.whenPosted
            )
        ).wasAcknowledged()
    }

    override suspend fun getAllPosts(): List<Post> {
        return postsCollection.find().toList()
    }

    override suspend fun getPostByPostId(postId: String): Post? {
        return postsCollection.findOneById(id = postId)
    }

    override suspend fun updatePost(post: Post): Boolean {
        val postIdFilter = Post::postId eq post.postId
        val updateOperation = set(
            Post::whomPosted setTo post.whomPosted,
            Post::postMessage setTo post.postMessage,
            Post::whenPosted setTo post.whenPosted
        )

        val updateResult = postsCollection.updateOne(postIdFilter, updateOperation)
        return updateResult.wasAcknowledged()
    }

    override suspend fun deletePost(postId: String): Boolean {
        return postsCollection.deleteOne(Post::postId eq postId).wasAcknowledged()
    }
}
