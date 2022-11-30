/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.fateccomerce.controller.category;

import br.com.fateccomerce.dao.CategoryDAO;
import br.com.fateccomerce.dao.GenericDAO;
import br.com.fateccomerce.model.Category;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Rodrigues
 */
@WebServlet(name = "SaveCategory", urlPatterns = {"/SaveCategory"})
public class SaveCategory extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("idcategory").isEmpty()) {
            String msg = null;
            Category category = new Category(request.getParameter("namecategory"), request.getParameter("descriptioncategory"));
            try {
                GenericDAO dao = new CategoryDAO();
                if (dao.save(category)) {
                    msg = "Categoria cadastrada com sucesso";
                } else {
                    msg = "Erro ao cadastrar categoria";
                }
            } catch (Exception e) {
                System.out.println("Problema ao cadastrar categoria: " + e.getMessage());
                e.printStackTrace();
            } finally {
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("category/save.jsp").forward(request, response);
            }
        }else{
            String msg = null;
            Category category = new Category(Integer.parseInt(request.getParameter("idcategory")),request.getParameter("namecategory"), request.getParameter("descriptioncategory"));
            try {
                GenericDAO dao = new CategoryDAO();
                if (dao.update(category)) {
                    msg = "Categoria alterada com sucesso";
                } else {
                    msg = "Erro ao alterar categoria";
                }
            } catch (Exception e) {
                System.out.println("Problema ao alterar categoria: " + e.getMessage());
                e.printStackTrace();
            } finally {
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("category/save.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
