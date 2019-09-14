@file:JvmName("StringUtils")

package com.project.framework.extention

import android.util.Base64
import java.io.UnsupportedEncodingException
import java.net.URI
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * Hash given string with MD5
 *
 * @receiver[String]
 */
fun String.md5(): String? {
    try {
        val md = MessageDigest.getInstance("MD5")
        md.update(toByteArray())
        val digest = md.digest()
        val hexString = StringBuffer()
        for (i in digest.indices) {
            var hex = Integer.toHexString(0xFF and digest[i].toInt())
            while (hex.length < 2) {
                hex = "0" + hex
            }
            hexString.append(hex)
        }
        return hexString.toString()
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }
    return null
}

/**
 * Encode given string with Base64 Encoder
 *
 * @receiver[String]
 */
fun String.base64Encode(): String? {
    try {
        val data = toByteArray(Charsets.UTF_8)
        return Base64.encodeToString(data, Base64.NO_WRAP)
    } catch (e: UnsupportedEncodingException) {
        e.printStackTrace()
    }
    return null
}

/**
 * Decode given string with Base64 Decoder
 *
 * @receiver[String]
 */
fun String.base64Decode(): String? {
    val data = Base64.decode(this, Base64.NO_WRAP)
    try {
        return String(data, Charsets.UTF_8)
    } catch (e: UnsupportedEncodingException) {
        e.printStackTrace()
    }
    return null
}

/**
 * Parse Uri String
 *
 * @receiver[String]
 */
fun String.asUri(): URI? {
    return try {
        URI.create(this)
    } catch (e: IllegalArgumentException) {
        null
    }
}