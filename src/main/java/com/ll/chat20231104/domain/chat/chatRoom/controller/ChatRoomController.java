package com.ll.chat20231104.domain.chat.chatRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// ChatController가 컨트롤러
@Controller
public class ChatRoomController {
    @GetMapping("/chat/room/{roomId}") // get 방식의 통신
    @ResponseBody // 메소드 실행
    public String showRoom(
        @PathVariable final long roomId,
        @RequestParam(defaultValue = "NoName") final String writerName
    ) {
        return "%d번 채팅방입니다. writer : %s".formatted(roomId, writerName);
    }
}


// 서버 찾아서 kill하는 방법
// lsof -i :8082
// kill pid