package com.example.guess2win.utils

import android.content.Context
import android.content.SharedPreferences

object SharedPref {
    private var mappcontext: Context? = null

    val shared_preferences_name = "tawseel data"

    private const val user_name = "name"
    private const val user_phone = "phone"
    private const  val user_email = "email"
    private const   val user_address = "address"
    private const  val user_logo = "logo"
    private const val user_updated_at = "updated_at"
    private const  val user_created_at = "created_at"
    private const  val user_id = "id"
    private const  val app_language = "language"

    const val token ="token"
    const val clientID ="clientid"
    val user_password = "password"
    fun init(appcontext: Context?) {
        mappcontext = appcontext
    }

    private fun getsharedpreferences():SharedPreferences{
        return mappcontext!!.getSharedPreferences(shared_preferences_name, Context.MODE_PRIVATE)
    }

    fun setusertoken(value: String) {
        val editor = getsharedpreferences().edit()
        editor.putString(token, value).apply()
    }

    fun getusertoken(): String = getsharedpreferences().getString(token,"")!!



    fun setUserID(value:String){
        val editor = getsharedpreferences().edit()
        editor.putString(clientID, value).apply()
    }

    fun getUserID():String{
    return     getsharedpreferences().getString(clientID,"")!!
    }
}