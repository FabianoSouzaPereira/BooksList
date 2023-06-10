package br.com.fabianospdev.bookslist.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.fabianospdev.bookslist.R
import br.com.fabianospdev.bookslist.model.book.Book
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.fabianospdev.imageprocessing.converter.converter.ImageProcessorImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.io.File

class BooksAdapter(context: Context) :
    RecyclerView.Adapter<BooksAdapter.ViewHolder>() {
    private val mContext: Context = context
    private var mListBooks: MutableList<Book> = arrayListOf()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(mContext)
                .inflate(R.layout.item_book, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        val position = holder.adapterPosition
        val books = mListBooks[position]
        holder.title.text = books.volumeInfo?.title
        holder.subtitle.text = books.volumeInfo?.subtitle
        holder.author.text = books.volumeInfo?.authors.toString()

        holder.itemView.setOnClickListener {
            Toast.makeText(mContext, "Clicado em lista de livros", Toast.LENGTH_SHORT).show()
        }

        Glide.with(mContext)
            .downloadOnly()
            .load(books.volumeInfo?.imageLinks?.thumbnail)
            .into(object : CustomTarget<File>() {
                override fun onResourceReady(resource: File, transition: Transition<in File>?) {
                    val bitmap = ImageProcessorImpl().imageCompressor(mContext, resource)
                    holder.imageView.setImageBitmap(bitmap)
                }

                override fun onLoadFailed(errorDrawable: Drawable?) {
                    ImageProcessorImpl().imageDownloadTask(
                        mContext,
                        holder.imageView,
                        books.volumeInfo?.imageLinks?.thumbnail ?: ""
                    )
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                }
            })
    }

    override fun getItemCount(): Int {
        return mListBooks.size
    }

    fun update(list: List<Book>) {
        mListBooks.clear()
        mListBooks.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById<TextView>(R.id.edtTitle)
        val subtitle: TextView = itemView.findViewById<TextView>(R.id.edtSubTitle)
        val author: TextView = itemView.findViewById<TextView>(R.id.edtAuthor)
        val imageView: ImageView = itemView.findViewById(R.id.imgBook)
    }
}