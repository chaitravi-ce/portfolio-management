import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-add-trades',
  templateUrl: './add-trades.component.html',
  styleUrls: ['./add-trades.component.css']
})
export class AddTradesComponent implements OnInit {

  

    addtradesForm = new FormGroup(
      {
        stockTicker: new FormControl(''),
        stockPrice: new FormControl(''),
        volume: new FormControl(''),
        buyOrSell: new FormControl(''),
        statusCode: new FormControl('')
      }
    );
    
    handleSubmit() {
      console.log(this.addtradesForm.value);
    }
    
    
    
    

  constructor() { }

  ngOnInit(): void {
  }

}
