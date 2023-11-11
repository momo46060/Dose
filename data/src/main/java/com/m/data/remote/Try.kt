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
                            name = "",
                            sitName = "",
                            dose = "",
                            dis = ""
                        ),
                        Medecin(
                            name = "",
                            sitName = "",
                            dose = "",
                            dis = ""
                        ),

                        )
                )
            )
        }
    }

}