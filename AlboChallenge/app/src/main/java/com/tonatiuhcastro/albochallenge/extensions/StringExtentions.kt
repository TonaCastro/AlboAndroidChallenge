package com.tonatiuhcastro.albochallenge.extensions

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 1/31/21
 * @updated on
 * @modified by
 */

fun String?.value(): String {
    if (this.equals(null)) {
        return ""
    } else {
        return  this.value()
    }
}
