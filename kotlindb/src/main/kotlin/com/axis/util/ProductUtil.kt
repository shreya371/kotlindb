package com.axis.util

import com.axis.app.DbConnection
import com.axis.model.Product
import java.util.*

class ProductUtil {

    var dbConnection= DbConnection()
    var connection=dbConnection.connect()

    var products= mutableListOf<Product>()


    fun insert():String{

        val stmt =connection.createStatement()
        val res = stmt.executeUpdate("insert into product values(104,'fridge',20000.0,2)")
        if (res > 0) {
            return "successfully inserted record into users db !!!"
        } else {
            return "Insert Not successful"
        }

    }

    fun selectAllProducts(){
        val query = connection.prepareStatement("select * from product")
        val result = query.executeQuery()


        while(result.next()){
            val productId = result.getInt("productId")
            val productName= result.getString("productName")
            val productPrice= result.getDouble("productPrice")
            val productQuantity= result.getInt("productQuantity")
            products.add(Product(productId,productName,productPrice,productQuantity))
        }
        for(product in products) {
            println(product)
        }

    }

    /*fun update():String{
        val update_res = connection.createStatement().executeUpdate("update userdb set name = 'shreya' where id = 2")
        if( update_res > 0){
            println("successfully updated record in users db !!!")
            return "$update_res updated"
        } else{
            return "Update Not successful"
        }
    }*/

    fun insertUserInput(product:Product){

        val prepareStmt=connection.prepareStatement("insert into product values(?,?,?,?)")
        prepareStmt.setInt(1,product.productId)
        prepareStmt.setString(2,product.productName)
        prepareStmt.setDouble(3,product.productPrice)
        prepareStmt.setInt(4,product.productQuantity)
        val result = prepareStmt.executeUpdate()

        if (result>0){
            println("inserted")
        }
        else{
            println("not inserted")
        }
    }


}