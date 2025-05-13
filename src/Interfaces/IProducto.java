package Interfaces;

import Modelo.ModeloProducto;

/**
 *
 * @author jhosu
 */
public interface IProducto {
    
    public boolean guardarProducto(ModeloProducto modelo);
    public ModeloProducto mostrarProducto(int idProducto);
    public boolean actualizarProducto(ModeloProducto modelo);
    public boolean eliminarProducto(int idProducto);
    
    
}
