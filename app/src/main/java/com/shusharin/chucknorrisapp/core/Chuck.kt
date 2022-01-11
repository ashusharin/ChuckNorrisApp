package com.shusharin.chucknorrisapp.core

// TODO: 06.01.2022 fix технический долг
data class Chuck(
    val categories: List<String>,
    val createdAt:String,
    val icon: String,
    val id: String,
    val updatedAt: String,
    val url: String,
    val value: String,
)