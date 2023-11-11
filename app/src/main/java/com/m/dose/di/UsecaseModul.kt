package com.m.dose.di

import com.m.data.remote.Try
import com.m.data.repo.SerchRepo
import com.m.domain.repo.SerchService
import com.m.domain.usecase.searchBySintNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object UsecaseModul {

    @Provides
    fun service(tr:Try): SerchService = SerchRepo(tr)

       @Provides
    fun tr(): Try = Try()


    @Provides
    fun getusecase(serchService:SerchService): searchBySintNameUseCase =searchBySintNameUseCase(serchService)
}