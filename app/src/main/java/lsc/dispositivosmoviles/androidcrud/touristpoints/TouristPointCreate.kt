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
import androidx.compose.material.icons.filled.Add
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
import lsc.dispositivosmoviles.androidcrud.data.ExampleDatabase
import lsc.dispositivosmoviles.androidcrud.data.TouristPointEntity
import lsc.dispositivosmoviles.androidcrud.touristpoints.ui.theme.AndroidCRUDTheme

class TouristPointAdd : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCRUDTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val database = Room.databaseBuilder(this, ExampleDatabase::class.java, "crud_db").build()
                    val dao = database.TouristPointDao
                    val viewModel by viewModels<TouristPointViewModel>(factoryProducer = {
                        object : ViewModelProvider.Factory{
                            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                                return TouristPointViewModel(dao) as T
                            }
                        }
                    })
                    TouristPointCreateApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun TouristPointCreateApp(viewModel: TouristPointViewModel) {
    var id by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var countryCode by remember { mutableStateOf("") }
    var cityId by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var cost by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }

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
                    Spacer(modifier = Modifier.width(32.dp))
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
                    label = { Text("ID") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                name?.let {
                    TextField(
                        value = it,
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
                                "Tourist point added!",
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
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add Icon",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Add",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
