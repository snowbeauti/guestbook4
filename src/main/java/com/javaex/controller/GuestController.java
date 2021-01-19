package com.javaex.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		List<GuestVo> GList = gdao.GList();

		model.addAttribute("gList", GList);
		System.out.println(GList.toString());

		return "/WEB-INF/views/AddList.jsp";
	}
	
	//등록
	@RequestMapping(value = "add",  method = { RequestMethod.GET, RequestMethod.POST } )
	public String add(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("content") String content, Model model) {
		System.out.println("add");
		GuestDao gdao = new GuestDao();
		GuestVo gvo = new GuestVo(name, password, content);
		
		System.out.println(gvo +"등록");
		gdao.insert(gvo);
		
		return "redirect:/guest/addlist";
	}
	

	// 삭제폼
	@RequestMapping(value = "dform",  method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteform(@RequestParam("no") int no) {
		System.out.println("deleteForm");

		return "/WEB-INF/views/DeleteForm.jsp";
	}

	// 삭제
	@RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam int no, @RequestParam String password) {
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
