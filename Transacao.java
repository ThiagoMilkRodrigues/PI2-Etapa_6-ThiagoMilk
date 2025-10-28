package model;

import java.util.Date;

public class Transacao {
    private int id;
    private String usuario;
    private String tipo;
    private Date dataRegistro;
    private String moeda;
    private double valorInvestido;
    private double valorNaCompra;
    private double valorNaVenda;
    private Date dataCompra;
    private Date dataVenda;
    
    // Construtores
    public Transacao() {}
    
    public Transacao(String usuario, String tipo, String moeda) {
        this.usuario = usuario;
        this.tipo = tipo;
        this.moeda = moeda;
    }
    
    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public Date getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(Date dataRegistro) { this.dataRegistro = dataRegistro; }
    
    public String getMoeda() { return moeda; }
    public void setMoeda(String moeda) { this.moeda = moeda; }
    
    public double getValorInvestido() { return valorInvestido; }
    public void setValorInvestido(double valorInvestido) { this.valorInvestido = valorInvestido; }
    
    public double getValorNaCompra() { return valorNaCompra; }
    public void setValorNaCompra(double valorNaCompra) { this.valorNaCompra = valorNaCompra; }
    
    public double getValorNaVenda() { return valorNaVenda; }
    public void setValorNaVenda(double valorNaVenda) { this.valorNaVenda = valorNaVenda; }
    
    public Date getDataCompra() { return dataCompra; }
    public void setDataCompra(Date dataCompra) { this.dataCompra = dataCompra; }
    
    public Date getDataVenda() { return dataVenda; }
    public void setDataVenda(Date dataVenda) { this.dataVenda = dataVenda; }
}