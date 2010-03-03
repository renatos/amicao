package modelo.cliente
{	
	import modelo.base.Entidade
	
	[Bindable]
	[RemoteClass(alias="br.com.capela.amicao.modelo.cliente.Endereco")]
	public class Endereco extends Entidade
	{
	    public var logradouro:String;
	    
	    public var numero:String;
	    
	    public var bairro:String;
	    
	    public var cidade:String;
	    
	    public var cep:String;

	}
}