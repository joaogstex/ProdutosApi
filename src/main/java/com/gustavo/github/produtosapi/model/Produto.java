package com.gustavo.github.produtosapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Produto {
    
    private String id;
    private String name;
    private String description;
    private Double price;

}
