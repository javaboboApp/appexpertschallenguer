package com.theappexperts.supergit.utils

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.inputmethod.InputMethodManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

private const val TAG = "Utitlites"

object Utitlites {
    fun runDelayForTesting(runDelay: Boolean, runWihDelayTesting: () -> Unit) {
        if (runDelay)
            GlobalScope.launch {
                delay(1000)
                runWihDelayTesting()
            }
        else
            runWihDelayTesting()
    }


    fun Activity.hideKeyBoardHelper() {
        if (currentFocus != null) {
            val inputMethodManager = getSystemService(
                Context.INPUT_METHOD_SERVICE
            ) as InputMethodManager
            inputMethodManager
                .hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
    }

}