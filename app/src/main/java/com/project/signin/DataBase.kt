package com.project.signin

object DataBase {
    private val dbMap = mutableMapOf<String,Pair<String,String>>()  // <ID, Pair<Name,PW>>

    fun getDB(id: String):Pair<String,String>?{
        return dbMap.getOrDefault(id,null)
    }
    fun addDB(name:String, id:String, pw:String){
        dbMap[id] = Pair(name,pw)
    }
}