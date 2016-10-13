package com.epam.koval.carrent.web.bean.extractor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Bean extractor interface.
 * 
 * @author Koval Dmitry
 * @version 1.0
 * @param <T> generic type
 */
public interface BeanExtractor<T> {
    /**
     * Extracts bean from request.
     * 
     * @param request http servlet request
     * @return bean object
     * @throws IOException {@linkplain IOException}
     * @throws ServletException {@linkplain ServletException}
     */
    T extract(HttpServletRequest request) throws IOException, ServletException;
}
