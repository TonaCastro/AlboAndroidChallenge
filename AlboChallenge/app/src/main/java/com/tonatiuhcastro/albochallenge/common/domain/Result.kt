package com.tonatiuhcastro.albochallenge.common.domain

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 1/31/21
 * @updated on
 * @modified by
 */
class Result<T> private constructor(var status: Status, var data: T?, var exception: ResultException?) {
        enum class Status {
            SUCCESS, LOADING, EXCEPTION
        }
        companion object {
            fun <T> success(data: T?): Result<T> {
                return Result(Status.SUCCESS, data, null)
            }
            fun <T> exception(exception: ResultException?): Result<T> {
                return Result(Status.EXCEPTION, null, exception)
            }
            fun <T> loading(data: T?): Result<T> {
                return Result(Status.LOADING, data, null)
            }
        }
}