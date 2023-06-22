import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { Medicamento } from './models/articulo';
import { RestService } from './services/rest.service';
import { Venta } from './models/venta';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private service: RestService) { }

  ngOnInit() {
    this.getMedicamentos();
  }

  columnas: string[] = ['nombreMedicamento', 'laboratorio', 'fechaFabricacion', 'fechaVencimiento', 'cantidad', 'valor', 'eliminar', 'editar', 'vender'];

  columnasVentas: string[] = ['nombreMedicamento', 'fecha', 'cantidad', 'valor', 'valorTotal'];

  datos: Medicamento[] = [];

  dataSource: any;

  datosVentas: Venta[] = [];

  formVenta: boolean= false;

  formEditar: boolean= false;

  formMedicamento: boolean= false;

  tableVentas: boolean = false;

  fechaInicial: any;

  fechaFinal: any;

  medicamentoNuevo: Medicamento = new Medicamento(0, '', '', new Date, new Date, 0,0);
  medicamentoEditar: Medicamento = new Medicamento(0, '', '', new Date, new Date, 0,0);

  nuevaVenta: Venta = new Venta('', new Date, 0,0,0);


  @ViewChild(MatTable) tablaArticulos!: MatTable<Medicamento>;
  @ViewChild(MatPaginator, { static: true }) paginador!: MatPaginator;


  changeDates(event: any) {
    if(this.fechaInicial && this.fechaFinal && this.fechaFinal > this.fechaInicial){
      this.getVentas();
      this.tableVentas=true;
    }
  }

  eliminarMedicamento(idMedicamento: number) {
    if (confirm('¿Realmente quiere eliminar este medicamento?')) {
      let url = `/api/medicamentos/eliminar-medicamento/${idMedicamento}`;
      this.service.queryDelete(url).subscribe(
        response => {
          let result = response;
          this.getMedicamentos();
        },
        err => {
          console.log(err);
        }
      );
    }
  }

  venderMedicamento(nombreMedicamento: string, valor: number){
    this.formVenta=true;
    this.nuevaVenta.nombreMedicamento=nombreMedicamento;
    this.nuevaVenta.valor=valor;
  }

  crearMedicamento(){
    this.formMedicamento=true;
  }

  private getMedicamentos() {
    let url = `/api/medicamentos/obtener-medicamentos`;
    this.service.queryExternalApi(url).subscribe(
      response => {
        let result = response.json();
        if (result) {
          this.datos = result;
          this.dataSource = new MatTableDataSource<Medicamento>(this.datos);
          this.dataSource.paginator = this.paginador;          
        } else {
          console.log('error');
        }
      },
      err => {
        console.log(err);
      }
    );
  }

  private getVentas() {
    let url = `/api/ventas/obtener-ventas/${this.fechaInicial}/${this.fechaFinal}`;
    this.service.queryExternalApi(url).subscribe(
      response => {
        let result = response.json();
        if (result) {
          this.datosVentas = result;
        } else {
          console.log('error');
        }
      },
      err => {
        console.log(err);
      }
    );
  }

  agregarVenta(){
    let data = {
      "nombreMedicamento": this.nuevaVenta.nombreMedicamento,
      "fecha": this.nuevaVenta.fecha,
      "cantidad": this.nuevaVenta.cantidad,
      "valor": this.nuevaVenta.valor,
      "valorTotal": this.nuevaVenta.valor*this.nuevaVenta.cantidad
    }

    let url = `/api/ventas/agregar-venta`;
    let body = JSON.stringify(data);
    this.service.queryPost(url, body)
      .subscribe(data => {
        let result = data;
        if (result) {
          this.getMedicamentos();
          this.formVenta=false
        } else {
          swal({
            title: "alerts.error",
            text: "alerts.cannot_delete_urgencia",
            type: "error",
            showCancelButton: false,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "buttons.ok",
          })
        }
      }, err => {
        console.log(err);
      });
    
      this.nuevaVenta = new Venta('', new Date, 0,0,0);
  }

  realizarEdicionMedicamento(){
    let data = {
      "idMedicamento": this.medicamentoEditar.idMedicamento,
      "nombreMedicamento": this.medicamentoEditar.nombreMedicamento,
      "laboratorio": this.medicamentoEditar.laboratorio,
      "fechaFabricacion": this.medicamentoEditar.fechaFabricacion,
      "fechaVencimiento": this.medicamentoEditar.fechaVencimiento,
      "cantidad": this.medicamentoEditar.cantidad,
      "valor": this.medicamentoEditar.valor
    }

    let url = `/api/medicamentos/agregar-medicamento`;
    let body = JSON.stringify(data);
    this.service.queryPost(url, body)
      .subscribe(data => {
        let result = data;
        if (result) {
          this.getMedicamentos();
          this.formEditar=false;
        } else {
          swal({
            title: "alerts.error",
            text: "alerts.cannot_delete_urgencia",
            type: "error",
            showCancelButton: false,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "buttons.ok",
          })
        }
      }, err => {
        console.log(err);
      });
    
    this.medicamentoEditar = new Medicamento(0,'', '', new Date, new Date, 0,0);
  }
  editarMedicamento(medicamento: Medicamento){
    this.formEditar=true;
    this.medicamentoEditar=medicamento;
  }

  filtrar(event: Event) {
    const filtro = (event.target as HTMLInputElement).value;
    console.log(filtro);
    
    this.dataSource.filter = filtro.trim().toLowerCase();
    this.dataSource.paginator = this.paginador;
  }

  
  cerrarEditar(){
    this.formEditar=false;
  }

  cerrarVenta(){
    this.formVenta=false;
  }

  agregarMedicamento() {
    let data = {
      "nombreMedicamento": this.medicamentoNuevo.nombreMedicamento,
      "laboratorio": this.medicamentoNuevo.laboratorio,
      "fechaFabricacion": this.medicamentoNuevo.fechaFabricacion,
      "fechaVencimiento": this.medicamentoNuevo.fechaVencimiento,
      "cantidad": this.medicamentoNuevo.cantidad,
      "valor": this.medicamentoNuevo.valor
    }

    let url = `/api/medicamentos/agregar-medicamento`;
    let body = JSON.stringify(data);
    this.service.queryPost(url, body)
      .subscribe(data => {
        let result = data;
        if (result) {
          this.getMedicamentos();
        } else {
          swal({
            title: "alerts.error",
            text: "alerts.cannot_delete_urgencia",
            type: "error",
            showCancelButton: false,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "buttons.ok",
          })
        }
      }, err => {
        console.log(err);
      });
    
    this.medicamentoNuevo = new Medicamento(0,'', '', new Date, new Date, 0,0);
    this.formMedicamento=false;
    this.getMedicamentos();
  }
}
function swal(arg0: { title: any; text: any; type: string; showCancelButton: boolean; confirmButtonColor: string; cancelButtonColor: string; confirmButtonText: any; }) {
  throw new Error('Function not implemented.');
}

