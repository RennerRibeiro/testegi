package br.ibm.com.controller;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ibm.com.entity.PibEntity;
import br.ibm.com.service.PibService;

@RestController 
public class Controller {

	
	
	@Autowired	
	private PibService pibService;
	
	//CONSULTAR POR ID
	@RequestMapping(value = "/topicos/{id}", method = RequestMethod.GET)
	public Optional<PibEntity> consultar(Long id) {
		return pibService.findById(id);

	}
	
	//LISTAR TODOS
		@RequestMapping(value = "/topicos/", method = RequestMethod.GET)
		public List<PibEntity> listarTodos() {
			return pibService.findAll();

		}
		
		//LISTAR TODOS
				@RequestMapping(value = "/topicos/todos", method = RequestMethod.GET)
				public List<PibEntity> callApi() {
					return pibService.callApi();

				}
	//CONSULTA POR ANO
	@RequestMapping(value = "/topicos/ano", method = RequestMethod.GET)
	public List<PibEntity> findByYear(String year) {
        return pibService.findByYear(year);
    }
	
	//CONSULTA E SOMA POR ANO
	@RequestMapping(value = "topicos/soma", method = RequestMethod.GET)
	public Double soma(String year) {
        List<PibEntity> byYear = pibService.findByYear(year);

        double soma = 0;

        for(int i=0; i<byYear.size(); i++) {
            soma += byYear.get(i).getValor();
        }
        return soma;
    }
	
	//SALVAR POR ID
	@RequestMapping(value = "/topicos/salvar/{id}", method = RequestMethod.GET)
	public PibEntity saveAll(PibEntity divida) {
        return pibService.save(divida);
    }
	

	//DELETAR POR ID 
	@RequestMapping(value = "/topicos/deleta/{id}", method = RequestMethod.DELETE)
	public void deletar(Long id) {
		pibService.deleteById(id);

	}
	
	//ATUALIZAR POR ID
		@RequestMapping(value = "/topicos/atualizar/{id}", method = RequestMethod.GET)
		public Optional<PibEntity> atualizar(Long id) {
			return pibService.findById(id);

		}
	

	
	
	
	
}