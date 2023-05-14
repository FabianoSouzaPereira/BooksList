package br.com.fabianospdev.bookslist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.com.fabianospdev.bookslist.R
import br.com.fabianospdev.bookslist.databinding.ActivityMainBinding
import br.com.fabianospdev.bookslist.ui.di.MainComponent
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    lateinit var mainComponent: MainComponent

//    private val navController: NavController by lazy {
//        findNavController()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent =
            (applicationContext as BookListApplication).appComponent.mainComponent().create()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (applicationContext as BookListApplication).db

        // shortAndroidName("MainActivity_One")
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navController.navigateUp()

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        onSupportNavigateUp()
        val toolbar: com.google.android.material.appbar.MaterialToolbar =
            findViewById(R.id.topAppBar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

//    fun shortAndroidName(androidName: String) {
//        desativarAll(androidName)
//        if (androidName == "MainActivity_One") {
//            packageManager.setComponentEnabledSetting(
//                ComponentName(
//                    BuildConfig.APPLICATION_ID,
//                    "${BuildConfig.APPLICATION_ID}.${androidName}"
//                ), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP
//            )
//        } else if (androidName == "MainActivity_Two") {
//            packageManager.setComponentEnabledSetting(
//                ComponentName(
//                    "br.com.fabianospdev.bookslist",
//                    "${BuildConfig.APPLICATION_ID}.${androidName}"
//                ), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP
//            )
//        }
//    }

//    fun desativarAll(androidName: String) {
//        packageManager.setComponentEnabledSetting(
//            ComponentName(
//                BuildConfig.APPLICATION_ID,
//                "${BuildConfig.APPLICATION_ID}.${androidName}"
//            ), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP
//        )
//
//        packageManager.setComponentEnabledSetting(
//            ComponentName(
//                "br.com.fabianospdev.bookslist",
//                "${BuildConfig.APPLICATION_ID}.${androidName}"
//            ), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP
//        )
//
//    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}


