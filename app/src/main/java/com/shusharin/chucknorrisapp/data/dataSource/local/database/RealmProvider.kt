package com.shusharin.chucknorrisapp.data.dataSource.local.database

import io.realm.Realm

interface RealmProvider {

    fun provide(): Realm

    class Base() : RealmProvider {
        override fun provide(): Realm = Realm.getDefaultInstance()
    }
}