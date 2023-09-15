package com.example.translatex.models

import com.google.gson.annotations.SerializedName

data class Translation(

    @SerializedName("responseData")
    val responseData: ResponseData,
    @SerializedName("quotaFinished")
    val quotaFinished: Boolean,
//    @SerializedName("mtLangSupported")
//    val mtLangSupported:
    @SerializedName("responseDetails")
    val responseDetails: String,
    @SerializedName("responseStatus")
    val responseStatus: Int,
    @SerializedName("responderId")
    val responderId: Int?,
    @SerializedName("exception_code")
    val exceptionCode: Int,
    @SerializedName("matches")
    val matches: List<Match>
)


/*
"responseData": {},
"quotaFinished": false,
"mtLangSupported": null,
"responseDetails": "",
"responseStatus": 200,
"responderId": null,
"exception_code": null,
"matches": []
*/