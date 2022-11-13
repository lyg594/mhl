package mhl.service;

import mhl.dao.MenuDAO;
import mhl.domain.Menu;

import java.util.List;

/**
 * @ author   lyg
 * @ version  1.0
 */
public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();

    public List<Menu> list() {
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }

    public Menu getMenuById(int id) {
        return menuDAO.querySingle("select * from menu where id = ?", Menu.class, id);
    }
}
