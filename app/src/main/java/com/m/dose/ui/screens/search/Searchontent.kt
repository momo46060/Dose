package com.m.dose.ui.screens.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.m.domain.model.Medecin
import com.m.domain.model.Resource
import com.m.dose.ui.views.ItemView

@Composable
fun SearchContent(
    data: Resource<List<Medecin>>
) {
    when(data){
        is Resource.Unspecified ->{}
        is Resource.Loading ->{}
        is Resource.Success ->{
            data.data?.let { doc ->
                LazyColumn(modifier = Modifier.fillMaxSize()){
                    items(doc){medeicin ->
                        ItemView(medecin = medeicin)
                    }
                }
            }
        }
        else ->{}
    }

}