package lsc.dispositivosmoviles.androidcrud.touristpoints

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import lsc.dispositivosmoviles.androidcrud.R
import lsc.dispositivosmoviles.androidcrud.cities.CityCRUD
import lsc.dispositivosmoviles.androidcrud.countries.CountryViewModel
import lsc.dispositivosmoviles.androidcrud.data.CountryEntity
import lsc.dispositivosmoviles.androidcrud.data.ExampleDatabase
import lsc.dispositivosmoviles.androidcrud.data.TouristPointEntity
import lsc.dispositivosmoviles.androidcrud.touristpoints.ui.theme.AndroidCRUDTheme

class TouristPointUpdate : ComponentActivity() {
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
                    val database = Room.databaseBuilder(this, ExampleDatabase::class.java, "crud_db").build()
                    val dao = database.countryDao
                    val viewModel by viewModels<TouristPointViewModel>(factoryProducer = {
                        object : ViewModelProvider.Factory{
                            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                                return CountryViewModel(dao) as T
                            }
                        }
                    })
                    TouristPointUpdateApp(touristPoint, viewModel)
                }
            }
        }
    }
}

@Composable
fun TouristPointUpdateApp(touristPoint: TouristPointEntity?, viewModel: TouristPointViewModel) {
    var id by remember { mutableStateOf(touristPoint?.id.toString()?:"") }
    var name by remember { mutableStateOf(touristPoint?.name) }
    var countryCode by remember { mutableStateOf(touristPoint?.countryCode) }
    var cityId by remember { mutableStateOf(touristPoint?.cityId.toString()?:"") }
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
                        painter = painterResource(id = R.drawable.point),
                        contentDescription = "cities icon",
                        modifier = Modifier.size(32.dp),
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                    Text(
                        text = "TOURIST POINTS",
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
                        label = { Text("Country Code (3)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                cityId?.let {
                    TextField(
                        value = it,
                        enabled = false,
                        onValueChange = { cityId = it },
                        label = { Text("City Id") },
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
                Button(
                    onClick = {
                        val touristPoint = TouristPointEntity(0, countryCode, cityId.toInt(), name,description,cost.toFloat(),latitude,longitude)
                        if (touristPoint != null) {
                            viewModel.createTouristPoint(touristPoint)
                            Toast.makeText(
                                context,
                                "Tourist point modified!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF42A5F5)),
                    modifier = Modifier
                        .padding(10.dp)
                        .width(400.dp)
                        .height(50.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painterResource(id = R.drawable.pencil),
                            modifier = Modifier.size(32.dp),
                            contentDescription = "Icono Favorito",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Update",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
