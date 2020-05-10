package com.awaredevelopers.puzzledroid

class FooKotlin (val stringKotlin: String,
                 val integerKotlin: Int,
                 val booleanKotlin: Boolean,
                 val enumKotlin: RANDOMDES){

    enum class RANDOMDES {
        DES1,
        DES2,
        DES3,
    }

    override fun toString(): String {
        return "FooKotlin(stringKotlin='$stringKotlin', integerKotlin=$integerKotlin, booleanKotlin=$booleanKotlin, enumKotlin=$enumKotlin)"
    }

}