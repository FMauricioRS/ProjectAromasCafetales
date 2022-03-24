package com.fmauriciors.projectaromascafetales.ui.deleteproduct

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fmauriciors.projectaromascafetales.R
import com.fmauriciors.projectaromascafetales.databinding.FragmentDeleteProductBinding
import com.fmauriciors.projectaromascafetales.local.Product
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DeleteProductFragment : Fragment() {


    private lateinit var deleteproductBinding: FragmentDeleteProductBinding
    private lateinit var deleteProductViewModel: DeleteProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        deleteproductBinding = FragmentDeleteProductBinding.inflate(inflater, container, false)
        deleteProductViewModel = ViewModelProvider(this)[DeleteProductViewModel::class.java]
        return deleteproductBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        deleteProductViewModel.findProductDone.observe(viewLifecycleOwner, { result ->
            onFindProductDoneSubscribe(result)
        })

        with(deleteproductBinding) {
            searchProduct.setOnClickListener {
                deleteProductViewModel.searchProduct(nameSearchEditText.text.toString())
            }
        }
    }

    private fun onFindProductDoneSubscribe(product: Product) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(resources.getString(R.string.warning_title))
            .setMessage(
                resources.getString(
                    R.string.delete_book_msg,
                    product.productName,
                    product.cost
                )
            )
            .setNegativeButton(resources.getString(R.string.cancel)) { dialog, which ->
                // Respond to negative button press
            }
            .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                deleteProductViewModel.deleteProduct(product)
                deleteproductBinding.nameSearchEditText.text?.clear()
            }
            .show()
    }
}
