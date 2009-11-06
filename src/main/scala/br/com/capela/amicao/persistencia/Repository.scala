package br.com.capela.persistencia;

trait Repository[T]{

    def salvar(entidade:T);

    def excluir(entidade:T) ;

    def listarTodos():java.util.List[T];
    
    def getById(id:Int):T;

}

