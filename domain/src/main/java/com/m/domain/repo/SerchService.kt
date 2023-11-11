package com.m.domain.repo

import com.m.domain.model.Medecin
import com.m.domain.model.Resource
import kotlinx.coroutines.flow.Flow

interface SerchService {
    fun searchBySintName(sint :String): Flow<Resource<List<Medecin>>>


}