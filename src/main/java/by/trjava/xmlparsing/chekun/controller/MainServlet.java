package by.trjava.xmlparsing.chekun.controller;

import by.trjava.xmlparsing.chekun.domain.entity.TouristVoucher;
import by.trjava.xmlparsing.chekun.domain.service.ServiceFactory;
import by.trjava.xmlparsing.chekun.domain.service.TouristVouchersService;
import by.trjava.xmlparsing.chekun.domain.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@WebServlet("/mainServlet")
@MultipartConfig //annotation to help download file
public class MainServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(MainServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String parserName = request.getParameter("parserName");
        final Part xmlPart = request.getPart("xml");
        final Part xsdPart = request.getPart("xsd");

        try (InputStream xmlInputStream = xmlPart.getInputStream();
             InputStream parsingInputStream = xmlPart.getInputStream();
             InputStream xsdInputStream = xsdPart.getInputStream()) {

            final ServiceFactory serviceFactory = ServiceFactory.getInstance();
            final TouristVouchersService touristVouchersService = serviceFactory.getTouristVouchersService();

            final List<TouristVoucher> touristVouchers = touristVouchersService.getTouristVouchersList(parserName, xmlInputStream, xsdInputStream, parsingInputStream);
            //
            logger.info("Final vouchers list: ");
            touristVouchers.forEach(logger::info);
            //
            request.setAttribute("parserType", parserName);
            request.setAttribute("trip_vouchers", touristVouchers);



            request.getRequestDispatcher("jsp/table.jsp").forward(request, response);

        } catch (ServiceException e) {
            logger.warn(e.getMessage());
            request.setAttribute("mistake","Exception text:  " + e.getLocalizedMessage());
            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
        }

    }
}
