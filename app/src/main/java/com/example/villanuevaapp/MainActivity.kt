package com.example.villanuevaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
@Composable
fun VillanuevaApp() {
    MyApp(
        title = stringResource(R.string.title_note),
        imagePainter = painterResource(R.drawable.notes)
    )
}

@Composable
private fun MyApp(
    title: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier

) {
    Column(modifier = modifier) {
        Image(painter = imagePainter, contentDescription = null, modifier= Modifier.fillMaxWidth())
        Text(
            text = title,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
                .weight(.1f)
                .fillMaxWidth()



        )

        SimpleFilledTextFieldSample( Modifier.weight(.8f))
    }
}

@Composable
fun SimpleFilledTextFieldSample(modifier: Modifier) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("What's in your mind") },
        modifier = modifier.fillMaxSize()

    )
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
