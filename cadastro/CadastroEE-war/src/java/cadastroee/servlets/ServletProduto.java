/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cadastroee.servlets;

import cadastroee.controller.ProdutoFacadeLocal;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


/**
 *
 * @author Maiara
 */
public class ServletProduto extends HttpServlet {

@EJB
    ProdutoFacadeLocal produtoFacade;

    private final HashMap<String, Strategy> estrategia
            = new HashMap<>();
    private final HashMap<String, String> acoes = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();

        estrategia.put("produto", new ProdutoStrategy(
                produtoFacade));

        String[] acoesProduto = {"listaProd", "incProd", "incProdExec", "excProdExec", "editProd", "editProdExec"}; // Adicione "editProdExec"
        for (String acao : acoesProduto) {
            acoes.put(acao, "produto");
        }

    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao == null) {
            throw new ServletException("Parâmetro acao requerido");
        }
//        Strategy st = estrategia.get(acoes.get(acao));
//        request.getRequestDispatcher(st.executar(acao, request)).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
