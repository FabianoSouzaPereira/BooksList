package br.com.fabianospdev.bookslist

import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.com.fabianospdev.bookslist.databinding.ActivityMainBinding
import br.com.fabianospdev.bookslist.ui.NavigationApp
import br.com.fabianospdev.bookslist.ui.di.MainComponent
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    lateinit var mainComponent: MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = (appBarConfiguration as NavigationApp).appComponent.mainComponent().create()

        super.onCreate(savedInstanceState)

        shortAndroidName("MainActivity_One")
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navController.navigateUp()

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        onSupportNavigateUp()
        val toolbar: com.google.android.material.appbar.MaterialToolbar = findViewById(R.id.topAppBar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    fun shortAndroidName(androidName: String) {
        desativarAll()
        if (androidName == "MainActivity_One") {
            packageManager.setComponentEnabledSetting(
                ComponentName(
                    BuildConfig.APPLICATION_ID,
                    "${BuildConfig.APPLICATION_ID}.${androidName}"
                ), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP
            )
        } else if (androidName == "MainActivity_Two") {
            packageManager.setComponentEnabledSetting(
                ComponentName(
                    "br.com.fabianospdev.bookslist",
                    "${BuildConfig.APPLICATION_ID}.${androidName}"
                ), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP
            )
        }
    }

    fun desativarAll() {
        packageManager.setComponentEnabledSetting(
            ComponentName(
                "br.com.fabianospdev.bookslist",
                "br.com.fabianospdev.bookslist.MainActivity-One"
            ), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                "br.com.fabianospdev.bookslist",
                "br.com.fabianospdev.bookslist.MainActivity-Two"
            ), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}