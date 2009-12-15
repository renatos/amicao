package br.com.capela.amicao

import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.junit._
import org.junit.Assert._

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import org.springframework.test.context.transaction.TransactionConfiguration
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.test.context.TestExecutionListeners

import _root_.com.google.appengine.tools.development.ApiProxyLocalImpl;
import _root_.com.google.apphosting.api.ApiProxy;
import _root_.com.google.appengine.api.datastore.dev.LocalDatastoreService

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration{val locations = Array("classpath*:**/infrastructure-context.xml")}
@TestExecutionListeners(Array(classOf[DependencyInjectionTestExecutionListener],classOf[TransactionalTestExecutionListener]))
@TransactionConfiguration{ val transactionManager = "transactionManager"}
abstract class AbstractAppEngineJpaTests{
	
	@Before
	def setUpAppEngine = {
		ApiProxy.setEnvironmentForCurrentThread(new TestEnvironment());
        ApiProxy.setDelegate(new ApiProxyLocalImpl(new java.io.File(".")){});
        var proxy:ApiProxyLocalImpl =  ApiProxy.getDelegate().asInstanceOf[ApiProxyLocalImpl];
        proxy.setProperty(LocalDatastoreService.NO_STORAGE_PROPERTY, java.lang.Boolean.TRUE.toString());
	}
	
	@After
	def tearDownAppEngine = {
		var proxy:ApiProxyLocalImpl =  ApiProxy.getDelegate().asInstanceOf[ApiProxyLocalImpl];
        if(proxy != null){
        	var datastoreService:LocalDatastoreService =  proxy.getService("datastore_v3").asInstanceOf[LocalDatastoreService];
        	datastoreService.clearProfiles();
        }
        ApiProxy.setDelegate(null);
        ApiProxy.setEnvironmentForCurrentThread(null);
	}
	
  
}
