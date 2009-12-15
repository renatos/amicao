package br.com.capela.amicao.visao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype._
import org.springframework.web.bind.annotation._
import org.springframework.beans.factory.annotation.Qualifier

import br.com.capela.amicao.servico.cliente.ClienteService
import br.com.capela.amicao.persistencia.cliente.ClienteDao

import br.com.capela.amicao.modelo.cliente._
import br.com.capela.amicao.modelo.pet._

import java.io.IOException;
import javax.servlet.http._;
import javax.servlet._;
import javax.annotation._

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.context._;  
import org.springframework.web.context.support._;  

import _root_.com.google.appengine.api.datastore.KeyFactory

@Controller
class GuestbookServlet {
	
	var clienteService:ClienteService = _
	
	@Autowired 
    def setClienteService(service:ClienteService) = this.clienteService = service
    
    @RequestMapping{val value = Array("/test.do"), val method = Array(RequestMethod.POST)}
	def get(name:String, model: Model):String = {
		var pet:Pet = new Pet();
		pet.nome = "Li"
     	pet.especie(EspecieEnum.felina);
        pet.coresPredominantesDoPelo.add(new Cor("A","Azul"))
        pet.coresPredominantesDoPelo.add(new Cor("P","Preto"))
		var cliente:Cliente  = new Cliente();
      	cliente.nome = name
        cliente.inserePet(pet);
		this.clienteService.salvar(cliente)
		var clientes = clienteService.listarTodos();
        clientes foreach {cliente => println("DADOS: "+cliente.toString) }
		model.addAttribute("name", clientes); 
		"test";  
    }
 
}

