package com.example.guess2win.BottomNavigation.Login

import android.util.Log
import com.example.guess2win.Model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase



class LoginRepo {
    fun uploadUserDataToRealtimeDB(user: User) {
        user.id=FirebaseAuth.getInstance().currentUser!!.uid
        FirebaseDatabase.getInstance().getReference("Users").child(
            FirebaseAuth.getInstance().currentUser!!.uid
        ).setValue(user).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("realtime", "success")
            } else {
                Log.d("realtime", "Failure")
            }
        }
    }
}