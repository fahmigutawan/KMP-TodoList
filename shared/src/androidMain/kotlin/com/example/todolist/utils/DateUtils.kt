package com.example.todolist.utils

object DateUtils {
    private const val DEFAULT_INPUT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    private const val DEFAULT_OUTPUT_FORMAT = "HH:mm, dd MMM yyyy"

    fun dateUtcToFormatted(
        input: String,
        inputFormat: String = DEFAULT_INPUT_FORMAT,
        outputFormat: String = DEFAULT_OUTPUT_FORMAT
    ): String? {
        return try {
            val formatter = java.text.SimpleDateFormat(inputFormat, java.util.Locale.getDefault())
            formatter.timeZone = java.util.TimeZone.getTimeZone("UTC")
            val date = formatter.parse(input)
            val outputFormatter = java.text.SimpleDateFormat(outputFormat, java.util.Locale.getDefault())
            outputFormatter.format(date)
        } catch (e: Exception) {
            null
        }
    }

    fun formattedToDateUtc(
        input: String,
        inputFormat: String = DEFAULT_OUTPUT_FORMAT,
        outputFormat: String = DEFAULT_INPUT_FORMAT
    ): String? {
        return try {
            val formatter = java.text.SimpleDateFormat(inputFormat, java.util.Locale.getDefault())
            val date = formatter.parse(input)
            val outputFormatter = java.text.SimpleDateFormat(outputFormat, java.util.Locale.getDefault())
            outputFormatter.timeZone = java.util.TimeZone.getTimeZone("UTC")
            outputFormatter.format(date)
        } catch (e: Exception) {
            null
        }
    }

    fun getCurrentDateUtc(): String {
        val formatter = java.text.SimpleDateFormat(DEFAULT_INPUT_FORMAT, java.util.Locale.getDefault())
        formatter.timeZone = java.util.TimeZone.getTimeZone("UTC")
        return formatter.format(java.util.Date())
    }
}
