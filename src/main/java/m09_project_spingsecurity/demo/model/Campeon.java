package m09_project_spingsecurity.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Campeon {

    @Id
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String role;

    @NotNull
    @NotEmpty
    private String attack;

    @NotNull
    @NotEmpty
    private String resource;

    @NotNull
    private int attackRange;
}
