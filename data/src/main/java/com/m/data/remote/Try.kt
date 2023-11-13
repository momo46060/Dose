package com.m.data.remote

import com.m.domain.model.Medecin
import com.m.domain.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Try() {

    fun test(str: String): Flow<Resource<List<Medecin>>> {
        return flow {
            emit(
                Resource.Success(
                    data = listOf(
                        Medecin(
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

                        ),
                        Medecin(
                            name = "Panadol Night",
                            sitName = "500mg Paracetamol + 25mg Diphenhydramine hydrochloride",
                            dose = "2 caplets 20 minutes before bed",
                            dis = "Panadol Night contains two active ingredients, Paracetamol which is an analgesic (a pain reliever which relieves aches) and antipyretic (reduces body temperature when you have a fever) and Diphenhydramine hydrochloride, an antihistamine with additional sedative properties.",
                            image = "https://www.panadol.com/content/dam/cf-consumer-healthcare/panadol-reborn/en_GB/product-detail/panadol-night-pain-box-20/Panadol-Night-Pain-Box-20s380x463.png",
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
                )
            )
        }
    }

}