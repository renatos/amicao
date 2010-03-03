package modelo.cliente
{	
	import modelo.base.Entidade
	
	[Bindable]
	[RemoteClass(alias="br.com.capela.amicao.modelo.cliente.FormaDeContato")]
	public class FormaDeContato extends Entidade
	{
		public var telefone1:String;
    
		public var telefone2:String;
    
		public var celular:String;
    
		public var email:String;
	}
}