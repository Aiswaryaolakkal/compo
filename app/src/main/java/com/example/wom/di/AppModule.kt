package com.example.wom.di

import android.app.Application
import androidx.room.Room
import com.example.wom.data.ConversionRepository
import com.example.wom.data.ConversionRepositoryImp
import com.example.wom.data.ConvertDAO
import com.example.wom.data.ConvertDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideConverterDataBase(app:Application):ConvertDataBase{
        return Room.databaseBuilder(
            app,
            ConvertDataBase::class.java,
            "converter_data_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideConverterRepository(db:ConvertDataBase):ConversionRepository{
        return ConversionRepositoryImp(db.convertDAO)
    }
}