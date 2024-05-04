package com.reynaldo.horoscapp.data.network

import com.reynaldo.horoscapp.data.RepositoryImpl
import com.reynaldo.horoscapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providerRetrofit(): Retrofit{
      return  Retrofit
            .Builder()
            .baseUrl("https://newastro.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providerHoroscopeApiService(retrofit: Retrofit): HoroscopeApiService{
        return retrofit.create(HoroscopeApiService::class.java)
    }
    @Provides
    fun providerRepository(horoscopeApiService: HoroscopeApiService):Repository{
        return RepositoryImpl(horoscopeApiService)
    }

}