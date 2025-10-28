package controller;

import dao.TransacaoDAO;
import model.Transacao;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TransacaoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String usuario = (String) session.getAttribute("usuario");
        
        if (usuario == null) {
            response.sendRedirect("../index.html");
            return;
        }
        
        String tipo = request.getParameter("tipo");
        String moeda = request.getParameter("moeda");
        
        Transacao transacao = new Transacao();
        transacao.setUsuario(usuario);
        transacao.setTipo(tipo);
        transacao.setMoeda(moeda);
        transacao.setDataRegistro(new Date());
        
        try {
            if ("venda".equals(tipo)) {
                transacao.setValorInvestido(Double.parseDouble(request.getParameter("valorInvestido")));
                transacao.setValorNaCompra(Double.parseDouble(request.getParameter("valorCompra")));
                transacao.setValorNaVenda(Double.parseDouble(request.getParameter("valorVenda")));
                
                // PEGAR DATAS DE COMPRA E VENDA
                String dataCompraStr = request.getParameter("dataCompra");
                String dataVendaStr = request.getParameter("dataVenda");
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                
                if (dataCompraStr != null && !dataCompraStr.isEmpty()) {
                    transacao.setDataCompra(sdf.parse(dataCompraStr));
                }
                
                if (dataVendaStr != null && !dataVendaStr.isEmpty()) {
                    transacao.setDataVenda(sdf.parse(dataVendaStr));
                }
                
            } else {
                transacao.setValorNaCompra(Double.parseDouble(request.getParameter("valorCompraSimples")));
                transacao.setValorInvestido(Double.parseDouble(request.getParameter("valorInvestidoSimples")));
            }
            
            TransacaoDAO transacaoDAO = new TransacaoDAO();
            boolean sucesso = transacaoDAO.salvar(transacao);
            
            if (sucesso) {
                response.sendRedirect("pages/menu.html?sucesso=1");
            } else {
                response.sendRedirect("pages/registro.html?erro=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("pages/registro.html?erro=2");
        }
    }
}