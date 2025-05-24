package com.artalia.jewelryshop.UIComponent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artalia.jewelryshop.Component.MyBottomBar
import com.artalia.jewelryshop.R
import com.artalia.jewelryshop.StateManagement.LoginInfoViewModel

@Composable
fun LoginScreen(loginInfoViewModel:LoginInfoViewModel) {

    var passwordIsVisible by remember {mutableStateOf(false)}
    var error by remember { mutableStateOf("")}
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = colorResource(R.color.lightOrange),
        bottomBar = { MyBottomBar() }
    ) {innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Login",
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = loginInfoViewModel.loginInfo.emailOrUsername,
                onValueChange = {loginInfoViewModel.changeLoginInfoEmailOrUsername(it)},
                label = {
                    Text(
                        "Email or username",
                        fontSize = if(loginInfoViewModel.loginInfo.emailOrUsername.isBlank()) 12.sp else 10.sp
                    )},
                leadingIcon = {
                    Icon(
                        Icons.Rounded.Email,
                        contentDescription = null,
                    )
                },
                modifier = Modifier
                    .width(320.dp),
                shape = RoundedCornerShape(8.dp),
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = loginInfoViewModel.loginInfo.password,
                onValueChange = {loginInfoViewModel.changeLoginInfoPassword(it)},
                label = {
                    Text(
                    "Password",
                        fontSize = if(loginInfoViewModel.loginInfo.password.isBlank()) 12.sp else 10.sp
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
                        Icons.Rounded.MoreVert
                    else
                        Icons.Rounded.Add

                    Icon(
                        image,
                        contentDescription = null,
                        modifier = Modifier.clickable { passwordIsVisible = !passwordIsVisible }
                    )
                },

                modifier = Modifier
                    .width(320.dp),
                shape = RoundedCornerShape(8.dp),
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    error = if(loginInfoViewModel.loginInfo.emailOrUsername.isBlank()
                        || loginInfoViewModel.loginInfo.password.isBlank()) "Please fill necessary information" else ""
                    if(error.isEmpty()){
                        //something
                    }
                },

                shape = RoundedCornerShape(20.dp),

                modifier = Modifier
                    .width(200.dp),
            ) {
                Text("Login")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "Forgot password?",
                color = MaterialTheme.colors.primary
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
                    "Sign up"
                )
            }
        }
    }
}
