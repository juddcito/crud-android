package lsc.dispositivosmoviles.androidcrud

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import lsc.dispositivosmoviles.androidcrud.ui.theme.AndroidCRUDTheme

class CountryRead : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCRUDTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CountryReadApp()
                }
            }
        }
    }
}

@Composable
fun CountryReadApp() {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        TopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.width(64.dp))
                    Image(
                        painter = painterResource(id = R.drawable.world),
                        contentDescription = "world icon",
                        modifier = Modifier.size(32.dp),
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                    Text(
                        text = "COUNTRIES",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        val intent = Intent(context, CountryCRUD::class.java)
                        ContextCompat.startActivity(context, intent, null)
                    }
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Navegación hacia atrás")
                }
            }
        )
        TextField(
            value = text1,
            onValueChange = { text1 = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Code (3)") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Code (2)") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Continent") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Region") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Code (3)") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Code (3)") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Surface Area") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Independence Year") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Population") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Life Expectancy") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("GNP") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Local Name") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Government Form") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Head of State") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Capital") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidCRUDTheme {
        CountryReadApp()
    }
}