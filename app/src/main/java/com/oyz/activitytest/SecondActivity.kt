package com.oyz.activitytest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.second_layout.*

class SecondActivity : BaseActivity() {
    //启动activity传递数据的最佳写法
    companion object {
        fun actionStart(context: Context, data1: String, data2 : String){
            val intent = Intent(context , SecondActivity::class.java).apply {
                putExtra("param1", data1)
                putExtra("param2", data2)
            }

            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SecondActivity", this.toString())
        setContentView(R.layout.second_layout)

        //val person = intent.getSerializableExtra("person_data") as Person
        val person = intent.getParcelableExtra<Person>("person_data") as Person

        val data1 = intent.getStringExtra("param1")
        val data2 = intent.getStringExtra("param2")
        Log.d("SecondActivity", "param1 is $data1,param2 is $data2")


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