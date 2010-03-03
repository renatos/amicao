package modelo.cliente
{
	import flash.events.Event;

	public class ClienteEvent extends Event
	{
		public static const CREATED:String = "clienteCreated";
		public static const UPDATED:String = "clienteUpdated";
		public static const DELETED:String = "clienteDeleted";
	
		public var cliente:Cliente;
		
		public function ClienteEvent(type:String, cliente:Cliente, bubbles:Boolean = true, cancelable:Boolean = false)
   		{
   			this.cliente = cliente;
			super(type, bubbles, cancelable);
		}
	}
}
