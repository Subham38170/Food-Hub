package com.example.foodhub.data.repository

import com.example.foodhub.core.Result
import com.example.foodhub.core.constants.FirebaseConstants
import com.example.foodhub.data.mappers.UserMapper
import com.example.foodhub.data.model.user.UserDto
import com.example.foodhub.domain.model.user.User
import com.example.foodhub.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await


//Authentication class which has several methods like login with email and passowrd,Sign Up with email,password and name
class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRepository {
    //Sign In using email and password
    //For sucess it loads the stored User data
    override fun loginWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<Result<User>> = flow {
        emit(Result.Loading)
        try {
            val authResult = auth.signInWithEmailAndPassword(email, password).await()
            val uid = authResult.user?.uid ?: throw Exception("Failed to fetch User Id")

            val doc = firestore.collection(FirebaseConstants.USERS)
                .document(uid)
                .get()
                .await()
            val dto = doc.toObject(UserDto::class.java) ?: throw Exception("user data missing")
            val user = UserMapper.fromDto(dto)
            emit(Result.Success(user))
        } catch (e: Exception) {
            emit(Result.Error(e.message ?: "Login Failed"))
        }

    }.flowOn(Dispatchers.IO)

    //Sign up with email and password
    //Once created account it stores the user info like email,name,uid in firestore
    override fun signUpWithEmailAndPassword(
        fullName: String,
        email: String,
        password: String
    ): Flow<Result<User>> = flow {

        emit(Result.Loading)
        try {
            val authResult = auth.createUserWithEmailAndPassword(email, password).await()
            val uid = authResult.user?.uid ?: throw Exception("Failed to create user Id.")

            val userDto = UserDto(
                email = email,
                uid = uid,
                name = fullName
            )
            val doc = firestore.collection(FirebaseConstants.USERS)
                .document(uid)
                .set(userDto).await()
            val user = UserMapper.fromDto(userDto)
            emit(Result.Success(user))
        } catch (e: Exception) {
            emit(Result.Error(e.message ?: "SignUp Failed. Please try again"))
        }
    }.flowOn(Dispatchers.IO)


}