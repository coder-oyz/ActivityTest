package com.oyz.activitytest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.second_layout.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SecondActivity", this.toString())
        setContentView(R.layout.second_layout)
        //接收数据
        /*val extraData = intent.getStringExtra("extra_data")
        Log.d("SecondActivity", "extra_data is $extraData")*/

//        button2.setOnClickListener {
//            val intent = Intent()
//            intent.putExtra("data_return","Hello FirstActivity")
//            //向上一个activity返回数据
//            Log.d("SecondActivity","RESULT_OK:$RESULT_OK")
//            setResult(RESULT_OK,intent)
//            finish()
//            //销毁后会调用上一个activity的onActivityResult方法
//        }
        //测试singleTop 启动模式
        /*button2.setOnClickListener {
            val intent = Intent(this,FirstActivity::class.java)

            startActivity(intent)
        }*/

        //测试singleInstance启动模式
        Log.d("SecondActivity", "Task id is $taskId")
        button2.setOnClickListener {
            val intent = Intent(this,ThirdActivity::class.java)

            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SecondActivity","onDestroy")
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return","Hello FirstActivity")
        //向上一个activity返回数据
        setResult(RESULT_OK,intent)
        finish()
        //销毁后会调用上一个activity的onActivityResult方法
    }


}