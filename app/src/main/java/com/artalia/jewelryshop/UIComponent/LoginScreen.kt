package com.artalia.jewelryshop.UIComponent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artalia.jewelryshop.Component.MyBottomBar
import com.artalia.jewelryshop.R

@Composable
fun LoginScreen() {
    var passwordIsVisible by rememberSaveable{mutableStateOf(false)}
    var error by remember { mutableStateOf("")}
    var password by rememberSaveable {mutableStateOf("")}
    var emailOrUsername by rememberSaveable {mutableStateOf("")}
    val localFocusManager = LocalFocusManager.current
    Scaffold (
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    localFocusManager.clearFocus()
                })
            }
            .fillMaxSize(),
        backgroundColor = colorResource(R.color.grey),
        bottomBar = { MyBottomBar() }
    ) {innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .width(320.dp)
            ){
                Column (
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        "SHINING GOLD",
                        fontSize = 60.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = colorResource(R.color.shiningGold),
                    )

                    Text(
                        "Welcome",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Thin,
                        fontStyle = FontStyle.Italic,
                        color = colorResource(R.color.darkBrown),
                    )
                }
            }

            Spacer(Modifier.height(30.dp))

            TextField(
                value = emailOrUsername,
                onValueChange = {emailOrUsername = it},
                label = {
                    Text(
                        "Email or username",
                        fontSize = if(emailOrUsername.isBlank()) 12.sp else 10.sp
                    )},
                leadingIcon = {
                    Icon(
                        Icons.Rounded.Email,
                        contentDescription = null,
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Gray,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Gray,
                    focusedContainerColor = Color.White
                ),
                modifier = Modifier
                    .width(320.dp),
                shape = RoundedCornerShape(8.dp),
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = password,
                onValueChange = {password = it},
                label = {
                    Text(
                    "Password",
                        fontSize = if(password.isBlank()) 12.sp else 10.sp
                    )},
                leadingIcon = {
                    Icon(
                        Icons.Rounded.Lock,
                        contentDescription = null,
                    )
                },
                visualTransformation = if(passwordIsVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if(passwordIsVisible)
                        Icons.Outlined.CheckCircle
                    else
                        Icons.Filled.CheckCircle

                    Icon(
                        image,
                        contentDescription = null,
                        modifier = Modifier.clickable { passwordIsVisible = !passwordIsVisible }
                    )
                },

                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Gray,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Gray,
                    focusedContainerColor = Color.White
                ),

                modifier = Modifier
                    .width(320.dp),
                shape = RoundedCornerShape(8.dp),
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    error = if(emailOrUsername.isBlank()
                        || password.isBlank()) "Please fill necessary information" else ""
                    if(error.isEmpty()){
                        //something
                    }
                },

                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(R.color.darkPurple),
                ),

                shape = RoundedCornerShape(20.dp),

                modifier = Modifier
                    .width(200.dp),
            ) {
                Text(
                    "Login",
                    color = colorResource(R.color.lightOrange)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "Forgot password?",
                color = colorResource(R.color.black),
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row (
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Don't have your own account?"
                )

                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    "Create one"
                )
            }
        }
    }
}
