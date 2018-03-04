import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {SelectionModel} from '@angular/cdk/collections';
import {LazyProject} from '../../model/lazy/LazyProject';
import {LazyProjectMock} from '../../mock/LazyProjectMock';
import {ProjectService} from "../../service/project.service";

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css'],
    providers: [ProjectService]
})
export class HomeComponent implements OnInit {

    private isLoadingResults: boolean = false;
    private isLoadingError: boolean = false;

    private projects: LazyProject[] = LazyProjectMock.getData();

    selection: any;
    displayedColumns = ['select', 'label', 'description', 'backlogCount', 'sprintCount', 'actions'];
    dataSource: MatTableDataSource<LazyProject>;

    @ViewChild(MatPaginator) paginator: MatPaginator;
    @ViewChild(MatSort) sort: MatSort;

    constructor(public dialog: MatDialog, private playerService: ProjectService) {
        this.selection = new SelectionModel<Account>(true, []);
        this.dataSource = new MatTableDataSource();
    }

    ngOnInit() {
        this.load();
    }

    load(): void {
        this.playerService.findAll().subscribe(
            next => this.updateDataSource(next, true),
            error => this.updateDataSource(this.projects, true),
            () => this.isLoadingResults = false
        );
    }

    onSelectRow(row: any): void {
        if (this.selection.isSelected(row)) {
            this.selection.deselect(row);
        } else {
            this.selection.select(row);
        }
    }

    deleteDialog(): void {
    }

    deleteSelectedDialog(id: number): void {
        if (id == null) {
            console.warn('action on undefined project identifier');
            return;
        }
        /*
        this.dialog.open(ProjectPopinComponent, {
            data: { project: player }
        });*/
    }

    updateDataSource(dataset: LazyProject[], isFirstLoad: boolean = false): void {
        if (!dataset) {
            console.error('cannot update datasource with empty data');
            return;
        }

        // Reformat some data to be properly displayed
        if (isFirstLoad) {

        }

        this.isLoadingResults = true;

        // re-init selection
        this.selection = new SelectionModel<LazyProject>(true, []);

        // backup filter
        let filterValue = this.dataSource.filter;

        // re-init source
        this.dataSource = new MatTableDataSource();
        this.ngAfterViewInit();
        this.dataSource.data = dataset;
        this.dataSource.paginator.pageIndex = 0;

        // re-apply search filter
        if (filterValue != null) {
            this.dataSource.filter = filterValue;
        }

        setTimeout(() => this.isLoadingResults = false, 300);
    }

    /**
     * Set the paginator and sort after the view init since this component will
     * be able to query its view for the initialized paginator and sort.
     */
    ngAfterViewInit() {
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
    }

    applyFilter(filterValue: string) {
        filterValue = filterValue.trim(); // Remove whitespace
        filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
        this.dataSource.filter = filterValue;
    }

    /** Whether the number of selected elements matches the total number of rows. */
    isAllSelected() {
        const numSelected = this.selection.selected.length;
        const numRows = this.dataSource.data.length;
        return numSelected == numRows;
    }

    /** Selects all rows if they are not all selected; otherwise clear selection. */
    masterToggle() {
        this.isAllSelected() ?
            this.selection.clear() :
            this.dataSource.data.forEach(row => this.selection.select(row));
    }
}
