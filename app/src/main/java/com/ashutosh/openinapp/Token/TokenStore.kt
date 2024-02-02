package com.ashutosh.openinapp.Token

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class TokenStore @Inject constructor(private val dataStore: DataStore<Preferences>){


    companion object {
        val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
    }

    val accessTokenFlow: Flow<String?> = dataStore.data.map { preferences ->
        preferences[ACCESS_TOKEN_KEY] ?: "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8t bjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI"
    }

}
