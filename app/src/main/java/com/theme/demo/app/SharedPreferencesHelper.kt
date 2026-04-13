package com.theme.demo.app

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferencesHelper(context: Context) {

    private val prefsName = "my_prefs"
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)

    fun saveBoolean(key: String, value: Boolean) {
        sharedPreferences.edit {
            putBoolean(key, value)
        }
    }

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun saveString(key: String, value: String) {
        sharedPreferences.edit {
            putString(key, value)
        }
    }

    fun saveInt(key: String, value: Int) {
        sharedPreferences.edit {
            putInt(key, value)
        }
    }

    fun getInt(key: String, defaultValue: Int = 0): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun getString(key: String, defaultValue: String = ""): String? {
        return sharedPreferences.getString(key, defaultValue)
    }
}
