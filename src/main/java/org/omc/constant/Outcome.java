package org.omc.constant;

/**
 * Created by ocortez on 10/29/2015.
 */
public enum Outcome {

    PAGES_PRODUCT_LIST("/pages/product/list.xhtml"),
    PAGES_PRODUCT("/pages/product/addEdit.xhtml"),
    PAGES_CATEGORY_LIST("/pages/category/list.xhtml"),
    PAGES_USER_LIST("/pages/user/list.xhtml"),
    PAGES_CATEGORY_SELECT_CATEGORY("/pages/category/selectCategory");

    private String outcome;

    Outcome(String outcome) {
        this.outcome = outcome;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }


    @Override
    public String toString() {
        return outcome;
    }
}
