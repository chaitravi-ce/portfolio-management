import { Component, OnInit } from '@angular/core';
import { Trade } from 'src/domain/Trade';
import { ApiService } from '../services/api.service';

interface Column {
  field: string;
  header: string;
}

@Component({
  selector: 'app-trade-list',
  templateUrl: './trade-list.component.html',
  styleUrls: ['./trade-list.component.css']
})
export class TradeListComponent implements OnInit {

  trades: Trade[] = [];
  cols!: Column[];

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.loadTrades();

    this.cols = [
      { field: 'id', header: 'ID' },
      { field: 'stockTicker', header: 'Stock Ticker' },
      { field: 'stockPrice', header: 'Stock Price' },
      { field: 'volume', header: 'Volume' },
      { field: 'buyOrSell', header: 'Buy or sell' },
      { field: 'statusCode', header: 'Status' },
    ];
  }

  loadTrades(): void {
    this.apiService.getAllTrades().subscribe(
      (trades) => {
        this.trades = trades;
      },
      (error) => {
        console.error('Error fetching trades:', error);
      }
    );
  }
}
