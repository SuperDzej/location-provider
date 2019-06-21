import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { MatProgressSpinnerModule, MatTableModule, MatPaginatorModule, MatButtonModule,
    MatFormFieldModule, MatDialogModule, MatInputModule, MatIconModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { LocationListComponent } from './components/location-list/location-list.component';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { NewLocationComponent } from './components/new-location/new-location.component';
import LocationsService from './services/locations.service';
import { HttpClientModule } from '@angular/common/http';
import { FilterComponent } from './components/filter/filter.component';
import { FormsModule } from '@angular/forms';
import { HomePage } from './containers/home-page/home-page.component';

@NgModule({
    declarations: [
        AppComponent,
        HomePage,
        NewLocationComponent,
        LocationListComponent,
        FilterComponent
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        HttpClientModule,
        MatProgressSpinnerModule,
        MatTableModule,
        MatPaginatorModule,
        MatButtonModule,
        MatFormFieldModule,
        MatDialogModule,
        MatIconModule,
        FormsModule,
        MatInputModule
    ],
    providers: [LocationsService],
    bootstrap: [AppComponent],
    entryComponents: [NewLocationComponent]
})
export class AppModule { }
