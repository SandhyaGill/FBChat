package com.sandhyagill.fbchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.sandhyagill.fbchat.databinding.ActivityHomeBinding
import com.sandhyagill.fbchat.module.User

class HomeActivity : AppCompatActivity() {
    private val binding : ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    val firebaseAuth = Firebase.auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.side_menu, menu)
        return super.onCreateOptionsMenu(menu)
        navController = findNavController(R.id.fragment)

        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment,R.id.userFragment,R.id.chatFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuLogout ->{ firebaseAuth.signOut()
                Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()
                var intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            R.id.menuChat ->{
                navController.navigate(R.id.action_homeFragment_to_userFragment)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}