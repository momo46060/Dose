package com.m.dose.ui.views

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.m.domain.model.Medecin
import com.m.dose.ui.theme.ShdowColor
import com.m.dose.ui.theme.smallText
import com.m.dose.ui.theme.subTitleStyle
import com.m.dose.ui.theme.titleStyle
import com.m.dose.utils.CARD_HEIGHT
import com.m.dose.utils.L_PADDING
import com.m.dose.utils.S_PADDING

@Composable
fun ItemView(medecin: Medecin) {
    Box(Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(CARD_HEIGHT)
                .shadow(L_PADDING, shape = RoundedCornerShape(20.dp), spotColor = ShdowColor)
                .padding(S_PADDING),
            colors = CardDefaults.cardColors(Color.White),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(S_PADDING)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxHeight(.95f)
                        .width(120.dp),
                    contentScale = ContentScale.Crop,
                    painter = rememberAsyncImagePainter(model = medecin.image),
                    contentDescription = null
                )
               Column(modifier = Modifier.fillMaxSize()) {
                   Text(
                       text = medecin.name,
                       style = titleStyle
                   )
                   Text(
                       text = medecin.sitName,
                       style = subTitleStyle
                   )
                   Text(
                       text = medecin.sitName,
                       style = smallText,
                       maxLines = 1,
                       overflow = TextOverflow.Ellipsis
                   )
               }
            }
        }

    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, locale = "ar")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "ar")

@Composable
fun MM() {
    ItemView(
        medecin = Medecin(
            name = "Panadol Migraine",
            sitName = "250mg Paracetamol + 250mg acetylsalicylic acid + 65mg caffeine",
            dose = "2 tablets",
            dis = "Panadol Migraine is an effective (over the counter) OTC migraine treatment. In clinical studies, patients with moderate to severe migraines experienced effective relief with just one dose. Migraine symptoms may vary, but often start on one side of the head, along with pulsating or throbbing pain. This can be combined with nausea, vomiting, and sensitivity to light and sound.\n" +
                    "\n" +
                    "Panadol Migraine contains acetylsalicylic acid, paracetamol and therapeutically active caffeine.",
            image = "https://medicalmartpk.com/cdn/shop/products/panadol-migraine_800x.gif?v=1624096974",
            useFor = "Panadol Migraine is recommended for treatment of tough pain such as:\n" +
                    "\n" +
                    "Migraine\n" +
                    "Headache\n" +
                    "A cold\n" +
                    "Arthritis\n" +
                    "Muscular aches\n" +
                    "Sinusitis\n" +
                    "Toothache\n" +
                    "Premenstrual and menstrual cramps"

        )
    )
}