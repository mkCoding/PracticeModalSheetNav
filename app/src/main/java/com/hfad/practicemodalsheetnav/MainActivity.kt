package com.hfad.practicemodalsheetnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.hfad.practicemodalsheetnav.view.collapse_expand_navigation.MainScreen3
import com.hfad.practicemodalsheetnav.view.navigate_from_sheet_to_sheet.MainScreen2
import com.hfad.practicemodalsheetnav.view.simple_bottom_sheet.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //val navController+ = rememberNavController()
//            AppNavGraph(navController=navController)
            MainScreen3()
        }
    }
}

