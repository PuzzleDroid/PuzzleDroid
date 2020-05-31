package com.awaredevelopers.puzzledroid.utils

//Hacemos que sea un objeto estático, instanciado una única vez para toda la app.
object ImagesUtil {
    operator fun invoke(): ImagesUtil {
        return this;
    }
}