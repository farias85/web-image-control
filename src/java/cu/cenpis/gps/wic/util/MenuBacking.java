package cu.cenpis.gps.wic.util;

import java.io.Serializable;

public class MenuBacking implements Serializable {

    private String selection;
    private boolean create;
    private boolean view;
    private boolean edit;
    private boolean list;

    public MenuBacking() {
        create = false;
        list = true; // You can define the default page that will be show
        view = false;
        edit = false;
    }

    public void active() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        setCreate(selection.equals("create"));
        setList(selection.equals("list"));
        setView(selection.equals("view"));
        setEdit(selection.equals("edit"));
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }

    public boolean isView() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public boolean isList() {
        return list;
    }

    public void setList(boolean list) {
        this.list = list;
    }
}
