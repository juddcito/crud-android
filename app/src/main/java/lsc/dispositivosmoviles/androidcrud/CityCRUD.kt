package lsc.dispositivosmoviles.androidcrud

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import lsc.dispositivosmoviles.androidcrud.ui.theme.ui.theme.AndroidCRUDTheme

class CityCRUD : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCRUDTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CityCRUDApp()
                }
            }
        }
    }
}

@Composable
fun CityCRUDApp() {
    val context = LocalContext.current
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
                        contentDescription = "world icon",
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
            navigationIcon = {
                IconButton(
                    onClick = {
                        val intent = Intent(context, MainActivity::class.java)
                        ContextCompat.startActivity(context, intent, null)
                    }
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Navegación hacia atrás")
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
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Icono Favorito",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Add Country",
                        fontWeight = FontWeight.Bold
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
        //LazyColumn(modifier = Modifier.fillMaxWidth()){
         //   items(state.countries){
        //      CountryItem(country = it)
         //   }
        //}
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AndroidCRUDTheme {
        CityCRUDApp()
    }
}