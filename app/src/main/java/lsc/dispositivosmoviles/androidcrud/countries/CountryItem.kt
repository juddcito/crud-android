package lsc.dispositivosmoviles.androidcrud.countries

import android.content.Intent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import lsc.dispositivosmoviles.androidcrud.R
import lsc.dispositivosmoviles.androidcrud.data.CountryEntity

@Composable
fun CountryItem(
    country: CountryEntity,
    viewModel: CountryViewModel
) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)// redondea las esquinas con radio de 16 dp
            .border(1.dp, Color.Gray),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier.padding(16.dp)// ajusta el relleno dentro de la tarjeta
        ) {
            country.name?.let { Text(it, fontSize = 18.sp, fontWeight = FontWeight.Bold) }
            country.countryCode?.let { Text(it) }
            country.continent?.let { Text(it) }
            country.region?.let { Text(it) }
        }
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(32.dp)
        ) {
            IconButton(
                onClick = {
                    val intent = Intent(context, CountryRead::class.java)
                    intent.putExtra("country", country)
                    startActivity(context,intent,null)
                }
            ) {
                Icon(
                    painterResource(id = R.drawable.eye),
                    contentDescription = "",
                    modifier = Modifier.size(32.dp)
                )
            }
            IconButton(
                onClick = {
                    val intent = Intent(context, CountryUpdate::class.java)
                    intent.putExtra("country", country)
                    startActivity(context,intent,null)
                }
            ) {
                Icon(
                    painterResource(id = R.drawable.pencil),
                    contentDescription = "",
                    modifier = Modifier.size(32.dp)
                )
            }
            IconButton(onClick = {
                    viewModel.deleteCountry(country)
            }) {
                Icon(
                    painterResource(id = R.drawable.delete),
                    contentDescription = "",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}