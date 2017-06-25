/**
 * 
 */
package org.omc.util;

/**
 * @author ocean
 *
 */
public enum Paginas {

	erro404("erros/", "not-found-page"), inicio("pages/", "inicio");

	String path;
	String jsp;

	Paginas(String path, String jsp) {
		this.path = path;
		this.jsp = jsp;
	}

	public String forward() {
		return path + jsp;
	}

}
