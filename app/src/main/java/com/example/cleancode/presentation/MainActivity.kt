package com.example.cleancode.presentation

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.cleancode.R
import com.example.cleancode.domain.FlowerModel
import com.example.cleancode.presentation.library.LibraryFragment

class MainActivity(override val drawer_layout: DrawerLayout?) : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    MainActivityDelegate {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val toolbar: Toolbar = findViewById(R.id.toolbar)
    setSupportActionBar(toolbar)

    val toggle = ActionBarDrawerToggle(
        this, drawer_layout, toolbar,
        R.string.navigation_drawer_open,
        R.string.navigation_drawer_close)
      drawer_layout?.addDrawerListener(toggle)
    toggle.syncState()

      val nav_view = findViewById(R.id.nav_view) as NavigationView
      nav_view.setNavigationItemSelectedListener(this)

    if(savedInstanceState == null) {
      nav_view.menu.findItem(R.id.nav_library).isChecked = true
      nav_view.menu.performIdentifierAction(R.id.nav_library, 0)
    }
  }


  override fun onBackPressed() {
    val drawerLayout: DrawerLayout = findViewById(
        R.id.drawer_layout)
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
      drawerLayout.closeDrawer(GravityCompat.START)
    } else {
      super.onBackPressed()
    }
  }

  override fun onNavigationItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.nav_library -> supportFragmentManager.beginTransaction()
          .replace(R.id.content, LibraryFragment.newInstance())
          .commit()
    }
    val drawerLayout: DrawerLayout = findViewById(
        R.id.drawer_layout)
    drawerLayout.closeDrawer(GravityCompat.START)
    return true
  }

  override fun openDocument(flower: FlowerModel) {

  }
}
