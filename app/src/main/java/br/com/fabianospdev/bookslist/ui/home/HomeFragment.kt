package br.com.fabianospdev.bookslist.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import br.com.fabianospdev.bookslist.MainActivity
import br.com.fabianospdev.bookslist.adapters.BooksAdapter
import br.com.fabianospdev.bookslist.databinding.FragmentHomeBinding
import br.com.fabianospdev.bookslist.model.book.Book
import br.com.fabianospdev.bookslist.utils.Shared
import javax.inject.Inject

class HomeFragment : Fragment(), FragmentManager.OnBackStackChangedListener {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: BooksAdapter
    val books = Shared.instance.populate

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).mainComponent
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
        val recyclerView: RecyclerView = binding.rvListBooks
        recyclerView.adapter = adapter

        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        viewModel.getBooks().observe( requireActivity(), Observer<List<Book>>{ books ->
            val list: MutableList<Book> = arrayListOf()
            list.add(Shared.instance.populate)
            adapter.update(list)
            adapter.notifyDataSetChanged()
        })

        viewModel.getBooks()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onBackStackChanged() {

    }



}