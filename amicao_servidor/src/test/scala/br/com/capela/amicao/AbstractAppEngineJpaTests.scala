package br.com.capela.amicao

import org.junit.runner.RunWith
import org.junit._
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.{SpringJUnit4ClassRunner}
import org.springframework.beans.factory.annotation.{Qualifier, Autowired}


import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import org.springframework.test.context.transaction.TransactionConfiguration
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.test.context.TestExecutionListeners

import _root_.com.google.appengine.tools.development.testing.{LocalServiceTestHelper}


@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration {val locations = Array("classpath*:**/infrastructure-context.xml")}
@TestExecutionListeners(Array(classOf[DependencyInjectionTestExecutionListener], classOf[TransactionalTestExecutionListener]))
@TransactionConfiguration {val transactionManager = "transactionManager"}
abstract class AbstractAppEngineJpaTests {
  private var datastoreHelper: LocalServiceTestHelper = _;

  private var authenticationHelper: LocalServiceTestHelper = _;
  //.setEnvIsAdmin(true).setEnvIsLoggedIn(true);

  private var taskQueueHelper: LocalServiceTestHelper = _;

  private var localMemcacheHelper: LocalServiceTestHelper = _;

  @Autowired()
  @Qualifier("datastoreHelper")
  def setDatastoreHelper(helper: LocalServiceTestHelper) = this.datastoreHelper = helper

  @Autowired
  @Qualifier("authenticationHelper")
  def setAuthenticationHelper(helper: LocalServiceTestHelper) = this.authenticationHelper = helper

  @Autowired
  @Qualifier("taskQueueHelper")
  def setTaskQueueHelper(helper: LocalServiceTestHelper) = this.taskQueueHelper = helper

  @Autowired
  @Qualifier("localMemcacheHelper")
  def setLocalMemcacheHelper(helper: LocalServiceTestHelper) = this.localMemcacheHelper = helper

  @Before
  def setUpAppEngine = datastoreHelper.setUp();

  @After
  def tearDownAppEngine = datastoreHelper.tearDown();
}

