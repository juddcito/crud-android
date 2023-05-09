package lsc.dispositivosmoviles.androidcrud.cities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import lsc.dispositivosmoviles.androidcrud.MainActivity
import lsc.dispositivosmoviles.androidcrud.R
import lsc.dispositivosmoviles.androidcrud.countries.CustomComboBox
import lsc.dispositivosmoviles.androidcrud.data.CountryEntity
import lsc.dispositivosmoviles.androidcrud.data.ExampleDatabase
import lsc.dispositivosmoviles.androidcrud.ui.theme.ui.theme.AndroidCRUDTheme

class CityCRUD : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCRUDTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF5F5FF)
                ) {
                    val database = Room.databaseBuilder(this, ExampleDatabase::class.java, "crud_db").build()
                    val cityDao = database.cityDao
                    val viewModel by viewModels<CityViewModel>(factoryProducer = {
                        object : ViewModelProvider.Factory{
                            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                                return CityViewModel(cityDao) as T
                            }
                        }
                    })
                    CityCRUDApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun CityCRUDApp(viewModel: CityViewModel) {
    val state = viewModel.state
    val context = LocalContext.current
    var items by remember { mutableStateOf(emptyList<CountryEntity>()) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
                        val intent = Intent(context, MainActivity::class.java)
                        ContextCompat.startActivity(context, intent, null)
                    }
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Navegación hacia atrás", tint = Color.White)
                }
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Acción del botón */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFFFFB74D))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Icono Favorito",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Add City",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
        val itemsContinent = listOf("Country", "America", "Europe", "Asia")
        val itemsLanguage = listOf("Population", "Spanish", "English", "Chinese")
        var selectedItemContinent by remember { mutableStateOf(itemsContinent.first()) }
        var selectedItemLanguage by remember { mutableStateOf(itemsLanguage.first()) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "FILTERS")
            CustomComboBox(items = itemsContinent, selectedItem = selectedItemContinent, onItemSelected = { selectedItemContinent = it })
            CustomComboBox(items = itemsLanguage, selectedItem = selectedItemLanguage, onItemSelected = { selectedItemLanguage = it })
            IconButton(onClick = {
                selectedItemContinent = itemsContinent.first()
                selectedItemLanguage = itemsLanguage.first()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.eraser),
                    contentDescription = "eraser icon",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(state.cities){
                CityItem(city = it, viewModel = viewModel)
            }
        }
    }
}