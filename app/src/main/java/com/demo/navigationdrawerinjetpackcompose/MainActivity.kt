package com.demo.navigationdrawerinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.demo.navigationdrawerinjetpackcompose.ui.theme.NavigationDrawerInJetpackComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerInJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val scaffoldState = rememberScaffoldState()
                    val scope =  rememberCoroutineScope()
                    Scaffold(scaffoldState = scaffoldState,
                    drawerContent = {
                        Column() {
                            IconButton(onClick = {
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }

                            }) {
                                Icon(Icons.Default.Close, contentDescription = "", tint = Color.Blue)
                            }
                            Text(text = "Drawer Content")
                        }
                    },
                    drawerGesturesEnabled = false) {
                        CreateDrawer(scaffoldState = scaffoldState)
                    }


                }
            }
        }
    }
}



