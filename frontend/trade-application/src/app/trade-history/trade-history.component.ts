import { Component, OnInit } from '@angular/core';
import { Trade } from 'src/domain/Trade';
import { ApiService } from '../services/api.service';
import { ActivatedRoute } from '@angular/router';

interface Column {
    field: string;
    header: string;
}

@Component({
    selector: 'app-trade-history',
    templateUrl: './trade-history.component.html',
    styleUrls: ['./trade-history.component.css']
})
export class TradeHistoryComponent implements OnInit {

    trades: Trade[] = [];
    cols!: Column[];

    constructor(private route: ActivatedRoute, private apiService: ApiService) { }

    ngOnInit(): void {

        const userIdString = this.route.snapshot.paramMap.get('id');

        if (userIdString !== null) {
            const userId = +userIdString;
            console.log(userId)
            if (!isNaN(userId)) {
                this.loadTradeHistory(userId);
            } else {
                console.log('Invalid userId');
            }
        } else {
            console.log('userId is null');
        }

        this.cols = [
            { field: 'id', header: 'ID' },
            { field: 'stockTicker', header: 'Stock Ticker' },
            { field: 'stockPrice', header: 'Stock Price' },
            { field: 'volume', header: 'Volume' },
            { field: 'buyOrSell', header: 'Buy or sell' },
            { field: 'statusCode', header: 'Status' },
        ];
    }

    loadTradeHistory(userId: number): void {
        this.apiService.getAllTradesByUser(userId).subscribe(
            (trades) => {
                this.trades = trades;
                
                console.log(this.trades)
            },
            (error) => {
                console.error('Error fetching trades:', error);
            }
        );
    }
}
