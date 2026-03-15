package com.ShopSmart.Clientes.models.request;

import lombok.Data;

@Data
public class AgregarCliente {

    private String pnombre_cli;

    private String snombre_cli;
    
    private String apaterno_cli;

    private String amaterno_cli;

    private String run_cli;

    private String email_cli;

    private String telefono_cli;

    private String contrasena;
}
