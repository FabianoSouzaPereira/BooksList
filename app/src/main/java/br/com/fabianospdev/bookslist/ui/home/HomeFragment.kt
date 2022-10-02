package br.com.fabianospdev.bookslist.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import br.com.fabianospdev.bookslist.adapters.BooksAdapter
import br.com.fabianospdev.bookslist.databinding.FragmentHomeBinding
import br.com.fabianospdev.bookslist.model.book.Book
import br.com.fabianospdev.bookslist.utils.Shared

class HomeFragment : Fragment(), FragmentManager.OnBackStackChangedListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: BooksAdapter
    val books = Shared.instance.populate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.supportFragmentManager?.addOnBackStackChangedListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        adapter = BooksAdapter(requireContext())

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val root: View = binding.root
        val textView: TextView = binding.textHome
        val recyclerView: RecyclerView = binding.rvListBooks
        recyclerView.adapter = adapter

        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        homeViewModel.getBooks().observe( requireActivity(), Observer<List<Book>>{ books ->
            val list: MutableList<Book> = arrayListOf()
            list.add(Shared.instance.populate)
            adapter.update(list)
            adapter.notifyDataSetChanged()
        })

        homeViewModel.getBooks()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onBackStackChanged() {

    }



}