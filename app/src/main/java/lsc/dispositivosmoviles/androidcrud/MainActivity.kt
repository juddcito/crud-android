package lsc.dispositivosmoviles.androidcrud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lsc.dispositivosmoviles.androidcrud.ui.theme.AndroidCRUDTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCRUDTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainMenu()
                }
            }
        }
    }
}

@Composable
fun MainMenu() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = { Text(text = "CRUD EXAMPLE",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally))
            }
        )
        Spacer(modifier = Modifier.height(108.dp))
        Image(
            painter = painterResource(id = R.drawable.db),
            contentDescription = "database icon",
            modifier = Modifier
                .padding(15.dp)
                .align(CenterHorizontally)
                .size(184.dp)
        )
        Spacer(modifier = Modifier.height(108.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.width(256.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.world),
                    contentDescription = "world icon",
                    modifier = Modifier
                        .size(32.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text("COUNTRIES")
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.width(256.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cities),
                    contentDescription = "world icon",
                    modifier = Modifier
                        .size(32.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text("CITIES")
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.width(256.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.point),
                    contentDescription = "world icon",
                    modifier = Modifier
                        .size(32.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text("TOURIST POINTS")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    AndroidCRUDTheme {
        MainMenu()
    }
}