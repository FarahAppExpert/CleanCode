package com.example.cleancode.framework

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.provider.OpenableColumns
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object FileUtil {

    data class FlowerDetail(
        val productId: Int, val category: String, val price: String,
        val instructions: String, val name: String, val photo: String
    )

    private fun getPdfThumbnailUri(context: Context, documentUri: String, documentName: String):
            String {


        val thumbnailFile = File(context.cacheDir, documentName + "_thumbnail")

        try {
            FileOutputStream(thumbnailFile).use { out: FileOutputStream ->
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return thumbnailFile.absolutePath
    }

    fun getDocumentDetails(context: Context, documentUri: String): FlowerDetail {
        val projection = arrayOf(MediaStore.MediaColumns.DISPLAY_NAME, MediaStore.MediaColumns.SIZE)

        context.contentResolver.query(Uri.parse(documentUri), projection, null, null, null)
            ?.use { metaCursor ->
                val nameIndex = metaCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                val sizeIndex = metaCursor.getColumnIndex(OpenableColumns.SIZE)

            }

        return FlowerDetail(0, "" , "", "", "", "")
    }
}