package br.com.fabianospdev.bookslist.ui.home

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fabianospdev.bookslist.adapters.BooksAdapter
import br.com.fabianospdev.bookslist.databinding.FragmentHomeBinding
import br.com.fabianospdev.bookslist.model.book.Book
import br.com.fabianospdev.bookslist.ui.MainActivity
import br.com.fabianospdev.bookslist.utils.Shared
import javax.inject.Inject


class HomeFragment : Fragment(), FragmentManager.OnBackStackChangedListener {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: BooksAdapter
    val books: MutableList<Book> = Shared.instance.recording.items!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).mainComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.supportFragmentManager?.addOnBackStackChangedListener(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapter = BooksAdapter(requireContext())
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val recyclerView: RecyclerView = binding.rvListBooks
        recyclerView.background = linearGradientDrawable()
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.adapter = adapter

        viewModel.getBooks().observe(viewLifecycleOwner) {
            adapter.update(it)
            adapter.notifyDataSetChanged()
        }
        return root
    }

    override fun onStart() {
        super.onStart()
        adapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //  viewModel.books.removeObservers(viewLifecycleOwner)
        _binding = null
    }

    override fun onBackStackChanged() {

    }

    private fun linearGradientDrawable(): GradientDrawable {
        return GradientDrawable().apply {
            colors = intArrayOf(
                Color.parseColor("#E8F5E9"),
                Color.parseColor("#E7F4E8"),
                Color.parseColor("#E8F5E9"),
                Color.parseColor("#E7F4E8"),
            )
            gradientType = GradientDrawable.LINEAR_GRADIENT
            shape = GradientDrawable.RECTANGLE
            orientation = GradientDrawable.Orientation.BOTTOM_TOP
            setStroke(1, Color.parseColor("#4B5320"))
        }
    }

    private fun radialGradientDrawable(): GradientDrawable {
        return GradientDrawable().apply {
            colors = intArrayOf(
                Color.parseColor("#DA1884"),
                Color.parseColor("#FFF600"),
                Color.parseColor("#800020")
            )
            gradientType = GradientDrawable.RADIAL_GRADIENT
            shape = GradientDrawable.RECTANGLE
            gradientRadius = 35F
            setStroke(5, Color.parseColor("#CD5700"))
        }
    }


    // method to generate sweep gradient drawable
    private fun sweepGradientDrawable(): GradientDrawable {
        return GradientDrawable().apply {
            colors = intArrayOf(
                Color.parseColor("#DA1884"),
                Color.parseColor("#FFF600"),
                Color.parseColor("#800020")
            )
            gradientType = GradientDrawable.SWEEP_GRADIENT
            shape = GradientDrawable.RECTANGLE
            cornerRadii = floatArrayOf(15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f)
            cornerRadius = 25f
            setStroke(5, Color.parseColor("#232B2B"))
        }
    }


}