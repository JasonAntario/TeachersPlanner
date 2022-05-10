package com.dsankovsky.tutorsschedule.domain

import java.util.*

data class Lesson(
    val time: Date,
    val homework: String,
    val topic: String,
    val completion: CompletionState

)
