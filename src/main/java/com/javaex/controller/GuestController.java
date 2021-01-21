package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping(value = "/guest")
public class GuestController {

	// 리스트
	@RequestMapping(value = "/addlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String addlist(Model model) {
		System.out.println("addlist");
		GuestDao gdao = new GuestDao();
		List<GuestVo> gList = gdao.GList();

		model.addAttribute("gList", gList);
		System.out.println(gList.toString());

		return "AddList";
	}
	
	//등록
	@RequestMapping(value = "add",  method = { RequestMethod.GET, RequestMethod.POST } )
	public String add(@ModelAttribute GuestVo gvo) {
		System.out.println("add");
		
		GuestDao gdao = new GuestDao();
		gdao.insert(gvo);
		System.out.println(gvo +"등록");
		
		return "redirect:/guest/addlist";
	}
	

	// 삭제폼
	@RequestMapping(value = "dform",  method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteform() {
		System.out.println("deleteForm");

		return "DeleteForm";
	}

	// 삭제
	@RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam/*("id")*/ int no, 	
						 @RequestParam/*("password")*/ String password) {
		System.out.println("delete");

		GuestDao gdao = new GuestDao();
		GuestVo gvo = gdao.getGuest(no);

		if (gvo.getPassword().equals(password)) {
			System.out.println(gvo + "삭제");

			gdao.delete(gvo);
			
		} else {
			return "redirect:/guest/dform?no="+no+"&result=fail";
		}

		return "redirect:/guest/addlist";
	}
	

	
}
