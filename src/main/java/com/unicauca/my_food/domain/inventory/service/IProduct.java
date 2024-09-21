package com.unicauca.my_food.domain.inventory.service;

public interface IProduct {
    /**
     * Se encarga de la lógica de salida de los productos del inventario.
     * 
     * @param amount cantidad de unidades salidas del inventario
     * @return {@code true} si se completa satisfactoriamente y {@code false} en
     *         caso contrario.
     */
    boolean decreaseStock(int amount);

    /**
     * Se encarga de la lógica de agregar productos al inventario.
     * 
     * @param amount cantidad de unidades a agregar al inventario.
     * @return {@code true} en caso de que se complete la acción y {@code false} en
     *         caso contrario.
     */
    boolean increaseStock(int amount);

    /**
     * Se encarga de determinar si un producto ha llegado a su fecha de caducidad y
     * lo marca de esta forma
     * 
     * @return {@code true} en caso de que el producto se haya vencido o
     *         {@code false} en caso contrario.
     */
    public boolean markExpired();

}
