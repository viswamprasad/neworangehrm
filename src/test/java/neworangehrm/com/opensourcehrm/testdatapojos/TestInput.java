package neworangehrm.com.opensourcehrm.testdatapojos;

import java.util.List;

/**
 * Created by Viswa on 12/30/2017.
 */
public class TestInput {
    private List<FormElements> formElements;
    private MenuNavigation menuNavigation;

    public MenuNavigation getMenuNavigation() {
        return menuNavigation;
    }

    public void setMenuNavigation(MenuNavigation menuNavigation) {
        this.menuNavigation = menuNavigation;
    }

    public List<FormElements> getFormElements() {
        return formElements;
    }

    public void setFormElements(List<FormElements> formElements) {
        this.formElements = formElements;
    }
}
