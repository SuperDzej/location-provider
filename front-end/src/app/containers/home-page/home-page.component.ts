import { Component, ViewChild, AfterViewInit } from '@angular/core';
import LocationModel from 'src/app/models/location.model';
import LocationsService from 'src/app/services/locations.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog } from '@angular/material';
import { NewLocationComponent } from 'src/app/components/new-location/new-location.component';
import Filter from 'src/app/models/filter.model';
import { environment } from 'src/environments/environment';

@Component({
    selector: 'app-home-page',
    templateUrl: './home-page.component.html',
    styleUrls: ['./home-page.component.css']
})
export class HomePage implements AfterViewInit {
    locations: LocationModel[] = [];
    filter: Filter = new Filter();

    isLoadingResults = true;
    @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;

    constructor(private locationsService: LocationsService, private dialog: MatDialog) { }

    ngAfterViewInit() {
        this.refreshList();
    }

    public addNew(): void {
        const dialogRef = this.dialog.open(NewLocationComponent, {
            width: `${environment.dialogWidth}px`
        });

        dialogRef.afterClosed().subscribe(result => {
            if (!result) {
                return;
            }
            this.locationsService.create(result)
                .subscribe(() => {
                this.refreshList();
            });
        });
    }

    public onFilterChange(): void {
        this.refreshList();
    }

    private refreshList(): void {
        this.isLoadingResults = true;
        if (this.filter.addressId) {
            this.locationsService.getByFilter(this.filter)
                .subscribe(this.refreshSuccess, this.refresError);
        } else {
            this.locationsService.get()
                .subscribe(this.refreshSuccess, this.refresError);
        }
    }

    private refreshSuccess = (data) => {
        this.locations = data;
        this.isLoadingResults = false;
    }

    private refresError = () => {
        this.isLoadingResults = false;
    }

}
