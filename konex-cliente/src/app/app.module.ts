import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { FormsModule } from '@angular/forms';

import { MatTableModule} from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { MatPaginatorModule } from '@angular/material/paginator';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    HttpModule, 
    BrowserModule,
    BrowserAnimationsModule, 
    FormsModule, 
    MatTableModule, 
    MatInputModule, 
    MatButtonModule ,
    MatPaginatorModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
