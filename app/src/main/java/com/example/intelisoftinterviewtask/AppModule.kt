package com.example.intelisoftinterviewtask

import android.app.Application
import androidx.room.Room
import com.example.intelisoftinterviewtask.repository.PatientRepository
import com.example.intelisoftinterviewtask.repository.PatientRepositoryImpl
import com.example.intelisoftinterviewtask.data.local.AppDatabase
import com.example.intelisoftinterviewtask.data.local.PatientDao
import com.example.intelisoftinterviewtask.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //API / RETROFIT
    @Provides
    @Singleton // 1 instance of Retrofit
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://patientvisitapis.intellisoftkenya.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    // DB / ROOM
    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "patient_db" // Name of db file
        ).build()
    }

    @Provides // Tells Hilt how to get the PatientDao
    @Singleton
    fun providePatientDao(db: AppDatabase): PatientDao {
        return db.patientDao()
    }

    @Provides
    @Singleton
    fun providePatientRepository(
        api: ApiService,
        dao: PatientDao
    ): PatientRepository {
        return PatientRepositoryImpl(api, dao)
    }
}