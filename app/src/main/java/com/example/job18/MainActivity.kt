package com.example.jobsheet18

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.job18.R
import com.example.job18.busanafragment
import com.example.job18.kulinerfragment
import com.example.job18.pplgfragment
import com.example.job18.tofragment
import com.example.job18.tpflfragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawer: DrawerLayout
    lateinit var navView: NavigationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navView = findViewById(R.id.nav_view)
        drawer = findViewById(R.id.layout_gambar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = "JOBSHEET 18"

        toggle = ActionBarDrawerToggle(
            this@MainActivity, drawer,
            0, 0
        )

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.tpfl -> {
                val fragmentTpfl = supportFragmentManager.beginTransaction()
                fragmentTpfl.replace(R.id.content, tpflfragment())
                fragmentTpfl.commit()
                drawer.close()
            }
            R.id.to -> {
                val fragmentTo = supportFragmentManager.beginTransaction()
                fragmentTo.replace(R.id.content, tofragment())
                fragmentTo.commit()
                drawer.close()
            }
            R.id.pplg -> {
                val fragmentPplg = supportFragmentManager.beginTransaction()
                fragmentPplg.replace(R.id.content, pplgfragment())
                fragmentPplg.commit()
                drawer.close()
            }
            R.id.kuliner -> {
                val fragmentKuliner = supportFragmentManager.beginTransaction()
                fragmentKuliner.replace(R.id.content, kulinerfragment())
                fragmentKuliner.commit()
                drawer.close()
            }
            R.id.busana -> {
                val fragmentBusana = supportFragmentManager.beginTransaction()
                fragmentBusana.replace(R.id.content, busanafragment())
                fragmentBusana.commit()
                drawer.close()
            }
        }
        return true
    }
}