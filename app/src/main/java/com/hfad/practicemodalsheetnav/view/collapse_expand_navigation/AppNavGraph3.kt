package com.hfad.practicemodalsheetnav.view.collapse_expand_navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

enum class BottomSheetStateEnum {
    Sheet1, Sheet2, Sheet3 // Add more states as needed
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen3() {
    var currentSheet by remember { mutableStateOf(BottomSheetStateEnum.Sheet1) }
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Expanded)
    )
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        sheetShape = RoundedCornerShape(50.dp),
        sheetBackgroundColor = Color.Cyan,
        sheetElevation = 50.dp,
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            BottomSheetContent(currentSheet) { nextSheet ->
                coroutineScope.launch {
                    // Collapse the current bottom sheet
                    bottomSheetScaffoldState.bottomSheetState.collapse()
                    // Update the current sheet
                    currentSheet = nextSheet
                    // Expand the new bottom sheet
                    bottomSheetScaffoldState.bottomSheetState.expand()
                }
            }
        },
        sheetPeekHeight = 0.dp
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
fun BottomSheetContent(currentSheet: BottomSheetStateEnum, onNavigate: (BottomSheetStateEnum) -> Unit) {
    Column(
        modifier = Modifier
            .height(400.dp)
            .fillMaxWidth()
            .padding(30.dp)
    ) {
        when (currentSheet) {
            BottomSheetStateEnum.Sheet1 -> {
                Text("This is Bottom Sheet 1")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { onNavigate(BottomSheetStateEnum.Sheet2) }) {
                    Text("Go to Bottom Sheet 2")
                }
            }
            BottomSheetStateEnum.Sheet2 -> {
                Text("This is Bottom Sheet 2")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { onNavigate(BottomSheetStateEnum.Sheet3) }) {
                    Text("Go to Bottom Sheet 3")
                }
            }
            BottomSheetStateEnum.Sheet3 -> {
                Text("This is Bottom Sheet 3")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { onNavigate(BottomSheetStateEnum.Sheet1) }) {
                    Text("Go to Bottom Sheet 1")
                }
            }
            // Add more cases as needed
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
        MainScreen3()

}