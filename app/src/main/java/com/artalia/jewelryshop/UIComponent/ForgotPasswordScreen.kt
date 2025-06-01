package com.artalia.jewelryshop.UIComponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artalia.jewelryshop.Component.MyBottomBar
import com.artalia.jewelryshop.R

@Composable
@Preview
fun ForgotPasswordScreen () {
    var error by remember { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = colorResource(R.color.grey),
        bottomBar = { MyBottomBar() }
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                "Enter your email",
                color = colorResource(R.color.black)
            )

            Spacer(Modifier.height(10.dp))

            TextField(
                value = email,
                onValueChange = {email = it},
                modifier = Modifier
                    .width(320.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Gray,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Gray,
                    focusedContainerColor = Color.White
                ),
                label = {
                    Text(
                        "Email",
                        fontSize = if(email.isBlank()) 12.sp else 10.sp
                    )
                },
                shape = RoundedCornerShape(8.dp),
            )

            if(!error.isBlank()){
                Spacer(Modifier.height(10.dp))

                Text(
                    error,
                    color = colorResource(R.color.black)
                )
            }

            Spacer(Modifier.height(10.dp))

            Row (
                modifier = Modifier
                    .wrapContentWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Button(
                    onClick = {},

                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(R.color.darkPurple),
                    ),

                    shape = RoundedCornerShape(20.dp),
                ) {
                    Text(
                        "Back",
                        color = colorResource(R.color.lightOrange),
                    )
                }

                Spacer(Modifier.width(10.dp))

                Button(
                    onClick = {},

                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(R.color.darkPurple),
                    ),

                    shape = RoundedCornerShape(20.dp),
                ) {
                    Text(
                        "Send",
                        color = colorResource(R.color.lightOrange),
                    )
                }
            }
        }
    }
}