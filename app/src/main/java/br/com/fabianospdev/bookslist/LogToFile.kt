package br.com.fabianospdev.bookslist

import android.content.Context
import android.util.Log
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException

object LogToFile {
    fun log(context: Context, message: String) {
        if (context == null) {
            Log.e("LogToFile", "Contexto null. Doesn't possible register the message $message")
            return
        }

        val logMessage = getStacktraceError(message)
        val flavorName = BuildConfig.FLAVOR
        val fileName = "log_$flavorName.txt"
        val directoryPath = context.getExternalFilesDir(null)?.absolutePath

        val directory = directoryPath?.let { File(it) }
        if (directory != null) {
            if (!directory.exists()) {
                directory.mkdirs()
            }
        }
        val filePath = "$directoryPath/$fileName"

        keepFileSize(filePath)

        try {
            val buf = BufferedWriter(FileWriter(filePath, true))
            buf.append(logMessage)
            buf.newLine()
            buf.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        Log.d("br.com.seventh.dguardcloud.LogToFile", logMessage)
    }

    /* The first element of the stack (index 0) is the log method itself,
    *  index 2 is the LogToFile class, so we take the second element (index 3)
    */
    private fun getStacktraceError(message: String): String {
        /* Get the stack trace to find the class and log line */
        val stackTrace = Thread.currentThread().stackTrace
        val callingElement = stackTrace[3]
        val className = callingElement.className
        val lineNumber = callingElement.lineNumber
        val logMessage = "[$className:$lineNumber] $message"
        return logMessage
    }

    private fun keepFileSize(filePath: String) {
        try {
            val logFile = File(filePath)

            if (checksize(filePath)) {
                var lines = logFile.readLines()
                lines = lines.drop(1)

                // Writes the lines back to the file, replacing the old content
                logFile.writeText(lines.joinToString("\n"))
            }
        } catch (e: Exception) {
            Log.d("br.com.seventh.dguardcloud.LogToFile", "Error to keep Log file size")
        }
    }

    private fun checksize(filePath: String): Boolean {
        val MAX_FILE_SIZE_BYTES = 2 * 1024 * 1024 // 2 megabytes
        try {
            val logFile = File(filePath)
            val currentFileSize = logFile.length()
            if (currentFileSize >= MAX_FILE_SIZE_BYTES) {
                return true
            }
        } catch (e: Exception) {
            Log.d("br.com.seventh.dguardcloud.LogToFile", "Can't get Log file size.")
        }
        return false
    }
}
