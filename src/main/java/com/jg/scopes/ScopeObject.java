package com.jg.scopes;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ScopeObject {

    @Builder.Default
    private UUID id = UUID.randomUUID();

}
