package com.example.learning

data class Student(
    val id: Int,
    val name: String,
    val regNumber: String,
    val program: String,
    val profileImage: Int,
    val isVerified: Boolean = false
)
