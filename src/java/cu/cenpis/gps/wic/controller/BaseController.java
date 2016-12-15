/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.controller.converter.BaseConverterDelegate;
import cu.cenpis.gps.wic.data.service.BaseService;
import cu.cenpis.gps.wic.util.Bundle;
import cu.cenpis.gps.wic.util.JsfUtil;
import cu.cenpis.gps.wic.util.JsfUtil.PersistAction;
import cu.cenpis.gps.wic.util.Util;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.faces.context.FacesContext;

/**
 *
 * @author farias-i5
 * @param <T>
 * @param <I>
 */
public abstract class BaseController<T, I> implements Serializable, BaseConverterDelegate<T, I> {

    private Class<T> itemClass;

    protected BaseService<T, I> service;

    protected T selected;

    protected List<T> items = null;

    protected List<T> filtered = null;

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    protected void create(String bundleMessage) {
        persist(PersistAction.CREATE, bundleMessage);
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
//            getItems().add(selected);
        }
    }

    protected void update(String bundleMessage) {
        persist(PersistAction.UPDATE, bundleMessage);
//        if (!JsfUtil.isValidationFailed()) {
//            refreshItem(selected);
//        }
    }

    public void refreshItem(T object) {
        getItems().set(findItemPos(getIdValue(object)), object);
    }

    protected void destroy(String bundleMessage) {
        persist(PersistAction.DELETE, bundleMessage);
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
//            getItems().remove(selected);
//            selected = null;
        }
    }

    protected void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction == PersistAction.CREATE) {
                    getFacade().create(selected);
                } else if (persistAction == PersistAction.UPDATE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, Bundle.getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, Bundle.getString("PersistenceErrorOccured"));
            }
        }
    }

    protected Method getIdMethod() {

        Method mid = null;
        Method[] mms = itemClass.getMethods();
        for (Method m : mms) {
            if (m.getName().startsWith("getId") && (m.getName().equals("getId")
                    || Character.isUpperCase(m.getName().charAt(5)))) {
                mid = m;
                break;
            }
        }
        return mid;
    }

    public T prepareCreate() {
        T newItem;
        try {
            newItem = itemClass.newInstance();
            this.selected = newItem;
            initializeEmbeddableKey();
            return newItem;
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public abstract void init();

    public abstract void create();

    public abstract void update();

    public abstract void destroy();

    public BaseController(Class<T> itemClass) {
        this.itemClass = itemClass;
    }

    public BaseController() {
    }

    public BaseService<T, I> getService() {
        return service;
    }

    public void setService(BaseService<T, I> service) {
        this.service = service;
    }

    public T getSelected() {
        return selected;
    }

    public void setSelected(T selected) {
        this.selected = selected;
    }

    public BaseService<T, I> getFacade() {
        return service;
    }

    public void setFacade(BaseService<T, I> facade) {
        this.service = facade;
    }

    public List<T> getItemsAvailableSelectMany() {
        //return getFacade().findAll();
        return getItems();
    }

    public List<T> getItemsAvailableSelectOne() {
        //return getFacade().findAll();
        return getItems();
    }

    @SuppressWarnings("null")
    @Override
    public T findItem(I id) {

        for (T item : getItems()) {
            I value = getIdValue(item);
            if (value.equals(id)) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, value + " equals to " + id);
                return item;
            }
        }
        return null;
    }

    private I getIdValue(T item) {
        Method idm = getIdMethod();
        I value = null;
        try {
            value = (I) (idm.invoke(item));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }

    public int findItemPos(I id) {

        int pos = 0;
        for (T item : getItems()) {
            I value = getIdValue(item);
            if (value.equals(id)) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, value + " equals to " + id);
                return pos;
            }
            pos++;
        }
        return -1;
    }

    protected String queryMethod;

    public String getQueryMethod() {
        return queryMethod;
    }

    public void setQueryMethod(String queryMethod) {
        this.queryMethod = queryMethod;
    }

    public List<String> autoCompleteQuery(String query) {

        List<String> result = new ArrayList<>();
        try {
            Method method = itemClass.getMethod(queryMethod);
            for (int i = 0; i < getItems().size(); i++) {
                T item = getItems().get(i);
                String returnValue = String.valueOf(method.invoke(item));
                if (Util.toSlug(returnValue).contains(Util.toSlug(query))) {
                    result.add(returnValue);
                }
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<T> autoCompleteQueryItems(String query) {

        List<T> result = new ArrayList<>();
        try {
            Method method = itemClass.getMethod(queryMethod);
            for (int i = 0; i < getItems().size(); i++) {
                T item = getItems().get(i);
                String returnValue = String.valueOf(method.invoke(item));
                if (Util.toSlug(returnValue).contains(Util.toSlug(query))) {
                    result.add(item);
                }
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<String> getItemsAsStringList(String methodStr) {
        List<T> pitems = getItems();
        return getItemsAsStringList(pitems, methodStr);
    }

    public List<String> getItemsAsStringList(List<T> pitems) {
        return getItemsAsStringList(pitems, queryMethod);
    }

    public List<String> getItemsAsStringList() {
        List<T> pitems = getItems();
        return getItemsAsStringList(pitems);
    }

    public List<String> getItemsAsStringList(List<T> pitems, String methodStr) {
        List<String> result = new ArrayList<>();
        try {
            Method method = itemClass.getMethod(methodStr);
            for (int i = 0; i < pitems.size(); i++) {
                result.add(String.valueOf(method.invoke(pitems.get(i))));
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<String> getItemsAsStringListNotIn(List<T> pitems) {

        List<T> resultAux = new ArrayList<>(getItems());
        try {
            Method method = itemClass.getMethod(queryMethod);
            for (T itemI : pitems) {

                String valueI = String.valueOf(method.invoke(itemI));
                for (T itemJ : getItems()) {
                    String valueJ = String.valueOf(method.invoke(itemJ));
                    if (Util.toSlug(valueI).equalsIgnoreCase(Util.toSlug(valueJ))) {
                        resultAux.remove(itemJ);
                        break;
                    }
                }
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return getItemsAsStringList(resultAux, queryMethod);
    }

    public T findItemByStringMethod(String query, String methodStr) {

        try {
            Method method = itemClass.getMethod(methodStr);
            for (int i = 0; i < getItems().size(); i++) {
                T item = getItems().get(i);
                String returnValue = String.valueOf(method.invoke(item));
                if (Util.toSlug(returnValue).equals(Util.toSlug(query))) {
                    return item;
                }
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public T findItemByStringMethod(String query) {
        return findItemByStringMethod(query, queryMethod);
    }

    public <Controller extends BaseController> Controller getController(Class<? extends Controller> type) {
        String className = type.getSimpleName();
        String paramName = Character.toLowerCase(className.charAt(0)) + className.substring(1);
        return getContext().getApplication().evaluateExpressionGet(getContext(), "#{" + paramName + "}", type);
    }

    public FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }

    public List<T> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public List<T> getFiltered() {
        return filtered;
    }

    public void setFiltered(List<T> filtered) {
        this.filtered = filtered;
    }

    public String actionPrepareCreate() {
        this.prepareCreate();
        return "Create.jsf?faces-redirect=true";
    }

    public String actionCreate() {
        this.create();
        return actionCancel();
    }

    public String actionView() {
        return "View.jsf?faces-redirect=true";
    }

    public String actionPrepareEdit() {
        return "Edit.jsf?faces-redirect=true";
    }

    public String actionEdit() {
        this.update();
        return actionCancel();
    }

    public String actionCancel() {
        selected = null;
        return "List.jsf?faces-redirect=true";
    }
}
