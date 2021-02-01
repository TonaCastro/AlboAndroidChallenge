package com.tonatiuhcastro.albochallenge.common.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/1/21
 * @updated on
 * @modified by
 */
class UtilsDate {
    @SuppressLint("SimpleDateFormat")
    val parser: SimpleDateFormat =  SimpleDateFormat("MM/dd/yyyy")

    @SuppressLint("SimpleDateFormat")
    fun stringToFormatDateMonth(stringDate: String): String {
        if (stringDate != "") {
            val formatter = SimpleDateFormat("MMM")
            val date = parser.parse(stringDate)
            date?.let {
                return  formatter.format(it)
            }
        }
        return ""
    }
}