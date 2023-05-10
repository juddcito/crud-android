package lsc.dispositivosmoviles.androidcrud.cities

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import lsc.dispositivosmoviles.androidcrud.R
import lsc.dispositivosmoviles.androidcrud.cities.ui.theme.AndroidCRUDTheme
import lsc.dispositivosmoviles.androidcrud.countries.CountryViewModel
import lsc.dispositivosmoviles.androidcrud.data.CityEntity
import lsc.dispositivosmoviles.androidcrud.data.CountryEntity
import lsc.dispositivosmoviles.androidcrud.data.ExampleDatabase

class CityUpdate : ComponentActivity() {
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
                    val database = Room.databaseBuilder(this, ExampleDatabase::class.java, "crud_db").build()
                    val dao = database.cityDao
                    val viewModel by viewModels<CityViewModel>(factoryProducer = {
                        object : ViewModelProvider.Factory{
                            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                                return CityViewModel(dao) as T
                            }
                        }
                    })
                    CityUpdateApp(city, viewModel)
                }
            }
        }
    }
}


@Composable
fun CityUpdateApp(city: CityEntity?, viewModel: CityViewModel) {
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
                        painter = painterResource(id = R.drawable.cities),
                        contentDescription = "cities icon",
                        modifier = Modifier.size(32.dp),
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                    Text(
                        text = "UPDATE CITY",
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
                        label = { Text("Code (3)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                district?.let {
                    TextField(
                        value = it,
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
                        onValueChange = { population = it },
                        label = { Text("Population") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(292.dp))
                Button(
                    onClick = {
                        val city = CityEntity(id.toInt(),name,countryCode,district,population.toInt(),"")
                        if (city != null) {
                            viewModel.insertCity(city)
                            Toast.makeText(
                                context,
                                "Country modified!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    modifier = Modifier
                        .padding(10.dp)
                        .width(400.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFFFFB74D))
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painterResource(id = R.drawable.pencil),
                            modifier = Modifier.size(32.dp),
                            contentDescription = "pencil icon",
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
