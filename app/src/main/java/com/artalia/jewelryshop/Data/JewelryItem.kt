package com.artalia.jewelryshop.Data

import android.media.Image
import java.util.Date

data class JewelryItem (
    private val id:Int,
    private val name:String,
    private val type:String,
    private val uploadData:Date,
    private val information:String,
    private val price:Double,
    private val numberLeft:Int,
    private val guarantee:String,
    private val thumbnailImage:Image,
    private val showcaseImages:List<Image>,
)