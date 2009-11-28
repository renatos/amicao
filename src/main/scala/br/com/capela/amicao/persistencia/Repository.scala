package br.com.capela.persistencia;

import javax.persistence.Query

trait Repository[T]{

    def salvar(entidade:T);

    def excluir(entidade:T) ;

    def listarTodos():List[T];
    
    def getById(id:Long):T;
    
    def findByQuery(consulta:Query):java.util.List[T];

}

