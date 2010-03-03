package modelo.cliente
{	
	import modelo.base.Entidade
	
	[Bindable]
	[RemoteClass(alias="br.com.capela.amicao.modelo.cliente.Cliente")]
	public class Cliente extends Entidade
	{
		public var codigo:String;
		
		public var nome:String;
		
		public var endereco:Endereco;
	
		public var formaDeContato:FormaDeContato;	}
}
