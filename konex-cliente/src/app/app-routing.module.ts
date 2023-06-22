import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UrgenciasComponent } from './feature/urgencias/urgencias.component';
import { CrearUrgenciasComponent } from './feature/crear-urgencias/crear-urgencias.component';
import { MostrarFacturaComponent } from './feature/mostrar-factura/mostrar-factura.component';

const routes: Routes = [
  { path: "", component: UrgenciasComponent },
  {
    path: "",
    children: [
      { path: "urgencias", component: UrgenciasComponent },
      { path: "urgencia-form", component: CrearUrgenciasComponent },
      { path: "factura/:id", component: MostrarFacturaComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
