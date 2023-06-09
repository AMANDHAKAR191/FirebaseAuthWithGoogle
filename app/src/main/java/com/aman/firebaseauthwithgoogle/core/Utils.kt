package com.aman.firebaseauthwithgoogle.core

import android.util.Log
import com.aman.firebaseauthwithgoogle.core.Constants.TAG

class Utils {
    companion object {
        fun print(e: Exception) = Log.e(TAG, e.stackTraceToString())
    }
}