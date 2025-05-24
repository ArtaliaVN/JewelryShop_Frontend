package com.artalia.jewelryshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.artalia.jewelryshop.StateManagement.LoginInfoViewModel
import com.artalia.jewelryshop.UIComponent.HomeScreen
import com.artalia.jewelryshop.UIComponent.LoginScreen
import com.artalia.jewelryshop.ui.theme.JewelryShopTheme

class MainActivity : ComponentActivity() {
    private val loginInfoViewModel by viewModels<LoginInfoViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginScreen(loginInfoViewModel)
        }
    }
}
