package com.m.domain.usecase

import com.m.domain.model.Medecin
import com.m.domain.model.Resource
import com.m.domain.repo.SerchService
import kotlinx.coroutines.flow.Flow

class searchBySintNameUseCase(private  val repo:SerchService) {

    operator  fun invoke(sintName: String): Flow<Resource<List<Medecin>>> = repo.searchBySintName(sintName)
}