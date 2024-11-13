package org.example.project.pages.Data

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.example.project.Country
import org.example.project.insertData
import org.example.project.supabase


@Composable
fun DataPage(){

    val openAlertDialog = remember { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    openAlertDialog.value = true
                }
            ) {
                Icon(Icons.Filled.Add,"")
            }
        }
    ) {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                CountriesList(openAlertDialog.value, setOpenAlertDialog = {
                    openAlertDialog.value = it
                } )
            }
        }
    }
}

@Composable
fun CountriesList(openAlertDialog: Boolean, setOpenAlertDialog: (Boolean) -> Unit) {
    var countries by remember { mutableStateOf<List<Country>>(listOf()) }
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            countries = supabase.from("countries")
                .select().decodeList<Country>()
        }
    }
    Column {
        for (country in countries) {
            Text("Country: ${country.name}")
        }
    }

    // ...
    when {
        // ...
        openAlertDialog -> {
            MinimalDialog(onDismissRequest = {
                setOpenAlertDialog(false)
            },
                onOk = { country ->
                    setOpenAlertDialog(false)
                    insertData(Country(name = country))
                }
            )
        }
    }
}


@Composable
fun MinimalDialog(onDismissRequest: () -> Unit, onOk: (country: String) -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp)
                .background(Color.Cyan),
            shape = RoundedCornerShape(16.dp),
        ) {
            var text by remember { mutableStateOf(TextFieldValue("")) }
            Column {
                TextField(
                    value = text,
                    onValueChange = { newText ->
                        text = newText
                    }
                )
                TextButton(onClick = { onOk(text.text)}) {
                    Text("OK")
                }
            }
        }
    }
}
