package lsc.dispositivosmoviles.androidcrud.touristpoints

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import lsc.dispositivosmoviles.androidcrud.countries.CountryCreate
import lsc.dispositivosmoviles.androidcrud.data.ExampleDatabase
import lsc.dispositivosmoviles.androidcrud.data.TouristPointEntity
import lsc.dispositivosmoviles.androidcrud.ui.theme.ui.theme.AndroidCRUDTheme

class TouristPointCRUD : ComponentActivity() {
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
                    val dao = database.TouristPointDao
                    val viewModel by viewModels<TouristPointViewModel>(factoryProducer = {
                        object : ViewModelProvider.Factory{
                            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                                return TouristPointViewModel(dao) as T
                            }
                        }
                    })
                    TouristPointsApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun TouristPointsApp(viewModel: TouristPointViewModel) {
    val state = viewModel.state
    val context = LocalContext.current
    var items by remember { mutableStateOf(emptyList<TouristPointEntity>()) }
    var query by remember { mutableStateOf("") }

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
                    Spacer(modifier = Modifier.width(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.point),
                        contentDescription = "world icon",
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
            backgroundColor = Color(0XFFFF1B5E20 ),
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        val intent = Intent(context, TouristPointAdd::class.java)
                        ContextCompat.startActivity(context, intent, null)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFFFF6DBF45 ))
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Icono Favorito",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Add Tourist Point",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            SearchBar(onQueryChanged = { newQuery ->
                query = newQuery
                // Aquí puedes hacer cualquier acción que necesites con la nueva consulta de búsqueda
            })
        }
        val itemsCountry = listOf("Country", "America", "Europe", "Asia", "Africa", "Oceania")
        val itemsCity = listOf("City", "Spanish", "English", "French", "German", "Italian","Chinese","Japanese")
        var selectedItemCountry by remember { mutableStateOf(itemsCountry.first()) }
        var selectedItemCity by remember { mutableStateOf(itemsCity.first()) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "FILTERS",fontWeight = FontWeight.Bold)
            CustomComboBox(items = itemsCountry, selectedItem = selectedItemCountry, onItemSelected = { selectedItemCountry = it })
            CustomComboBox(items = itemsCity, selectedItem = selectedItemCity, onItemSelected = { selectedItemCity = it })
            IconButton(onClick = {
                if((selectedItemCountry == "Continent") && (selectedItemCity == "Language")){
                    viewModel.getAllTouristPoints()
                } else if ((selectedItemCountry != "Continent") && (selectedItemCity == "Language")){
                   // viewModel.getFilteredCountriesByContinent(selectedItemContinent)
                } else if ((selectedItemCountry == "Continent") && (selectedItemCity != "Language")){
                   // viewModel.getFilteredCountriesByLanguage(selectedItemLanguage)
                } else{
                    //viewModel.getFilteredCountriesByContinentAndLanguage(selectedItemContinent,selectedItemLanguage)
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "search icon",
                    modifier = Modifier.size(32.dp)
                )
            }
            IconButton(onClick = {
                selectedItemCountry = itemsCountry.first()
                selectedItemCity = itemsCity.first()
                viewModel.getAllTouristPoints()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.eraser),
                    contentDescription = "eraser icon",
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(state.touristPoints){
                //CountryItem(country = it, viewModel = viewModel)
            }
        }
    }
}

@Composable
fun SearchBar(onQueryChanged: (String) -> Unit) {
    var query by remember { mutableStateOf("") }

    TextField(
        value = query,
        onValueChange = {
            query = it
            onQueryChanged(it)
        },
        placeholder = { Text("Search") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                modifier = Modifier.clickable { /* Do nothing */ }
            )
        },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(onClick = { query = "" }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear Icon"
                    )
                }
            }
        },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun CustomComboBox(
    items: List<String>,
    selectedItem: String,
    onItemSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .clickable(onClick = { expanded = true })
    ) {
        Text(selectedItem, modifier = Modifier.padding(20.dp))
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = "Dropdown Icon",
            modifier = Modifier.align(Alignment.CenterEnd)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }
                ) {
                    Text(text = item)
                }
            }
        }
    }
}
