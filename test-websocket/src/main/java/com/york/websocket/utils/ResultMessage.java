package com.york.websocket.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultMessage {

    private boolean isSystem;

    private String fromName;

    private Object message;
}
