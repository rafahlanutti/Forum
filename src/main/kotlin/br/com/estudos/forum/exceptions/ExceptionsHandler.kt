package br.com.estudos.forum.exceptions

import br.com.estudos.forum.dtos.ErrorView
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionsHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(exception: NotFoundException, request: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message,
            path = request.servletPath
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleValidateError(exception: MethodArgumentNotValidException, request: HttpServletRequest): ErrorView {
        val errorMessage = HashMap<String, String?>()
        exception.bindingResult.fieldErrors.forEach {
            e ->
            errorMessage[e.field] = e.defaultMessage
        }
        return ErrorView(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = errorMessage.toString(),
            path = request.servletPath
        )
    }
}