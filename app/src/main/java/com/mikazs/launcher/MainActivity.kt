package com.mikazs.launcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(
                colorScheme = darkColorScheme()
            ) {
                MikaLauncher()
            }
        }
    }
}

@Composable
fun MikaLauncher() {

    var selected by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {

            NavigationBar {

                NavigationBarItem(
                    selected = selected == 0,
                    onClick = { selected = 0 },
                    icon = {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = "Home"
                        )
                    },
                    label = {
                        Text("Home")
                    }
                )

                NavigationBarItem(
                    selected = selected == 1,
                    onClick = { selected = 1 },
                    icon = {
                        Icon(
                            Icons.Default.Build,
                            contentDescription = "Mods"
                        )
                    },
                    label = {
                        Text("Mods")
                    }
                )

                NavigationBarItem(
                    selected = selected == 2,
                    onClick = { selected = 2 },
                    icon = {
                        Icon(
                            Icons.Default.Settings,
                            contentDescription = "Settings"
                        )
                    },
                    label = {
                        Text("Cài đặt")
                    }
                )
            }
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            when (selected) {

                0 -> HomeScreen()

                1 -> ModsScreen()

                2 -> SettingsScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "MIKA ZS LAUCHER",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Minecraft Java Android Launcher"
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("CHƠI MINECRAFT")
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("QUẢN LÝ PHIÊN BẢN")
        }
    }
}

@Composable
fun ModsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "Mods",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Quản lý Minecraft Mods"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("THÊM MOD")
        }
    }
}

@Composable
fun SettingsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "Cài đặt",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text("Java / RAM / Renderer")

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text("JVM Arguments")

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text("Tối ưu Android")
    }
}
