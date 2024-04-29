package com.sufaka.heliosquizapp.Domain

data class UserModel(
    val id:Int,
    val name:String,
    val pic:String,
    val scope: Int,
    val score: Int
)
