package com.example.lab_7

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {


    // same as in upcoming races I
    // just fit it for purposes of DriversScreen
    var driver by remember {
        mutableStateOf("")
    }

    var drivers = remember {
        mutableStateListOf<String>()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {


        // SPACEE
        Spacer(modifier = Modifier.height(16.dp))

        // back button
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("driversBackButton") // for testing
        ) {
            Text("Back")
        }


        // SPACE
        Spacer(modifier = Modifier.height(16.dp))

        // title text
        Text(
            text = "FormulaZero Drivers",
            fontSize = 30.sp
        )



        // SPACEE
        Spacer(modifier = Modifier.height(16.dp))

        // text field and button to add drivers
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = driver,
                onValueChange = {
                    driver = it // update driver to new value
                },
                label = {
                    Text("Driver Name")
                },
                modifier = Modifier.testTag("driverInput") // for testing
            )


            // SPACE
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (driver.isNotBlank()) {
                        drivers.add(driver)
                        driver = ""
                    }
                },
                modifier = Modifier.testTag("addDriverButton") // for testing
            ) {
                Text("Add The Driver")
            }
        }


        // SPACE
        Spacer(modifier = Modifier.height(16.dp))




        // button to clear all drivers
        Button(
            onClick =
                {
                drivers.clear()
                },
            modifier = Modifier.testTag("clearDriversButton") // for testing
        )
        {
            Text("Clear All Drivers")
        }



        // SPACE
        Spacer(modifier = Modifier.height(16.dp))




        // list to display drivers
        LazyColumn(
            modifier = Modifier.testTag("driverList")
        )

        {
            items(drivers) { d ->
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = d,
                    fontSize = 24.sp
                )
            }
        }
    }
}