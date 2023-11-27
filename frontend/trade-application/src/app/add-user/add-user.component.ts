import { Component, OnInit } from '@angular/core';
import { User } from 'src/domain/User';
import { ApiService } from '../services/api.service';
import { ActivatedRoute, Router } from '@angular/router';

interface Dropdown {
    name: string;
    value: string;
}

@Component({
    selector: 'app-add-user',
    templateUrl: './add-user.component.html',
    styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

    user: User = {
        id: 0,
        name: '',
        username: '',
        trades: [],
        stocks: []
    };

    constructor(private apiService: ApiService, private router: Router) { }

    ngOnInit(): void {
    }

    onSubmit(): void {
        this.apiService.addUser(this.user).subscribe(
            (Response) => {
                console.log("User Added Successfully")
                this.router.navigate(['/users']);
            },
            (_Error) => {
                console.log("error")
            }
        )
    }
}
