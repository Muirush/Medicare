package com.gallopingtech.medicare.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gallopingtech.medicare.R
import com.gallopingtech.medicare.navigation.Routes

@Composable
fun  loginScreen(navController: NavController) {

    var userName by remember { mutableStateOf("") }
    var passWord by remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(painter = painterResource(R.drawable.medicare), contentDescription = null,
            modifier = Modifier.size(80.dp).clip(RectangleShape)
        )
        Text(text = "Medicare",
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp
            )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = userName,
            onValueChange = {userName = it},
            label = { Text("Enter your Username / email") },
            placeholder = { Text("Enter your username or email") },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            trailingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) }

            )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = passWord,
            onValueChange = {passWord = it},
            label = { Text("Enter your Password") },
            placeholder = { Text("Enter your Password") },
            maxLines = 1,
            keyboardOptions =KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation =  PasswordVisualTransformation(),
            trailingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
            )
        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
            ){
           ClickableText(
               AnnotatedString("New Here?"),
               onClick = {}
           )
            OutlinedButton(
                onClick = {
                    navController.navigate(Routes.homeScreen + "/"+userName)
                }
            ){
                Text(text = "Login")

            }
        }












    }
}