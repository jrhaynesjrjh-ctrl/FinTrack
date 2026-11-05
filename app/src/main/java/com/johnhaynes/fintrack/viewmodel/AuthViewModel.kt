package com.johnhaynes.fintrack.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    fun loginUser(
        context: Context,
        username: String,
        password: String,
        callback: (Boolean, String) -> Unit
    ) {
        if (username.isNotBlank() && password.isNotBlank()) {
            callback(true, "Login successful")
        } else {
            callback(false, "Please enter username and password")
        }
    }

    fun registerUser(
        context: Context,
        username: String,
        email: String,
        password: String,
        callback: (Boolean, String) -> Unit
    ) {
        if (
            username.isNotBlank() &&
            email.isNotBlank() &&
            password.length >= 8
        ) {
            callback(true, "Registration successful")
        } else {
            callback(false, "Please complete all fields")
        }
    }

    fun changePassword(
        context: Context,
        userId: Int,
        newPassword: String,
        callback: (Boolean, String) -> Unit
    ) {
        if (newPassword.length >= 8) {
            callback(true, "Password updated successfully")
        } else {
            callback(false, "Password must be at least 8 characters")
        }
    }
}