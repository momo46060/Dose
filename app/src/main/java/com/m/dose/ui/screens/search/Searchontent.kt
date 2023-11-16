package com.m.dose.ui.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.m.domain.model.Medecin
import com.m.domain.model.Resource
import com.m.dose.ui.views.ItemView

@Composable
fun SearchContent(
    data: Resource<List<Medecin>>,
    onsearchClick:(String)->Unit
) {
    when(data){
        is Resource.Unspecified ->{}
        is Resource.Loading ->{}
        is Resource.Success ->{
            data.data?.let { doc ->
                LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(5.dp)){
                    items(doc){medeicin ->
                        ItemView(medecin = medeicin)
                    }
                }
            }
        }
        else ->{}
    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Prev() {
     SearchContent(
            data=Resource.Success(
                data = listOf(
                    Medecin(
                        name = "Panadol Migraine",
                        sitName = "250mg Paracetamol + 250mg acetylsalicylic acid + 65mg caffeine",
                        dose = "2 tablets",
                        dis = "Panadol Migraine is an effective (over the counter) OTC migraine treatment. In clinical studies, patients with moderate to severe migraines experienced effective relief with just one dose. Migraine symptoms may vary, but often start on one side of the head, along with pulsating or throbbing pain. This can be combined with nausea, vomiting, and sensitivity to light and sound.\n" +
                                "\n" +
                                "Panadol Migraine contains acetylsalicylic acid, paracetamol and therapeutically active caffeine.",
                        image = "",
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

                    ),
                    Medecin(
                        name = "Panadol Night",
                        sitName = "500mg Paracetamol + 25mg Diphenhydramine hydrochloride",
                        dose = "2 caplets 20 minutes before bed",
                        dis = "Panadol Night contains two active ingredients, Paracetamol which is an analgesic (a pain reliever which relieves aches) and antipyretic (reduces body temperature when you have a fever) and Diphenhydramine hydrochloride, an antihistamine with additional sedative properties.",
                        image = "",
                        useFor = "Panadol Night provides night time relief when you have pain such as:\n" +
                                "\n" +
                                "Headaches\n" +
                                "Migraine\n" +
                                "Backache\n" +
                                "Rheumatic and muscle pain\n" +
                                "Toothache\n" +
                                "Period pain\n" +
                                "It also temporarily relieves fever and aches and pains associated with cold and flu which causes difficulty in sleeping"

                    ),

                    )
            ),
            onsearchClick = {}

        )

}