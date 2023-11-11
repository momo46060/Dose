package com.m.data.repo

import com.m.data.remote.Try
import com.m.domain.model.Medecin
import com.m.domain.model.Resource
import com.m.domain.repo.SerchService
import kotlinx.coroutines.flow.Flow

class SerchRepo(val tr:Try):SerchService {
    override fun searchBySintName(sint: String): Flow<Resource<List<Medecin>>> {
        return tr.test(sint)
    }
}