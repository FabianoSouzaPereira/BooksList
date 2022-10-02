package br.com.fabianospdev.bookslist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.fabianospdev.bookslist.R
import br.com.fabianospdev.bookslist.model.book.Book

class BooksAdapter (context: Context) :
    RecyclerView.Adapter<BooksAdapter.ViewHolder>() {
    private val mContext: Context = context
    private var mListBooks: MutableList<Book?> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(mContext)
                .inflate(R.layout.item_book, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        val position =  holder.adapterPosition
        val books = mListBooks[position]
        holder.title.text = books?.volumeInfo?.title
        holder.subtitle.text = books?.volumeInfo?.subtitle
        holder.author.text = books?.volumeInfo?.authors.toString()

        holder.itemView.setOnClickListener {
            Toast.makeText(mContext, "Clicado em lista de livros", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return mListBooks.size
    }

    fun update(list: MutableList<Book>) {
        mListBooks.clear()
        mListBooks.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.edtTitle)
        val subtitle = itemView.findViewById<TextView>(R.id.edtSubTitle)
        val author = itemView.findViewById<TextView>(R.id.edtAuthor)
    }

}
