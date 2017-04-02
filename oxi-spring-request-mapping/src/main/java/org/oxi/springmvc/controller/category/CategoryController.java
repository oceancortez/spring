package org.oxi.springmvc.controller.category;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.oxi.springmvc.utils.Message;
import org.oxi.springmvc.utils.Route;
import org.oxi.stok.domain.CategoryEntity;
import org.oxi.stok.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("category")
public class CategoryController {

	private Logger logger = Logger.getLogger(this.getClass());

	private final int SAVE = 0;
	private final int UPDATE = 1;

	@Autowired
	ICategoryRepository iCategoryRepository;

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public ModelAndView buildViewCategory(@ModelAttribute("categoryForm") CategoryForm categoryForm,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName(Route.CATEGORY.toString());
		logger.info("\n \n Inside of method [CategoryController.buildViewCategory]");

		buildCateogryFormViewInit(categoryForm, modelAndView);
		logger.info("\n \n Return of method [CategoryController.buildViewCategory] = " + modelAndView);

		return modelAndView;
	}

	@RequestMapping(value = "categoryName", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView findCategoryByNameInRepository(@Valid CategoryForm categoryForm, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(Route.CATEGORY.toString());
		try {
			logger.info("\n \n Entrou no método [CategoryController.findCategoryByNameInRepository] categoryForm  = "
					+ categoryForm);
			if (bindingResult.hasErrors()) {
				return modelAndView;
			}
			CategoryEntity search = new CategoryEntity();
			search = iCategoryRepository.findCategoryEntityByCategoryName(categoryForm.getCategoryName());
			logger.info(" \n Entrou no método [CategoryController.findCategoryOxiProjectService]={search} ="
					+ categoryForm.getCategoryName());
			if (search != null) {
				modelAndView.setViewName(Route.CATEGORY.toString());
				buildCateogryFormBackOfRepository(categoryForm, modelAndView, search);
			} else {
				modelAndView.addObject("message", Message.NAO_EXISTEM_DADOS_PARA_SEREM_EXIBIDOS.toString());
			}
			return modelAndView;

		} catch (Exception e) {
			logger.error(" \n Entrou no método [CategoryController.findCategoryOxiProjectService]={search} ="
					+ e.getMessage());
			return modelAndView;
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.GET)
	public ModelAndView save(@ModelAttribute("categoryForm") CategoryForm categoryForm, BindingResult bindingResult) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(Route.CATEGORY_SAVE.toString());
		logger.info("\n \n Inside of method [CategoryController.saveCategory]");

		buildCateogryFormViewInit(categoryForm, modelAndView);
		logger.info("\n \n Return of method [CategoryController.saveCategory] = " + modelAndView);

		return modelAndView;

	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView saveCategory(@Valid CategoryForm categoryForm, BindingResult bindingResult,
			@RequestParam(value = "picture", required = false) MultipartFile picture)
					throws MaxUploadSizeExceededException {
		logger.info("\n \n Entrou no método [CategoryController.saveCategory] categoryForm  = " + categoryForm);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(Route.CATEGORY_SAVE.toString());
		try {
			CategoryEntity search = new CategoryEntity();
			search = iCategoryRepository.findCategoryEntityByCategoryName(categoryForm.getCategoryName());
			logger.info(" \n Entrou no método [CategoryController.findCategoryOxiProjectService]={search} =" + search);
			if (search != null) {
				return modelAndView.addObject("message", Message.CATEGORIA_JA_EXISTENTE.toString());
			}
			categoryForm.setActionSave(true);
			if (!isBuildUploadFile(categoryForm, picture, modelAndView)) {
				return modelAndView;
			}
			if (!isPictureValid(bindingResult, modelAndView, categoryForm)) {
				return modelAndView;
			}
			if (!isSaveInRepository(categoryForm, modelAndView)) {
				return modelAndView;
			}

		} catch (Exception e) {
			logger.error(" \n error no método [CategoryController.saveCategory] =" + e.getMessage());
			return modelAndView.addObject("error", e.getMessage());

		}
		return modelAndView;
	}

	private boolean isPictureValid(BindingResult bindingResult, ModelAndView modelAndView, CategoryForm categoryForm) {
		try {
			if(categoryForm.getActionSave() != null && categoryForm.getActionSave()){
			if (bindingResult.hasErrors()
					&& (bindingResult.getErrorCount() > 1 || !bindingResult.hasFieldErrors("picture"))) {
				return false;
			}
			}else{
				
			if (bindingResult.hasErrors()
					&& (bindingResult.getErrorCount() > 1 || !bindingResult.hasFieldErrors("pictureNew"))) {
				return false;
			}
			}
		} catch (MaxUploadSizeExceededException m) {
			modelAndView.addObject("message", Message.MAX_UPLOAD_EXCEEDED.toString());
			return false;
		}
		return true;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView update(@Valid CategoryForm categoryForm, BindingResult bindingResult,
			@RequestParam(value = "pictureNew", required = false) MultipartFile pictureNew) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(Route.CATEGORY_UPDATE.toString());
		try {
			logger.info("Entrou no método [CategoryController.update] categoryForm  = " + categoryForm);
			if(!isBuildUploadFile(categoryForm, pictureNew, modelAndView)){
				return modelAndView;
			}
			if(!isPictureValid(bindingResult, modelAndView, categoryForm)){
				return modelAndView;
			}
			CategoryEntity search = new CategoryEntity();
			search = iCategoryRepository.findOne(categoryForm.getCategoryId());
			logger.info("Entrou no método [CategoryController.findCategoryOxiProjectService]={search} =" + search);
			if (search != null) {
				if(!isUpdateInRepository(categoryForm, modelAndView)){
					return modelAndView;
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error no método [CategoryController.update] =" + e.getCause());
			return modelAndView;
		}
		return modelAndView;
	}

	@RequestMapping(value = "picture/{categoryId}", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getPicture(@PathVariable("categoryId") Long categoryId) {
		logger.info("\n \n Entrou no método [CategoryController.getImage] categoryId = " + categoryId);
		if (categoryId != null) {
			CategoryEntity search = iCategoryRepository.findOne(categoryId);
			if (search != null) {
				return search.getPicture();
			}
		}
		return null;
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView listAll() {
		ModelAndView modelAndView = new ModelAndView();
		List<CategoryEntity> listCategory = iCategoryRepository.findAll();
		if (listCategory != null) {
			logger.info("\n \n Entrou no método [CategoryController.listAll]");
			modelAndView.setViewName(Route.CATEGORY_LIST.toString());
			modelAndView.addObject("listCategory", listCategory);
		} else {
			modelAndView.setViewName(Route.CATEGORY.toString());
			modelAndView.addObject("message", Message.NAO_EXISTEM_DADOS_PARA_SEREM_EXIBIDOS);
		}
		return modelAndView;
	}

	@RequestMapping(value = "update/list", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView updateListAll() {
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView = listAll();
	}

	// Utilizando o @ResponseBody para aproveitar o recurso do ajax
	@RequestMapping("delete/{categoryId}")
	@ResponseBody
	public ModelAndView delete(@PathVariable("categoryId") Long categoryId) {
		logger.info("\n \n Entrou no método [CategoryController.delete]= " + categoryId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(Route.CATEGORY_LIST.toString());
		if (categoryId != null) {
			logger.info("\n Entrou no método [iCategoryRepository.delete]= " + categoryId);
			iCategoryRepository.delete(categoryId);
		}
		return modelAndView;
	}

	@RequestMapping(value = "update/{categoryId}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView callbackUpdate(@PathVariable("categoryId") Long categoryId) {
		logger.info("\n \n Entrou no método [CategoryController.update]");
		ModelAndView modelAndView = new ModelAndView();
		CategoryEntity categoryEntity = null;
		if (categoryId != null) {
			categoryEntity = iCategoryRepository.findOne(categoryId);
			logger.info("\n \n Entrou no método [iCategoryRepository.findOne]");
		}
		if (categoryEntity != null) {
			logger.info("\n \n Entrou no método [CategoryController.buildCateogryFormViewInit]");
			modelAndView.setViewName(Route.CATEGORY_UPDATE.toString());
			CategoryForm categoryForm = parseCategoryEntity(categoryEntity);
			try {
				buildUploadFileFromRepository(categoryForm, categoryEntity);
			} catch (IOException e) {
				logger.error("\n Error no método [CategoryController.buildUploadFileFromRepository]" + e.getMessage());
			}
			buildCateogryFormViewInit(categoryForm, modelAndView);
		}
		return modelAndView;
	}

	private boolean isSaveInRepository(CategoryForm categoryForm, ModelAndView modelAndView) {
		try {
			CategoryEntity categoryEntity = parseCategoryForm(categoryForm);
			iCategoryRepository.save(categoryEntity);
			logger.info(
					"\n SAVE OK [CategoryController.saveAndFlush] categoryEntity= " + categoryEntity.getCategoryName());
			modelAndView.addObject("categoryName", categoryForm.getCategoryName());
			modelAndView.addObject("message", Message.SAVE_SUCCESS.toString());
			modelAndView.setViewName(Route.CATEGORY_DETAIL.toString());

		} catch (Exception e) {
			logger.info("\n ERROR [CategoryController.saveAndFlush] categoryForm= " + categoryForm.getCategoryName());
			return false;
		}

		return true;
	}

	private boolean isUpdateInRepository(CategoryForm categoryForm, ModelAndView modelAndView) {
		try {
			CategoryEntity categoryEntity = parseCategoryForm(categoryForm);
			iCategoryRepository.saveAndFlush(categoryEntity);
			logger.info("\n UPDATE OK [CategoryController.updateAndFlush] categoryEntity= "
					+ categoryEntity.getCategoryName());
			categoryForm.setMessage(Message.UPDATE_SUCCESS.toString());
			modelAndView.setViewName(Route.CATEGORY_DETAIL.toString());

		} catch (Exception e) {
			logger.info("\n ERROR [CategoryController.updateAndFlush] categoryForm= " + categoryForm.getCategoryName());
			return false;
		}
		return true;
	}

	private boolean isBuildUploadFile(CategoryForm categoryForm, MultipartFile picture, ModelAndView modelAndView)
			throws IOException {
		if (categoryForm.getActionSave() != null && categoryForm.getActionSave()) {
			if (!picture.isEmpty()) {
				categoryForm.setPicture(picture.getBytes());
				categoryForm.setPictureName(picture.getOriginalFilename());
			} else {
				modelAndView.addObject("message", Message.PICTURE_NOT_SELECTED.toString());
				return false;

			}
		} else {

			if (!picture.isEmpty()) {
				categoryForm.setPictureNew(picture.getBytes());
				categoryForm.setPictureName(picture.getOriginalFilename());
			} else {
				categoryForm.setPicture(picture.getBytes());
				categoryForm.setPictureName(picture.getOriginalFilename());
			}
		}
		return true;
	}

	private void buildUploadFileFromRepository(CategoryForm categoryForm, CategoryEntity categoryEntity)
			throws IOException {
		if (categoryEntity != null) {
			categoryForm.setPicture(categoryEntity.getPicture());
			categoryForm.setPictureName(categoryEntity.getPictureName());
		}
	}

	public CategoryEntity parseCategoryForm(CategoryForm categoryForm) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCategoryId(categoryForm.getCategoryId());
		categoryEntity.setId(categoryForm.getCategoryId());

		categoryEntity.setCategoryName(categoryForm.getCategoryName());
		categoryEntity.setDescription(categoryForm.getDescription());
		categoryEntity.setPictureName(categoryForm.getPictureName());

		if (categoryForm.getActionSave() != null && categoryForm.getActionSave()) {
			categoryEntity.setPicture(categoryForm.getPicture());
		} else {
			if (categoryForm.getPictureNew() == null) {
				categoryEntity.setPicture(getPicture(categoryForm.getCategoryId()));
			} else {
				categoryEntity.setPicture(categoryForm.getPictureNew());
			}
		}

		return categoryEntity;
	}

	public CategoryForm parseCategoryEntity(CategoryEntity categoryEntity) {
		CategoryForm categoryForm = new CategoryForm();
		categoryForm.setCategoryId(categoryEntity.getCategoryId());
		categoryForm.setCategoryName(categoryEntity.getCategoryName());
		categoryForm.setDescription(categoryEntity.getDescription());
		categoryForm.setPictureName(categoryEntity.getPictureName());
		categoryForm.setPicture(categoryEntity.getPicture());
		return categoryForm;
	}

	@SuppressWarnings("unused")
	private void buildCateogryFormBackOfRepository(CategoryForm categoryForm, ModelAndView modelAndView,
			CategoryEntity categoryEntity) {
		modelAndView.addObject("categoryForm", categoryForm);
		modelAndView.addObject("categoryEntity", categoryEntity);

		modelAndView.addObject("categoryId", categoryEntity.getCategoryId());
		modelAndView.addObject("categoryName", categoryEntity.getCategoryName());
		modelAndView.addObject("description", categoryEntity.getDescription());
		modelAndView.addObject("pictureName", categoryEntity.getPictureName());
		modelAndView.addObject("picture", categoryEntity.getPicture());
		modelAndView.addObject("categoryForm", categoryForm);
	}

	private void buildCateogryFormViewInit(CategoryForm categoryForm, ModelAndView modelAndView) {
		modelAndView.addObject("categoryForm", categoryForm);

		modelAndView.addObject("categoryId", categoryForm.getCategoryId());
		modelAndView.addObject("categoryName", categoryForm.getCategoryName());
		modelAndView.addObject("description", categoryForm.getDescription());
		modelAndView.addObject("pictureName", categoryForm.getPictureName());
		modelAndView.addObject("picture", categoryForm.getPicture());
	}

	@RequestMapping(value = "db/service/oxi-spring/categoryId/{categoryId}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView findCategoryByRepository(@PathVariable("categoryId") Long categoryId) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			logger.info(
					"Entrou no método [HelloSpringController.showRestServiceOxiProjectFindByNameAndDescription]={categoryId} = "
							+ categoryId);
			modelAndView.setViewName("hello");

			CategoryEntity search = iCategoryRepository.findOne(categoryId);
			logger.info(
					" \n Entrou no método [HelloSpringController.findCategoryOxiProjectService]={search} =" + search);

			if (search.getCategoryId() != null) {
				modelAndView.addObject("category", search.getCategoryName());
			}
			return modelAndView;

		} catch (Exception e) {

			modelAndView.addObject("message", e.getMessage());
			return modelAndView;
		}

	}

}
