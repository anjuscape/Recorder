package com.anjali.recorder.enums

sealed interface TrimmerState {
    object NoJob : TrimmerState
    object Running : TrimmerState
    object Success : TrimmerState
    object Failed : TrimmerState
}
