import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit {

  totalTrades: number = 0;
  totalUsers: number = 0;

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.getTradeCount();
    this.getUserCount();
  }

  getTradeCount(): void {
    this.apiService.getAllTrades().subscribe(
      (data: any) => {
        this.totalTrades = data.length;
      },
      (error: any) => {
        console.error('Error fetching trade count:', error);
      }
    );
  }

  getUserCount(): void {
    this.apiService.getAllUsers().subscribe(
      (data: any) => {
        this.totalUsers = data.length;
      },
      (error: any) => {
        console.error('Error fetching user count:', error);
      }
    );
  }

}
