package Interfaces;

import Modelo.ModeloProducto;

/**
 *
 * @author jhosu
 */
public interface IProducto {

    public boolean guardarProducto(ModeloProducto modelo);

    public boolean guardarLote(ModeloProducto modelo, int idProducto);

    public boolean guardarNombreAlternativo(ModeloProducto modelo, int idProducto);

    public ModeloProducto mostrarProducto(String nombreP, String codigoP);

    public boolean actualizarProducto(ModeloProducto modelo);

    public boolean eliminarProducto(int idProducto);
}
