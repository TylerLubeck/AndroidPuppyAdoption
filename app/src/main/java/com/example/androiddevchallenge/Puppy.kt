package com.example.androiddevchallenge

data class Puppy constructor(
    val name: String,
    val breed: String,
    val houseTrained: Boolean,
    val ageInMonths: Int,
) {
    fun ageDisplay(): String {
        val years = ageInMonths / 12
        val remainingMonths = ageInMonths % 12

        // TODO: Stringbuilder?
        var msg = ""
        if (years > 0) {
            msg = "$years years"
        }
        if (remainingMonths > 0) {
            if (!msg.isEmpty()) {
                msg = "$msg, $remainingMonths months"
            } else {
                msg = "$remainingMonths months"
            }
        }

        // TODO: localize these strings
        return msg
    }
}