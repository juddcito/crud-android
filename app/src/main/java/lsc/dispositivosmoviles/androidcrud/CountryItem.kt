package lsc.dispositivosmoviles.androidcrud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lsc.dispositivosmoviles.androidcrud.data.CountryEntity
import lsc.dispositivosmoviles.androidcrud.ui.theme.AndroidCRUDTheme

@Composable
fun CountryItem(
    country: CountryEntity
) {
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
            Text(country.name)
            Text(country.countryCode)
        }
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painterResource(id = R.drawable.eye),
                    contentDescription = "",
                    modifier = Modifier.size(32.dp)
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painterResource(id = R.drawable.pencil),
                    contentDescription = "",
                    modifier = Modifier.size(32.dp)
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painterResource(id = R.drawable.delete),
                    contentDescription = "",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}