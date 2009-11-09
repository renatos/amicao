package br.com.capela.persistencia;

trait Repository[T]{

    def salvar(entidade:T);

    def excluir(entidade:T) ;

    def listarTodos():List[T];
    
    def getById(id:Int):T;

}

