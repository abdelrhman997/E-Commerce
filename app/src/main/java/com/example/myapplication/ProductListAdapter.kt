package com.example.myapplication
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.model.Product

class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {
    var products = mutableListOf<Product>()
    fun setProductsList(products: List<Product>) {
        this.products = products.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val ItemsViewModel = products[position]
        holder.bind(ItemsViewModel)
    }


    override fun getItemCount()= products.size

    class ProductViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView), View.OnClickListener {
        init {
            ItemView.setOnClickListener(this)
        }
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val qtv:TextView= itemView.findViewById(R.id.qTV)
        val tpTV:TextView= itemView.findViewById(R.id.tpTV)
        val statusTV:TextView= itemView.findViewById(R.id.statusTV)

        override fun onClick(v: View) {

//          val a=  Fragment1Directions.actionFragment1ToProductDetailsFragment(textView.text.toString())
//            v.findNavController().navigate(a)
        }


         fun bind(itemsViewModel: Product) {
             textView.text = itemsViewModel.title
             tpTV.text = itemsViewModel.price.toString()
             qtv.text=itemsViewModel.rating!!.count.toString()
             statusTV.text=itemsViewModel.rating!!.rate.toString()
             Glide.with(imageView.context).load(itemsViewModel.image).into(imageView)
        }

        companion object {
            fun from(parent: ViewGroup): ProductViewHolder {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.order_list_item, parent, false)
                return ProductViewHolder(view)
            }
        }
    }


}
