package com.hfad.practicemodalsheetnav.view.navigate_from_sheet_to_sheet

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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

enum class BottomSheetState {
    Sheet1, Sheet2, Sheet3 // Add more states as needed
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen2() {
    var currentSheet by remember { mutableStateOf(BottomSheetState.Sheet1) }
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Expanded)
    )

    BottomSheetScaffold(
        sheetShape = RoundedCornerShape(50.dp),
        sheetBackgroundColor = Color.Cyan,
        sheetElevation = 50.dp,
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            BottomSheetContent(currentSheet) { nextSheet ->
                currentSheet = nextSheet
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
fun BottomSheetContent(currentSheet: BottomSheetState, onNavigate: (BottomSheetState) -> Unit) {
    Column(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(30.dp)
    ) {
        when (currentSheet) {
            BottomSheetState.Sheet1 -> {
                Text("This is Bottom Sheet 1")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { onNavigate(BottomSheetState.Sheet2) }) {
                    Text("Go to Bottom Sheet 2")
                }
            }
            BottomSheetState.Sheet2 -> {
                Text("This is Bottom Sheet 2")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { onNavigate(BottomSheetState.Sheet3) }) {
                    Text("Go to Bottom Sheet 3")
                }
            }
            BottomSheetState.Sheet3 -> {
                Text("This is Bottom Sheet 3")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { onNavigate(BottomSheetState.Sheet1) }) {
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
//    YourAppTheme {
//      //  MainScreen()
//    }
}