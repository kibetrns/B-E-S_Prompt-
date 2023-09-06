package ipsum_amet.data.models

import ipsum_amet.data.models.remote.dtos.UserDTO
import kotlinx.datetime.toKotlinLocalDateTime
import org.bson.types.ObjectId
import java.time.LocalDateTime

data class User(
    val userId: String,
    val userName: String,
    val email: String,
    val password: String,
    val accountCreated: LocalDateTime,
    val accountStatus: UserAccountStatus
)

fun User.toDTO(): UserDTO {
    return UserDTO(
        userId = userId,
        userName = userName,
        email = email,
        password = password,
        accountCreated = accountCreated.toKotlinLocalDateTime(),
        accountStatus =  accountStatus
    )
}

