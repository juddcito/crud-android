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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
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

class CountryCreate : ComponentActivity() {
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
                    val dao = database.countryDao
                    val viewModel by viewModels<CountryViewModel>(factoryProducer = {
                        object : ViewModelProvider.Factory{
                            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                                return CountryViewModel(dao) as T
                            }
                        }
                    })
                    CountryCreateApp(viewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CountryCreateApp(viewModel: CountryViewModel) {
    var name by remember { mutableStateOf("") }
    var countryCode by remember { mutableStateOf("") }
    var continent by remember { mutableStateOf("") }
    var region by remember { mutableStateOf("") }
    var surfaceArea by remember { mutableStateOf("") }
    var indepYear by remember { mutableStateOf("") }
    var population by remember { mutableStateOf("") }
    var lifeExpectancy by remember { mutableStateOf("") }
    var gnp by remember { mutableStateOf("") }
    var localName by remember { mutableStateOf("") }
    var governmentForm by remember { mutableStateOf("") }
    var headOfState by remember { mutableStateOf("") }
    var capital by remember { mutableStateOf("") }
    var code2 by remember { mutableStateOf("") }
    val focusRequester1 = remember { FocusRequester() }
    val focusRequester2 = remember { FocusRequester() }
    val focusRequester3 = remember { FocusRequester() }
    val focusRequester4 = remember { FocusRequester() }
    val focusRequester5 = remember { FocusRequester() }
    val focusRequester6 = remember { FocusRequester() }
    val focusRequester7 = remember { FocusRequester() }
    val focusRequester8 = remember { FocusRequester() }
    val focusRequester9 = remember { FocusRequester() }
    val focusRequester10 = remember { FocusRequester() }
    val focusRequester11= remember { FocusRequester() }
    val focusRequester12 = remember { FocusRequester() }
    val focusRequester13 = remember { FocusRequester() }
    val focusRequester14 = remember { FocusRequester() }
    val focusRequester15 = remember { FocusRequester() }

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
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusRequester2.requestFocus() }
                        ),
                        label = { Text("Name") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .focusRequester(focusRequester1)
                    )
                }
                countryCode?.let {
                    TextField(
                        value = it,
                        onValueChange = { countryCode = it },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusRequester3.requestFocus() }
                        ),
                        label = { Text("Code (3)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .focusRequester(focusRequester2)
                    )
                }
                code2?.let {
                    TextField(
                        value = it,
                        onValueChange = { code2 = it },
                        label = { Text("Code (2)") },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusRequester4.requestFocus() }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .focusRequester(focusRequester3)
                    )
                }
                continent?.let {
                    TextField(
                        value = it,
                        onValueChange = { continent = it },
                        label = { Text("Continent") },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusRequester5.requestFocus() }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .focusRequester(focusRequester4)
                    )
                }
                region?.let {
                    TextField(
                        value = it,
                        onValueChange = { region = it },
                        label = { Text("Region") },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusRequester6.requestFocus() }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .focusRequester(focusRequester5)
                    )
                }

                TextField(
                    value = surfaceArea?.toString() ?: "",
                    onValueChange = { surfaceArea = it },
                    label = { Text("Surface Area") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onNext = { focusRequester7.requestFocus() }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .focusRequester(focusRequester6)
                )
                TextField(
                    value = indepYear,
                    onValueChange = { indepYear = it },
                    label = { Text("Independence Year") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onNext = { focusRequester8.requestFocus() }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .focusRequester(focusRequester7)
                )
                TextField(
                    value = population,
                    onValueChange = { population = it },
                    label = { Text("Population") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onNext = { focusRequester9.requestFocus() }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .focusRequester(focusRequester8)
                )
                TextField(
                    value = lifeExpectancy,
                    onValueChange = { lifeExpectancy = it },
                    label = { Text("Life Expectancy") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onNext = { focusRequester10.requestFocus() }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .focusRequester(focusRequester9)
                )
                TextField(
                    value = gnp,
                    onValueChange = { gnp = it },
                    label = { Text("GNP") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onNext = { focusRequester11.requestFocus() }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .focusRequester(focusRequester10)
                )
                localName?.let {
                    TextField(
                        value = it,
                        onValueChange = { localName = it },
                        label = { Text("Local Name") },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusRequester12.requestFocus() }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .focusRequester(focusRequester11)
                    )
                }
                governmentForm?.let {
                    TextField(
                        value = it,
                        onValueChange = { governmentForm = it },
                        label = { Text("Government Form") },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusRequester13.requestFocus() }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .focusRequester(focusRequester12)
                    )
                }
                headOfState?.let {
                    TextField(
                        value = it,
                        onValueChange = { headOfState = it },
                        label = { Text("Head of State") },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusRequester14.requestFocus() }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .focusRequester(focusRequester13)
                    )
                }
                capital?.let {
                    TextField(
                        value = it,
                        onValueChange = { capital = it },
                        label = { Text("Capital") },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(
                            onNext = { focusRequester15.requestFocus() }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .focusRequester(focusRequester14)
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
                                "Country added!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    modifier = Modifier.padding(10.dp).width(400.dp).height(50.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Icono Favorito",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "ADD COUNTRY",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }

}
