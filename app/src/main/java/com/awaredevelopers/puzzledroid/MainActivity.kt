package com.awaredevelopers.puzzledroid

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.awaredevelopers.puzzledroid.db.AppDatabase
import com.awaredevelopers.puzzledroid.db.entity.UserEntity
import com.awaredevelopers.puzzledroid.ui.intentActivity.SigInIntentActivity
import com.firebase.ui.auth.AuthUI
import com.awaredevelopers.puzzledroid.utility.AudioFactory.customTheme
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var user: UserEntity
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_scores, R.id.nav_global_scores, R.id.nav_settings, R.id.nav_help), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val headerView: View = navView.getHeaderView(0)

        val username: TextView = headerView.findViewById(R.id.username)

        username.text = Firebase.auth.currentUser?.displayName

        val sigin: Button = headerView.findViewById(R.id.sign_in)

        if (Firebase.auth.currentUser?.isAnonymous === true) {
            sigin.text = "Sign In"
        }

        try {
            val db = AppDatabase.getInstance(this)
            db.userDao().loadLiveUsers().observe(this, Observer {
                user = it[0]
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
//                Toast.makeText(this, "Item 1 pressed", Toast.LENGTH_LONG).show()
                findNavController(R.id.nav_host_fragment).navigate(R.id.nav_settings)
                return true
            }
        }
        return false
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK){
            customTheme = data?.data
        }
    }

    fun signOut(view: View) {
        AuthUI.getInstance().signOut(this).addOnCompleteListener {
            val intent = Intent(this, SigInIntentActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}