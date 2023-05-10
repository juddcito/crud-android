package lsc.dispositivosmoviles.androidcrud

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import lsc.dispositivosmoviles.androidcrud.cities.CityCRUD
import lsc.dispositivosmoviles.androidcrud.countries.CountryCRUD
import lsc.dispositivosmoviles.androidcrud.touristpoints.TouristPointCRUD
import lsc.dispositivosmoviles.androidcrud.ui.theme.AndroidCRUDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCRUDTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF5F5FF)
                ) {
                    MainMenu()
                }
            }
        }
    }
}

@Composable
fun MainMenu() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = {
                Text(text = "ANDROID CRUD",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally))
            },
            backgroundColor = Color(0XFFced4da)
        )
        Spacer(modifier = Modifier.height(108.dp))
        Image(
            painter = painterResource(id = R.drawable.db),
            contentDescription = "database icon",
            modifier = Modifier
                .padding(15.dp)
                .align(CenterHorizontally)
                .size(184.dp)
        )
        Spacer(modifier = Modifier.height(108.dp))
        Button(
            onClick = {
                val intent = Intent(context, CountryCRUD::class.java)
                ContextCompat.startActivity(context, intent, null)
            },
            modifier = Modifier.width(256.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffB2DFB2))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.world),
                    contentDescription = "world icon",
                    modifier = Modifier
                        .size(32.dp)
                        .fillMaxWidth(),
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text("COUNTRIES")
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                val intent = Intent(context, CityCRUD::class.java)
                ContextCompat.startActivity(context, intent, null)
            },
            modifier = Modifier.width(256.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFFB2CCFF))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cities),
                    contentDescription = "world icon",
                    modifier = Modifier
                        .size(32.dp)
                        .fillMaxWidth(),
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text("CITIES")
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                val intent = Intent(context, TouristPointCRUD::class.java)
                ContextCompat.startActivity(context, intent, null)
            },
            modifier = Modifier.width(256.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFFF3C13A))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.point),
                    contentDescription = "world icon",
                    modifier = Modifier
                        .size(32.dp)
                        .fillMaxWidth(),
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text("TOURIST POINTS")
            }
        }
    }
}