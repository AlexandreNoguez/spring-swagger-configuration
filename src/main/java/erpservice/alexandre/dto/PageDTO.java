package erpservice.alexandre.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageDTO<T> {

    private Long totalElementos;
    private Integer quantidadePaginas;
    private Integer pagina;
    private Integer tamanho;
    private List<T> elementos;
}
