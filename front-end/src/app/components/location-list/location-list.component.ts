import { Component, ViewChild, Input, Output, EventEmitter } from '@angular/core';
import LocationModel from 'src/app/models/location.model';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog } from '@angular/material';
import { NewLocationComponent } from '../new-location/new-location.component';

@Component({
    selector: 'app-location-list',
    templateUrl: './location-list.component.html',
    styleUrls: ['./location-list.component.css']
})
export class LocationListComponent {
    displayedColumns: string[] = ['id', 'location name', 'latitude', 'longitude'];
    @Input() locations: LocationModel[] = [];

    @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;

    constructor(private dialog: MatDialog) { }
}
