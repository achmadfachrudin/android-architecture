@file:JvmName("NumberFormattingUtils")

package com.project.framework.extention

import com.project.framework.util.Constants
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

/**
 * Format integer number as Rupiah (Rp)
 *
 * @receiver[Int]
 */
fun Int.formatAsRupiah(): String {
    return if (this < 0) "- Rp " + NumberFormat.getInstance(Locale(Constants.LANGUAGE)).format(this * -1)
    else "Rp " + NumberFormat.getInstance(Locale(Constants.LANGUAGE)).format(this)
}

/**
 * Format long number as Rupiah (Rp)
 *
 * @receiver[Long]
 */
fun Long.formatAsRupiah(): String {
    return if (this < 0L) "- Rp " + NumberFormat.getInstance(Locale(Constants.LANGUAGE)).format(
        this * -1
    )
    else "Rp " + NumberFormat.getInstance(Locale(Constants.LANGUAGE)).format(this)
}

/**
 * Format decimal number as Rupiah (Rp)
 *
 * @receiver[Double]
 */
fun Double.formatAsRupiah(): String {
    return if (this < 0.0) "- Rp " + NumberFormat.getInstance(Locale(Constants.LANGUAGE)).format(
        this * -1
    )
    else "Rp " + NumberFormat.getInstance(Locale(Constants.LANGUAGE)).format(this)
}

/**
 * Format big decimal number as Rupiah (Rp)
 *
 * @receiver[BigDecimal]
 */
fun BigDecimal.formatAsRupiah(): String {
    return "Rp " + NumberFormat.getInstance(Locale(Constants.LANGUAGE)).format(this)
}
