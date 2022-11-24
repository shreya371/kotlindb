package com.axis.app

import com.axis.model.Product
import com.axis.service.ProductService
import java.util.*

fun main(){
    var productService=ProductService()



    var sc  = Scanner(System.`in`)
    println("enter id")
    var productId:Int=sc.nextInt()
    println("enter product name")
    var productName:String=sc.next()
    println("enter product price")
    var productPrice:Double=sc.nextDouble()
    println("enter product quantity")
    var productQuantity:Int =sc.nextInt()

    var product= Product(productId,productName,productPrice,productQuantity)

    // productService.insertProduct()

    productService.insertUserProduct(product)


    productService.displayAllProducts()



}