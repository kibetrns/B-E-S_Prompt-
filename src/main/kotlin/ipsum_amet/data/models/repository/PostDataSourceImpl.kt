package ipsum_amet.data.models.repository

import ipsum_amet.data.models.Post
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.insertOne
import org.litote.kmongo.eq
import org.litote.kmongo.setValue

class PostDataSourceImpl (db: CoroutineDatabase) : PostDataSource{

    val postsCollection = db.getCollection<Post>()


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
        TODO("Not yet implemented")
    }



    override suspend fun deletePost(postId: String): Boolean {
        TODO("Not yet implemented")
    }


}
