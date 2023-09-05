package ipsum_amet.data.models.remote.dtos

import ipsum_amet.data.models.User
import ipsum_amet.data.models.UserAccountStatus
import java.time.LocalDateTime

data class UserDTO(
    val userId: String,
    val userName: String,
    val email: String,
    val password: String,
    val accountCreated: LocalDateTime,
    val accountStatus: UserAccountStatus
)

fun UserDTO.toUser() : User {
    return User(
        userId = userId,
        userName = userName,
        email = email,
        password = password,
        accountCreated = accountCreated,
        accountStatus = accountStatus
    )
}
