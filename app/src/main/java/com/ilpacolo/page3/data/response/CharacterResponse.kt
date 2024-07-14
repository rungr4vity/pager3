package com.ilpacolo.page3.data.response

import com.google.gson.annotations.SerializedName
import com.ilpacolo.page3.presentation.model.CharacterModel

data class CharacterResponse(

    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("image") val image: String
){
    fun toPresentation(): CharacterModel {
        return CharacterModel(
            id = id,
            name = name,
            isAlive = status == "Alive",
            image = image

        )
    }
}
