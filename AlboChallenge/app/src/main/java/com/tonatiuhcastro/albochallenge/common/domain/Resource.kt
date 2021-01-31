package com.tonatiuhcastro.albochallenge.common.domain

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 1/31/21
 * @updated on
 * @modified by
 */
class Resource<T> private constructor(val status: Resource.Status, val data: T?, val exception: Exception?) {
        enum class Status {
            SUCCESS, ERROR, LOADING, EXCEPTION
        }
        companion object {
            fun <T> success(data: T?): Resource<T> {
                return Resource(Status.SUCCESS, data, null)
            }
            fun <T> error(exception: Exception?): Resource<T> {
                return Resource(Status.ERROR, null, exception)
            }
            fun <T> exception(exception: Exception?): Resource<T> {
                return Resource(Status.EXCEPTION, null, exception)
            }
            fun <T> loading(data: T?): Resource<T> {
                return Resource(Status.LOADING, data, null)
            }
        }
}