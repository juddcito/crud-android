package lsc.dispositivosmoviles.androidcrud.touristpoints

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
import lsc.dispositivosmoviles.androidcrud.R
import lsc.dispositivosmoviles.androidcrud.cities.CityCRUD
import lsc.dispositivosmoviles.androidcrud.data.TouristPointEntity
import lsc.dispositivosmoviles.androidcrud.touristpoints.ui.theme.AndroidCRUDTheme

class TouristPointRead : ComponentActivity() {
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
                    val touristPoint = intent.getParcelableExtra<TouristPointEntity>("touristPoint")
                    TouristPointReadApp(touristPoint)
                }
            }
        }
    }
}

@Composable
fun TouristPointReadApp(touristPoint: TouristPointEntity?) {
    var id by remember { mutableStateOf(touristPoint?.id.toString()?:"") }
    var name by remember { mutableStateOf(touristPoint?.name) }
    var description by remember { mutableStateOf(touristPoint?.description) }
    var cost by remember { mutableStateOf(touristPoint?.cost.toString()?:"") }
    var latitude by remember { mutableStateOf(touristPoint?.latitude.toString()?:"") }
    var longitude by remember { mutableStateOf(touristPoint?.longitude.toString()?:"") }

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
                        painter = painterResource(id = R.drawable.cities),
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
                description?.let {
                    TextField(
                        value = it,
                        enabled = false,
                        onValueChange = { description = it },
                        label = { Text("Code (2)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                cost?.let {
                    TextField(
                        value = it,
                        enabled = false,
                        onValueChange = { cost = it },
                        label = { Text("Cost (USD$)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                latitude?.let {
                    TextField(
                        value = it,
                        enabled = false,
                        onValueChange = { latitude = it },
                        label = { Text("Population") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                longitude?.let {
                    TextField(
                        value = it,
                        enabled = false,
                        onValueChange = { longitude = it },
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