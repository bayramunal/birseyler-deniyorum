package com.hacib.duygusalbiruygulama.db

class UserRepository(
    private val db: UserDatabase
) {
    suspend fun insertUser(user: User) = db.getUserDao().upsertUser(user)
}