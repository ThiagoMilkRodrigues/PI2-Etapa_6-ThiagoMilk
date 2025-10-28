package controller;

import dao.TransacaoDAO;
import model.Transacao;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarTransacoesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        List<Transacao> transacoes = transacaoDAO.listarTodas();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>");
        html.append("<html lang='pt-BR'>");
        html.append("<head>");
        html.append("<meta charset='UTF-8'>");
        html.append("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        html.append("<title>BitBook - Transações</title>");
        html.append("<link rel='stylesheet' href='resources/css/estilo.css'>");
        html.append("<link rel='stylesheet' href='resources/css/tabela.css'>");
        html.append("</head>");
        html.append("<body>");
        html.append("<div class='container'>");
        html.append("<h1>Dados guardados:</h1>");
        
        html.append("<div class='tabela-container'>");
        html.append("<table>");
        html.append("<thead>");
        html.append("<tr>");
        html.append("<th>Tipo</th>");
        html.append("<th>Moeda</th>");
        html.append("<th>Valor Investido</th>");
        html.append("<th>Valor Compra</th>");
        html.append("<th>Valor Venda</th>");
        html.append("<th>Data Registro</th>");
        html.append("</tr>");
        html.append("</thead>");
        html.append("<tbody>");
        
        if (transacoes.isEmpty()) {
            html.append("<tr><td colspan='6' style='text-align: center;'>Nenhuma transação encontrada</td></tr>");
        } else {
            for (Transacao t : transacoes) {
                html.append("<tr>");
                html.append("<td><span class='tipo-").append(t.getTipo().toLowerCase()).append("'>")
                    .append(t.getTipo()).append("</span></td>");
                html.append("<td>").append(t.getMoeda()).append("</td>");
                html.append("<td>R$ ").append(String.format("%.2f", t.getValorInvestido())).append("</td>");
                html.append("<td>R$ ").append(String.format("%.2f", t.getValorNaCompra())).append("</td>");
                html.append("<td>").append(t.getValorNaVenda() > 0 ? "R$ " + String.format("%.2f", t.getValorNaVenda()) : "-").append("</td>");
                html.append("<td>").append(sdf.format(t.getDataRegistro())).append("</td>");
                html.append("</tr>");
            }
        }
        
        html.append("</tbody>");
        html.append("</table>");
        html.append("</div>");
        
        html.append("<div class='buttons'>");
        html.append("<button onclick=\"window.location.href='pages/registro.html'\" class='btn'>Registrar</button>");
        html.append("<button onclick=\"window.location.href='pages/menu.html'\" class='btn'>Menu</button>");
        html.append("</div>");
        
        html.append("</div>");
        html.append("</body>");
        html.append("</html>");
        
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(html.toString());
    }
}