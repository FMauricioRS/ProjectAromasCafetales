package com.fmauriciors.projectaromascafetales.ui.listproducts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fmauriciors.projectaromascafetales.R
import com.fmauriciors.projectaromascafetales.databinding.CardViewItemProductBinding
import com.fmauriciors.projectaromascafetales.local.Product
import java.util.ArrayList

class ProductsAdapter (
    private val productsList: ArrayList <Product>

    ): RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>(){


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_product, parent, false)
            return ProductViewHolder(view)
        }

        override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
            val product = productsList[position]
            holder.bind(product)
        }

        override fun getItemCount(): Int = productsList.size

        fun appendItems(newList: ArrayList<Product>) {
            productsList.clear()
            productsList.addAll(newList)
            notifyDataSetChanged()
        }

        class ProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            private val binding = CardViewItemProductBinding.bind(itemView)
            fun bind(product: Product) {
                with(binding){
                    nameCardProductTextView.text = product.productName
                    nameCardCostoTextView.text = product.cost
                   // nameCardResumeTextView.text = product.resumePlantation

                }
            }
        }
    }
