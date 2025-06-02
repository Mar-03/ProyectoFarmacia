/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

/**
 *
 * @author jhosu
 */


import Modelo.ModeloClientesVentas;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JTable;


public class GeneradorPDFVentas {
    
    public void generarFacturaPDF(JTable tablaCarrito, String nombreArchivo, String codigoArchivo, ModeloClientesVentas venta,String usuarioActivo, int idVenta){
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();
            
            //Encabezado para PDF
            Image logo = Image.getInstance("src/Imagen/Pill MT 10-100 BlancoNegro");
            logo.scaleToFit(100, 100);
            logo.setAlignment(Image.ALIGN_CENTER);
            
            document.add(logo);
            
            
            document.add(new Paragraph("FARMACIA SOCIAL", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20)));
            document.add(new Paragraph("Dirección: Calle principal,Guastatoya"));
            
            //Fecha y número de venta
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd&/MM/yyyy HH:mm");
            document.add(new Paragraph("No. de Venta: " + idVenta));
            document.add(new Paragraph("Tipo Pago: " + venta.getTipoPago()));
            document.add(new Paragraph("Fecha: " + LocalDateTime.now().format(formatter)));
            document.add(new Paragraph("Código Comprobante: " + codigoArchivo));
            document.add(new Paragraph("Vendedor: " + usuarioActivo));
            document.add(new Paragraph(""));
            document.add(new Paragraph("Cliente: " + venta.getNombre() + venta.getApellido()));
            document.add(new Paragraph("NIT: " + venta.getNit()));
            document.add(new Paragraph("Dirección: " + venta.getDireccion()));
           
            //Tabla del Carrito
            PdfPTable tablaPDF  = new PdfPTable(5);
            tablaPDF.setWidthPercentage(100);
            tablaPDF.addCell("Nombre");
            tablaPDF.addCell("Precio");
            tablaPDF.addCell("Cantidad");
            tablaPDF.addCell("SubTotal");
            tablaPDF.addCell("Total");
            
            //Agregar filas de la tabla
            for(int i = 0; i  < tablaCarrito.getRowCount(); i++) {
            tablaPDF.addCell(tablaCarrito.getValueAt(i, 0).toString()); // Nombre
            tablaPDF.addCell(tablaCarrito.getValueAt(i, 1).toString()); // Precio
            tablaPDF.addCell(tablaCarrito.getValueAt(i, 2).toString()); // Cantidad
            tablaPDF.addCell(tablaCarrito.getValueAt(i, 3).toString()); // Subtotal
            tablaPDF.addCell(tablaCarrito.getValueAt(i, 4).toString());
            }
            
            document.add(tablaPDF);
            document.add(new Paragraph(""));
            Paragraph paragraphTotal = new Paragraph("Total:");
            paragraphTotal.setAlignment(Element.ALIGN_RIGHT);
            document.add(paragraphTotal);
            
            //document.add(new Paragraph("Total: " + venta));
            
            //Totales
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Descuento: Q" + venta.getDescuento()));
            document.add(new Paragraph("Total: $" + venta.getTotal()));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("¡Gracias por su compra!", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            
            document.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static String obtenerRutaComprobantes(){
        String escritorio = System.getProperty("user.home") + File.separator + "Desktop";
        String carpetaComprobantes = escritorio + File.separator + "comprobantesVentas";
        
        //Crear carpeta si no existe
        File directorio = new File(carpetaComprobantes);
        if(!directorio.exists()){
            directorio.mkdir();
        }
        return carpetaComprobantes;
    }
    
    
}
