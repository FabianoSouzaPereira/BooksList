package br.com.fabianospdev.bookslist.adapters

import android.content.Context
import android.graphics.Bitmap
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
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.fabianospdev.imageprocessing.converter.ImageProcessor

class BooksAdapter(context: Context) :
    RecyclerView.Adapter<BooksAdapter.ViewHolder>() {
    private val mContext: Context = context
    private var mListBooks: MutableList<Book> = arrayListOf()

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
            .asBitmap()
            .load(books.volumeInfo?.imageLinks ?: R.drawable.outline_highlight_off_black_48)
            .apply(
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop().format(DecodeFormat.DEFAULT)
                    .error(R.drawable.outline_error_outline_black_48)
            )
            .listener(object : RequestListener<Bitmap> {
                override fun onLoadFailed(
                    p0: GlideException?,
                    p1: Any?,
                    p2: Target<Bitmap>?,
                    p3: Boolean
                ): Boolean {
                    //  holder.progress.visibility = View.GONE
                    return true
                }

                override fun onResourceReady(
                    resource: Bitmap?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    dataSource: DataSource?,
                    p3: Boolean
                ): Boolean {
                    val image = object: ImageProcessor {
                        override fun imageCompressor(image: String): Bitmap? {
                            return super.imageCompressor(image)
                        }
                    }
                    return false
                }
            }).into(holder.imageView)

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
