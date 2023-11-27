import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { TableModule} from 'primeng/table';
import { AvatarModule } from 'primeng/avatar';
import { AvatarGroupModule } from 'primeng/avatargroup';
import { InputTextModule } from 'primeng/inputtext';
import { ChartModule } from 'primeng/chart';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TradeListComponent } from './trade-list/trade-list.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AddUsertradeComponent } from './add-usertrade/add-usertrade.component';
import { TradeHistoryComponent } from './trade-history/trade-history.component';
import { AddUserComponent } from './add-user/add-user.component';
import { StockDetailsComponent } from './stock-details/stock-details.component';


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    TradeListComponent,
    UserListComponent,
    UserProfileComponent,
    AddUsertradeComponent,
    TradeHistoryComponent,
    AddUserComponent,
    StockDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CardModule,
    ButtonModule,
    TableModule,
    AvatarModule,
    AvatarGroupModule,
    InputTextModule,
    ChartModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
