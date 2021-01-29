package com.oyz.activitytest

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
//使用封装好后的Parcelable
/*@Parcelize
class Person(var name: String, var age: Int) : Parcelable*/
/**
 * 使用原始的Parcelable
 */
class Person() : Parcelable{
    var name = ""
    var age = 0


    /**
     * 将Person中的字段一一写出
     */
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            val person = Person()
            person.name = parcel.readString() ?: ""  //读取name
            person.age = parcel.readInt() //读取age
            return person
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }


}



/**
 * 实现序列化接口，使能够使用Intent传递自定义对象
 */
/*class Person : Serializable {
    var name = ""
    var age = 0
}*/