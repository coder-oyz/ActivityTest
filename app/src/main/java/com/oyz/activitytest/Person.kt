package com.oyz.activitytest

import java.io.Serializable

/**
 * 实现序列化接口，使能够使用Intent传递自定义对象
 */
class Person : Serializable {
    var name = ""
    var age = 0
}