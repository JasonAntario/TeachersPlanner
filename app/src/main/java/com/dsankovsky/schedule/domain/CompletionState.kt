package com.dsankovsky.tutorsschedule.domain

sealed class CompletionState{

    class Planned: CompletionState()
    class Completed: CompletionState()
    class Canceled: CompletionState()
    class Postpone: CompletionState()
}
