import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { PricelistComponent } from './components/pricelist/pricelist.component';
import { PriceformComponent } from './components/priceform/priceform.component';
import { FormsModule } from '@angular/forms';
import { CategorylistComponent } from './components/categorylist/categorylist.component';
import { CategoryformComponent } from './components/categoryform/categoryform.component';
import { ProductformComponent } from './components/productform/productform.component';
import { ProductlistComponent } from './components/productlist/productlist.component';
import { StocklistComponent } from './components/stocklist/stocklist.component';
import { StockformComponent } from './components/stockform/stockform.component';
import { InvoicelistComponent } from './components/invoicelist/invoicelist.component';
import { InvoiceformComponent } from './components/invoiceform/invoiceform.component';

const rules:Routes=[{path:'',component:WelcomeComponent},
{path:'pricings',component:PricelistComponent},
{path:'priceform',component:PriceformComponent},
{path:'updatePrice/:pricing_id',component:PriceformComponent},

{path:'categories',component:CategorylistComponent},
{path:'categoryform',component:CategoryformComponent},
{path:'updateCategory/:category_id',component:CategoryformComponent},

{path:'products',component:ProductlistComponent},
{path:'productform',component:ProductformComponent},
{path:'updateProduct/:productid',component:ProductformComponent},

{path:'stocks',component:StocklistComponent},
{path:'stockform',component:StockformComponent},
{path:'updateStock/:ref_id',component:StockformComponent},

{path:'invoices',component:InvoicelistComponent},
{path:'invoiceform',component:InvoiceformComponent},
{path:'updateInvoice/:invoice_id',component:InvoiceformComponent}

]


@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
   PriceformComponent,
    PricelistComponent,
    CategorylistComponent,
    CategoryformComponent,
    ProductformComponent,
    ProductlistComponent,
    StocklistComponent,
    StockformComponent,
    InvoicelistComponent,
    InvoiceformComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(rules),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
