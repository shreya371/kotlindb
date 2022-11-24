package com.axis.service

import com.axis.model.Product
import com.axis.util.ProductUtil

class ProductService {
    var productUtil=ProductUtil()

    fun insertProduct(){
        var res =productUtil.insert()
        println(res)
    }

    fun displayAllProducts(){
        productUtil.selectAllProducts()
    }

    fun insertUserProduct(product:Product){
        productUtil.insertUserInput(product)
    }


}