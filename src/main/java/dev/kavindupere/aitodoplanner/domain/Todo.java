package dev.kavindupere.aitodoplanner.domain;

import lombok.Builder;

@Builder
record Todo(
    String code,
    String title,
    String description,
    boolean completed
) {    
}
