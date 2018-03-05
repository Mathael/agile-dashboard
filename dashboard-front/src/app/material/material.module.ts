import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {
    MatButtonModule,
    MatCardModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatInputModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatPaginatorModule,
    MatSortModule,
    MatRadioModule,
    MatIconModule,
    MatDialogModule,
    MatProgressSpinnerModule,
    MatDividerModule,
    MatSelectModule,
    MatStepperModule,
    MatListModule
} from '@angular/material';
import {CdkTableModule} from '@angular/cdk/table';

@NgModule({
    imports: [
        CommonModule,
        MatTableModule,
        MatTabsModule,
        MatInputModule,
        MatFormFieldModule,
        MatToolbarModule,
        MatCardModule,
        MatButtonModule,
        MatCheckboxModule,
        CdkTableModule,
        MatPaginatorModule,
        MatSortModule,
        MatRadioModule,
        MatIconModule,
        MatDialogModule,
        MatProgressSpinnerModule,
        MatDividerModule,
        MatSelectModule,
        MatStepperModule,
        MatListModule
    ],
    exports: [
        MatTableModule,
        MatTabsModule,
        MatInputModule,
        MatFormFieldModule,
        MatToolbarModule,
        MatCardModule,
        MatButtonModule,
        MatCheckboxModule,
        CdkTableModule,
        MatPaginatorModule,
        MatSortModule,
        MatRadioModule,
        MatIconModule,
        MatDialogModule,
        MatProgressSpinnerModule,
        MatDividerModule,
        MatSelectModule,
        MatStepperModule,
        MatListModule
    ],
    declarations: []
})
export class MaterialModule {}
