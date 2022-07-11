package com.nikolaenko.playground.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object ThemeSerializer : Serializer<ThemeProto.ThemeData> {
    override val defaultValue: ThemeProto.ThemeData = ThemeProto.ThemeData.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): ThemeProto.ThemeData {
        try {
            return ThemeProto.ThemeData.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: ThemeProto.ThemeData, output: OutputStream) = t.writeTo(output)
}