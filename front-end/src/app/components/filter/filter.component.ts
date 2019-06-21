import { Component, EventEmitter, Output, Input } from '@angular/core';
import Filter from 'src/app/models/filter.model';
import { MatIconRegistry } from '@angular/material';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent {
    @Input() filter: Filter;
    @Output() filterChanged: EventEmitter<Filter> = new EventEmitter();

  constructor(iconRegistry: MatIconRegistry, sanitizer: DomSanitizer) {
    iconRegistry.addSvgIcon(
      'search',
      sanitizer.bypassSecurityTrustResourceUrl('assets/baseline-search-24px.svg'));
  }

  public onSearchClicked(): void {
      this.filterChanged.emit(this.filter);
  }
}
