@file:OptIn(ExperimentalMaterial3Api::class)

package net.thedevdad.listify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ){
                        Header()
                        CreateNew()
                        ListOfLists()
                    }

                }
            }
        }
    }
}

@Composable
fun Header()
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Cyan),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Lisfity",
            modifier = Modifier.padding(10.dp),
            color = Color.White
        )
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)

    ) {
     OutlinedTextField(
         value = newListName,
         onValueChange =  { text ->
            newListName = text
         },
         modifier = Modifier
             .weight(1f)
     )

     Button(onClick = {
        newListName = ""
        },
         modifier = Modifier.padding(4.dp)) {
         Text(text = "Add")
     }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ListifyTheme {
        Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Header()
                CreateNew()
            }
        }
    }
}