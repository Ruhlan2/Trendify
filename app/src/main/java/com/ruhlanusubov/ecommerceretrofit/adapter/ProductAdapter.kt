package com.ruhlanusubov.ecommerceretrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ruhlanusubov.ecommerceretrofit.databinding.ProductItemsBinding
import com.ruhlanusubov.ecommerceretrofit.model.ProductResponseItem
import com.ruhlanusubov.ecommerceretrofit.ui.bottom_navigation.home.HomeFragmentDirections

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    private val productlist = ArrayList<ProductResponseItem>()

    inner class ProductHolder(val binding: ProductItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val layout = ProductItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductHolder(layout)
    }

    override fun getItemCount(): Int {
        return productlist.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val item = productlist[position]
        holder.binding.productname.text = item.title
        holder.binding.productprice.text = "${item.price} $"
        Glide.with(holder.itemView.context).load(item.image).into(holder.binding.productimg)

        holder.binding.productcard.setOnClickListener{

             it.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item))


        }
    }

    fun updatelist(list: List<ProductResponseItem>) {
        productlist.clear()
        productlist.addAll(list)
        notifyDataSetChanged()
    }
}