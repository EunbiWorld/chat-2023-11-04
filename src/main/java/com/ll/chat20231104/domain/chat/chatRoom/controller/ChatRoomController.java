package com.ll.chat20231104.domain.chat.chatRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// ChatController가 컨트롤러
@Controller
@RequestMapping("/chat/room")
public class ChatRoomController {
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
}


// 서버 찾아서 kill하는 방법
// lsof -i :8082
// kill pid