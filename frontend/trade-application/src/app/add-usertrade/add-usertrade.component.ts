import { Component, OnInit } from '@angular/core';
import { Trade } from 'src/domain/Trade';
import { ApiService } from '../services/api.service';
import { ActivatedRoute, Router } from '@angular/router';
import { StockData } from 'src/domain/StockData';

interface Dropdown {
  name: string;
  value: string;
}

@Component({
  selector: 'app-add-usertrade',
  templateUrl: './add-usertrade.component.html',
  styleUrls: ['./add-usertrade.component.css']
})
export class AddUsertradeComponent implements OnInit {

  trade: Trade = {
    id: 0,
    stockTicker: '',
    stockPrice: 0,
    volume: 0,
    buyOrSell: 'BUY',
    statusCode: 0
  };

  userIdString: string | null = '';

  types: Dropdown[] = [];
  selectedType!: Dropdown;

  status: Dropdown[] = [];
  selectedStatus!: Dropdown;

  stockData: StockData | undefined;

  constructor(private apiService: ApiService, private route: ActivatedRoute, private router: Router,) { }

  ngOnInit(): void {
    this.userIdString = this.route.snapshot.paramMap.get('id');

    this.types = [
      { name: 'BUY', value: 'BUY' },
      { name: 'SELL', value: 'SELL' },
    ];
  }

  onStockTickerChange(event: any) {
    this.apiService.getMarket(event.target.value.toLowerCase()).subscribe(data => {
      this.trade.stockPrice = data[0].price;
    })
  }

  onSubmit() {

    if (this.userIdString !== null) {
      const userId = +this.userIdString;
      this.apiService.addTradeByUser(userId, this.trade).subscribe(
        (Response) => {
          console.log("Trade Added Successfully")

          // Reset the form after submission
          this.trade = {
            id: 0,
            stockTicker: '',
            stockPrice: 0,
            volume: 0,
            buyOrSell: 'BUY',
            statusCode: 0
          };

          this.router.navigate(['/users', userId]);
        },
        (_Error) => {
          console.log("error")
        }
      )
    }
  }
}
