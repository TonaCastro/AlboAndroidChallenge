package com.tonatiuhcastro.albochallenge.common.domain

import java.lang.Exception

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 1/31/21
 * @updated on
 * @modified by
 */
data class ResultException(
    var kindError: ValidationError? = null,
    var message: String? = null,
    var exception: Exception? = null)