package com.dsankovsky.schedule.domain

import java.util.*

data class Lesson(
    var id: Int = UNDEFINED_ID,
    val time: Date,
    val homework: String,
    val topic: String,
    val completion: CompletionState
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}

