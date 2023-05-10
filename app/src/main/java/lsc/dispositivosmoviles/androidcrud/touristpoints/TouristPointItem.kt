package lsc.dispositivosmoviles.androidcrud.touristpoints

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.core.content.ContextCompat
import lsc.dispositivosmoviles.androidcrud.R
import lsc.dispositivosmoviles.androidcrud.countries.CountryRead
import lsc.dispositivosmoviles.androidcrud.countries.CountryUpdate
import lsc.dispositivosmoviles.androidcrud.countries.CountryViewModel
import lsc.dispositivosmoviles.androidcrud.data.CountryEntity
import lsc.dispositivosmoviles.androidcrud.data.TouristPointEntity
import lsc.dispositivosmoviles.androidcrud.touristpoints.ui.theme.AndroidCRUDTheme

@Composable
fun TouristPointItemApp(
    touristPoint: TouristPointEntity,
    viewModel: TouristPointViewModel
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
            touristPoint.name?.let { Text(it, fontSize = 18.sp, fontWeight = FontWeight.Bold) }
            touristPoint.countryCode?.let { Text(it) }
            touristPoint.cost?.let { Text(it.toString()) }
        }
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(32.dp)
        ) {
            IconButton(
                onClick = {
                    val intent = Intent(context, TouristPointRead::class.java)
                    intent.putExtra("touristPoint",touristPoint)
                    ContextCompat.startActivity(context,intent,null)
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
                    val intent = Intent(context, TouristPointUpdate::class.java)
                    intent.putExtra("touristPoint", touristPoint)
                    ContextCompat.startActivity(context,intent,null)
                }
            ) {
                Icon(
                    painterResource(id = R.drawable.pencil),
                    contentDescription = "",
                    modifier = Modifier.size(32.dp)
                )
            }
            IconButton(onClick = {
                viewModel.deleteTouristPoint(touristPoint)
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

