package com.ShopSmart.Clientes.models.request;

import lombok.Data;

@Data
public class ActualizarCliente {
    
    private Integer id_cliente;

    private String pnombre_cli;

    private String snombre_cli;
    
    private String apaterno_cli;

    private String amaterno_cli;

    private String email_cli;

    private String telefono_cli;

    private String contrasena;
}
