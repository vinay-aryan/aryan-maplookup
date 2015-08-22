package com.maplookup.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.maplookup.db.domain.Zipcodes;
import com.maploopup.service.ZipcodesService;

@Controller
public class MapLookupController {

	 @Autowired
	    ZipcodesService zipcodeService;

	    Logger logger = Logger.getLogger(MapLookupController.class);

	    @RequestMapping(method = RequestMethod.GET, value = "/home")
	    public ModelAndView mapRequestHandler(HttpServletRequest request) {
	        Map<String, Object> modelMap = new HashMap<String, Object>();
	        return new ModelAndView("/home", modelMap);
	    }
	    
	    
	    @ResponseBody
	    @RequestMapping(method = RequestMethod.GET, value = "/autocomplete/{field}/{text}")
	    public List<String> autoCompletHandler(@PathVariable String field, @PathVariable String text){
	        if((field != null || text != null) && (!field.isEmpty() || !text.isEmpty()))
	        return zipcodeService.searchTextInField( field, text );
	        return new ArrayList<String>();
	    }

	    @ResponseBody
	    @RequestMapping(method = RequestMethod.GET, value = "/getCities/{state}")
	    public List<String> getCitiesByState(@PathVariable String state){
	        if(state != null  && !state.isEmpty())
	        return zipcodeService.searchCitiesBystate( state );
	        return new ArrayList<String>();
	    }
	    
	    @ResponseBody
	    @RequestMapping(method = RequestMethod.GET, value = "/getZips/{city}/{state}")
	    public List<String> getZipsByCity(@PathVariable String city,@PathVariable String state){
	        if(city != null  && !city.isEmpty())
	            return zipcodeService.searchZipsByCityAndstate(state,city );
	        return new ArrayList<String>();
	    }
	    
	    @ResponseBody
	    @RequestMapping(method = RequestMethod.GET, value = "/getStates/{city}")
	    public List<String> getStateByCity(@PathVariable String city){
	        if(city != null  && !city.isEmpty())
	        return zipcodeService.searchStatesByCity( city );
	        return new ArrayList<String>();
	    }
	    
	    @RequestMapping(method = RequestMethod.GET, value = "/getCordinates/{zip}")
	    @ResponseBody
	    public Zipcodes getZip(@PathVariable String zip){
	        if(zip != null  && !zip.isEmpty())
	        return zipcodeService.findZipCodesById( zip );
	        return null;        
	    }
	    
	    @RequestMapping(method = RequestMethod.GET, value = "/getCityCordinates/{state}/{city}")
	    @ResponseBody
	    public Zipcodes getZipByCityAndState(@PathVariable String state, @PathVariable String city){        
	        if(city != null  && !city.isEmpty() && state != null && !state.isEmpty())
	            return zipcodeService.findZipCodesByStateAndCity( state, city );
	        return null;  
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/getCityCordinate/{city}")
	    @ResponseBody
	    public List getZipByCity(@PathVariable String city){        
	        if(city != null  && !city.isEmpty())
	            return zipcodeService.searchStatesByCity( city );
	        return null;  
	    }
	    
	    @RequestMapping(method = RequestMethod.GET, value = "/getStateCordinates/{state}")
	    @ResponseBody
	    public Zipcodes getZipByState(@PathVariable String state){
	        if(state != null  && !state.isEmpty())
	           return zipcodeService.findZipCodesByState( state );
	        return null;        
	    }           
}
