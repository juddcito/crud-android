package lsc.dispositivosmoviles.androidcrud.touristpoints

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lsc.dispositivosmoviles.androidcrud.ui.theme.ui.theme.AndroidCRUDTheme

class TouristPointCRUD : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCRUDTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TouristPointsApp()
                }
            }
        }
    }
}

@Composable
fun TouristPointsApp() {
    Text(text = "Hello !")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    AndroidCRUDTheme {
        TouristPointsApp()
    }
}