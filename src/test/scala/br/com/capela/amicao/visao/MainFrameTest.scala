package br.com.capela.amicao.visao

import java.awt.Dimension
import swing._
import swing.event._
import GridBagPanel._
import javax.swing._

import br.com.capela.amicao.servico.cliente.ClienteService
import br.com.capela.amicao.servico.pet.PetService

import br.com.capela.amicao.modelo.pet.Pet

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.junit._
import org.junit.Assert._

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired


object MainFrameTest extends SimpleGUIApplication{
	
	val ui = new BoxPanel(Orientation.Vertical) {
		var desktop = new DesktopPane 
		var internalFrame = new JInternalFrame("Frame Interno",true, true, true, true)
		internalFrame.pack
		internalFrame.setVisible(true)
		internalFrame.setSize(100,100)
		desktop.add(internalFrame)
		contents += desktop
		
	}
 
	def top = new MainFrame {
		title = "Table Selection"
		menuBar = new MenuBar 
		var menu = new Menu("Teste")
		var menuItem = new MenuItem("Item");
		
		menu.contents += menuItem
		menuBar.contents += menu
		size = new Dimension(600,400)
		contents = ui
	}
}

class DesktopPane extends Component {
	override lazy val peer: JDesktopPane = new JDesktopPane() with SuperMixin
	
	def add(c:java.awt.Component) = peer.add(c)
}
class InternalFrame extends Component {
	override lazy val peer: JInternalFrame = new JInternalFrame() with SuperMixin
}



@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration{val locations = Array("classpath*:**applicationContext-jpa.xml")}
class MainTest {
    @Test
    def exibir{	
    	MainFrameTest.main(Array[String]())
    	
    	Thread.sleep(1000000)
    }
}