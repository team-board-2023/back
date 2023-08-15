package com.board.notice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TokenInfo {
    private String grantType;       // Bearer를 사용
    private String accessToken;
    private String refreshToken;
}
