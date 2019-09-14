package com.project.framework.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by achmad.fachrudin on 21-Mar-19
 */
object DateUtil {
    const val EEEE = "EEEE"
    const val dd_MMMM_yyyy = "dd MMMM yyyy" // 21 Jan 2021
    const val yyyy_MM_dd = "yyyy-MM-dd" // 2021-01-21
    const val yyyy_MM_dd_T_HHmmss_Z = "yyyy-MM-dd'T'HH:mm:ss'Z'" //2019-05-20T12:27:01Z

    /**
     * @param dateSource is String
     * @param pattern is String example yyyy_MM_dd
     * @return String
     */
    fun getNameDay(dateSource: String, pattern: String): String {
        val date = SimpleDateFormat(pattern, Locale(Constants.LANGUAGE)).parse(dateSource)
        val nameOfday = SimpleDateFormat("EEEE", Locale(Constants.LANGUAGE)).format(date)
        return SimpleDateFormat(EEEE, Locale("in")).format(date)
    }

    /**
     * @param milliseconds is Long example 1558363965259
     * @param newFormat is String example dd_MMMM_yyyy
     * @return String
     */
    fun longToDateFormat(milliseconds: Long, newFormat: String): String {
        val sdf = SimpleDateFormat(newFormat, Locale(Constants.LANGUAGE))
        val mDate = Date(milliseconds)
        return sdf.format(mDate)
    }

    /**
     * @param dateSource is String
     * @param oldFormat is String example yyyy_MM_dd_T_HHmmss_Z
     * @param newFormat is String example dd_MMMM_yyyy
     * @return String
     */
    fun changeFormat(dateSource: String, oldFormat: String, newFormat: String): String {
        val oldDateFormat = SimpleDateFormat(oldFormat, Locale(Constants.LANGUAGE))
        val milliseconds = oldDateFormat.parse(dateSource)
        val newDateFormat = SimpleDateFormat(newFormat, Locale(Constants.LANGUAGE))
        return newDateFormat.format(milliseconds)
    }

    /**
     * @param dateSource is String 2013 04 01
     * @param fromFormat is yyyy_MM_dd
     * @return String of 3 bulan lalu
     */
    fun getTimeAgo(dateSource: String, fromFormat: String): String? {
        var fixTime: String? = null
        try {
            val dateFormat = SimpleDateFormat(fromFormat, Locale(Constants.LANGUAGE))
            val pasTime = dateFormat.parse(dateSource)
            val nowTime = Date()
            val dateGap = nowTime.time - pasTime.time
            val detik = TimeUnit.MILLISECONDS.toSeconds(dateGap)
            val menit = TimeUnit.MILLISECONDS.toMinutes(dateGap)
            val jam = TimeUnit.MILLISECONDS.toHours(dateGap)
            val hari = TimeUnit.MILLISECONDS.toDays(dateGap)

            when {
                detik < 60 -> fixTime = "$detik detik lalu"
                menit < 60 -> fixTime = "$menit menit lalu"
                jam < 24 -> fixTime = "$jam jam lalu"
                hari >= 7 -> fixTime = when {
                    hari > 30 -> (hari / 30).toString() + " bulan lalu"
                    hari > 360 -> (hari / 360).toString() + " tahun lalu"
                    else -> (hari / 7).toString() + " minggu lalu"
                }
                hari < 7 -> fixTime = "$hari hari lalu"
            }
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return fixTime
    }
}