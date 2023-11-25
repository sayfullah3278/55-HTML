import { Component,OnInit } from '@angular/core';
import { ProductModel } from './product.model';
import { FormBuilder, FormGroup } from '@angular/forms';

import { ProductService } from '../services/product.service';
import { error } from 'console';
@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent  implements OnInit{
 productModel: ProductModel=new ProductModel();

 fromValue!: FormGroup;

 productData: any;

constructor(private api: ProductService, private formBuilder: FormBuilder){

}
ngOnInit(): void {
  this.fromValue = this.formBuilder.group({

    productName: [''],
    productPrice: [''],
 

  });
  this.getAllProduct();

}


addProduct() {

  this.productModel.productName = this.fromValue.value.productName;
  this.productModel.productPrice = this.fromValue.value.productPrice;
 

  this.api.saveProduct(this.productModel)
    .subscribe(res => {
      console.log(res);
      alert("Product Saved");
      this.getAllProduct() ;
    },
      err => {
        alert("Product Not save");
      }
    )
}

getAllProduct() {
  this.api.getAllProduct()
    .subscribe(res => {
      this.productData = res

    });

}

deleteProduct(row:any){
  this.api.deleteProduct(row.id)
    .subscribe(res => {
      console.log(res);
      alert("Product Deleted");
      this.getAllProduct() ;
    },
      err => {
        alert("Product Not Delete");
      }
    )

}

onEdite(row: any) {

  this.productModel.id=row.id;
  this.fromValue.controls['productName'].setValue(row.productName);
  this.fromValue.controls['productPrice'].setValue(row.productPrice);


}


updateProduct(){

  this.productModel.productName = this.fromValue.value.productName;
  this.productModel.productPrice = this.fromValue.value.productPrice;


  this.api.editProduct(this.productModel.id, this.productModel)
    .subscribe(res => {
      console.log(res);
      alert("Product Updated");
      this.getAllProduct() ;
    },
      error => {
        alert("Product Not Update");
      }
    )
}



}
