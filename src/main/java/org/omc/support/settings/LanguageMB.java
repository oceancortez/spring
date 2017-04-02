package org.omc.support.settings;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "languageMB")
public class LanguageMB implements Serializable{
    public static final Long serialVersionUID = 201405150723L;

    private String localeCode;
    private static Map<String, Locale> countries;


    static {
        countries = new LinkedHashMap<>();
        countries.put("Português", new Locale("pt"));
        countries.put("English", new Locale("en"));

    }

    public LanguageMB() {
         getLocaleCode();
    }



    public String getLocaleCode() {
        if (this.localeCode == null && (FacesContext.getCurrentInstance().getViewRoot() != null) &&
                (FacesContext.getCurrentInstance().getViewRoot().getLocale() != null)) {
            this.localeCode = FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage();
        }

        return this.localeCode;
    }

    public void localeCodeChanged(AjaxBehaviorEvent e) {
        String newLocaleValue = ((SelectOneMenu)e.getSource()).getValue() + "";

        for (Map.Entry<String, Locale> entry : countries.entrySet()) {
            if (entry.getValue().toString().equals(newLocaleValue)) {
                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
            }
        }
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public Map<String, Locale> getCountries() {
        return countries;
    }

    public static void setCountries(Map<String, Locale> countries) {
        LanguageMB.countries = countries;
    }
}
