import { Component, OnInit, ViewChild } from '@angular/core';
import { Urgencia } from '../../shared/interfaces/urgencia';
import { TranslateService } from '@ngx-translate/core';
import { Router } from '@angular/router';
import { RestService } from 'src/app/core/services/rest.service';
import { MatTable } from '@angular/material/table';




@Component({
  selector: 'app-urgencias',
  templateUrl: './urgencias.component.html',
  styleUrls: ['./urgencias.component.scss']
})
export class UrgenciasComponent implements OnInit {

  public urgencias: Urgencia[] = [];
  articuloSeleccionado: Urgencia;


  @ViewChild(MatTable) tablaArticulos!: MatTable<Urgencia>;

  public page: number = 1;
  public pageSize: number = 4;
  public collectionSize: number = this.urgencias.length;

  constructor(private service: RestService, public translate: TranslateService, private router: Router) { }

  ngOnInit() {
    this.getUrgencias();
  }

  private getUrgencias() {
    let url = `/api/urgencias/obtener-urgencias`;
    this.service.queryExternalApi(url).subscribe(
      response => {
        let result = response.json();
        if (result) {
          this.urgencias = result;
        } else {
          console.log('error');
        }
      },
      err => {
        console.log(err);
      }
    );

  }

  operar(urgencia: Urgencia) {
    urgencia.fechaCirugia = new Date();
    this.actualizar(urgencia, "alerts.registrar_operacion");
  }

  hospitalizar(urgencia: Urgencia) {
    urgencia.fechaHospitalizacion = new Date();
    this.actualizar(urgencia, "alerts.registrar_hospitalizacion");
  }

  actualizar(urgencia: Urgencia, alerta: string) {
    let url = `/api/urgencias/agregar-urgencia`;

    let data = {
      "eps": urgencia.eps,
      "fechaHospitalizacion": urgencia.fechaHospitalizacion,
      "fechaIngreso": urgencia.fechaIngreso,
      "idPaciente": urgencia.idPaciente,
      "nombrePersona": urgencia.nombrePersona,
      "fechaCirugia": urgencia.fechaCirugia
    }
    let body = JSON.stringify(data);
    this.service.queryPost(url, body)
      .subscribe(data => {
        let result = data;
        if (result) {
          swal({
            title: this.translate.instant("alerts.success"),
            text: this.translate.instant(alerta),
            type: "success",
            showCancelButton: false,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: this.translate.instant("buttons.ok"),
          });
          this.getUrgencias();
        } else {
          swal({
            title: this.translate.instant("alerts.error"),
            text: this.translate.instant("alerts.cannot_delete_urgencia"),
            type: "error",
            showCancelButton: false,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: this.translate.instant("buttons.ok"),
          });
          return false;
        }
      }, err => {
        console.log(err);
      });
  }

  cambiar(valor: Date): string {
    var cadena: string;
    if (valor !== null) {
      cadena = "Si";
    } else {
      cadena = "No";
    }
    return cadena;
  }

  confirmDelete(idPaciente) {
    swal({
      title: this.translate.instant("alerts.confirm"),
      text: this.translate.instant("alerts.sure_to_delete"),
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: this.translate.instant("buttons.yes"),
    });
    this.eliminarUrgencia(idPaciente);
  }


  private eliminarUrgencia(idPaciente) {
    let url = `/api/urgencias/eliminar-urgencia/${idPaciente}`;
    this.service.queryDeleteRegular(url).subscribe(
      response => {
        let result = response;
        if (result) {
          this.getUrgencias();
          swal({
            title: this.translate.instant("alerts.success"),
            text: this.translate.instant("alerts.deleted_urgencia"),
            type: "success",
            showCancelButton: false,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: this.translate.instant("buttons.ok"),
          });
          return false;
        } else {
          swal({
            title: this.translate.instant("alerts.error"),
            text: this.translate.instant("alerts.urgencia_doesnt_exist"),
            type: "error",
            showCancelButton: false,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: this.translate.instant("buttons.ok"),
          });
          return false;
        }
      },
      err => {
        console.log(err);
      }
    );
  }

  confirmFacturar(idPaciente) {
    swal({
      title: this.translate.instant("alerts.confirm"),
      text: this.translate.instant("alerts.sure_to_facturar"),
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: this.translate.instant("buttons.yes"),
    });
    this.router.navigate(["/factura/" + idPaciente]);
  }

}
function swal(arg0: { title: any; text: any; type: string; showCancelButton: boolean; confirmButtonColor: string; cancelButtonColor: string; confirmButtonText: any; }) {
  throw new Error('Function not implemented.');
}

