package com.carniceria.mesitas.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long idProveedor;

    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    @Column(name = "cedula_juridica")
    private String cedulaJuridica;

    private String telefono;
    private String categoria;

    // Getters y Setters
    public Long getIdProveedor() { return idProveedor; }
    public void setIdProveedor(Long idProveedor) { this.idProveedor = idProveedor; }
    public String getNombreEmpresa() { return nombreEmpresa; }
    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }
    public String getCedulaJuridica() { return cedulaJuridica; }
    public void setCedulaJuridica(String cedulaJuridica) { this.cedulaJuridica = cedulaJuridica; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}