/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {
                MyApp(dummyPuppies())
            }
        }
    }
}

fun dummyPuppies(): List<Puppy> {
    return listOf(
        Puppy("Indie", "Mutt", true, 24),
        Puppy("Yellow", "Labrador", false, 2),
        Puppy("Coco", "Poodle", true, 17),
        Puppy("Indie", "Mutt", true, 24),
        Puppy("Yellow", "Labrador", false, 2),
        Puppy("Coco", "Poodle", true, 17),
        Puppy("Indie", "Mutt", true, 24),
        Puppy("Yellow", "Labrador", false, 2),
        Puppy("Coco", "Poodle", true, 17),
        Puppy("Indie", "Mutt", true, 24),
        Puppy("Yellow", "Labrador", false, 2),
        Puppy("Coco", "Poodle", true, 17),
        Puppy("Indie", "Mutt", true, 24),
        Puppy("Yellow", "Labrador", false, 2),
        Puppy("Coco", "Poodle", true, 17),
        Puppy("Indie", "Mutt", true, 24),
        Puppy("Yellow", "Labrador", false, 2),
        Puppy("Coco", "Poodle", true, 17),
    )
}

// Start building your app here!
@Composable
fun MyApp(puppies: List<Puppy>) {
    Surface {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(space = 1.dp)) {
            items(items = puppies) {
                PuppyOverview(it)
            }
        }
    }
}

@Composable
fun PuppyOverview(puppy: Puppy) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Image of ${puppy.name}",
            modifier = Modifier
                .fillMaxHeight()
                .clip(shape = RoundedCornerShape(10.dp))
        )
        Column {
            Text(puppy.name, style = typography.h6)
            Text(puppy.breed, style = typography.body2)
            Text("${puppy.ageDisplay()} old", style = typography.body2)
            if (puppy.houseTrained) {
                Text("House Trained!", style = typography.body2)
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(dummyPuppies())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(dummyPuppies())
    }
}
