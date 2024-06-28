package com.example.villanuevaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.villanuevaapp.ui.theme.VillanuevaAPPTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VillanuevaAPPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VillanuevaApp()
                }
            }
        }
    }
}
//nagcacall sa image at title
@Composable
fun VillanuevaApp() {
    MyApp(
        title = stringResource(R.string.title_note),
        imagePainter = painterResource(R.drawable.notes)
    )
}
//Image
@Composable
private fun MyApp(
    //ito is for title "Note"
    title: String,
    //ito naman para sa image, nag declare ng imagePainter para matawag ang image
    imagePainter: Painter,
    modifier: Modifier = Modifier

) {
SelectionContainer {
    Column(modifier = modifier) {
        //nagdidisplay ng image,
        Image(painter = imagePainter, contentDescription = null, modifier = Modifier.fillMaxWidth())
        Text(
            text = "$title",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
                .weight(.1f)
                .fillMaxWidth()


        )
        // tinatawag neto yung user input
        SimpleFilledTextFieldSample(Modifier.weight(.8f))
    }
}
}
// kumukuha ng user input
@Composable
fun SimpleFilledTextFieldSample(modifier: Modifier) {
    // nag declare ng variable na naghahandle ng text
    var text by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxSize()) {
//User input
        TextField(
            value = text,
            onValueChange = { text = it },
            singleLine = false,
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            label = { Text("What's on your mind?") },
            modifier = modifier.fillMaxSize()

        )
        Row(modifier = Modifier.fillMaxWidth()) {
            // Clear button
            Button(
                onClick = { text = "" },   //kapag clinick yung button mabubura ang user input
                modifier = Modifier.weight(1f).padding(top = 8.dp)
            ) {
                Text("Clear")
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun VillanuevaAppPreview() {
    VillanuevaAPPTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            VillanuevaApp()
        }
    }
}
