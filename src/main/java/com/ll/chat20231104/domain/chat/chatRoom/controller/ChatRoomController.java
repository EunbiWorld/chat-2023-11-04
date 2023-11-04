package com.ll.chat20231104.domain.chat.chatRoom.controller;

import com.ll.chat20231104.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat20231104.domain.chat.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ChatController가 컨트롤러
@Controller
@RequestMapping("/chat/room")
@RequiredArgsConstructor
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    @GetMapping("/{roomId}") // get 방식의 통신
    @ResponseBody // 메소드 실행
    public String showRoom(
        @PathVariable final long roomId,
        @RequestParam(defaultValue = "NoName") final String writerName
    ) {
        return "%d번 채팅방입니다. writer : %s".formatted(roomId, writerName);
    }

    @GetMapping("/make") // get 방식의 통신
    public String showMake() {
        return "domain/chat/chatRoom/make";
    }

    @PostMapping("/make")
    public String make(
            final String name
    ) {
        chatRoomService.make(name);
        return "redirect:/chat/room/make?message=Chat Room Created";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<ChatRoom> showList() {
        return chatRoomService.findAll();
    }
}


// 서버 찾아서 kill하는 방법
// lsof -i :8082
// kill pid