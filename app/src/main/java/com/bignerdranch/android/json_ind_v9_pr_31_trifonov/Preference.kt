package com.bignerdranch.android.json_ind_v9_pr_31_trifonov
import com.google.gson.Gson
import android.content.Context
import com.google.gson.reflect.TypeToken

object Preference {
    private const val prefs_name="music_disk_prefs"
    private const val log_user="saved_username"
    private const val pass_user="saved_password"
    private const val is_logged="is_logged_in"
    private const val disks="disks_list"
    private val gson=Gson()

    fun getSaveLogin(context: Context):String?{
        return context.getSharedPreferences(prefs_name,Context.MODE_PRIVATE).getString(log_user,null)
    }

    fun getSavePass(context: Context):String?{
        return context.getSharedPreferences(prefs_name,Context.MODE_PRIVATE).getString(pass_user,null)
    }

    fun setLoggedIn(context: Context,isLoggedIn:Boolean){
        context.getSharedPreferences(prefs_name,Context.MODE_PRIVATE).edit()
            .putBoolean(is_logged,isLoggedIn)
            .apply()
    }

    fun isLoggedIn(context: Context):Boolean{
        return context.getSharedPreferences(prefs_name,Context.MODE_PRIVATE).getBoolean(is_logged,false)
    }

    fun saveDisks(context: Context,disksList:List<MusicDisk>){
        val jsonString=gson.toJson(disksList)

        val sharedPrefs=context.getSharedPreferences(prefs_name,Context.MODE_PRIVATE)
        sharedPrefs.edit().putString(disks,jsonString).apply()
    }

    fun getDisks(context: Context):MutableList<MusicDisk>{
        val jsonString=context.getSharedPreferences(prefs_name,Context.MODE_PRIVATE).getString(disks,null)
        if(jsonString==null){
            return mutableListOf()
        }

        val listType=object:TypeToken<MutableList<MusicDisk>>() {}.type
        return gson.fromJson(jsonString,listType)
    }
}