package pichardo.fernanda.lexi.themes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pichardo.fernanda.lexi.R
import pichardo.fernanda.lexi.databinding.FragmentThemesBinding

class ThemesFragment : Fragment() {

    private var _binding: FragmentThemesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        _binding = FragmentThemesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

        bindAdapter()
    }

    private fun bindAdapter() {
        val adapter = ThemesCourseAdapter()
        adapter.list = arrayListOf(Theme(R.drawable.th_negocios,"Negocios"),
            Theme(R.drawable.th_peliculas,"Películas/Series"),
            Theme(R.drawable.th_deportes,"Deportes"),
            Theme(R.drawable.th_musica,"Música"),
            Theme(R.drawable.th_gastronomia,"Gastronomía"),
            Theme(R.drawable.th_historia,"Historia"),
            Theme(R.drawable.th_moda,"Moda"),
            Theme(R.drawable.th_tadiciones,"Tradiciones"))
        binding.rvThemes.adapter = adapter

        adapter.listener = object : OnThemeListener {
            override fun onClick() {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container_fragments,ThemeDetailFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}