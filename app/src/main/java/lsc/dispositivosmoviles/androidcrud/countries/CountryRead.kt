package lsc.dispositivosmoviles.androidcrud.countries

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
import lsc.dispositivosmoviles.androidcrud.data.CountryEntity
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
                    val intent = intent
                    val country = intent.getParcelableExtra<CountryEntity>("country")
                    CountryReadApp(country)
                }
            }
        }
    }
}

@Composable
fun CountryReadApp(country: CountryEntity?) {
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
                        label = { Text("Code (3)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                code2?.let {
                    TextField(
                        value = it,
                        enabled = false,
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
                        enabled = false,
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
                        enabled = false,
                        onValueChange = { continent = it },
                        label = { Text("Region") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }

                TextField(
                    value = surfaceArea?.toString() ?: "",
                    enabled = false,
                    onValueChange = { surfaceArea = it },
                    label = { Text("Surface Area") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                TextField(
                    value = indepYear,
                    onValueChange = { indepYear = it },
                    enabled = false,
                    label = { Text("Independence Year") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                TextField(
                    value = population,
                    onValueChange = { population = it },
                    enabled = false,
                    label = { Text("Population") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                TextField(
                    value = lifeExpectancy,
                    onValueChange = { lifeExpectancy = it },
                    enabled = false,
                    label = { Text("Life Expectancy") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                TextField(
                    value = gnp,
                    onValueChange = { gnp = it },
                    enabled = false,
                    label = { Text("GNP") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                localName?.let {
                    TextField(
                        value = it,
                        onValueChange = { localName = it },
                        enabled = false,
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
                        enabled = false,
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
                        enabled = false,
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
                        enabled = false,
                        label = { Text("Capital") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}
