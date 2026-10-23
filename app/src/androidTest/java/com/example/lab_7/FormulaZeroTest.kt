package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }


    @Test
    fun navigate_d_add_d_clear_returnHome(){// navigate to drivers screen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        // verify that we are on the right screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()




        // ADD ME
        // enter my name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Nikola")

        // add meeee
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify that I appear in the list
        composeTestRule
            .onNodeWithText("Nikola")
            .assertExists()


        // NO LONGER THERE
        // clear the drivers
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // verify that I am  no longer visible
        composeTestRule
            .onNodeWithText("Nikola")
            .assertDoesNotExist()


        // HOME

        // return home
        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()

        // verify we home
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }


}