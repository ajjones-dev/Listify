@file:OptIn(ExperimentalMaterial3Api::class)

package net.thedevdad.listify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.thedevdad.listify.ui.theme.ListifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListifyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateNew()
                }
            }
        }
    }
}

@Composable
fun ListOfLists()
{

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNew()
{
    var newListName by remember {
        mutableStateOf("")
    }
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
     TextField(
         value = newListName,
         onValueChange =  { text ->
            newListName = text
         }
     )

     Button(onClick = {
        newListName = ""
     }) {
         Text(text = "Create")
     }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ListifyTheme {
        CreateNew()
    }
}