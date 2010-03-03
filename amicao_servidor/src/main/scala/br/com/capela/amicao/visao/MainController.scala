package br.com.capela.amicao.visao

import org.springframework.stereotype.Controller
import _root_.com.google.appengine.api.users.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping {val value = Array("/main.do")}
class MainController {

  @RequestMapping {val method = Array(RequestMethod.POST)}
  def post(name: String, model: Model) = "main"

  @RequestMapping {val method = Array(RequestMethod.GET)}
  def get(name: String, model: Model) = "index"

}
