package dev.kavindupere.aitodoplanner.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todos")
class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todos_seq")
    @SequenceGenerator(name = "todos_seq", sequenceName = "todos_seq", allocationSize = 1)
    private Long id;
    private String code;
    private String title;
    private String description;
    private boolean completed;
}
