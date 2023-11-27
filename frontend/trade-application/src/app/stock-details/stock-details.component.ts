import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../services/api.service';
import { User } from 'src/domain/User';
import { StockDetails } from 'src/domain/StockDetails';

@Component({
  selector: 'app-stock-details',
  templateUrl: './stock-details.component.html',
  styleUrls: ['./stock-details.component.css']
})
export class StockDetailsComponent implements OnInit {

  user!: User;
  stockDetail!: StockDetails;

  data: any;
  second_data: any;
  options: any;

  constructor(
    private route: ActivatedRoute,
    private apiService: ApiService,
    private router: Router,
  ) { }

  ngOnInit(): void {

    const userIdString = this.route.snapshot.paramMap.get('id');
    const ticker = this.route.snapshot.paramMap.get('stock');

    const documentStyle = getComputedStyle(document.documentElement);
    const textColor = documentStyle.getPropertyValue('--text-color');
    const textColorSecondary = documentStyle.getPropertyValue('--text-color-secondary');
    const surfaceBorder = documentStyle.getPropertyValue('--surface-border');

    this.options = {
      maintainAspectRatio: false,
      aspectRatio: 0.6,
      plugins: {
        legend: {
          labels: {
            color: textColor
          }
        }
      },
      scales: {
        x: {
          ticks: {
            color: textColorSecondary
          },
          grid: {
            color: surfaceBorder,
            drawBorder: false
          }
        },
        y: {
          ticks: {
            color: textColorSecondary
          },
          grid: {
            color: surfaceBorder,
            drawBorder: false
          }
        }
      }
    };

    if (userIdString !== null) {
      const userId = +userIdString;
      if (!isNaN(userId)) {
        this.apiService.getUserById(userId).subscribe((user) => {
          this.user = user;
        });

        this.apiService.getStockDetails(ticker).subscribe((stock) => {
          this.stockDetail = stock;
          console.log(this.stockDetail);

          this.data = {
            labels: this.stockDetail.values.map((value: any) => value.datetime),
            datasets: [
              {
                label: 'Open',
                data: this.stockDetail.values.map((value: any) => value.open),
                fill: false,
                borderColor: documentStyle.getPropertyValue('--green-800'),
                tension: 0.4
              },
              {
                label: 'Close',
                data: this.stockDetail.values.map((value: any) => value.close),
                fill: false,
                borderColor: documentStyle.getPropertyValue('--red-900'),
                tension: 0.4
              }
            ]
          };

          this.second_data = {
            labels: this.stockDetail.values.map((value: any) => value.datetime),
            datasets: [
              {
                label: 'High',
                data: this.stockDetail.values.map((value: any) => value.high),
                fill: false,
                borderColor: documentStyle.getPropertyValue('--green-600'),
                tension: 0.4
              },
              {
                label: 'Low',
                data: this.stockDetail.values.map((value: any) => value.low),
                fill: false,
                borderColor: documentStyle.getPropertyValue('--red-600'),
                tension: 0.4
              }
            ]
          };
        });

      } else {
        console.log('Invalid userId');
      }
    } else {
      console.log('userId is null');
    }
    console.log(userIdString, ticker)
  }

}
