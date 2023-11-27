import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CommonModule } from '@angular/common';
import { TradeListComponent } from './trade-list/trade-list.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AddUsertradeComponent } from './add-usertrade/add-usertrade.component';
import { TradeHistoryComponent } from './trade-history/trade-history.component';
import { AddUserComponent } from './add-user/add-user.component';
import { StockDetailsComponent } from './stock-details/stock-details.component';

const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'trades', component: TradeListComponent},
  { path: 'users', component: UserListComponent},
  { path: 'users/:id', component: UserProfileComponent },
  { path: 'users/:id/add-trade', component: AddUsertradeComponent },
  { path: 'users/:id/trade-history', component: TradeHistoryComponent },
  { path: 'add-user', component: AddUserComponent},
  { path: 'users/:id/stock-details/:stock', component: StockDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), CommonModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
