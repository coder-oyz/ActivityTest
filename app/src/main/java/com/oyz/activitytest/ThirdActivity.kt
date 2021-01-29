package com.oyz.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.third_layout.*

class ThirdActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ThirdActivity", "Task id is $taskId")
        setContentView(R.layout.third_layout)
        //完成所有
        button3.setOnClickListener {
            ActivityController.finishAll()
            //还可以通过killProcess杀死当前程序的进程
            android.os.Process.killProcess(android.os.Process.myPid())
        }
    }
}