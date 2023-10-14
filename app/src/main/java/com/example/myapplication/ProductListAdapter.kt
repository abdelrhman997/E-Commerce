package com.example.myapplication
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Data.ProductModel

class ProductListAdapter(private val mList: List<ProductModel>) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.bind(ItemsViewModel)
    }


    override fun getItemCount()= mList.size

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView), View.OnClickListener {
        init {
            ItemView.setOnClickListener(this)
        }
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        override fun onClick(v: View) {

//          val a=  Fragment1Directions.actionFragment1ToProductDetailsFragment(textView.text.toString())
//            v.findNavController().navigate(a)
        }


         fun bind(ItemsViewModel: ProductModel) {
             imageView.setImageResource(ItemsViewModel.img)
             textView.text = ItemsViewModel.name
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.order_list_item, parent, false)
                return ViewHolder(view)
            }
        }
    }


}
