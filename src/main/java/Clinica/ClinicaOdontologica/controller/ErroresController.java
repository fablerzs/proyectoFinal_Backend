package Clinica.ClinicaOdontologica.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ErroresController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        System.out.println("Controlador de errores");

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.FORBIDDEN.value()) {
                return "templates/errores/error-403";
            }
        }
        return "templates/errores/error";
    }
}
