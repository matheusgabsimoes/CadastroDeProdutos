package SimoesGabMatheus.CadastroDeProdutos.Categorias;

import org.springframework.stereotype.Component;

@Component
public class CategoriasMapper {

    public CategoriasModel map(CategoriasDTO categoriasDTO) {
        CategoriasModel categoriasModel = new CategoriasModel();
        categoriasModel.setId(categoriasDTO.getId());
        categoriasModel.setNome(categoriasDTO.getNome());

        return categoriasModel;
    }

    public CategoriasDTO map(CategoriasModel categoriasModel) {
        CategoriasDTO categoriasDTO = new CategoriasDTO();
        categoriasDTO.setId(categoriasModel.getId());
        categoriasDTO.setNome(categoriasModel.getNome());

        return categoriasDTO;
    }

}
