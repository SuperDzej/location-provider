import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import Filter from '../models/filter.model';
import LocationModel from '../models/location.model';
import { environment } from 'src/environments/environment';

@Injectable()
export default class LocationsService {
    private apiUrl = environment.apiUrl;

    // tslint:disable-next-line:variable-name
    constructor(private _http: HttpClient) { }

    public get(): Observable<LocationModel[]> {
        return this._http.get<LocationModel[]>(`${this.apiUrl}/locations`);
    }

    public getById(id: string): Observable<LocationModel> {
        return this._http.get<LocationModel>(`${this.apiUrl}/locations/${id}`);
    }

    public getByFilter(filter: Filter): Observable<LocationModel[]> {
        return this._http.get<LocationModel[]>(`${this.apiUrl}/locations/filter?radius=${filter.radius}&addressId=${filter.addressId}`);
    }

    public create(location: LocationModel): Observable<LocationModel> {
        return this._http.post<LocationModel>(`${this.apiUrl}/locations`, location);
    }

    public update(id: string, location: LocationModel): void {
        this._http.put<LocationModel>(`${this.apiUrl}/locations/${id}`, location);
    }
}
