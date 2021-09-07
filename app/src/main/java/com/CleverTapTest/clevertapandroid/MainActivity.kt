package com.CleverTapTest.clevertapandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.CleverTapTest.clevertapandroid.databinding.ActivityMainBinding
import com.clevertap.android.sdk.CleverTapAPI
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var cleverTapDefaultInstance: CleverTapAPI? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(applicationContext)

        binding.btnProductView.setOnClickListener {
            val profileUpdate = HashMap<String, Any>()
            // each of the below mentioned fields are optional
            profileUpdate["Name"] = "Imran Khan" // String
            profileUpdate["Identity"] = 1234561233 // String or number
            profileUpdate["Email"] = "mmkhan359@gmail.com" // Email address of the user
            profileUpdate["Phone"] = "7568559111" // Phone (with the country code, starting with +)
            profileUpdate["Gender"] = "M" // Can be either M or F
            profileUpdate["DOB"] = Date() // Date of Birth. Set the Date object to the appropriate value first
            // optional fields. controls whether the user will be sent email, push etc.
            // optional fields. controls whether the user will be sent email, push etc.
            profileUpdate["MSG-email"] = false // Disable email notifications
            profileUpdate["MSG-push"] = true // Enable push notifications
            profileUpdate["MSG-sms"] = false // Disable SMS notifications
            profileUpdate["MSG-whatsapp"] = true // Enable WhatsApp notifications
            val stuff = ArrayList<String>()
            stuff.add("bag")
            stuff.add("shoes")
            profileUpdate["MyStuff"] = stuff //ArrayList of Strings
            val otherStuff = arrayOf("Jeans", "Perfume")
            profileUpdate["MyStuff"] = otherStuff //String Array
            Log.d("DATA==",profileUpdate.toString())

            CleverTapAPI.getDefaultInstance(applicationContext)?.onUserLogin(profileUpdate)
            cleverTapDefaultInstance?.pushEvent("Product viewed")

        }
    }



}