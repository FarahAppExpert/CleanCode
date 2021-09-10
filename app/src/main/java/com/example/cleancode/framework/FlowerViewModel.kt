package com.example.cleancode.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class FlowerViewModel(application: Application, protected val interactors: Interactors) :
    AndroidViewModel(application) {
  protected val application: FlowerReaderApplication = getApplication()

}
