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
        setContentView(R.layout.second_layout)
        //接收数据
        /*val extraData = intent.getStringExtra("extra_data")
        Log.d("SecondActivity", "extra_data is $extraData")*/

        button2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_return","Hello FirstActivity")
            //向上一个activity返回数据
            Log.d("SecondActivity","RESULT_OK:$RESULT_OK")
            setResult(RESULT_OK,intent)
            finish()
            //销毁后会调用上一个activity的onActivityResult方法
        }
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