package lsc.dispositivosmoviles.androidcrud

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import lsc.dispositivosmoviles.androidcrud.data.CountryEntity
import lsc.dispositivosmoviles.androidcrud.data.ExampleDatabase
import lsc.dispositivosmoviles.androidcrud.ui.theme.AndroidCRUDTheme

class CountryUpdate : ComponentActivity() {
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
                    val country = intent.getParcelableExtra<CountryEntity>("country")
                    val database = Room.databaseBuilder(this, ExampleDatabase::class.java, "crud_db").build()
                    val dao = database.countryDao
                    val viewModel by viewModels<CountryViewModel>(factoryProducer = {
                        object : ViewModelProvider.Factory{
                            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                                return CountryViewModel(dao) as T
                            }
                        }
                    })
                    CountryUpdateApp(country,viewModel)
                }
            }
        }
    }
}

@Composable
fun CountryUpdateApp(country: CountryEntity?, viewModel: CountryViewModel) {
    var name by remember { mutableStateOf(country?.name) }
    var countryCode by remember { mutableStateOf(country?.countryCode) }
    var continent by remember { mutableStateOf(country?.continent) }
    var region by remember { mutableStateOf(country?.region) }
    var surfaceArea by remember { mutableStateOf(country?.surfaceArea.toString()?:"") }
    var indepYear by remember { mutableStateOf(country?.indepYear.toString()?:"") }
    var population by remember { mutableStateOf(country?.population.toString()?:"") }
    var lifeExpectancy by remember { mutableStateOf(country?.lifeExpectancy.toString()?:"") }
    var gnp by remember { mutableStateOf(country?.gnp.toString()?:"") }
    var localName by remember { mutableStateOf(country?.localName) }
    var governmentForm by remember { mutableStateOf(country?.governmentForm) }
    var headOfState by remember { mutableStateOf(country?.headOfState) }
    var capital by remember { mutableStateOf(country?.capital) }
    var code2 by remember { mutableStateOf(country?.code2) }

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
        LazyColumn(modifier = Modifier.fillMaxSize()){
            item{
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
                code2?.let {
                    TextField(
                        value = it,
                        onValueChange = { code2 = it },
                        label = { Text("Code (2)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                continent?.let {
                    TextField(
                        value = it,
                        onValueChange = { continent = it },
                        label = { Text("Continent") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                region?.let {
                    TextField(
                        value = it,
                        onValueChange = { continent = it },
                        label = { Text("Region") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }

                TextField(
                    value = surfaceArea?.toString() ?: "",
                    onValueChange = { surfaceArea = it },
                    label = { Text("Surface Area") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                TextField(
                    value = indepYear,
                    onValueChange = { indepYear = it },
                    label = { Text("Independence Year") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                TextField(
                    value = population,
                    onValueChange = { population = it },
                    label = { Text("Population") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                TextField(
                    value = lifeExpectancy,
                    onValueChange = { lifeExpectancy = it },
                    label = { Text("Life Expectancy") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                TextField(
                    value = gnp,
                    onValueChange = { gnp = it },
                    label = { Text("GNP") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                localName?.let {
                    TextField(
                        value = it,
                        onValueChange = { localName = it },
                        label = { Text("Local Name") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                governmentForm?.let {
                    TextField(
                        value = it,
                        onValueChange = { governmentForm = it },
                        label = { Text("Government Form") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                headOfState?.let {
                    TextField(
                        value = it,
                        onValueChange = { headOfState = it },
                        label = { Text("Head of State") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                capital?.let {
                    TextField(
                        value = it,
                        onValueChange = { capital = it },
                        label = { Text("Capital") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                Button(
                    onClick = {
                        val country = countryCode?.let {
                            CountryEntity(
                                it,name,continent,
                                region,surfaceArea.toFloat(),indepYear.toInt(),population,
                                lifeExpectancy,gnp.toFloat(),localName,governmentForm,
                                headOfState,capital,code2)
                        }
                        if (country != null) {
                            viewModel.createCountry(country)
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
                            text = "UPDATE COUNTRY",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CustomToast(message: String) {
    Snackbar() {
        Text(message)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidCRUDTheme {
        CountryUpdate()
    }
}