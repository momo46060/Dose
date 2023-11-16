package com.m.dose.ui.views

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.m.domain.model.Medecin
import com.m.dose.ui.theme.CardBackground
import com.m.dose.ui.theme.subTitleStyle
import com.m.dose.ui.theme.textColor
import com.m.dose.ui.theme.titleStyle
import com.m.dose.utils.CARD_HEIGHT
import com.m.dose.utils.L_PADDING
import com.m.dose.utils.S_PADDING

@Composable
fun ItemView(medecin: Medecin) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(CardBackground)
            .height(CARD_HEIGHT),
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(CardBackground)
                .padding(L_PADDING)
        ) {
            val ( title, sitName, dis) = createRefs()
            Text(
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.absoluteLeft,S_PADDING)
                    height = Dimension.wrapContent
                    width = Dimension.matchParent
                }
                ,
                text = medecin.name,
                style = titleStyle,
                color = textColor
            )
            Text(
                modifier = Modifier
                    .constrainAs(sitName) {
                        top.linkTo(title.bottom, S_PADDING)
                        start.linkTo(parent.absoluteLeft, S_PADDING)
                        height = Dimension.wrapContent
                        width = Dimension.matchParent

                    }
                    .fillMaxWidth(.95f),
                text = medecin.sitName,
                style = subTitleStyle,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = textColor,

            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(dis) {
                        top.linkTo(sitName.bottom, S_PADDING)
                        start.linkTo(parent.absoluteLeft, S_PADDING)
                        height = Dimension.wrapContent
                        width = Dimension.matchParent
                    },
                text = medecin.dis,
                style = subTitleStyle,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = textColor

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