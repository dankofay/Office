package logos.office.officeProject.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logos.office.officeProject.dto.EventDTO;


import logos.office.officeProject.service.EventService;


@Controller
@RequestMapping("/event")
public class EventController {

	@Inject
	private EventService eventService;
	
	@RequestMapping()
	public ModelAndView getSalarys(ModelAndView model) {
		model.addObject("eventsList", eventService.getAllEvents());
		model.setViewName("event");
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getSalaryByUserId(Model model, @PathVariable long id) {
		List<EventDTO> event = eventService.getAllEventsById(id);

		model.addAttribute("eventById", event);
		return "event";
	}
//	@RequestMapping(value="{/create?timeFrom={from}&duration={duration}&date={date}&typeId={typeID}",method = RequestMethod.POST)
//	public String getEventsByTypeName(Model model, @PathVariable(value ="from") Time from,
//			@PathVariable(value ="duration") Time duration,
//			@PathVariable(value ="date") Date date,
//			@PathVariable(value ="typeID") Long typeId){
//		System.out.println(from +" "+duration+" "+date+" "+ typeId);
//		model.addAttribute("saveEvent", eventService.saveEvent(from, duration, typeId, date) );
//		return "event";
//	}
	
	
		
	
	
	
	
	
}
