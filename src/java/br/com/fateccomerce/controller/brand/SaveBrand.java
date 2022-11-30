/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.fateccomerce.controller.brand;

import br.com.fateccomerce.dao.BrandDAO;
import br.com.fateccomerce.dao.GenericDAO;
import br.com.fateccomerce.model.Brand;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Rodrigues
 */
@WebServlet(name = "SaveBrand", urlPatterns = {"/SaveBrand"})
public class SaveBrand extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("idbrand").isEmpty()) {
            String msg = null;
            Brand brand = new Brand(request.getParameter("namebrand"), request.getParameter("descriptionbrand"));

            try {
                GenericDAO dao = new BrandDAO();
                if (dao.save(brand)) {
                    msg = "Marca Cadastrada com sucesso!";
                } else {
                    msg = "Problemas ao cadastrar Marcas!";
                }
            } catch (Exception e) {
                System.out.println("Problema ao cadastrar marca: " + e.getMessage());
                e.printStackTrace();
            } finally {
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("brand/save.jsp").forward(request, response);
            }
        }else{
             String msg = null;
            Brand brand = new Brand(Integer.parseInt(request.getParameter("idbrand")), request.getParameter("namebrand"), request.getParameter("descriptionbrand"));

            try {
                GenericDAO dao = new BrandDAO();
                if (dao.update(brand)) {
                    msg = "Marca alterada com sucesso!";
                } else {
                    msg = "Problemas ao alterar Marcas!";
                }
            } catch (Exception e) {
                System.out.println("Problema ao alterar marca: " + e.getMessage());
                e.printStackTrace();
            } finally {
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("ListCategory").forward(request, response);
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
