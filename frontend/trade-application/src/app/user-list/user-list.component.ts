import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/domain/User';
import { ApiService } from '../services/api.service';

interface Column {
  field: string;
  header: string;
}

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[] = [];

  cols!: Column[];

  constructor(private router: Router, private apiService: ApiService) { }

  ngOnInit(): void {
    this.loadUsers();

    this.cols = [
      { field: 'id', header: 'ID' },
      { field: 'name', header: 'Name' },
      { field: 'username', header: 'User Name' },
      { field: 'trades', header: 'Total Trades' }
    ];
  }

  loadUsers(): void {
    this.apiService.getAllUsers().subscribe(
      (users: User[]) => this.users = users,
      error => console.error('Error fetching users:', error)
    );
  }

  

  navigateToUserProfile(userId: number): void {
    this.router.navigate(['/users', userId]);
  }
}
