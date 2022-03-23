package com.example.applic0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {

    val teacher = arrayListOf<Teacher>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        initData()
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = TeacherAdapter(teacher)

    }

    private fun initData() {

        for( i in 0..10) {

            teacher.add(Teacher().apply {
                name = "王钊"
                description =
                    "四川泸州人，西南大学经济管理学院二级教授，博士生导师，经济管理学院院长。国务院政府特殊津贴专家；重庆市学术技术带头人。兼任国务院学位委员会学科评议组委员，教育部本科教学指导委员会委员，中国农业经济学会常务理事，重庆市区域经济学会副会长等。"
                avatar = R.mipmap.wz
            })

            teacher.add(Teacher().apply {
                name = "王小佳"
                description =
                    "四川南溪人，园艺园林学院二级教授，博士生导师。农业部有突出贡献中青年优秀专家、优秀归国人员；教育部跨世纪优秀人才计划入选者；1993年起享受国务院政府特殊津贴。"
                avatar = R.mipmap.wxj
            })
            teacher.add(Teacher().apply {
                name = "赵伶俐"
                description =
                    "四川南充人，教育学部二级教授、博士生导师，文学学士、教育学硕士、心理学博士；高等教育学博导、心理学博导、美学博导；曾宪梓基金全国优秀教师一等奖获得者；享受国务院颁发的政府特殊津贴；重庆市名师;国家精品课程“课堂教学技术与艺术”创建、负责人和主讲教师、国家级精品视频课程“跨界思维”创建、负责和主讲教师；高等教育研究所副所长。"
                avatar = R.mipmap.zll
            })
        }

    }
}