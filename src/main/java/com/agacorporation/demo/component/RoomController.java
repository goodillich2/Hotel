package com.agacorporation.demo.component;

import com.agacorporation.demo.domain.CountOfRoomView;
import com.agacorporation.demo.domain.Room;
import com.agacorporation.demo.repository.view.CountOfRoomViewRepository;
import com.agacorporation.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private CountOfRoomViewRepository countOfRoomViewRepository;


    @GetMapping({"/roomDetails"})
    public String showRoomDetails(Model model) {
        return "roomDetails.html";
    }

    @RequestMapping(value="/reservationList.html", params = {"rid"}, method = RequestMethod.GET)
    public String showRoomDetails(Model model, long rid){
        Room r = roomService.getRoom(rid);
        model.addAttribute("room", r);
        return "roomDetails";
    }
    @RequestMapping(value="/roomList.html", method = {RequestMethod.GET})
    public String showReservationList(Model model,Pageable pageable){
        System.out.println("to ja");
        model.addAttribute("roomListPage", roomService.getAllRooms2(pageable));
        System.out.println("to ja 2");
        return "roomList.html";
    }


    @GetMapping({"/countOfRoom"})
    public String countOfRoom(Model model) {
        List<CountOfRoomView> countOfRoomViews = countOfRoomViewRepository.findAll();
        model.addAttribute("countOfRoomViews", countOfRoomViews);
        System.out.println(countOfRoomViews);
        return "countOfRoomCertainType.html";
    }


}
