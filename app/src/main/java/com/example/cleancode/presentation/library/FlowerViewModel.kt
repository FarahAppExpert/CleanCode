package com.example.cleancode.presentation.library

import android.app.Application
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import com.example.cleancode.domain.FlowerModel
import com.example.cleancode.framework.FlowerViewModel
import com.example.cleancode.framework.Interactors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FlowerViewModel(application: Application, interactors: Interactors)
  : FlowerViewModel(application, interactors) {

  val documents: MutableLiveData<List<FlowerModel>> = MutableLiveData()

  fun loadFlowers() {
    GlobalScope.launch {
      documents.postValue(interactors.getFlower())
    }
  }

  fun addFlower(uri: Uri) {
    GlobalScope.launch {
      withContext(Dispatchers.IO) {
        interactors.addFlower(FlowerModel(uri.toString(), 0.0, "", "", "", 0))
      }

      loadFlowers()
    }
  }

  suspend fun setOpenFlower(flower: FlowerModel) {
    interactors.setFlowerInformation(flower)
  }
}
