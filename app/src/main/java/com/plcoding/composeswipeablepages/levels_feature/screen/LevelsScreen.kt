package com.plcoding.composeswipeablepages.levels_feature.screen

import androidx.compose.foundation.Image
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.composeswipeablepages.MainActivity
import com.plcoding.composeswipeablepages.R
import com.plcoding.composeswipeablepages.levels_feature.viewmodel.usecase.levelImage
import com.plcoding.composeswipeablepages.common.navigate.Screen
import com.plcoding.composeswipeablepages.levels_feature.viewmodel.viewmodel.ViewModelLevels

@Preview
@Composable
fun ShowLevels() {
    LevelsScreen.Content()
}

object LevelsScreen {
    @Composable
    fun Content() {
        Image(
            painter = painterResource(id = R.drawable.levels_backgraund), contentDescription = null,
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds
        )
        Image(painter = painterResource(id = R.drawable.back_button), contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .padding(top = 40.dp, start = 20.dp)
                .clickable { MainActivity.navController.navigate(Screen.Menu.route) })
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp)
        ) {
            itemsIndexed(levelImage.chunked(3)) { _, rowImages ->
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (image in rowImages) {
                        Image(painter = painterResource(id = image.imageResId),
                            contentDescription = "",
                            modifier = Modifier
                                .size(120.dp)
                                .padding(vertical = 10.dp)
                                .clickable {

                                    MainActivity.navController.navigate(Screen.Game.route)
                                }
                        )
                    }
                }
            }
        }
    }
}