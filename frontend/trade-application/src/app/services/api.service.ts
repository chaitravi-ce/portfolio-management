import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, retry, throwError } from 'rxjs';
import { Trade } from 'src/domain/Trade';
import { User } from 'src/domain/User';
import { StockDetails } from 'src/domain/StockDetails';
import { StockData } from 'src/domain/StockData';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private apiUrl = 'http://localhost:8080';

  private baseUrl = 'https://api.twelvedata.com/time_series';
  private apiKey = 'bd3443cb01f54413a1c41f468e6555d9';

  private marketApi = 'https://marketdata.multicode.uk/API/StockFeed/GetStockPricesForSymbol';

  constructor(private http: HttpClient) { }

  getAllTrades(): Observable<Trade[]> {
    return this.http.get<Trade[]>(`${this.apiUrl}/trades`)
      .pipe(
        retry(3),
        catchError(this.handleError),
      );
  }

  getStockDetails(symbol: string | null): Observable<StockDetails>{
    const interval = '1day'
    const url = `${this.baseUrl}?symbol=${symbol}&interval=${interval}&apikey=${this.apiKey}`;    
    
    return this.http.get<StockDetails>(url);
  }

  getMarket(symbol: string | null): Observable<StockData[]>{
    const url = `${this.marketApi}/${symbol}`; 
    return this.http.get<StockData[]>(url);
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiUrl}/users`)
      .pipe(
        retry(3),
        catchError(this.handleError),
      );
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${this.apiUrl}/users/${id}`)
      .pipe(
        retry(3),
        catchError(this.handleError),
      );
  }

  getAllTradesByUser(id: number): Observable<Trade[]> {
    return this.http.get<Trade[]>(`${this.apiUrl}/users/${id}/trades`)
      .pipe(
        retry(3),
        catchError(this.handleError),
      );
  }

  addTradeByUser(id: number, trade: Trade): Observable<Trade[]> {
    return this.http.post<Trade[]>(`${this.apiUrl}/users/add-trades/${id}`, trade)
      .pipe(
        retry(3),
        catchError(this.handleError),
      );
  }

  addUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.apiUrl}/users`, user)
      .pipe(
        retry(3),
        catchError(this.handleError),
      );
  }

  updateUser(user: User): Observable<User> {
    return this.http.put<User>(`${this.apiUrl}/users/${user.id}`, user)
      .pipe(
        retry(3),
        catchError(this.handleError),
      );
  }

  deleteUser(userId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/users/${userId}`)
      .pipe(
        retry(3),
        catchError(this.handleError),
      );
  }


  private handleError(error: HttpErrorResponse) {
    console.error("An error occurred:", error.error);
    return throwError(() => new Error("Please try again later."));
  }
}
