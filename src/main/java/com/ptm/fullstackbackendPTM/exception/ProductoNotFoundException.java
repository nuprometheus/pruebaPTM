package com.ptm.fullstackbackendPTM.exception;

public class ProductoNotFoundException extends RuntimeException{
    public ProductoNotFoundException(Long id){
        super("No se puede encontrar producto con el id " + " " + id);
    }
}
