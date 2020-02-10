package com.hotatekaoru.carbscounter

import android.content.Context

class CarbsInteractor(private val context: Context) {

    companion object {
        private const val PREFS_NAME = "CarbsCounter"
        private const val KEY_RICE = "rice"
        private const val KEY_SNACK = "snack"
        private const val KEY_JUICE = "juice"
    }

    internal fun saveRiceCount(value: Int) {
        val prefs = context.getSharedPreferences(PREFS_NAME, 0).edit()
        prefs.putInt(KEY_RICE, value)
        prefs.apply()
    }

    internal fun saveSnackCount(value: Int) {
        val prefs = context.getSharedPreferences(PREFS_NAME, 0).edit()
        prefs.putInt(KEY_SNACK, value)
        prefs.apply()
    }

    internal fun saveJuiceCount(value: Int) {
        val prefs = context.getSharedPreferences(PREFS_NAME, 0).edit()
        prefs.putInt(KEY_JUICE, value)
        prefs.apply()
    }

    internal fun loadCarbs(): Carbs {
        val prefs = context.getSharedPreferences(PREFS_NAME, 0)
        return Carbs(
            rice = prefs.getInt(KEY_RICE, 0),
            snack = prefs.getInt(KEY_SNACK, 0),
            juice = prefs.getInt(KEY_JUICE, 0)
        )
    }
}
