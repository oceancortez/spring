package org.oxi.springmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.oxi.springmvc.utils.Message;
import org.oxi.springmvc.utils.Route;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

/***
 * Classe para interceptar o Request quando utilizamos UPLOAD de arquivos
 * @author ocortez
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView handleMaxUploadException(MaxUploadSizeExceededException exceededException, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        boolean isJson = request.getRequestURL().toString().contains(".json");
        if (isJson) {
            mav.setView(new MappingJacksonJsonView());
            mav.addObject("result", "nok");
        }
        else{ 
        	if(exceededException.getMaxUploadSize() >= 1048576){
        		String uri = request.getRequestURI();        		
        		if(uri.contains("/spring3/category/save")){
        			mav.setViewName(Route.CATEGORY_SAVE.toString());
        		}
        		if(uri.contains("/spring3/category/update")){
        			mav.setViewName(Route.CATEGORY_UPDATE.toString());        			
        		}        		        		
    			return mav.addObject("message", Message.MAX_UPLOAD_EXCEEDED.toString());
    		}	
        	
        
        }
        return mav;
    }

}
