package fr.eni.ecole.projet.filtre;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FiltreAuth implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException
    {
        this.context = fConfig.getServletContext();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        if(session == null) 
        {   
            res.sendRedirect("accueil");
        } 
        else 
        {
            chain.doFilter(request, response);
        }
    }

    public void destroy() 
    {
    	
    }
}
