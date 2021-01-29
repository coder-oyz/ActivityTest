package com.oyz.activitytest

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.first_layout.*
import kotlinx.android.synthetic.main.second_layout.*

class FirstActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FirstActivity",this.toString())
        setContentView(R.layout.first_layout)

        val person = Person()
        person.name = "Tom"
        person.age = 20
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("person_data", person)
        startActivity(intent)

        //var button:Button = findViewById(R.id.button)
        /*button.setOnClickListener {
            //Toast.makeText(this, "You clicked Button" , Toast.LENGTH_SHORT).show()

            //finish()//销毁activity

            //使用显式intent 启动第二个activity
            /*val intent = Intent(this , SecondActivity::class.java)
            startActivity(intent)*/

            //使用隐式intent   action:"com.oyz.activitytest.ACTION_START"  category:default   启动第二个activity
            val intent = Intent("com.oyz.activitytest.ACTION_START")
            //再添加一个category
            //若没有与之对应的category的话会报错
            intent.addCategory("com.oyz.activitytest.MY_CATEGORY")
            startActivity(intent)
        }*/
        /*button.setOnClickListener {
            //使用intent展示网页
            /*val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.baidu.com")
            startActivity(intent)*/

            //使用隐式intent调用系统拨号界面
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }*/

        //使用intent传递数据
        /*button.setOnClickListener {
            val data = "Hello SecondActivity"
            val intent = Intent(this , SecondActivity::class.java)
            intent.putExtra("extra_data",data)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }*/

//        //启动的activity销毁后有数据回传
//        button.setOnClickListener {
//            val intent = Intent(this , SecondActivity::class.java)
//            //使用startActivityForResult，请求码用于回调中判断数据来源
//            startActivityForResult(intent,1)
//        }

        //测试standard 启动模式
        //对于使用standard模式的Activity，系统不会在乎这个Activity是否已经在返回栈中存在，每次启动都会创建一个该Activity的新实例。
        /*button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }*/

        //测试singleTop 启动模式
        //当Activity的启动模式指定为singleTop，在启动Activity时如果发现返回栈的栈顶已经是该Activity，则认为可以直接使用它，不会再创建新的Activity实例。
        /*button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }*/

        //测试singleInstance启动模式
        /*Log.d("FirstActivity","Task id is $taskId")

        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }*/

        button.setOnClickListener {
            //SecondActivity.actionStart(this, "data1", "data2")
            Toast.makeText(this, "You clicked Button" , Toast.LENGTH_SHORT).show()
        }


    }

    override fun onRestart() {
        super.onRestart()
        Log.d("FirstActivity","onRestart")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("FirstActivity" , "进入first，requestCode：$requestCode,RESULT_OK:$RESULT_OK")
        when(requestCode) {
            1-> if(resultCode == RESULT_OK){
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity" , "returned data is $returnedData")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //初始化menu
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    //menu选择连选中事件
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_item -> Toast.makeText(this, "You clicked Add" , Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove" , Toast.LENGTH_SHORT).show()
        }
        return true
    }
}