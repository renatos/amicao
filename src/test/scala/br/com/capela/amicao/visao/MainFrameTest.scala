package br.com.capela.amicao.visao

import java.awt.Dimension
import swing._
import swing.event._
import GridBagPanel._
import javax.swing.{JInternalFrame,JDesktopPane}

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
	var desktop = new DesktopPane 
	val ui = new BoxPanel(Orientation.Vertical) {
		
		
		contents += desktop
		
	}
 	
 	def createInternalFrame() = {
 		var internalFrame = new JInternalFrame("Frame Interno",true, true, true, true)
		internalFrame.pack
		internalFrame.setVisible(true)
		internalFrame.setSize(100,100)
		desktop.add(internalFrame)
 	}
 	
	def top = new MainFrame {
		title = "Amicão"
		menuBar = new MenuBar 
		var menu = new Menu("Teste")
		
		menu.contents += new MenuItem("Item");
		menu.contents += new MenuItem(Action("An action item") {
		      createInternalFrame
		    });
		menuBar.contents += menu
		preferredSize=(600,400)
		contents = ui
	}
}

class DesktopPane extends Component {
	override lazy val peer: JDesktopPane = new JDesktopPane() with SuperMixin
	
	def add(c:java.awt.Component) = peer.add(c)
}
class InternalFrame(nome:String, p1:Boolean,p2:Boolean,p3:Boolean) extends Component {
	override lazy val peer: JInternalFrame = new JInternalFrame(nome,p1,p2,p3) with SuperMixin
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
