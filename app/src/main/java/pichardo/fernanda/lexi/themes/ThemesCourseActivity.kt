package pichardo.fernanda.lexi.themes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pichardo.fernanda.lexi.R
import pichardo.fernanda.lexi.databinding.ActivityThemesCourseBinding

class ThemesCourseActivity : AppCompatActivity() {
    private lateinit var binding : ActivityThemesCourseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThemesCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.container_fragments,ThemesFragment()).commit()

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }


}