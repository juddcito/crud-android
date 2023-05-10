package lsc.dispositivosmoviles.androidcrud.cities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import lsc.dispositivosmoviles.androidcrud.theme.AndroidCRUDTheme
import lsc.dispositivosmoviles.androidcrud.data.CityEntity

class CityRead : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCRUDTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val intent = intent
                    val city = intent.getParcelableExtra<CityEntity>("city")
                    CityReadApp(city)
                }
            }
        }
    }
}

@Composable
fun CityReadApp(city: CityEntity?) {
    var id by remember { mutableStateOf(city?.id.toString()?:"") }
    var name by remember { mutableStateOf(city?.name) }
    var countryCode by remember { mutableStateOf(city?.countryCode) }
    var district by remember { mutableStateOf(city?.district) }
    var population by remember { mutableStateOf(city?.population.toString()?:"") }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
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
                        painter = painterResource(id = lsc.dispositivosmoviles.androidcrud.R.drawable.cities),
                        contentDescription = "cities icon",
                        modifier = Modifier.size(32.dp),
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                    Text(
                        text = "CITIES",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            },
            backgroundColor = Color(0XFFFFA726),
            navigationIcon = {
                IconButton(
                    onClick = {
                        val intent = Intent(context, CityCRUD::class.java)
                        ContextCompat.startActivity(context, intent, null)
                    }
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Navegación hacia atrás", tint = Color.White)
                }
            }
        )
        LazyColumn(modifier = Modifier.fillMaxSize()){
            item{
                TextField(
                    value = id,
                    onValueChange = { id = it },
                    enabled = false,
                    label = { Text("ID") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                name?.let {
                    TextField(
                        value = it,
                        enabled = false,
                        onValueChange = { name = it },
                        label = { Text("Name") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                countryCode?.let {
                    TextField(
                        value = it,
                        enabled = false,
                        onValueChange = { countryCode = it },
                        label = { Text("Code (2)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                district?.let {
                    TextField(
                        value = it,
                        enabled = false,
                        onValueChange = { district = it },
                        label = { Text("District") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                population?.let {
                    TextField(
                        value = it,
                        enabled = false,
                        onValueChange = { population = it },
                        label = { Text("Population") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}
