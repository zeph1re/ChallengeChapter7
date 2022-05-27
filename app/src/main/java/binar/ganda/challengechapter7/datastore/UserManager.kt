package binar.ganda.challengechapter7.datastore

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserManager (context: Context){

    private val dataStore : DataStore<Preferences> = context.createDataStore("user_prefs")

    companion object {
        val USERNAME = preferencesKey<String>("USERNAME")
        val PASSWORD = preferencesKey<String>("PASSWORD")

        val EMAIL = preferencesKey<String>("EMAIL")
        val ID = preferencesKey<Int>("ID")

    }

    suspend fun saveDataLogin( username : String, password : String){
        dataStore.edit {
            it[USERNAME] = username
            it[PASSWORD] = password
        }
    }

    suspend fun logout(){
        dataStore.edit {
            it.clear()
        }
    }

    val userUsername : Flow<String> = dataStore.data.map {
        it[UserManager.USERNAME] ?: ""
    }

    val userPassword : Flow<String> = dataStore.data.map {
        it[UserManager.PASSWORD] ?: ""
    }

}