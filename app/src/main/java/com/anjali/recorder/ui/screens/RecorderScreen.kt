package com.anjali.recorder.ui.screens

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anjali.recorder.enums.RecorderState
import com.anjali.recorder.ui.common.ResponsiveRecordScreenLayout
import com.anjali.recorder.ui.components.RecorderController
import com.anjali.recorder.ui.components.RecorderPreview
import com.anjali.recorder.ui.models.RecorderModel

@Composable
fun RecorderView(
    recordScreenMode: Boolean
) {
    val recorderModel: RecorderModel = viewModel(LocalContext.current as ComponentActivity)

    LaunchedEffect(recorderModel.recorderState) {
        // update the UI when the recorder gets destroyed by the notification
        if (recorderModel.recorderState == RecorderState.IDLE) {
            recorderModel.stopRecording()
        }
    }

    Scaffold { pV ->
        ResponsiveRecordScreenLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(pV),
            PaneOne = {
                RecorderPreview(recordScreenMode)
            },
            PaneTwo = {
                RecorderController(recordScreenMode)
            }
        )
    }
}
