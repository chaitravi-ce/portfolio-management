import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/domain/User';
import { ApiService } from '../services/api.service';
import { MenuItem, PrimeIcons } from 'primeng/api';

interface Column {
  field: string;
  header: string;
}

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  user!: User;
  cols!: Column[];
  items: MenuItem[] = [];
  stockData: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private apiService: ApiService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    const userIdString = this.route.snapshot.paramMap.get('id');
    if (userIdString !== null) {
      const userId = +userIdString;
      if (!isNaN(userId)) {
        this.apiService.getUserById(userId).subscribe((user) => {
          this.user = user;
        });
      } else {
        console.log('Invalid userId');
      }
    } else {
      console.log('userId is null');
    }

    this.cols = [
      { field: 'id', header: 'ID' },
      { field: 'stockTicker', header: 'Stock Name' },
      { field: 'stockPrice', header: 'Stock Price ($)' },
      { field: 'volume', header: 'Volume' },
      { field: 'value', header: 'Value' }
    ];

  }

  navigateToAddTrade(userId: number): void {
    this.router.navigate(['/users', userId, 'add-trade']);
  }

  navigateToTradeHistory(userId: number): void {
    this.router.navigate(['/users', userId, 'trade-history']);
  }

  navigateToStockProfile(userId: number, ticker: string): void {
    this.router.navigate(['/users', userId, 'stock-details', ticker]);
  }
}
