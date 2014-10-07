package br.com.ufjf.util;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.Transaction;

@WebFilter(servletNames = {"Faces Servlet"})
public class HibernateSessionFilter implements Filter, Serializable {
 private static final long serialVersionUID = 1L;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        Session session = HibernateUtil.getSession();
        Transaction trx = null;

        try {
            trx = session.beginTransaction();
            request.setAttribute("session", session);

            chain.doFilter(request, response);

            trx.commit();
        } catch (IOException e) {
            if (trx != null) {
                trx.rollback();
            }
        } catch (ServletException e) {
            if (trx != null) {
                trx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

}
