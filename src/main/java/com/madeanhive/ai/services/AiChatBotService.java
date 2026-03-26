package com.madeanhive.ai.services;

import com.madeanhive.exception.ProductException;
import com.madeanhive.response.ApiResponse;

public interface AiChatBotService {

    ApiResponse aiChatBot(String prompt,Long productId,Long userId) throws ProductException;
}
