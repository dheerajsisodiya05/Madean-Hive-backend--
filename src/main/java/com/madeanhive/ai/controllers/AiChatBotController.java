package com.madeanhive.ai.controllers;

import com.madeanhive.ai.services.AiChatBotService;
import com.madeanhive.model.User;
import com.madeanhive.request.Prompt;
import com.madeanhive.response.ApiResponse;
import com.madeanhive.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ai/chat")
public class AiChatBotController {

    private final AiChatBotService aiChatBotService;
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<ApiResponse> generate(
            @RequestBody Prompt prompt,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long productId,
            @RequestHeader(required = false,name = "Authorization")String jwt) throws Exception {

        String message = prompt.getPrompt();
        if (productId != null) {
            message = "the product id is " + productId +", " + message ;
        }

        if(jwt!=null) {
            User user = userService.findUserProfileByJwt(jwt);
            if(user != null) {
                userId = user.getId();
            }
        }

        ApiResponse apiResponse = aiChatBotService.aiChatBot(message, productId, userId);

        return ResponseEntity.ok(apiResponse);

    }

}
