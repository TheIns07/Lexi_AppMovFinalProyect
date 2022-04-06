package pichardo.fernanda.lexi.myCourses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pichardo.fernanda.lexi.R
import pichardo.fernanda.lexi.databinding.ActivityMyCoursesBinding
import pichardo.fernanda.lexi.themes.ThemesCourseActivity

class MyCoursesActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMyCoursesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindAdapter()
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun bindAdapter() {
        val adapter = MyCoursesAdapter()
        adapter.list = arrayListOf(Course(10,"Inglés",58, R.drawable.uk_flag),
            Course(1,"Francés",10, R.drawable.fr_flag))
        binding.rvCourses.adapter = adapter

        adapter.listener = object : OnCourseListener {
            override fun onClick() {
                startActivity(Intent(this@MyCoursesActivity,ThemesCourseActivity::class.java))
            }
        }
    }
}