package com.awaredevelopers.puzzledroid

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.PermissionChecker
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.awaredevelopers.puzzledroid.model.NPuzzleGallery
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private val permisoLectura = android.Manifest.permission.READ_EXTERNAL_STORAGE
    private val permisoEscritura = android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    private val permisoCamara = android.Manifest.permission.CAMERA

    private val CODIGO_SOLICITUD_PERMISOS = 1007
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val REQUEST_GALLERY = 1001
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_scores, R.id.nav_settings, R.id.nav_help), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)



        if (validarPermisosLectura()&& validarPermisosEscritura()&& validarPermisosCamara()){
          println("Permisos concedidos")
        }
        else{
            pedirPermisos()
        }


    }

    private fun validarPermisosLectura():Boolean{
        val hayPermisoRead = ActivityCompat.checkSelfPermission(this,permisoLectura)== PackageManager.PERMISSION_GRANTED
        return hayPermisoRead
    }

    private fun validarPermisosEscritura():Boolean{
        val hayPermisoWrite = ActivityCompat.checkSelfPermission(this,permisoEscritura)== PackageManager.PERMISSION_GRANTED
        return hayPermisoWrite
    }

    private fun validarPermisosCamara():Boolean{
        val hayPermisoCamara = ActivityCompat.checkSelfPermission(this,permisoCamara)== PackageManager.PERMISSION_GRANTED
        return hayPermisoCamara
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun pedirPermisos(){
        val contextoRead = ActivityCompat.shouldShowRequestPermissionRationale(this,permisoLectura)
        val contextoWrite = ActivityCompat.shouldShowRequestPermissionRationale(this,permisoEscritura)
        val contextoCamara = ActivityCompat.shouldShowRequestPermissionRationale(this,permisoCamara)
        if (contextoRead || contextoWrite || contextoCamara){
            Toast.makeText(this, "PuzzleDroid necesita acceder a la galeria y a la camara para añadir nuevos puzzles", Toast.LENGTH_SHORT).show()
            solicitudPermisos()
        }
        else{
            solicitudPermisos()
        }
    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun solicitudPermisos(){
        requestPermissions(arrayOf(permisoLectura,permisoEscritura,permisoCamara),CODIGO_SOLICITUD_PERMISOS)

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
                val navHostFragment =
                    supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                val navController: NavController = navHostFragment.navController
                navController.navigate(R.id.action_HomeFragment_to_SettingsFragment)

                return true
            }
        }
        return false
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onRequestPermissionsResult(
                requestCode: Int,
                permissions: Array<out String>,
                grantResults: IntArray
            ) {

                when (requestCode) {
                    CODIGO_SOLICITUD_PERMISOS -> {
                        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                                    grantResults[1] == PackageManager.PERMISSION_GRANTED &&
                                    grantResults[2] == PackageManager.PERMISSION_GRANTED
                        ) {
                            //permission from popup granted
                        } else {
                            //permission from popup denied
                            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

}