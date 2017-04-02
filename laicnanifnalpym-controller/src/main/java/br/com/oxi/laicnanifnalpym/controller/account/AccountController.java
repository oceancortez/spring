
package br.com.oxi.laicnanifnalpym.controller.account;

import java.util.Set;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.oxi.laicnanifnalpym.controller.AbstractController;
import br.com.oxi.laicnanifnalpym.middleware.service.account.AccountService;
import br.com.oxi.laicnanifnalpym.middleware.service.forms.AccountForm;
import br.com.oxi.laicnanifnalpym.repository.domain.AccountEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;
import br.com.oxi.laicnanifnalpym.utils.enums.Message;
import br.com.oxi.laicnanifnalpym.utils.enums.Route;

@Controller
@RequestMapping("account")
public class AccountController extends AbstractController {

	private final static Logger LOGGER = Logger.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView modelAndView = getModelAndView();
		try {
			modelAndView.setViewName(Route.ACCOUNT_CREATE.toString());
			LOGGER.info("INSIDE method create()");
			final AccountForm accountForm = new AccountForm();
			LOGGER.info("EXITED method create()");
			return modelAndView.addObject("accountForm", accountForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error("erro no método create() GET " + e.getMessage());
		}
		return modelAndView;
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView createOrUpdate(@Valid AccountForm accountForm, BindingResult bindingResult) {
		ModelAndView modelAndView = getModelAndView();
		try {			
			modelAndView.setViewName(Route.ACCOUNT_CREATE.toString());
			LOGGER.info("INSIDE method create()");
			final UserEntity userEntity = getUserLogado();
			final Set<AccountEntity> listAccounts = accountService.listAccountByUser(userEntity);
			final boolean isAccountAlready = isFormAccountValid(accountForm, listAccounts);
			if (isAccountAlready) {
				return modelAndView.addObject("message", Message.ACCOUNT_ALREADY.toString());
			}
			final boolean isAccountHasCreated = accountService.saveOrUpdate(accountForm, userEntity);
			if (!isAccountAlready && isAccountHasCreated) {
				LOGGER.info("EXITED method create()");
				return modelAndView.addObject("message", Message.ACCOUNT_CREATE.toString());
			}
			if(isAccountAlready && isAccountHasCreated){
				LOGGER.info("EXITED method update()");
				return modelAndView.addObject("message", Message.ACCOUNT_UPDATE.toString());
			}
		} catch (Exception e) {
			LOGGER.error("erro no método create() POST " + e.getMessage());
		}
		
		return modelAndView.addObject("message", Message.ACCOUNT_CREATE_ERROR.toString());
	}

	private boolean isFormAccountValid(AccountForm accountForm, Set<AccountEntity> listAccounts) {
		for (AccountEntity accountEntity : listAccounts) {
			if (accountForm.getNumberAgencyAccount().replaceAll("\\-", "")
					.equals(accountEntity.getNumberAgencyAccount().replaceAll("\\-", ""))) {
				return true;
			}
		}
		return false;
	}

}
