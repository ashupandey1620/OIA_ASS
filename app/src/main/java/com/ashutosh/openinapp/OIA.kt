package com.ashutosh.openinapp

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.work.Configuration
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.ashutosh.openinapp.API.OIAApi
import com.ashutosh.openinapp.Token.TokenStore
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class OIA : Application() {

}


