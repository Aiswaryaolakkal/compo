package com.example.wom.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
@Entity(
    tableName = "result_table",
    indices = [Index(value = ["convertion_type", "con_from", "con_to"], unique = true)]
)
data class ConversionResult(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "result_id")
    val id: Int,
    @ColumnInfo(name = "convertion_type")
    val conv_type: String,
    @ColumnInfo(name = "con_from")
    val conFrom: String,
    @ColumnInfo(name = "con_to")
    val conTo: String
)