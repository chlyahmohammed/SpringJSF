package com.esisa.spring.jsf.actions;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.context.FacesContext;

public class ManagedBeanService<T> {

	public ManagedBeanService() {

	}

	public T getBean(String name) {
		FacesContext context = FacesContext.getCurrentInstance();
		ELContext el = context.getELContext();
		ELResolver resolver = el.getELResolver();
		T bean = (T) resolver.getValue(el, null, name);
		return bean;
	}	
}
