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
    MatListModule,
    MatGridListModule
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
        MatListModule,
        MatGridListModule
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
        MatListModule,
        MatGridListModule
    ],
    declarations: []
})
export class MaterialModule {}
