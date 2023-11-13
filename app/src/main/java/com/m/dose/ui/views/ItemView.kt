package com.m.dose.ui.views

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberAsyncImagePainter
import com.m.domain.model.Medecin
import com.m.dose.ui.theme.Blue
import com.m.dose.ui.theme.ShdowColor
import com.m.dose.ui.theme.subTitleStyle
import com.m.dose.ui.theme.titleStyle
import com.m.dose.utils.CARD_HEIGHT
import com.m.dose.utils.L_PADDING
import com.m.dose.utils.S_PADDING

@Composable
fun ItemView(medecin: Medecin) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(CARD_HEIGHT)
            .shadow(L_PADDING, shape = RoundedCornerShape(L_PADDING), spotColor = ShdowColor)
            .padding(S_PADDING),
        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(2.dp, Blue)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(L_PADDING)
                .padding(S_PADDING)
        ) {
            val (image, title, sitName, dis) = createRefs()
            Image(
                modifier = Modifier
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        end.linkTo(title.start)
                        width = Dimension.value(100.dp)
                        height = Dimension.fillToConstraints
                    },
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(model = medecin.image),
                contentDescription = null
            )
            Text(
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(image.end,S_PADDING)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                },
                text = medecin.name,
                style = titleStyle
            )
            Text(
                modifier = Modifier.constrainAs(sitName) {
                    top.linkTo(title.bottom, S_PADDING)
                    start.linkTo(image.end,S_PADDING)
                    height = Dimension.wrapContent
                }.fillMaxWidth(.7f),
                text = medecin.sitName,
                style = subTitleStyle,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
            )
            Text(
                modifier = Modifier.fillMaxWidth(.7f).constrainAs(dis) {
                    top.linkTo(sitName.bottom, S_PADDING)
                    start.linkTo(image.end,S_PADDING)
                    height = Dimension.wrapContent
                },
                text = medecin.dis,
                style = subTitleStyle,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )

        }

    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
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