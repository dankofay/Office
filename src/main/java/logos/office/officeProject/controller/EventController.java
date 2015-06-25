package logos.office.officeProject.controller;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logos.office.officeProject.model.Event;
import logos.office.officeProject.service.EventService;


@Controller
@RequestMapping("/events")
public class EventController {

	@Inject
	private EventService eventService;
	
	@RequestMapping()
	public ModelAndView getEvents(ModelAndView model){
		model.addObject("eventsList", eventService.getAllEvents());
		model.setViewName("event");
		return model;
		
	}
	
	@RequestMapping(value="{/getEventsByTypeName}",method = RequestMethod.GET)
	public String getEventsByTypeName(Model model, @PathVariable String nameType){
		List<Event> events=eventService.findEventsByTypeName(nameType);
		model.addAttribute("nameType", events);
		
		return "events";
	}
	
	
		
	
	
	
	
	
}
