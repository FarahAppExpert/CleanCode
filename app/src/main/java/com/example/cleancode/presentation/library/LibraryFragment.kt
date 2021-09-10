package com.example.cleancode.presentation.library

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.cleancode.R
import com.example.cleancode.framework.FlowerViewModelFactory
import com.example.cleancode.presentation.MainActivityDelegate
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.raywenderlich.android.majesticreader.presentation.IntentUtil.createOpenIntent

class LibraryFragment : Fragment() {

  companion object {
    const val READ_REQUEST_CODE = 100

    fun newInstance() = LibraryFragment()
  }

  private lateinit var viewModel: FlowerViewModel

  private lateinit var mainActivityDelegate: MainActivityDelegate



  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_library, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    val adapter = FlowerAdapter(glide = Glide.with(this)) {
      mainActivityDelegate.openDocument(it)
    }


    viewModel = ViewModelProviders.of(this, FlowerViewModelFactory)
        .get(FlowerViewModel::class.java)
    viewModel.documents.observe(viewLifecycleOwner, Observer { adapter.update(it) })
    viewModel.loadFlowers()

    var fab = view?.findViewById<FloatingActionButton>(R.id.fab)
    fab?.setOnClickListener { startActivityForResult(createOpenIntent(), READ_REQUEST_CODE) }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
      data?.data?.also { uri -> viewModel.addFlower(uri) }
    } else {
      super.onActivityResult(requestCode, resultCode, data)
    }
  }

}
