package br.com.capela.amicao.visao

import java.awt.event._
import java.awt._
import javax.swing._

import br.com.capela.amicao.servico.cliente.ClienteService
import br.com.capela.amicao.servico.pet.PetService

import br.com.capela.amicao.modelo.pet._

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.junit._
import org.junit.Assert._

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired


object MainFrameTest extends JFrame("Amicao"){
	var desktop = new JDesktopPane 
 	
	implicit def actionPerformedWrapper(func: (ActionEvent) => Unit) = 
		new ActionListener { 
		  def actionPerformed(e:ActionEvent) = func(e) 
		}
	
 
	def init = {
	  var menuBar:JMenuBar = new JMenuBar
	  var menu:JMenu = new JMenu("Cadastros")
	  var menuItem:JMenuItem = new JMenuItem("Raca")
	  
	  menu add menuItem 
      menuBar add menu
      
      setJMenuBar(menuBar)
	  getContentPane().add(desktop);
      
      menuItem.addActionListener(
        (e:ActionEvent) => createInternalFrame
      )
      setPreferredSize(new Dimension(600,400))
      setSize(600,400)
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
	  pack
	  setVisible(true)
	}
	
 	def createInternalFrame():Unit = {
 		var internalFrame = new JInternalFrame("Frame Interno",true, true, true, true)
		internalFrame.pack
		internalFrame.setVisible(true)
		internalFrame.setSize(200,100)
		internalFrame.add(createRacaForm())
		desktop.add(internalFrame) 
 	}
 	
 	def createRacaForm():JPanel = {
 	  var racaForm = new JPanel()
 	  var nome = new JTextField
 	  var salvar = new JButton("Salvar")
 	  nome.setColumns(20)
 	  racaForm.add(nome)
 	  racaForm.add(salvar)

      salvar.addActionListener(
 			  (e:ActionEvent) => salvarRaca(nome.getText())
 	  )
 	  
 	  racaForm
 	}
 	
    def salvarRaca(nome:String):Unit = {
      var raca = new Raca(); 
      raca.setNome(nome);
      println(raca) 
    }
}



@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration{val locations = Array("classpath*:**applicationContext.xml")}
class MainTest {
    @Test
    def exibir{	
    	MainFrameTest.init
    	
    	Thread.sleep(1000000)
    }
}

