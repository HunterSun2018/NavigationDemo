package io.violas.navigationdemo.ui.Demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.violas.navigationdemo.R

class DemoFragment : Fragment() {

    private lateinit var homeViewModel: DemoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(DemoViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_demo, container, false)

        var navView: BottomNavigationView = root.findViewById(R.id.nav_view);

        var hostView: View = root.findViewById(R.id.nav_host_fragment)
        var navController = Navigation.findNavController(hostView);

        var mainActivity = activity as AppCompatActivity;
        val drawerLayout: DrawerLayout = mainActivity.findViewById(R.id.drawer_layout)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            ), drawerLayout
        )

        mainActivity.setupActionBarWithNavController(
            navController,
            appBarConfiguration
        )

        navView.setupWithNavController(navController)
        
        return root
    }
}