package br.com.capela.persistencia;

trait Repositorio[T]{

    def salvar(entidade:T);

    def excluir(entidade:T) ;

    def listarTodos():java.util.List[T];

}

