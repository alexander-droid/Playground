package com.nikolaenko.playground.core.data.serializer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object UserSessionSerializer : Serializer<UserSessionProto.SessionData> {
    override val defaultValue: UserSessionProto.SessionData = UserSessionProto.SessionData.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserSessionProto.SessionData {
        try {
            return UserSessionProto.SessionData.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: UserSessionProto.SessionData, output: OutputStream) = t.writeTo(output)
}