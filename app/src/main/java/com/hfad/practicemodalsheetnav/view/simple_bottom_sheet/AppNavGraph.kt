package com.hfad.practicemodalsheetnav.view.simple_bottom_sheet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen() {
    val bottomSheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Expanded)
    )

    BottomSheetScaffold(
        sheetShape = RoundedCornerShape(50.dp),
        sheetBackgroundColor = Color.Cyan,
        sheetElevation = 50.dp,
        scaffoldState = bottomSheetState,
        sheetContent = {
            BottomSheetContent()
        },
        sheetPeekHeight = 0.dp // This ensures the sheet is fully expanded at the start
    ) {
        // Main content of your screen
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Main Content")
        }
    }
}

@Composable
fun BottomSheetContent() {
    Column(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(30.dp)
    ) {
        Text("This is the bottom sheet")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { /* Perform action or navigate */ }) {
            Text("Click me")
        }
    }
}

