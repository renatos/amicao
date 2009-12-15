package br.com.capela.persistencia;

import javax.persistence.Query

import _root_.com.google.appengine.api.datastore.Key;

trait Repository[T]{

    def salvar(entidade:T);

    def excluir(entidade:T) ;

    def listarTodos():List[T];
    
    def getById(id:Key):T;
    
    def findByQuery(consulta:Query):java.util.List[T];

}

