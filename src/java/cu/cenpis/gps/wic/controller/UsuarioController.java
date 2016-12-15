package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.entity.Rol;
import cu.cenpis.gps.wic.data.service.UsuarioService;
import cu.cenpis.gps.wic.data.entity.Usuario;
import cu.cenpis.gps.wic.util.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import javax.annotation.PostConstruct;
import org.primefaces.model.DualListModel;

public class UsuarioController extends BaseController<Usuario, java.lang.Long> {

    private UsuarioService usuarioService;

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public UsuarioController() {
        super(Usuario.class);
    }

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(usuarioService);
    }

    @Override
    public void create() {
        super.create(Bundle.getString("UsuarioCreated"));
    }

    @Override
    protected void setEmbeddableKeys() {
//        RolController rolController = getController(RolController.class);
//        List<Rol> rolList = new ArrayList<>();
//
//        for (String rolName : getPickedItems().getTarget()) {
//            Rol rol = rolController.findItemByStringMethod(rolName);
//            if (rol != null) {
//                rolList.add(rol);
//            }
//        }

        selected.setRolList(selectedThemes);
        super.setEmbeddableKeys(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actionCreate() {
        return super.actionCreate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void initializeEmbeddableKey() {
//        RolController rolController = getController(RolController.class);
//
//        getPickedItems().setSource(rolController.getItemsAsStringList());
//        getPickedItems().setTarget(new ArrayList<>());

        selected.setNombre("Felipe");
        selected.setApellidos("Rdguez");
        selected.setEmail("a@a.com");
        selected.setContrasenna("psw");

        super.initializeEmbeddableKey(); //To change body of generated methods, choose Tools | Templates.
    }

    public void rolPickListener() {
//        RolController rolController = getController(RolController.class);
//        getPickedItems().setSource(rolController.getItemsAsStringListNotIn(selected.getRolList()));
//        getPickedItems().setTarget(rolController.getItemsAsStringList(selected.getRolList()));
    }

    @Override
    public void update() {
        super.update(Bundle.getString("UsuarioUpdated"));
    }

    @Override
    public void destroy() {
        super.destroy(Bundle.getString("UsuarioDeleted"));
    }

    private DualListModel<String> pickedItems;

    public DualListModel<String> getPickedItems() {
        if (pickedItems == null) {
            pickedItems = new DualListModel<>(new ArrayList<>(), new ArrayList<>());
        }
        return pickedItems;
    }

    public void setPickedItems(DualListModel<String> pickedItems) {
        this.pickedItems = pickedItems;
    }

//    private String selectedItem; // +getter+setter
//    private List<String> availableItems; // +getter
//
//    public List<String> completeItems(String query) {
//        
//        availableItems = someService.search(query);
//        return availableItems;
//    }
//
//    public String getSelectedItem() {
//        return selectedItem;
//    }
//
//    public void setSelectedItem(String selectedItem) {
//        this.selectedItem = selectedItem;
//    }
//
//    public List<String> getAvailableItems() {
//        return availableItems;
//    }
//
//    public void setAvailableItems(List<String> availableItems) {
//        this.availableItems = availableItems;
//    }
    private Set<Rol> selectedThemes;

    public Set<Rol> getSelectedThemes() {
        return selectedThemes;
    }

    public void setSelectedThemes(Set<Rol> selectedThemes) { 
        this.selectedThemes = selectedThemes;
    }

    public List<Rol> completeTheme(String query) {
        RolController rolController = getController(RolController.class);
        List<Rol> allThemes = rolController.getItems();
        List<Rol> filteredThemes = new ArrayList<>();

        for (int i = 0; i < allThemes.size(); i++) {
            Rol rol = allThemes.get(i);
            if (rol.getNombre().toLowerCase().contains(query)) {
                filteredThemes.add(rol);
            }
        }

        return filteredThemes;
    }
}
