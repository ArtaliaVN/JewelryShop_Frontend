package com.artalia.jewelryshop.StateManagement

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.artalia.jewelryshop.Data.LoginInfo

class LoginInfoViewModel:ViewModel() {
    var loginInfo by mutableStateOf(LoginInfo("",""))
        private set

    fun changeLoginInfo(emailOrUsername:String, password:String){
        loginInfo = LoginInfo(emailOrUsername, password)
    }

    fun changeLoginInfoEmailOrUsername(emailOrUsername:String){
        loginInfo = LoginInfo(emailOrUsername, loginInfo.password)
    }

    fun changeLoginInfoPassword(password:String){
        loginInfo = LoginInfo(loginInfo.emailOrUsername, password)
    }
}