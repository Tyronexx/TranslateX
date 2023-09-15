package com.example.translatex.models

import com.google.gson.annotations.SerializedName

data class ResponseData (
    @SerializedName("translatedText")
    val translatedText: String,
    @SerializedName("match")
    val match: Double
)


/*
"responseData": {
"translatedText": "NO QUERY SPECIFIED. EXAMPLE REQUEST: GET?Q=HELLO&LANGPAIR=EN|IT"
},
 */