package com.m.dose.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.m.domain.model.Resource
import com.m.dose.ui.views.ItemView


@Composable
fun MainView(
   viewModel: MainViewModel =  hiltViewModel()
) {
    val state by viewModel.data.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.Serch("")
    }
      when(state){
          is Resource.Unspecified ->{}
          is Resource.Loading ->{}
          is Resource.Success ->{
              state.data?.let { doc ->
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


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Pre() {
    LazyColumn(){
        items(5){medeicin ->
            Card(modifier = Modifier) {

            }
        }
    }

}