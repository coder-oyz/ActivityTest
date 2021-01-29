package com.oyz.activitytest

import java.lang.StringBuilder

fun main() {

    //test1()
    test4()
}
//normal
fun test1(){
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val builder = StringBuilder()
    builder.append("Start eating fruits.\n")
    for(fruit in list){
        builder.append(fruit).append("\n")
    }
    builder.append("Ate all fruits.")
    val result = builder.toString()
    println(result)
}
//with
fun test2(){
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = with(StringBuilder()){
        append("Start eating fruits.\n")
        for(fruit in list){
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
        toString()
    }
    println(result)
}
//run
fun test3(){
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result =StringBuilder().run{
        append("Start eating fruits.\n")
        for(fruit in list){
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
        toString()
    }
    println(result)
}
//apply
fun test4(){
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result =StringBuilder().apply{
        append("Start eating fruits.\n")
        for(fruit in list){
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
    }
    println(result.toString())
}