export class Medicamento {
    constructor(public idMedicamento: number, public nombreMedicamento: string, public laboratorio: string, public fechaFabricacion: Date, public fechaVencimiento: Date, public cantidad: number, public valor: number) {
    }
}
